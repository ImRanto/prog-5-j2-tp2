package ranto.co.services;

import java.time.LocalDateTime;
import java.util.UUID;
import ranto.co.interfaces.Localisable;
import ranto.co.interfaces.Locataire;

/** Représente une location active */
public class Location {
  private final String id;
  private final Localisable objet;
  private final Locataire locataire;
  private final Integer dureeJours;
  private final LocalDateTime dateDebut;
  private final Double coutTotal;

  public Location(Localisable objet, Locataire locataire, Integer dureeJours) {
    this.id = UUID.randomUUID().toString();
    this.objet = objet;
    this.locataire = locataire;
    this.dureeJours = dureeJours;
    this.dateDebut = LocalDateTime.now();
    this.coutTotal = objet.getPrixLocationJournalier() * dureeJours;
  }

  public String getId() {
    return id;
  }

  public Localisable getObjet() {
    return objet;
  }

  public Locataire getLocataire() {
    return locataire;
  }

  public Integer getDureeJours() {
    return dureeJours;
  }

  public LocalDateTime getDateDebut() {
    return dateDebut;
  }

  public Double getCoutTotal() {
    return coutTotal;
  }

  @Override
  public String toString() {
    return String.format(
        "Location[%s - %s loué à %s - %d jours - %.2fAr]",
        id, objet.getIdentifiant(), locataire.getNom(), dureeJours, coutTotal);
  }
}
