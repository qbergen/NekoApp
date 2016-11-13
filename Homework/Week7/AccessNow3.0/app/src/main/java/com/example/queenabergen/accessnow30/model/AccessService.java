package com.example.queenabergen.accessnow30.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by queenabergen on 11/12/16.
 */

public interface AccessService {
    @GET("v1/gifs/random")
    Call<Example> getRandomGiphy(@Query("api_key")String id);
}
