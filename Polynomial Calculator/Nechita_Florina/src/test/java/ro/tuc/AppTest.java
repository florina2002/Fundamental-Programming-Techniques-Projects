package ro.tuc;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import ro.tuc.logic.Operations;
import ro.tuc.model.Polinom;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private Polinom p1 ;
    private Polinom p2;

    private Polinom rezultat1;
    private Polinom rezultat2;

    private static int numarTeste = 0;
    private static int testeValide = 0;
    public AppTest() {
        this.p1 = new Polinom();
        this.p2 = new Polinom();
    }

    @BeforeEach
    public void setUp() {
        numarTeste++;
        System.out.println("Test " + numarTeste + " is running");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("The number of tests is: " + numarTeste);
        System.out.println("The number of valid tests is: " + testeValide);
    }

    @Test
    public void testAddition() {
        String poly1 = "5*x^7+6*x^4+7*x^1+8*x^0";
        String poly2 = "-3*x^7-1*x^3+4*x^1+2*x^0";
        String result = "2.0*x^7+6.0*x^4-1.0*x^3+11.0*x^1+10.0*x^0";
        p1 = Polinom.parsare(poly1);
        p2 = Polinom.parsare(poly2);
        rezultat1 = Polinom.parsare(result);
        assertEquals(rezultat1.toString(), Operations.addition(p1, p2).toString());
        testeValide++;
    }

    @Test
    public void testSubtraction() {
        String poly1 = "5*x^7+6*x^4+7*x^1+8*x^0";
        String poly2 = "-3*x^7-1*x^3+4*x^1+2*x^0";
        String result1 = "8.0*x^7+6.0*x^4+1.0*x^3+3.0*x^1+6.0*x^0";
        String result2 = "-8.0*x^7-6.0*x^4-1.0*x^3-3.0*x^1-6.0*x^0";
        p1 = Polinom.parsare(poly1);
        p2 = Polinom.parsare(poly2);
        rezultat1 = Polinom.parsare(result1);
        rezultat2 = Polinom.parsare(result2);
        assertEquals(rezultat1.toString(), Operations.subtraction(p1, p2).toString());
        assertEquals(rezultat2.toString(), Operations.subtraction(p2, p1).toString());
        testeValide++;
    }

    @Test
    public void testMultiplication() {
        String poly1 = "5*x^7+6*x^4+7*x^1+8*x^0";
        String poly2 = "-3*x^7-1*x^3+4*x^1+2*x^0";
        String result = "-15.0*x^14-18.0*x^11-5.0*x^10-1*x^8-20.0*x^7+24.0*x^5+5.0*x^4-8.0*x^3+28.0*x^2+46.0*x^1+16.0*x^0";
        p1 = Polinom.parsare(poly1);
        p2 = Polinom.parsare(poly2);
        rezultat1 = Polinom.parsare(result);
        assertEquals(rezultat1.toString(), Operations.multiplication(p1, p2).toString());
        testeValide++;
    }

    @Test
    public void testDerivation() {
        String poly1 = "5*x^7+6*x^4+7*x^1+8*x^0";
        String result = "35.0*x^6+24.0*x^3+7.0*x^0";
        p1 = Polinom.parsare(poly1);
        rezultat1 = Polinom.parsare(result);
        assertEquals(rezultat1.toString(), Operations.derivation(p1).toString());
        testeValide++;
    }

    @Test
    public void testIntegration() {
        String poly1 = "5*x^7+6*x^4+7*x^1+8*x^0";
        String result = "1/8*x^8+1/5*x^5+7/2*x^2+8*x^1"; //we use the fraction form to show tath the correct result for coefficients is a double
        p1 = Polinom.parsare(poly1);
        rezultat1 = Polinom.parsare(result);
        assertEquals(rezultat1.toString(), Operations.integration(p1).toString());
        testeValide++;
    }

}
