package main.java.begin;

import main.java.control.BibliotecaCtrl;
import main.java.repository.repo.CartiRepo;
import main.java.repository.repoInterfaces.CartiRepoInterface;
import main.java.repository.repoMock.CartiRepoMock;
import main.java.view.Consola;

import java.io.IOException;

//functionalitati
//i.	 adaugarea unei noi carti (titlu, autori, an aparitie, editura, cuvinte cheie);
//ii.	 cautarea cartilor scrise de un anumit autor (sau parti din numele autorului);
//iii.	 afisarea cartilor din biblioteca care au aparut intr-un anumit an, ordonate alfabetic dupa titlu si autori.


public class Start {

    public static void main(String[] args) {
        //CartiRepoInterface cr = new CartiRepo();
        CartiRepoInterface cr = new CartiRepoMock();
        BibliotecaCtrl bc = new BibliotecaCtrl(cr);
        Consola c = new Consola(bc);
        
        try {
            c.executa();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//	CartiRepoInterface cr = new CartiRepo();
//	BibliotecaCtrl bc = new BibliotecaCtrl(cr);
//
//	Carte c = new Carte();
//	bc = new BibliotecaCtrl(cr);
//	c = new Carte();
//
//	List<String> autori = new ArrayList<String>();
//	autori.add("Mateiu Caragiale");
//
//	List<String> cuvinteCheie = new ArrayList<String>();
//	cuvinteCheie.add("mateiu");
//	cuvinteCheie.add("crailor");
//
//	c.setTitlu("Intampinarea crailor");
//	c.setAutori(autori);
//	c.setAnAparitie("1948");
//	c.setEditura("Litera");
//	c.setCuvinteCheie(cuvinteCheie);
//
//
//	try {
//		for(Carte ca:bc.getCartiOrdonateDinAnul("1948"))
//			System.out.println(ca);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//
////	try {
////		bc.adaugaCarte(c);
////	} catch (Exception e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}

}