package com.projet.model;

public class Livres{
    private String titre;
    private String auteur;
    private int anneePublication;
    private int nbExemplaire;

    public Livres(String titre, String auteur, int anneePublication, int nbExemplaire){
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.nbExemplaire = nbExemplaire;
    }
    public String getTitre(){
        return titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public int getAnneePublication(){
        return anneePublication;
    }
    public int getNbExemplaire(){
        return nbExemplaire;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    public void setAnneePublication(int anneePublication){
        this.anneePublication = anneePublication;
    }
    public void setNbExempaire(int nbExemplaire){
        this.nbExemplaire = nbExemplaire;
    }
}