/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corridas;

import java.util.ArrayList;

/**
 *
 * @author lenovo-user
 */
public class Corridas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Corridas cd = new Corridas();
        String aux = "";
        int np = 0;
        ArrayList<Double> n_pseudoaleatorios = new ArrayList<>();

        double datos[] = {0.64138, 0.55837, 0.81593, 0.04994, 0.61265, 0.06787, 0.30465, 0.54264, 0.81159, 0.61163, 0.47681, 0.52127, 0.69239, 0.92006, 0.37913, 0.32035, 0.37248, 0.57836, 0.19180, 0.28920, 0.79302, 0.08124, 0.53401, 0.48201,
            0.03268, 0.38087, 0.68054, 0.69251, 0.60284, 0.69351, 0.64264, 0.22409, 0.80242, 0.58071, 0.31629, 0.03585, 0.46034, 0.57039, 0.15096, 0.15523, 0.64388, 0.83371, 0.04198, 0.49796, 0.16087, 0.68317, 0.39974, 0.48571, 0.93409, 0.90760,
            0.59867, 0.10238, 0.57576, 0.20976, 0.25934, 0.27937, 0.74035, 0.26204, 0.06659, 0.75064, 0.08396, 0.14600, 0.07700, 0.76808, 0.90808, 0.19125, 0.71868, 0.31794, 0.81621, 0.47948, 0.93661, 0.72871, 0.96122, 0.52904, 0.18658, 0.81139,
            0.71166, 0.92589, 0.23092, 0.92253, 0.81515, 0.91642, 0.93912, 0.59072, 0.38699, 0.22783, 0.54638, 0.59725, 0.30204, 0.63166, 0.07339, 0.65144, 0.81809, 0.01614, 0.86034, 0.05137, 0.50878, 0.98290, 0.41824, 0.97056,};
        for (int i = 0; i < datos.length / 3; i++) { //para mostrar los numeros en pantalla
            for (int j = 0; j < 10; j++) {
                if (np == datos.length) {
                    break;
                }
                aux = aux + datos[np] + ", ";
                np++;

            }
            aux = aux + "\n";
        }
        System.out.println("" + aux);

        for (int i = 0; i < datos.length; i++) {
            n_pseudoaleatorios.add(datos[i]);
        }

        cd.prueba_Corridas(datos);
    }

    public void prueba_Corridas(double n_pseudoaleatorios[]) {
        
        System.out.println("\n<<<< PRUEBA CORRIDAS >>>>\n");
        
        ArrayList<Integer> binarios = new ArrayList<>();
        String aux = "";
        int n1 = 0, n2 = 0, R = 1;
        double Xr = 0, h = 0.00, Sr = 0.00, Zo = 0.00;
        int N = n_pseudoaleatorios.length;
        for (int i = 0; i < N; i++) {
            if (n_pseudoaleatorios[i] > 0.5) {
                binarios.add(1);
                n2++;//# de corridas
            } else {
                binarios.add(0);
                n1++;
            }
            if (i > 0) {
                if (binarios.get(i - 1) != binarios.get(i)) {
                    R++;
                }
            }
            aux = aux + binarios.get(i) + " ";
        }
        System.out.println(aux);
        System.out.println("R... " + R);
        Xr = ((double) (2 * n1 * n2) / (n1 + n2)) + 1;//+1;//promedio de las corridas
        System.out.println("Xr... " + Xr);
        if (R < Xr) {
            h = 0.5;
        } else {
            h = -0.5;
        }
        System.out.println("h... " + h);
        // 182104/26100//0.0083

        double desv = (((2 * n1 * n2) * ((2 * n1 * n2) - n1 - n2)) / ((Math.pow((n1 + n2), 2)) * (n1 + n2 - 1)));

        Sr = Math.sqrt(desv);//desviacion estandar de las corridas
        System.out.println("Sr... " + Sr);
        Zo = (R + h - Xr) / Sr;
        System.out.println("Estadistico Zo... " + Zo);
        //nivel de confianza del 95%  --> 0.975  (Tabla dist normal Z )   Z(α/2)   α=0.05
        if (Zo < 1.96 && Zo > -1.96) {
            System.out.println("\nLa muestra sigue una secuencia aleatoria");
        } else {
            System.out.println("\nLa muestra no sigue una secuencia aleatoria");
        }

    }
}
