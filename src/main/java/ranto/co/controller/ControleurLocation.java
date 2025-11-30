package ranto.co.controller;

import java.util.List;
import java.util.logging.Logger;
import ranto.co.exception.LocataireNonEligibleException;
import ranto.co.exception.ObjetIndisponibleException;
import ranto.co.exception.ObjetNonTrouveException;
import ranto.co.interfaces.Localisable;
import ranto.co.interfaces.Locataire;
import ranto.co.services.GestionnaireLocation;
import ranto.co.services.Location;

public class ControleurLocation {
  private static final Logger LOGGER = Logger.getLogger(ControleurLocation.class.getName());
  private final GestionnaireLocation gestionnaireLocation;

  public ControleurLocation() {
    this.gestionnaireLocation = new GestionnaireLocation();
  }

  public void ajouterObjet(Localisable objet) {
    gestionnaireLocation.ajouterObjetLocalisable(objet);
  }

  public void ajouterLocataire(Locataire locataire) {
    gestionnaireLocation.ajouterLocataire(locataire);
  }

  public Location effectuerLocation(
      String identifiantObjet, String identifiantLocataire, Integer dureeJours) {
    try {
      Location location =
          gestionnaireLocation.louerObjet(identifiantObjet, identifiantLocataire, dureeJours);
      LOGGER.info("Location effectuée avec succès");
      return location;
    } catch (ObjetIndisponibleException
        | LocataireNonEligibleException
        | ObjetNonTrouveException e) {
      LOGGER.severe("Erreur lors de la location: " + e.getMessage());
      return null;
    }
  }

  public boolean retournerObjet(String identifiantObjet) {
    try {
      gestionnaireLocation.retournerObjet(identifiantObjet);
      LOGGER.info("Retour effectué avec succès");
      return true;
    } catch (ObjetNonTrouveException e) {
      LOGGER.severe("Erreur lors du retour: " + e.getMessage());
      return false;
    }
  }

  public List<Localisable> getObjetsDisponibles() {
    return gestionnaireLocation.getObjetsDisponibles();
  }

  public List<Location> getLocationsActives() {
    return gestionnaireLocation.getLocationsActives();
  }

  public List<Localisable> getTousLesObjets() {
    return gestionnaireLocation.getObjetsLocalisables();
  }

  public List<Locataire> getTousLesLocataires() {
    return gestionnaireLocation.getLocataires();
  }
}
