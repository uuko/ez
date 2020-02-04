package com.example.download;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadTask extends AsyncTask<String,Integer,Integer> {
    private DownloadListener listener;
    public static final int success=0;
    public static final int failed=1;
    public static final int paused=2;
    public static final int canceled=3;
    public DownloadTask(DownloadListener listener){
        this.listener=listener;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        InputStream is=null;
        RandomAccessFile saveFile=null;
        File file=null;
        try{
            long downloadlg=0;
            String downloadurl=strings[0];
            String filename=downloadurl.substring(downloadurl.lastIndexOf("/"));
            String directory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file =new File(directory+filename);
            if (file.exists()){
                downloadlg=file.length();
            }
            long contentlg=getContentLength(downloadurl);
            if (contentlg==0){
                return failed;
            }else if (contentlg==downloadlg){
                return success;
            }
            OkHttpClient client=new OkHttpClient();
            Request request=new Request.Builder()
                    .addHeader("Range","bytes="+downloadlg+"-")
                    .url(downloadurl)
                    .build();
            Response response=client.newCall(request).execute();
            if (response!=null){
                is=response.body().byteStream();
                saveFile=new RandomAccessFile(file,"rw");;
                saveFile.seek(downloadlg);
                byte[] bytes=new byte[1024];
                int total=0;
                int len;
                while ((len =is.read(bytes))!=-1){
                    if (isCancelled()){
                        return  canceled;
//                    }else if(isPaused()){
//                        return paused;
                    }else {
                        total+=len;
                        saveFile.write(bytes,0,len);
                        int progress=(int)((total+downloadlg)*100/contentlg);
                        publishProgress(progress);
                    }
                    response.body().close();
                    return success;
                }
            }

        }catch (Exception e){e.printStackTrace();} finally {
            try {
                if (is !=null){
                    is.close();
                }
                if (saveFile!=null){saveFile.close();}
                if (isCanceled && file!!=null){

                }
            }catch (Exception e){e.printStackTrace();}
        }
        return null;
    }

    private long getContentLength(String downloadurl) {
    }
}
