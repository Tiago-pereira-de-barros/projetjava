package com.projet.service;

import java.util.ArrayList;

import com.projet.model.Empruns;

public class GestionEmpruns{
    private ArrayList<Empruns> empruns;

    public GestionEmpruns(){
        this.empruns = new ArrayList<>();
    }
    public String Emprunter(String TitreLivre, String AuteurLivre, String DateEmpruns, boolean estDispo){
        if(estDispo){
            Empruns emprunsLivre = new Empruns(TitreLivre, AuteurLivre, DateEmpruns);
            empruns.add(emprunsLivre);
            String message = "Livre emprunter avec succés !";
            return message;
        }
        else{
            String message = "Le livre choisit n'est pas disponible";
            return message;
        }
    }
    public String RendreLivres(String TitreLivre, String AuteurLivre, String DateEmpruns, GestionLivres gestionlivres){
        boolean estEmprunter = false;
        for(Empruns emprun : empruns){
            if(emprun.getTitreLivre().equalsIgnoreCase(TitreLivre) && emprun.getAuteurLivre().equalsIgnoreCase(AuteurLivre) && emprun.getDateEmpruns().equalsIgnoreCase(DateEmpruns)){
                estEmprunter = true;
            }
        }
        if(estEmprunter){
            if(gestionlivres.rechercherLivreParTitreEtAuteur(TitreLivre, AuteurLivre) != null){
                for(Empruns emprun : empruns){
                    if(emprun.getTitreLivre().equalsIgnoreCase(TitreLivre) && emprun.getAuteurLivre().equalsIgnoreCase(AuteurLivre) && emprun.getDateEmpruns().equalsIgnoreCase(DateEmpruns)){
                        empruns.remove(emprun);
                        break;
                    }
                }
            }
            String message = "Livre rendu avec succé !";
            return message;
        }
        else{
            String message = "Livre n'a pas etais emprunter ou n'existe pas !";
            return message;
        }
    }
}