package com.example.recyclernicovid_19.presenter;

import com.example.recyclernicovid_19.modelo.Pais;

import java.util.List;

public interface IPresenterView {
    void notificarVista(List<Pais> pais);
}
