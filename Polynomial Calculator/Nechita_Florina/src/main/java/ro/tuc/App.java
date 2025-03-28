package ro.tuc;

import ro.tuc.logic.Controller;
import ro.tuc.gui.View;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        /*
        String poly1 = "5*x^7+6*x^4+7*x^1+8*x^0";
        String poly2 = "-3*x^7-1*x^3+4*x^1+2*x^0";

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1 = Polinom.parsare(poly1);
        p2 = Polinom.parsare(poly2);


        System.out.println(Polinom.parsare(poly1));
        System.out.println(Polinom.parsare(poly2));

        System.out.println("Add: " + Operations.addition(p1, p2));
        System.out.println("Sub 1-2: " + Operations.subtraction(p1, p2));
        System.out.println("Sub 2-1: " + Operations.subtraction(p2, p1));
        System.out.println("Mult: " + Operations.multiplication(p1, p2));
        //System.out.println("Div 1/2: " + Operations.division(p1, p2));
        System.out.println("Deriv p1: " + Operations.derivation(p1));
        System.out.println("Deriv p2: " + Operations.derivation(p2));
        System.out.println("Integr p1: " + Operations.integration(p1));
        System.out.println("Integr p2: " + Operations.integration(p2));
        */




        View view = new View(null);
        Controller controller = new Controller(view);



    }

}
