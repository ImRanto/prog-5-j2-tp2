package ranto.co.services;

import ranto.co.exception.LocataireNonEligibleException;
import ranto.co.exception.ObjetIndisponibleException;
import ranto.co.exception.ObjetNonTrouveException;
import ranto.co.interfaces.Localisable;
import ranto.co.interfaces.Locataire;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Service principal pour gérer les locations
 */
public class GestionnaireLocation {
    private static final Logger LOGGER = Logger.getLogger(GestionnaireLocation.class.getName());

    private final List<Localisable> objetsLocalisables;
    private final List<Locataire> locataires;
    private final List<Location> locationsActives;

    public GestionnaireLocation() {
        this.objetsLocalisables = new ArrayList<>();
        this.locataires = new ArrayList<>();
        this.locationsActives = new ArrayList<>();
    }

    public void ajouterObjetLocalisable(Localisable objet) {
        objetsLocalisables.add(objet);
        LOGGER.info("Objet ajouté: " + objet.getIdentifiant());
    }

    public void ajouterLocataire(Locataire locataire) {
        locataires.add(locataire);
        LOGGER.info("Locataire ajouté: " + locataire.getIdentifiant());
    }

    public Location louerObjet(String identifiantObjet, String identifiantLocataire, Integer dureeJours)
            throws ObjetIndisponibleException, LocataireNonEligibleException, ObjetNonTrouveException {

        Localisable objet = trouverObjetParIdentifiant(identifiantObjet)
                .orElseThrow(() -> new ObjetNonTrouveException("Objet non trouvé: " + identifiantObjet));

        Locataire locataire = trouverLocataireParIdentifiant(identifiantLocataire)
                .orElseThrow(() -> new ObjetNonTrouveException("Locataire non trouvé: " + identifiantLocataire));

        if (!objet.estDisponible()) {
            throw new ObjetIndisponibleException("Objet non disponible: " + identifiantObjet);
        }

        if (!locataire.peutLouer()) {
            throw new LocataireNonEligibleException("Locataire non éligible: " + identifiantLocataire);
        }

        Location location = new Location(objet, locataire, dureeJours);
        locationsActives.add(location);
        objet.mettreAJourDisponibilite(false);

        LOGGER.info(String.format("Location créée: %s loué à %s pour %d jours",
                objet.getIdentifiant(), locataire.getNom(), dureeJours));

        return location;
    }

    public void retournerObjet(String identifiantObjet) throws ObjetNonTrouveException {
        Location location = locationsActives.stream()
                .filter(loc -> loc.getObjet().getIdentifiant().equals(identifiantObjet))
                .findFirst()
                .orElseThrow(() -> new ObjetNonTrouveException("Location active non trouvée pour: " + identifiantObjet));

        locationsActives.remove(location);
        location.getObjet().mettreAJourDisponibilite(true);

        LOGGER.info("Objet retourné: " + identifiantObjet);
    }

    private Optional<Localisable> trouverObjetParIdentifiant(String identifiant) {
        return objetsLocalisables.stream()
                .filter(obj -> obj.getIdentifiant().equals(identifiant))
                .findFirst();
    }

    private Optional<Locataire> trouverLocataireParIdentifiant(String identifiant) {
        return locataires.stream()
                .filter(loc -> loc.getIdentifiant().equals(identifiant))
                .findFirst();
    }

    public List<Localisable> getObjetsDisponibles() {
        return objetsLocalisables.stream()
                .filter(Localisable::estDisponible)
                .toList();
    }

    public List<Location> getLocationsActives() {
        return new ArrayList<>(locationsActives);
    }

    public List<Localisable> getObjetsLocalisables() {
        return new ArrayList<>(objetsLocalisables);
    }

    public List<Locataire> getLocataires() {
        return new ArrayList<>(locataires);
    }
}