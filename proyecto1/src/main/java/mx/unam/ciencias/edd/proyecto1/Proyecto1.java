package mx.unam.ciencias.edd.proyecto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

import mx.unam.ciencias.edd.Lista;

public class Proyecto1 {


    static Lista<Lineas> lineas = new Lista<>();

    public static Lista<Lineas> leerArchivo(String nombreArchivo) {
       // Lista<String> lineas = new Lista<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.agrega(new Lineas(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
    public static Lista<Lineas> leerEntrada() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.agrega(new Lineas(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       return lineas;
    }

    public static void imprimirLineas(Lista<Lineas> lineas) {
        for (Lineas linea : lineas) {
            System.out.println(linea);
        }
    }

    public static Lista<Lineas> ordena(Lista<Lineas> lineas) {
       return lineas.mergeSort((a, b) -> a.compareTo(b));
    }

    public static Lista <Lineas> reversa (Lista <Lineas> lineas){
            return ordena(lineas).reversa();
        }

    public static void main (String [] args){

    Banderas banderas = new Banderas(args);
   String salida = null;
    if (args.length > 0) {
            for (String archivo : args) {
                if (archivo.equals(Banderas.BANDERA_INVERSA))
                    continue;
                if (archivo.equals(Banderas.BANDERA_GUARDA))
                    continue;
                Lista<Lineas> lineas = leerArchivo(archivo);
                    if (banderas.banderaReversa()) {
                    imprimirLineas(reversa(lineas));
                    } else {
                        imprimirLineas(ordena(lineas));
                    }
                  try {
                        salida = banderas.banderaGuarda();
                        } catch(IllegalArgumentException iae) {
                            System.out.println("\nLa bandera -o debe estar seguida de un archivo");
                        System.exit(1);
                        }
            }
        }
   else {
        Lista<Lineas> lineas = leerEntrada();
        if (banderas.banderaReversa()) {
            imprimirLineas(reversa(lineas));
        } else {
            imprimirLineas(ordena(lineas));
        }
        try {
                salida = banderas.banderaGuarda();
                } catch(IllegalArgumentException iae) {
                        System.out.println("\nLa bandera -o debe estar seguida de un archivo");
                    System.exit(1);
                }
      }
    }
  }
