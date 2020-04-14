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

    public Pais(String pais, String codigo, String slug, int nuevosCasos, int totalCasos, int nuevasMuertes, int muertesTotal, int nuvosRecuperados, int totalRecuperados, String fecha) {
        this.pais = pais;
        this.codigo = codigo;
        this.slug = slug;
        this.nuevosCasos = nuevosCasos;
        this.totalCasos = totalCasos;
        this.nuevasMuertes = nuevasMuertes;
        this.muertesTotal = muertesTotal;
        this.nuvosRecuperados = nuvosRecuperados;
        this.totalRecuperados = totalRecuperados;
        this.fecha = fecha;
    }
    //Contructor para agregar los datos globales
    public Pais(int totalCasos, int muertesTotal) {
        this.totalCasos = totalCasos;
        this.muertesTotal = muertesTotal;
    }

    public Pais() {
    }

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
