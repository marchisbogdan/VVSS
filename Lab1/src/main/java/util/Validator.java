package main.java.util;

import java.util.List;

import main.java.model.Carte;

public class Validator {

    public static boolean isStringOK(String s) throws Exception {
        boolean flag = s.matches("[a-zA-Z]+");
        if (flag == false)
            throw new Exception("String invalid");
        return flag;
    }

    public static void validateCarte(Carte c) throws Exception {
        if (c.getCuvinteCheie() == null || c.getCuvinteCheie().size() == 0 ) {
            throw new Exception("Lista cuvinte cheie vida!");
        }
        if (c.getReferenti() == null || c.getReferenti().size() == 0 ) {
            throw new Exception("Lista autori vida!");
        }
        if (!isOKString(c.getTitlu())){
            throw new Exception("Titlu invalid!");
        }
        if(c.getTitlu().length() > 255){
        	throw new Exception("Titlu invalid! Lungime > 255");
        }
        for (String s : c.getReferenti()) {
            if (!isOKString(s))
                throw new Exception("Autor invalid! "+s);
            if(s.length() > 255){
            	throw new Exception("Autor invalid! Lungime > 255");
            }
        }
        for (String s : c.getCuvinteCheie()) {
            if (!isOKString(s))
                throw new Exception("Cuvant cheie invalid! "+s);
            if(s.length() > 255){
            	throw new Exception("Cuvant cheie invalid! Lungime > 255");
            }
        }
        if (!Validator.isNumber(c.getAnAparitie()))
            throw new Exception("An Aparitie invalid!");
        if(Integer.parseInt(c.getAnAparitie()) < 1 || Integer.parseInt(c.getAnAparitie()) > 2017){
        	throw new Exception("An Aparitie invalid! < 1 sau > 2017");
        }
        if(!isOKString(c.getEditura())){
        	throw new Exception("Editura invalid!");
        }
        if(c.getEditura().length() > 255){
        	throw new Exception("Editura invalid! Lungime > 255");
        }
    }

    public static boolean isNumber(String s) {
        return s.matches("[0-9]+");
    }

    public static boolean isOKString(String s) {
        String[] t = s.split(" ");
        if (t.length == 2) {
            boolean ok1 = t[0].matches("[a-zA-Z]+");
            boolean ok2 = t[1].matches("[a-zA-Z]+");
            if (ok1 == ok2 && ok1 == true) {
                return true;
            }
            return false;
        }
        return s.matches("[a-zA-Z]+");
    }

}
