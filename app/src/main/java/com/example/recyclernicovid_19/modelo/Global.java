package com.example.recyclernicovid_19.modelo;

public class Global {
    protected int NewConfirmed;
    protected int TotalConfirmed;
    protected int NewDeaths;
    protected int TotalDeaths;
    protected int proNewRecovered;
    protected int TotalRecovered;

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        NewDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public int getProNewRecovered() {
        return proNewRecovered;
    }

    public void setProNewRecovered(int proNewRecovered) {
        this.proNewRecovered = proNewRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        TotalRecovered = totalRecovered;
    }
}
