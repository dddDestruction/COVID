package com.example.recyclernicovid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.recyclernicovid_19.modelo.Pais;
import com.example.recyclernicovid_19.modelo.PojoCorona;
import com.example.recyclernicovid_19.modelo.api.Api;
import com.example.recyclernicovid_19.modelo.api.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "AAA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<PojoCorona> call = service.getPaises();
        call.enqueue(new Callback<PojoCorona>() {
            @Override
            public void onResponse(Call<PojoCorona> call, Response<PojoCorona> response) {
                Log.d(TAG, response.body().getDate());
                Log.d(TAG, response.body().getPaises().get(0).getPais());

                List<Pais> pais = new ArrayList<Pais>();
                pais.add(new Pais(response.body().getGlobal().getTotalConfirmed(), response.body().getGlobal().getTotalDeaths()));
                int i;
                for (i=0; i< response.body().getPaises().size(); i++){
                    pais.add(response.body().getPaises().get(i));
                }
                for (i=0; i< pais.size(); i++){
                    if (i%10==0 && i!=0){
                        pais.add(i, new Pais());
                    }
                }
                initRecycler(pais);
            }

            @Override
            public void onFailure(Call<PojoCorona> call, Throwable t) {
                Log.d(TAG, "Fallamos " + t);
            }
        });
    }

    public void initRecycler(List<Pais> paises){
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CoronaAdapter(paises, this));
    }
}
