package com.projet.model;

public class Empruns{
    private String titreLivre;
    private String auteurLivre;
    private String dateEmpruns;

    public Empruns(String titreLivre, String auteurLivre, String dateEmpruns){
        this.titreLivre = titreLivre;
        this.auteurLivre = auteurLivre;
        this.dateEmpruns = dateEmpruns;
    }
    public String getTitreLivre(){
        return titreLivre;
    }
    public String getAuteurLivre(){
        return auteurLivre;
    }
    public String getDateEmpruns(){
        return dateEmpruns;
    }
    public void setTitreLivre(String titreLivre){
        this.titreLivre = titreLivre;
    }
    public void setAuteurLivre(String auteurLivre){
        this.auteurLivre = auteurLivre;
    }
    public void setDateEmpruns(String dateEmpruns){
        this.dateEmpruns = dateEmpruns;
    }
}