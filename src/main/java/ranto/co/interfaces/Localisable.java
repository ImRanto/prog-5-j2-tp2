package ranto.co.interfaces;

/**
 * Interface pour les objets qui peuvent être loués
 */
public interface Localisable {
    Double getPrixLocationJournalier();
    String getIdentifiant();
    Boolean estDisponible();
    void mettreAJourDisponibilite(Boolean disponible);
}