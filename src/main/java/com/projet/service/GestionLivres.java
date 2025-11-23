package com.projet.service;

import java.util.ArrayList;

import com.projet.model.Livres;

public class GestionLivres {
    private ArrayList<Livres> livres;

    public GestionLivres() {
        this.livres = new ArrayList<>();
    }
    public void ajouterLivre(String titre, String auteur, int anneePublication, int nbExemplaire) {
        Livres nouveauLivre = new Livres(titre, auteur, anneePublication, nbExemplaire);
        livres.add(nouveauLivre);
    }
    public void afficherLivres(){
        for(Livres livre : livres){
            System.out.println("Titre: " + livre.getTitre() + ", Auteur: " + livre.getAuteur() + ", Année: " + livre.getAnneePublication() + ", Nombre d'éxemplaire: " + livre.getNbExemplaire() + "\n");
        }
    }
    public String supprimerLivre(String titreLivre, String AuteurLivre){
        Livres livreSup = rechercherLivreParTitreEtAuteur(titreLivre, AuteurLivre);
        if(livreSup == null){
            String message = "Le livre n'existe pas";
            return message;
        }
        else{
            livres.remove(livreSup);
            String message = "Livre supprimer avec succés";
            return message;
        }
    }
    public void rechercherLivresParAuteur(String auteur){
        for(Livres livre : livres){
            if(livre.getAuteur().equalsIgnoreCase(auteur)){
                System.out.println("Titre: " + livre.getTitre() + ", Auteur: " + livre.getAuteur() + ", Année: " + livre.getAnneePublication() + ", Nombre d'éxemplaire: " + livre.getNbExemplaire() + "\n");
            }
        }
    }
    public void rechercherLivresParTitre(String titre){
        for(Livres livre : livres){
            if(livre.getTitre().equalsIgnoreCase(titre)){
                System.out.println("Titre: " + livre.getTitre() + ", Auteur: " + livre.getAuteur() + ", Année: " + livre.getAnneePublication() + ", Nombre d'éxemplaire: " + livre.getNbExemplaire() + "\n");
            }
        }
    }
    public Livres rechercherLivreParTitreEtAuteur(String titre, String auteur){
        for(Livres livre : livres){
            if(livre.getTitre().equalsIgnoreCase(titre) && livre.getAuteur().equalsIgnoreCase(auteur)){
                return livre;
            }
        }
        return null;
    }
}