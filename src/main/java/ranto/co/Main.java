package ranto.co;

import ranto.co.controller.ControleurLocation;
import ranto.co.entities.*;
import ranto.co.services.Location;

public class Main {
  public static void main(String[] args) {
    ControleurLocation controleur = new ControleurLocation();

    // objets à louer
    controleur.ajouterObjet(new Voiture("V1", "Renault", "Clio", 45000.0));
    controleur.ajouterObjet(new Maison("M1", "Antananarivo Ambohimanarina", 60, 15000.0));
    controleur.ajouterObjet(new Ordinateur("PC1", "Asus", "i5", 3500.0));

    // des locataires
    controleur.ajouterLocataire(new Particulier("P001", "Rafalimanana", "Ranto Handraina"));
    controleur.ajouterLocataire(new Particulier("P002", "Rakoto", "Rabe", false)); // Non éligible
    controleur.ajouterLocataire(new Entreprise("E001", "Ranto Tech"));

    // Les objets disponibles
    System.out.println("=== OBJETS DISPONIBLES ===");
    controleur.getObjetsDisponibles().forEach(System.out::println);

    // Affichage des locataires
    System.out.println("\n=== LOCATAIRES ===");
    controleur.getTousLesLocataires().forEach(System.out::println);

    // Effectuer des locations
    System.out.println("\n=== EFFECTUER DES LOCATIONS ===");
    Location location1 = controleur.effectuerLocation("V1", "P001", 5);
    Location location2 = controleur.effectuerLocation("M1", "E001", 3);

    // Location avec locataire non éligible
    Location location3 = controleur.effectuerLocation("O1", "P002", 2);

    // Locations actives
    System.out.println("\n=== LOCATIONS ACTIVES ===");
    controleur.getLocationsActives().forEach(System.out::println);

    // Objets disponibles après locations
    System.out.println("\n=== OBJETS DISPONIBLES APRÈS LOCATIONS ===");
    controleur.getObjetsDisponibles().forEach(System.out::println);

    // Retour d'un objet
    System.out.println("\n=== RETOUR D'OBJET ===");
    controleur.retournerObjet("V1");

    // Version FINAL
    System.out.println("\n=== SITUATION FINALE ===");
    System.out.println("Locations actives:");
    controleur.getLocationsActives().forEach(System.out::println);
    System.out.println("\nObjets disponibles:");
    controleur.getObjetsDisponibles().forEach(System.out::println);
  }
}
