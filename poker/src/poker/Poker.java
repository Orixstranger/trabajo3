/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author lenovo-user
 */
public class Poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double datos[] = {0.64138, 0.55837, 0.81593, 0.04994, 0.61265, 0.06787, 0.30465, 0.54264, 0.81159, 0.61163, 0.47681, 0.52127, 0.69239, 0.92006, 0.37913, 0.32035, 0.37248, 0.57836, 0.19180, 0.28920, 0.79302, 0.08124, 0.53401, 0.48201,
            0.03268, 0.38087, 0.68054, 0.69251, 0.60284, 0.69351, 0.64264, 0.22409, 0.80242, 0.58071, 0.31629, 0.03585, 0.46034, 0.57039, 0.15096, 0.15523, 0.64388, 0.83371, 0.04198, 0.49796, 0.16087, 0.68317, 0.39974, 0.48571, 0.93409, 0.90760,
            0.59867, 0.10238, 0.57576, 0.20976, 0.25934, 0.27937, 0.74035, 0.26204, 0.06659, 0.75064, 0.08396, 0.14600, 0.07700, 0.76808, 0.90808, 0.19125, 0.71868, 0.31794, 0.81621, 0.47948, 0.93661, 0.72871, 0.96122, 0.52904, 0.18658, 0.81139,
            0.71166, 0.92589, 0.23092, 0.92253, 0.81515, 0.91642, 0.93912, 0.59072, 0.38699, 0.22783, 0.54638, 0.59725, 0.30204, 0.63166, 0.07339, 0.65144, 0.81809, 0.01614, 0.86034, 0.05137, 0.50878, 0.98290, 0.41824, 0.97056,};

        ArrayList<Integer> FO = new ArrayList<Integer>();
        ArrayList<Integer> FE = new ArrayList<Integer>();
        Poker p = new Poker();
        char[] caracteres;
        int contDif = 0;
        int contPar = 100;
        int contDosp = 0, cont1 = 0, cont2 = 0, cont3 = 0;

        String cadena = "";
        for (int i = 0; i < datos.length; i++) {
            cadena = Double.toString(datos[i]);
            String remplazado = cadena.replace("0.", "");
            //System.out.println(remplazado);
            caracteres = remplazado.toCharArray();
            cont1 = 0;
            cont2 = 0;
            cont3 = 0;
            for (int j = 0; j < caracteres.length; j++) {

                for (int k = j + 1; k < caracteres.length; k++) {
                    if (caracteres[j] == caracteres[k]) {
                        System.out.println(caracteres[j] + " es igual " + caracteres[k]);
                        cont1++;

                    } else {
                        System.out.println(caracteres[j] + " no es igual " + caracteres[k]);
                        cont2++;
                    }

                }
                
                if (cont1 == 2) {
                    cont3++;
                    cont1 = 0;
                    contDosp = contDosp + cont3;
                    System.out.println("existen 2 pares");
                    contPar = contPar - cont3;

                } else if (cont2==10) {
                    cont2 = 1;
                    contDif = contDif + cont2;
                    contPar = contPar - cont2;
                } 
            }

            System.out.println("Total pares: " + contPar);
            System.out.println("Total diferentes: " + contDif);
            System.out.println("Total Dos pares: " + contDosp);
            System.out.println("\n");
            
            System.out.println("FO-FE");
           
            double FoFe2 = Math.pow(contDif - p.frecuenciaEsperadaDif(), 2) + Math.pow(contDif - p.frecuenciaEsperadaPar(), 2) + Math.pow(contDif - p.frecuenciaEsperadaDosPares(), 2) + Math.pow(contDif - p.frecuenciaEsperadaTercia(), 2) + Math.pow(contDif - p.frecuenciaEsperadaFull(), 2) + Math.pow(contDif - p.frecuenciaEsperadaPoker(), 2) + Math.pow(contDif - p.frecuenciaEsperadaQuintilla(), 2);
            double FoFediv2 = FoFe2/(p.frecuenciaEsperadaDif()+p.frecuenciaEsperadaDosPares()+p.frecuenciaEsperadaFull()+p.frecuenciaEsperadaPar()+p.frecuenciaEsperadaPoker()+p.frecuenciaEsperadaQuintilla()+p.frecuenciaEsperadaTercia());
            
            System.out.println("No pasa la prueba "+FoFediv2);
            
            
            double cont = 0;
            
            System.out.println("");

        }

    }
    public double frecuenciaEsperadaDif(){
        return 100 * 0.3024;
    }
    
    public double frecuenciaEsperadaPar(){
        return 100 * 0.504;
    } 
    public double frecuenciaEsperadaDosPares(){
        return 100 * 0.108;
    }
    public double frecuenciaEsperadaTercia(){
        return 100 * 0.072;
    }
    public double frecuenciaEsperadaFull(){
        return 100 * 0.009;
    }
    public double frecuenciaEsperadaPoker(){
        return 100 * 0.0045;
    }
    public double frecuenciaEsperadaQuintilla(){
        return 100 * 0.0001;
    }

}

