package com.example.fortniterecord;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ProfileApi {

    @Headers(
            "TRN-Api-Key: 4ccb88f6-49b6-4fc5-9d2e-ad95d7ca0d0e"
    )

    @GET("profile/{platform}/{epic-nickname}")
    Call<Profile> loadProfile(@Path("platform") String platform, @Path("epic-nickname") String nickname);
}
