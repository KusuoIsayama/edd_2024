package mx.unam.ciencias.edd.proyecto1;

import java.text.Collator;


public class Lineas implements Comparable<Lineas>{

    String cadena;

    public Lineas (String cadena){
        this.cadena = cadena;
    }

    @Override public String toString (){
        return cadena;
    }

    @Override public int compareTo (Lineas nuevaLinea){
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        return collator.compare(cadena.replaceAll("[^a-z]", ""),
		                        nuevaLinea.toString().replaceAll("[^a-z]", ""));
    }
}
