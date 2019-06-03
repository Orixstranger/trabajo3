/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaseries;

import java.util.ArrayList;

/**
 *
 * @author lenovo-user
 */
public class PruebaSeries {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {

        double valoresLista[] = {0.64138,0.55837,0.81593,0.04994,0.61265,0.06787,0.30465,0.54264,0.81159,0.61163,0.47681,0.52127,0.69239,0.92006,0.37913,0.32035,0.37248,0.57836,0.19180,0.28920,0.79302,0.08124,0.53401,0.48201,
            0.03268,0.38087,0.68054,0.69251,0.60284,0.69351,0.64264,0.22409,0.80242,0.58071,0.31629,0.03585,0.46034,0.57039,0.15096,0.15523,0.64388,0.83371,0.04198,0.49796,0.16087,0.68317,0.39974,0.48571,0.93409,0.90760,
            0.59867,0.10238,0.57576,0.20976,0.25934,0.27937,0.74035,0.26204,0.06659,0.75064,0.08396,0.14600,0.07700,0.76808,0.90808,0.19125,0.71868,0.31794,0.81621,0.47948,0.93661,0.72871,0.96122,0.52904,0.18658,0.81139,
            0.71166,0.92589,0.23092,0.92253,0.81515,0.91642,0.93912,0.59072,0.38699,0.22783,0.54638,0.59725,0.30204,0.63166,0.07339,0.65144,0.81809,0.01614,0.86034,0.05137,0.50878,0.98290,0.41824,0.97056,};
        
        int contador = 0;
        int matriz[][] = new int[5][5];
        boolean first = false;
        boolean second = false;
        double variableX,variableY;
        double cuadrante_en_x;
        double cuadrante_en_y;
        double valor_aumento = 0.2;
        ArrayList<Integer> frecuenciaObtenida = new ArrayList<Integer>();
        ArrayList<Double> frecuenciaEsperada = new ArrayList<Double>();
        ArrayList<Double> Total = new ArrayList<Double>();
        
           for (int i = 0; i < valoresLista.length; i++) {
               
           }

        while (contador < valoresLista.length - 1) {

            String aux = "";
            for (int y = 0; y < matriz.length; y++) {

                for (int x = 0; x < matriz[y].length; x++) {
                    variableX = valoresLista[contador];
                    variableY = valoresLista[contador + 1];
                    cuadrante_en_x = (x + 1) * valor_aumento;
                    cuadrante_en_y = (y + 1) * valor_aumento;

                    first = (variableX >= (valor_aumento * x)) && (variableX <= cuadrante_en_x);
                    second = (variableY >= (valor_aumento * y)) && variableY <= cuadrante_en_y;

                    if (first && second) {

                        System.out.println("pareja: " + "[" + variableX + " , " + variableY + "]\n");
                        System.out.println("x: " + x);
                        System.out.println("y: " + y + "\n");

                        matriz[x][y] = matriz[x][y] + 1;
                    }

                    aux = "x = " + x + "  " + "y =" + y + "   " + "( " + valoresLista[contador] + "," + valoresLista[contador + 1] + " )" + "cuadrante: " + contador;
                }
            }

            contador++;
        }

        double ei = ((valoresLista.length - 1) / (Math.pow(matriz.length, 2)));
        double resul = 0;

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {

                frecuenciaObtenida.add(matriz[y][x]);

                frecuenciaEsperada.add(ei);
            }
            System.out.println();

        }

        double sumador = 0;

        System.out.println(" FE: " + frecuenciaEsperada);
        System.out.println(" FO: " + frecuenciaObtenida);

        for (int j = 0; j < frecuenciaEsperada.size(); j++) {
            resul = (Math.pow((frecuenciaEsperada.get(j) - frecuenciaObtenida.get(j)), 2)) / frecuenciaEsperada.get(j);
            sumador += resul;
            Total.add(resul);
        }

        System.out.println(Total);
        System.out.println(sumador);

      //  Recorrer la matriz
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {

                System.out.print(" | ");
                System.out.print(matriz[y][x]);
                System.out.print(" | ");

            }
            System.out.println();

        }

    }


    
}
