/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolmogorov;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-user
 */
public class Kolmogorov {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        double[] datos = {0.78961, 0.76086, 0.80548, 0.58518, 0.89898, 0.28269, 0.38618, 0.79982, 0.58962, 0.69623, 0.29931, 0.5741, 0.24, 0.93655, 0.54325, 0.58244, 0.23949, 0.19962, 0.19147, 0.22287, 0.0523, 0.12079, 0.82654, 0.98611, 0.5788, 0.73059, 0.7691, 0.45679, 0.33216, 0.17028, 0.30661, 0.26593, 0.65559, 0.88809, 0.62400, 0.85853, 0.53559, 0.65002, 0.40644, 0.07281,
            0.10699, 0.27738, 0.29453, 0.34488, 0.67621, 0.70119, 0.68334, 0.21631, 0.03185, 0.05475, 0.83358, 0.85903, 0.38507, 0.81772, 0.09133, 0.88752, 0.33381, 0.74579, 0.08128, 0.64183, 0.5587, 0.65726, 0.20852, 0.34358, 0.0501, 0.18284, 0.5517, 0.87616, 0.61168, 0.91512, 0.51781, 0.43308, 0.90829, 0.36982, 0.41678, 0.33729, 0.49383, 0.79113, 0.73435, 0.44267,
            0.14151, 0.179269, 0.42989, 0.11537, 0.00121, 0.49962, 0.1085, 0.55743, 0.09264, 0.76262, 0.03272, 0.35286, 0.94187, 0.19904, 0.33954, 0.15506, 0.75103, 0.63453, 0.22724, 0.72102};
        
        ArrayList<Integer> FO = new ArrayList<Integer>();
        ArrayList<Double> Fox = new ArrayList<Double>();
        ArrayList<Double> POA = new ArrayList<Double>();
        ArrayList<Double> PEA = new ArrayList<Double>();
        ArrayList<Double> total = new ArrayList<Double>();
        
        
        int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c10= 0;
        
        for (int i = 0; i < datos.length; i++) {

            if (datos[i] > 0 && datos[i] < 0.1) {
                c1++;
            }
            if (datos[i] > 0.1 && datos[i] < 0.2) {
                c2++;
            }
            if (datos[i] > 0.2 && datos[i] < 0.3) {
                c3++;
            }
            if (datos[i] > 0.3 && datos[i] < 0.4) {
                c4++;
            }
            if (datos[i] > 0.4 && datos[i] < 0.5) {
                c5++;
            }
            if (datos[i] > 0.5 && datos[i] < 0.6) {
                c6++;
            }
            if (datos[i] > 0.6 && datos[i] < 0.7) {
                c7++;
            }
            if (datos[i] > 0.7 && datos[i] < 0.8) {
                c8++;
            }

            if (datos[i] > 0.8 && datos[i] < 0.9) {
                c9++;
            }
            if (datos[i] > 0.9 && datos[i] < 1) {
                c10++;
            }
        }

        FO.add(c1);
        FO.add(c2);
        FO.add(c3);
        FO.add(c4);
        FO.add(c5);
        FO.add(c6);
        FO.add(c7);
        FO.add(c8);
        FO.add(c9);
        FO.add(c10);
        
        
        double sumaCuadrantes = 0;
        for (int i = 0; i < FO.size(); i++) {
            sumaCuadrantes = sumaCuadrantes + FO.get(i);
            Fox.add(sumaCuadrantes);
        }
        JOptionPane.showMessageDialog(null, "FO:\n\n" + FO + "\n\nFox:\n\n" + Fox);
        
        double pea = 0;
        for (int i = 0; i < Fox.size(); i++) {
            double por = Fox.get(i) / 100;
            POA.add(por);
        }

        System.out.println("POA:  " + POA);
        //System.out.println(PEA);
        for (int i = 1; i <= 10; i++) {

            pea = i * 0.1;
            PEA.add(pea);
        }
        JOptionPane.showMessageDialog(null,"PEA\n: " + PEA);

        double resultadoFin = 0;
        for (int i = 0; i < FO.size(); i++) {
            resultadoFin = PEA.get(i) - POA.get(i);

            total.add(resultadoFin);
        }

        JOptionPane.showMessageDialog(null,total);

        double D1 = datoAlto(total);
        System.out.println(D1);

        double D2 = 1.36 / Math.sqrt(100);
        JOptionPane.showMessageDialog(null,D2);

        if (D1 < D2) {
            JOptionPane.showMessageDialog(null, "Los valores Pseudoaleatorios provienen de una distribucion Uniforme");
        } else {
            JOptionPane.showMessageDialog(null, "Los numeros Pseudoaleatorios No provienen de una distribucion Uniforme");
        }

    }
    
    public static double datoAlto(ArrayList<Double> lista) {

        double datoAlto = lista.get(0);

        for (int x = 1; x < lista.size(); x++) {
            if (lista.get(x) > datoAlto) {
                datoAlto = lista.get(x);
            }
        }
        return datoAlto;
    }

}
