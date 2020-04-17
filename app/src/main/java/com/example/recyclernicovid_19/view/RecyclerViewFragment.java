package com.example.recyclernicovid_19.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclernicovid_19.R;
import com.example.recyclernicovid_19.modelo.IPresenterModel;
import com.example.recyclernicovid_19.modelo.Modelo;
import com.example.recyclernicovid_19.modelo.Pais;
import com.example.recyclernicovid_19.presenter.IPresenter;
import com.example.recyclernicovid_19.presenter.IPresenterView;
import com.example.recyclernicovid_19.presenter.Presenter;

import java.util.List;

public class RecyclerViewFragment extends Fragment implements IView, IPresenterView,  CallBackFragmentPais {
    private final static String TAG = "AAA";
    protected List<Pais> paises;
    protected IPresenter iPresenter;
    protected View view;
    protected CallBackFragmentRecycler callback;
    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        iniciarIPresenter();
        getDatosDesdePresenter();
        callback = (CallBackFragmentRecycler) view.getContext();

        return view;
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


        initRecycler(pais);
    }

    public void initRecycler(List<Pais> paises){
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CoronaAdapter(paises, view.getContext(), this));
    }
    @Override
    public void notificarOnClickPais(int position) {
        Log.d(TAG, "POSITION "+ position);
        Pais pais = paises.get(position);
        callback.notificarPais(pais);

    }
}
