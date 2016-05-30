package com.indus.retrofitsample.network;

import com.indus.retrofitsample.response.StateResponse;

import retrofit2.Call;
import retrofit2.http.POST;


/**
 * Created by Soham on 25-01-2016.
 */
public interface Restapi {
    @POST("states")
    Call<StateResponse> getStates();
}
