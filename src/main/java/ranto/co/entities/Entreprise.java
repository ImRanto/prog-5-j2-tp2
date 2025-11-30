package ranto.co.entities;

import ranto.co.interfaces.Locataire;

public class Entreprise implements Locataire {
  private final String identifiant;
  private final String nom;
  private final Boolean eligibleLocation;

  public Entreprise(String identifiant, String nom) {
    this.identifiant = identifiant;
    this.nom = nom;
    this.eligibleLocation = true;
  }

  public Entreprise(String identifiant, String nom, String siret, Boolean eligibleLocation) {
    this.identifiant = identifiant;
    this.nom = nom;
    this.eligibleLocation = eligibleLocation;
  }

  @Override
  public String getIdentifiant() {
    return identifiant;
  }

  @Override
  public String getNom() {
    return nom;
  }

  @Override
  public Boolean peutLouer() {
    return eligibleLocation;
  }

  @Override
  public String toString() {
    return String.format(
        "Entreprise[%s - %s - %s]",
        identifiant, nom, eligibleLocation ? "Éligible" : "Non éligible");
  }
}
