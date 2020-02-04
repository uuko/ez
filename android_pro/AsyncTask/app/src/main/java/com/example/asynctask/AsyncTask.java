package com.example.asynctask;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;


public class AsyncTask extends android.os.AsyncTask<Void, Integer, String> {
    private WeakReference<TextView> textViewWeakReference;

            AsyncTask(TextView tv) {
        textViewWeakReference = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        int count = 0;
        int length = 1;
        try {
            while (count<99) {
                count += length;
                // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
                publishProgress(count);
                // 模拟耗时任务
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        String u=Integer.toString(s);
        return u;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        progressBar.setProgress(values[0]);
        textView1.setText("loading..." + values[0] + "%");
    }

    protected void onPostExecute(String result) {
        textViewWeakReference.get().setText(result);
    }
}