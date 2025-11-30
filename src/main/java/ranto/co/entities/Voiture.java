package ranto.co.entities;

import ranto.co.interfaces.Localisable;

public class Voiture implements Localisable {
    private final String identifiant;
    private final String marque;
    private final String modele;
    private final Double prixJournalier;
    private Boolean disponible;

    public Voiture(String identifiant, String marque, String modele, Double prixJournalier) {
        this.identifiant = identifiant;
        this.marque = marque;
        this.modele = modele;
        this.prixJournalier = prixJournalier;
        this.disponible = true;
    }

    @Override
    public Double getPrixLocationJournalier() {
        return prixJournalier;
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public Boolean estDisponible() {
        return disponible;
    }

    @Override
    public void mettreAJourDisponibilite(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    @Override
    public String toString() {
        return String.format("Voiture[%s - %s %s - %.2fAr/jour - %s]",
                identifiant, marque, modele, prixJournalier,
                disponible ? "Disponible" : "Louée");
    }
}