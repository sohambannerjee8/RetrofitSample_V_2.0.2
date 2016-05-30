package com.indus.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.indus.retrofitsample.network.RestClient;
import com.indus.retrofitsample.response.StateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callStateApi();
    }
    private void callStateApi() {
        Call<StateResponse> respuesta =  RestClient.setupRestClient().getStates();
        respuesta.enqueue(new Callback<StateResponse>() {
            @Override
            public void onResponse(Call<StateResponse> call, Response<StateResponse> response) {
                Log.e(MainActivity.class.getName(),response.raw().message());
            }

            @Override
            public void onFailure(Call<StateResponse> call, Throwable t) {
                Log.e(MainActivity.class.getName(),call.toString());
            }

        /*RestClient.setupRestClient().getStates(state,new RestCallback<StateResponse>() {
            @Override
            public void failure(RestError restError) {

            }

            @Override
            public void onResponse(Call<StateResponse> call, Response<StateResponse> response) {
                *//*for(StateResponse.States responses:stateResponse.getStates()) {
                    Log.v("State Name",responses.getState());
                }*//*
            }*/;

        });

    }
}