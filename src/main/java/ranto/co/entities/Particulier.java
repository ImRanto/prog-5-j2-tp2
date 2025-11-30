package ranto.co.entities;

import ranto.co.interfaces.Locataire;

public class Particulier implements Locataire {
    private final String identifiant;
    private final String nom;
    private final String prenom;
    private final Boolean eligibleLocation;

    public Particulier(String identifiant, String nom, String prenom) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.eligibleLocation = true;
    }

    public Particulier(String identifiant, String nom, String prenom, Boolean eligibleLocation) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.eligibleLocation = eligibleLocation;
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public String getNom() {
        return nom + " " + prenom;
    }

    @Override
    public Boolean peutLouer() {
        return eligibleLocation;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return String.format("Particulier[%s - %s %s - %s]",
                identifiant, prenom, nom,
                eligibleLocation ? "Éligible" : "Non éligible");
    }
}