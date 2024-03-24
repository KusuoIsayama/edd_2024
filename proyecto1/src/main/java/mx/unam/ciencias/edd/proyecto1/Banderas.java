package mx.unam.ciencias.edd.proyecto1;

import mx.unam.ciencias.edd.Lista;


public class Banderas {

        String [] banderas;

            static final String BANDERA_INVERSA = "-r";
            static final String BANDERA_GUARDA = "-o";

        public Banderas (String [] args){
            banderas = args;
        }

        public boolean banderaReversa(){
            for (String agus : banderas){
                if (agus.equals(BANDERA_INVERSA))
                    return true;
            }
            return false;
        }
        public String banderaGuarda(){
            for (int a = 0; a < banderas.length; a++)
                if (banderas[a].equals(BANDERA_GUARDA))
                    if (banderas.length > a+1)
                    return banderas[a+1];
                else
                    throw new IllegalArgumentException("-o debe tener un archivo.");
            return null;
        }
}
