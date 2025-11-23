package com.projet;

import java.util.Scanner;

import com.projet.model.Livres;
import com.projet.service.GestionEmpruns;
import com.projet.service.GestionLivres;

public class Main {
    public static void main(String[] args) {
        int choix = -2;
        GestionLivres BiblioLivres = new GestionLivres();
        GestionEmpruns empruns = new GestionEmpruns();
        Scanner sc = new Scanner(System.in);
        while (choix != 3){
            System.out.println("Bienvenue dans la gestion de la bibliothèque !");
                System.out.println("1. Accéder a la gestion des livres");
                System.out.println("2. Accéder a la gestion des empruns");
                System.out.println("3. Quitter");
                choix = sc.nextInt();

                switch (choix) {
                    case 1:
                        while (choix != 0) {
                            System.out.println("1. Ajouter un livre");
                            System.out.println("2. Afficher les livres");
                            System.out.println("3. Rechercher un livre");
                            System.out.println("4. Supprimer un livre");
                            System.out.println("0. Quitter");
                            choix = sc.nextInt();
                            switch (choix) {
                                case 1:
                                    System.out.println("Entrez le titre du livre:");
                                    String titre = sc.next();
                                    System.out.println("Entrez l'auteur du livre:");
                                    String auteur = sc.next();
                                    System.out.println("Entrez l'année de publication:");
                                    int annee = sc.nextInt();
                                    System.out.println("Entrez le nombre d'exemplaire disponible:");
                                    int nbExemp = sc.nextInt();
                                    BiblioLivres.ajouterLivre(titre, auteur, annee, nbExemp);
                                    System.out.println("Livre ajouté avec succès !");
                                    break;
                                case 2:
                                    BiblioLivres.afficherLivres();
                                    break;
                                case 3:
                                    System.out.println("Rechercher par : 1. Titre 2. Auteur");
                                    int critere = sc.nextInt();
                                    if (critere == 1) {
                                        System.out.println("Entrez le titre du livre:");
                                        String rechercheTitre = sc.next();
                                        BiblioLivres.rechercherLivresParTitre(rechercheTitre);
                                    } else if (critere == 2) {
                                        System.out.println("Entrez l'auteur du livre:");
                                        String rechercheAuteur = sc.next();
                                        BiblioLivres.rechercherLivresParAuteur(rechercheAuteur);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Titre du livre à supprimer:");
                                    String titreLivreSup = sc.next();
                                    System.out.println("Auteur du livre à supprimer:");
                                    String auteurLivreSup = sc.next();
                                    System.out.println(BiblioLivres.supprimerLivre(titreLivreSup, auteurLivreSup));
                                    break;
                            }
                        }
                        break;
                    case 2:
                        while(choix != 0){
                            System.out.println("1. Emprunter un livre");
                            System.out.println("2. Rendre un livre");
                            System.out.println("0. Quitter");
                            choix = sc.nextInt();
                            switch (choix) {
                                case 1:
                                    System.out.println("Entrez le titre du livre à emprunter:");
                                    String titreEmpruns = sc.next();
                                    System.out.println("Entrez l'auteur du livre à emprunter:");
                                    String auteurEmpruns = sc.next();
                                    System.out.println("Entrez la date d'aujourd'hui:");
                                    String dateEmpruns = sc.next();
                                    boolean estDispo = false;
                                    Livres livreChoisi = BiblioLivres.rechercherLivreParTitreEtAuteur(titreEmpruns, auteurEmpruns);
                                    if(livreChoisi.getNbExemplaire() > 0){
                                        estDispo = true;
                                        livreChoisi.setNbExempaire(livreChoisi.getNbExemplaire() - 1);
                                        System.out.println(empruns.Emprunter(titreEmpruns, auteurEmpruns, dateEmpruns, estDispo));
                                    }
                                    else{
                                        System.out.println(empruns.Emprunter(titreEmpruns, auteurEmpruns, dateEmpruns, estDispo));
                                    }
                                    break;
                                case 2:
                                        System.out.println("Entrez le titre du livre que vous avez emprunter:");
                                        String titreEmprunsRendre = sc.next();
                                        System.out.println("Entrez l'auteur du livre que vous avez emprunter:");
                                        String auteurEmprunsRendre = sc.next();
                                        System.out.println("Entrez la date de l'empruns:");
                                        String dateEmprunsRendre = sc.next();
                                        System.out.println(empruns.RendreLivres(titreEmprunsRendre, auteurEmprunsRendre, dateEmprunsRendre, BiblioLivres));
                                        Livres livreEmpruns = BiblioLivres.rechercherLivreParTitreEtAuteur(titreEmprunsRendre, auteurEmprunsRendre);
                                        livreEmpruns.setNbExempaire(livreEmpruns.getNbExemplaire() + 1);
                                    break;
                            }
                        }
                        break;
                }
        }
    }
}