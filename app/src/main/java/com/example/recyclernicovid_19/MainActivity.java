package com.example.recyclernicovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.recyclernicovid_19.modelo.PojoCorona;
import com.example.recyclernicovid_19.modelo.api.Api;
import com.example.recyclernicovid_19.modelo.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<PojoCorona> call = service.getPaises();
        call.enqueue(new Callback<PojoCorona>() {
            @Override
            public void onResponse(Call<PojoCorona> call, Response<PojoCorona> response) {
                Log.d("AAA", response.body().getDate());
                Log.d("AAA", response.body().getPaises().toString());
            }

            @Override
            public void onFailure(Call<PojoCorona> call, Throwable t) {
                Log.d("AAA", "Fallamos " + t);
            }
        });
    }
}
