package com.example.recyclernicovid_19.modelo.api;

import com.example.recyclernicovid_19.modelo.PojoCorona;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("summary")
    Call<PojoCorona> getPaises();
}
