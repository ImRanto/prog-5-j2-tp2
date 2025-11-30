package ranto.co.entities;

import ranto.co.interfaces.Localisable;

public class Ordinateur implements Localisable {
  private final String identifiant;
  private final String marque;
  private final String processeur;
  private final Double prixJournalier;
  private Boolean disponible;

  public Ordinateur(String identifiant, String marque, String processeur, Double prixJournalier) {
    this.identifiant = identifiant;
    this.marque = marque;
    this.processeur = processeur;
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

  public String getProcesseur() {
    return processeur;
  }

  @Override
  public String toString() {
    return String.format(
        "Ordinateur[%s - %s %s - %.2fAr/jour - %s]",
        identifiant, marque, processeur, prixJournalier, disponible ? "Disponible" : "Loué");
  }
}
