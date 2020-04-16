package com.example.recyclernicovid_19.presenter;

import com.example.recyclernicovid_19.modelo.IModel;
import com.example.recyclernicovid_19.modelo.IPresenterModel;
import com.example.recyclernicovid_19.modelo.Pais;
import com.example.recyclernicovid_19.modelo.PojoCorona;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements IPresenter, IPresenterModel {

    protected IModel iModel;
    protected IPresenterView iPresenterView;

    public Presenter(IPresenterView iPresenterView) {
        this.iPresenterView = iPresenterView;
    }

    @Override
    public void setIModel(IModel iModel) {
        this.iModel = iModel;
    }

    @Override
    public void getDatosDesdeModel() {
        iModel.getDato();
    }

    @Override
    public void notificarPresenter(PojoCorona pojoCorona) {
        iPresenterView.notificarVista(transformarDato(pojoCorona));
    }

    public List<Pais> transformarDato(PojoCorona pojoCorona){
        List<Pais> paises = new ArrayList<Pais>();
        paises.add(new Pais(pojoCorona.getGlobal().getTotalConfirmed(), pojoCorona.getGlobal().getTotalDeaths()));
        int i;
        for (i=0; i< pojoCorona.getPaises().size(); i++){
            paises.add(pojoCorona.getPaises().get(i));
        }
        for (i=0; i< paises.size(); i++){
            if (i%10==0 && i!=0){
                paises.add(i, new Pais());
            }
        }
        return paises;
    }
}
