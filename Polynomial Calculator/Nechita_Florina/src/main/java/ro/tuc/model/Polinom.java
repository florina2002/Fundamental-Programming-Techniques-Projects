package ro.tuc.model;

import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

public class Polinom {
    private final Map<Integer, Double> poliMap;

    public Map<Integer, Double> getPoliMap(){
        return poliMap;
    }


    public Polinom (){
        this.poliMap = new TreeMap<>(Collections.reverseOrder());
    }


    public void addTerms (int degree, double coefficient){
        if (coefficient != 0) {
            poliMap.put(degree, poliMap.getOrDefault(degree,0.0) + coefficient);

        }
        else poliMap.remove(degree);
    }

    @Override
    public String toString(){
        StringBuilder sBuilder = new StringBuilder();

        for (Map.Entry<Integer, Double> entry : poliMap.entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();

            if (coefficient == 0) {
                continue;
            }

            // Add the sign
            if (coefficient > 0 && sBuilder.length() > 0) {
                sBuilder.append(" + ");
            } else if (coefficient < 0) {
                sBuilder.append(" - ");
                coefficient = -coefficient;
            }

            // Add the coefficient
            if (coefficient == 1 && degree != 0) {
                // If the coefficient is 1 and the degree is not 0, don't display it
                sBuilder.append("");
            } else {
                if (degree == 0) {
                    // If the degree is 0, don't display the variable
                    sBuilder.append(coefficient);
                    continue;
                }
                else sBuilder.append(coefficient + " * ");
            }

            // Add the variable and degree
            if (degree > 1) {
                sBuilder.append("x^").append(degree);
            } else if (degree == 1) {
                sBuilder.append("x");
            }
        }

        // Handle the case when the polynomial is zero
        if (sBuilder.length() == 0) {
            sBuilder.append("0");
        }

        return sBuilder.toString();
    }

    public static Polinom parsare(String poli){
        Polinom polinom = new Polinom();
        String[] terms = poli.split("(?=[+-])");
        for (String term : terms) {
            String[] parts = term.split("\\*x\\^");
            double coefficient = Double.parseDouble(parts[0].trim());
            int degree = Integer.parseInt(parts[1].trim());
            polinom.addTerms(degree, coefficient);
        }
        return polinom;
    }


}
// hashmap - key - putere, value - coeficient
// addterm - adauga un termen in polinom - daca exista deja termenul cu acea putere, se aduna coeficientii
// to string - afiseaza polinomul
// parse - primeste un string si il transforma in polinom regex


