package main.java.view;

import main.java.control.BibliotecaCtrl;
import main.java.model.Carte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {

    private BibliotecaCtrl bc;
    private BufferedReader console;

    public Consola(BibliotecaCtrl bc) {
        this.bc = bc;
    }

    public void executa() throws IOException {

        console = new BufferedReader(new InputStreamReader(System.in));

        int opt = -1;
        while (opt != 0) {

            switch (opt) {
                case 1:
                    adauga();
                    break;
                case 2:
                    cautaCartiDupaAutor();
                    break;
                case 3:
                    afiseazaCartiOrdonateDinAnul();
                    break;
                case 4:
                    afiseazaToateCartile();
                    break;
                case 5:
                    modifica();
                    break;
                case 6:
                    sterge();
                    break;
            }

            printMenu();
            String line;
            do {
                System.out.println("Introduceti un nr:");
                line = console.readLine();
            } while (!line.matches("[0-6]"));
            opt = Integer.parseInt(line);
        }
    }

    public void printMenu() {
        System.out.println("\n\n\n");
        System.out.println("Evidenta cartilor dintr-o biblioteca");
        System.out.println("     1. Adaugarea unei noi carti");
        System.out.println("     2. Cautarea cartilor scrise de un anumit autor");
        System.out.println("     3. Afisarea cartilor din biblioteca care au aparut intr-un anumit an, ordonate alfabetic dupa titlu si autori");
        System.out.println("     4. Afisarea toturor cartilor");
        System.out.println("     5. Modificare carte");
        System.out.println("     6. Stergere carte");
        System.out.println("     0. Exit");
    }

    public void sterge(){
        Carte c = new Carte();
        try {
            System.out.println("\n\n\n");

            System.out.println("Titlu cartii:");
            String titlu = console.readLine();

            c = bc.getByTitlu(titlu);
            if(c==null){
                System.out.println("Nu exista carti cu acest titlu!!");
                return;
            }
            bc.stergeCarte(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifica(){
        Carte c_v = new Carte();
        Carte c = new Carte();
        try {
            System.out.println("\n\n\n");

            System.out.println("Titlu cartii vechi:");
            String titlu = console.readLine();
            c_v = bc.getByTitlu(titlu);

            if(c_v==null){
                System.out.println("Nu exista carti cu acest titlu!!");
                return;
            }

            System.out.println("Titlu:");
            c.setTitlu(console.readLine());

            System.out.println("Editura:");
            c.setEditura(console.readLine());

            String line;
            do {
                System.out.println("An aparitie:");
                line = console.readLine();
            } while (!line.matches("[10-9]+"));
            c.setAnAparitie(line);

            do {
                System.out.println("Nr. de referent:");
                line = console.readLine();
            } while (!line.matches("[1-9]+"));
            int nrReferenti = Integer.parseInt(line);
            for (int i = 1; i <= nrReferenti; i++) {
                System.out.println("Autor " + i + ": ");
                c.adaugaReferent(console.readLine());
            }

            do {
                System.out.println("Nr. de cuvinte cheie:");
                line = console.readLine();
            } while (!line.matches("[1-9]+"));
            int nrCuv = Integer.parseInt(line);
            for (int i = 1; i <= nrCuv; i++) {
                System.out.println("Cuvant " + i + ": ");
                c.adaugaCuvantCheie(console.readLine());
            }

            bc.modificaCarte(c,c_v);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void adauga() {
        Carte c = new Carte();
        try {
            System.out.println("\n\n\n");

            System.out.println("Titlu:");
            c.setTitlu(console.readLine());

            System.out.println("Editura:");
            c.setEditura(console.readLine());

            String line;
            do {
                System.out.println("An aparitie:");
                line = console.readLine();
            } while (!line.matches("[10-9]+"));
            c.setAnAparitie(line);

            do {
                System.out.println("Nr. de referent:");
                line = console.readLine();
            } while (!line.matches("[1-9]+"));
            int nrReferenti = Integer.parseInt(line);
            for (int i = 1; i <= nrReferenti; i++) {
                System.out.println("Autor " + i + ": ");
                c.adaugaReferent(console.readLine());
            }

            do {
                System.out.println("Nr. de cuvinte cheie:");
                line = console.readLine();
            } while (!line.matches("[1-9]+"));
            int nrCuv = Integer.parseInt(line);
            for (int i = 1; i <= nrCuv; i++) {
                System.out.println("Cuvant " + i + ": ");
                c.adaugaCuvantCheie(console.readLine());
            }

            bc.adaugaCarte(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afiseazaToateCartile() {
        System.out.println("\n\n\n");
        try {
            for (Carte c : bc.getCarti())
                System.out.println(c);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cautaCartiDupaAutor() {

        System.out.println("\n\n\n");
        System.out.println("Autor:");
        try {
            for (Carte c : bc.cautaCarte(console.readLine())) {
                System.out.println(c);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void afiseazaCartiOrdonateDinAnul() {
        System.out.println("\n\n\n");
        try {
            String line;
            do {
                System.out.println("An aparitie:");
                line = console.readLine();
            } while (!line.matches("[10-9]+"));
            for (Carte c : bc.getCartiOrdonateDinAnul(line)) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
