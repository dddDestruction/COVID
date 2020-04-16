package com.example.recyclernicovid_19.modelo;

import android.util.Log;

import com.example.recyclernicovid_19.modelo.api.Api;
import com.example.recyclernicovid_19.modelo.api.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Modelo implements IModel {

    public static String TAG = "AAA";
    protected IPresenterModel iPresenterModel;

    public Modelo(IPresenterModel iPresenterModel) {
        this.iPresenterModel = iPresenterModel;
    }

    @Override
    public void getDato() {

        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<PojoCorona> call = service.getPaises();
        call.enqueue(new Callback<PojoCorona>() {
            @Override
            public void onResponse(Call<PojoCorona> call, Response<PojoCorona> response) {
                Log.d(TAG, response.body().getDate());
                Log.d(TAG, response.body().getPaises().get(0).getPais());

                enviarDato(response.body());
            }

            @Override
            public void onFailure(Call<PojoCorona> call, Throwable t) {
                Log.d(TAG, "Fallamos " + t);
            }
        });
    }

    @Override
    public void enviarDato(PojoCorona pojoCorona) {
        iPresenterModel.notificarPresenter(pojoCorona);
    }
}
