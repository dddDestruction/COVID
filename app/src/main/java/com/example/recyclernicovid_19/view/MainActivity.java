package com.example.recyclernicovid_19.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.recyclernicovid_19.R;
import com.example.recyclernicovid_19.modelo.IPresenterModel;
import com.example.recyclernicovid_19.modelo.Modelo;
import com.example.recyclernicovid_19.modelo.Pais;
import com.example.recyclernicovid_19.modelo.PojoCorona;
import com.example.recyclernicovid_19.modelo.api.Api;
import com.example.recyclernicovid_19.modelo.api.RetrofitClient;
import com.example.recyclernicovid_19.presenter.IPresenter;
import com.example.recyclernicovid_19.presenter.IPresenterView;
import com.example.recyclernicovid_19.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IView, IPresenterView, CallBackFragmentPais{
    public static String TAG = "AAA";
    protected List<Pais> paises;
    protected IPresenter iPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarIPresenter();
        getDatosDesdePresenter();

    }

    @Override
    public void iniciarIPresenter() {
        iPresenter = new Presenter(this);
        iPresenter.setIModel(new Modelo((IPresenterModel) iPresenter));
    }

    @Override
    public void getDatosDesdePresenter() {
        iPresenter.getDatosDesdeModel();
    }

    @Override
    public void notificarVista(List<Pais> pais) {
        this.paises = pais;
        RecyclerViewFragment recyclerViewFragment = RecyclerViewFragment.newInstance();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transa = manager.beginTransaction();
        transa.replace(R.id.contenedor, recyclerViewFragment)
                .addToBackStack("recycler")
                .commit();

        initRecycler(pais);
    }

    public void initRecycler(List<Pais> paises){
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CoronaAdapter(paises, this, this));
    }


    @Override
    public void notificarOnClickPais(int position) {
        Log.d(TAG, "POSITION "+ position);
        Pais pais = paises.get(position);
        PaisesFragment fragment = PaisesFragment.newInstance(pais.getPais(), pais.getCodigo(), pais.getSlug(), pais.getNuevosCasos(), pais.getTotalCasos(), pais.getNuevasMuertes(),
                pais.getMuertesTotal(), pais.getNuvosRecuperados(), pais.getTotalRecuperados(), pais.getFecha());
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contenedor, fragment).commit();

    }
}
