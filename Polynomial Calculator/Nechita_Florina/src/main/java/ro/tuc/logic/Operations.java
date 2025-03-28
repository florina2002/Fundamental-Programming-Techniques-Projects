package ro.tuc.logic;

import ro.tuc.model.Polinom;

import java.util.Map;

public class Operations{
   /* public static void newPolinom(String polinom){
        String exp = new String ("2x^2+3x^3+4x^4");
        int[] a =  new int[100];
        int[] v = new int[100];
        int[] b = new int[100];
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);

        Pattern pattern2 = Pattern.compile("([^]+])");

        int x=0;
        while (matcher.find()) {
            x=x+1;
            System.out.println("Group "+x+": " + matcher.group(1));
            Matcher matcher2 = pattern2.matcher(matcher.group(1));
            if(x>1) {
                a[x] = Integer.parseInt(matcher2.group(2));
                System.out.println(a[x]);
                v[x] = Integer.parseInt(matcher2.group(5));
                System.out.println(v[x]);
            }
            else {
                a[x] = Integer.parseInt(matcher2.group(1));
                System.out.println(a[x]);
                v[x] = Integer.parseInt(matcher2.group(4));
                System.out.println(v[x]);
            }
        }
    }*/

    public static Polinom addition(Polinom polinom1, Polinom polinom2){
        Polinom polinom3 = new Polinom();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree, coefficient);
        }
        for (Map.Entry<Integer, Double> entry : polinom2.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree, coefficient);
        }
        return polinom3;
    }

    public static Polinom subtraction(Polinom polinom1, Polinom polinom2){
        Polinom polinom3 = new Polinom();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree, coefficient);
        }
        for (Map.Entry<Integer, Double> entry : polinom2.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree, -coefficient);
        }
        return polinom3;
    }

    public static Polinom multiplication(Polinom polinom1, Polinom polinom2){
        Polinom polinom3 = new Polinom();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            for (Map.Entry<Integer, Double> entry2 : polinom2.getPoliMap().entrySet()){
                int degree2 = entry2.getKey();
                double coefficient2 = entry2.getValue();
                polinom3.addTerms(degree+degree2, coefficient*coefficient2);
            }
        }
        return polinom3;
    }

    /*
    public static Polinom division(Polinom polinom1, Polinom polinom2){

        Polinom polinom3 = new Polinom();
        Polinom polinom4 = new Polinom();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom4.addTerms(degree, coefficient);
        }
        for (Map.Entry<Integer, Double> entry : polinom2.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom4.addTerms(degree, -coefficient);
        }
        for (Map.Entry<Integer, Double> entry : polinom4.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree, coefficient);
        }
        return polinom3;
    }
    */

    public static Polinom integration(Polinom polinom1){
        Polinom polinom3 = new Polinom();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree+1, coefficient/(degree+1));
        }
        return polinom3;
    }

    public static Polinom derivation(Polinom polinom1){
        Polinom polinom3 = new Polinom();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoliMap().entrySet()){
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            polinom3.addTerms(degree-1, coefficient*degree);
        }
        return polinom3;
    }



}

// operatiile - 2 polinoame hashmaps ne folosim de addterm


