package ranto.co.entities;


import ranto.co.interfaces.Localisable;

public class Maison implements Localisable {
    private final String identifiant;
    private final String adresse;
    private final Integer superficie;
    private final Double prixJournalier;
    private Boolean disponible;

    public Maison(String identifiant, String adresse, Integer superficie, Double prixJournalier) {
        this.identifiant = identifiant;
        this.adresse = adresse;
        this.superficie = superficie;
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

    public String getAdresse() {
        return adresse;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    @Override
    public String toString() {
        return String.format("Maison[%s - %s - %dm² - %.2fAr/jour - %s]",
                identifiant, adresse, superficie, prixJournalier,
                disponible ? "Disponible" : "Louée");
    }
}