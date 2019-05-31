package com.example.fortniterecord;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Controller implements Callback<Profile> {

    ServerResponse handler;


    public Controller(ServerResponse handler){
        this.handler = handler;

    }


    static final String BASE_URL = "https://api.fortnitetracker.com/v1/";

    public void start(String nick, String platform){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        ProfileApi api = retrofit.create(ProfileApi.class);

        Call<Profile> call = api.loadProfile(nick,platform);
        call.enqueue(this);




    }

    @Override
    public void onResponse(Call<Profile> call, Response<Profile> response) {
        if (response.isSuccessful()){
            Profile profile = response.body();
            handler.onResponse(profile);


        }else{
            Log.d("CONTROLLER",response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<Profile> call, Throwable t) {
        t.printStackTrace();

    }

    interface ServerResponse{
        public void onResponse(Profile profile);
    }





}