package main.java.repository.repoInterfaces;

import main.java.model.Carte;

import java.util.List;

public interface CartiRepoInterface {
    void adaugaCarte(Carte c);

    void modificaCarte(Carte nou, Carte vechi);

    void stergeCarte(Carte c);

    List<Carte> cautaCarte(String ref);

    List<Carte> getCarti();

    List<Carte> getCartiOrdonateDinAnul(String an);

    Carte getByTitlu(String titlu);
}

