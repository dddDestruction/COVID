package com.example.recyclernicovid_19.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoCorona {
    @SerializedName("Global")
    protected Global global;
    @SerializedName("Countries")
    protected List<Pais> paises;
    @SerializedName("Date")
    protected String date;

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
