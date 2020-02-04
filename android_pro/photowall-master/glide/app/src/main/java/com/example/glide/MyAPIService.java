package com.example.glide;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyAPIService {
   // https://www.flickr.com/services/rest/
    // ?method=flickr.photos.search&api_key=f5c47104535c1a739703c68cc1680aec&text=test&format=json&nojsoncallback=1&api_sig=c9151c817e9c27a0e376191b690652f5
    @GET("method=flickr.photos.search&api_key=c039b26bc04f52fbab1f925cf9f7e6aa&text=test&format=json&nojsoncallback=1&api_sig=02bf1b1eb2b06c734fa61573e7341df1")    // 設置一個GET連線，路徑為albums/1
    Call<Flickr> getFlickr();
    @GET("services/rest/?method=flickr.photos.getRecent&api_key=c039b26bc04f52fbab1f925cf9f7e6aa&format=json&nojsoncallback=1")
    Call<Example> getNew();
    @GET("services/rest/?method=flickr.photos.search&api_key=c039b26bc04f52fbab1f925cf9f7e6aa&text=test&format=json&nojsoncallback=1")    // 設置一個GET連線，路徑為albums/1
    Call<Example> getExample();


}
