package com.example.recyclernicovid_19.modelo;

import com.google.gson.annotations.SerializedName;

public class Pais {
    @SerializedName("Country")
    protected String pais;
    @SerializedName("CountryCode")
    protected String codigo;
    @SerializedName("Slug")
    protected String slug;
    @SerializedName("NewConfirmed")
    protected int nuevosCasos;
    @SerializedName("TotalConfirmed")
    protected int totalCasos;
    @SerializedName("NewDeaths")
    protected int nuevasMuertes;
    @SerializedName("TotalDeaths")
    protected int muertesTotal;
    @SerializedName("NewRecovered")
    protected int nuvosRecuperados;
    @SerializedName("TotalRecovered")
    protected int totalRecuperados;
    @SerializedName("Date")
    protected String fecha;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getNuevosCasos() {
        return nuevosCasos;
    }

    public void setNuevosCasos(int nuevosCasos) {
        this.nuevosCasos = nuevosCasos;
    }

    public int getTotalCasos() {
        return totalCasos;
    }

    public void setTotalCasos(int totalCasos) {
        this.totalCasos = totalCasos;
    }

    public int getNuevasMuertes() {
        return nuevasMuertes;
    }

    public void setNuevasMuertes(int nuevasMuertes) {
        this.nuevasMuertes = nuevasMuertes;
    }

    public int getMuertesTotal() {
        return muertesTotal;
    }

    public void setMuertesTotal(int muertesTotal) {
        this.muertesTotal = muertesTotal;
    }

    public int getNuvosRecuperados() {
        return nuvosRecuperados;
    }

    public void setNuvosRecuperados(int nuvosRecuperados) {
        this.nuvosRecuperados = nuvosRecuperados;
    }

    public int getTotalRecuperados() {
        return totalRecuperados;
    }

    public void setTotalRecuperados(int totalRecuperados) {
        this.totalRecuperados = totalRecuperados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
