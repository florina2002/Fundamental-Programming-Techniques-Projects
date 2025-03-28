package ro.tuc.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    JFrame frame;

    public JButton additionButton;
    public JButton substraction12Button;
    public JButton substraction21Button;
    public JButton multiplicationButton;
    JButton divisionButton;
    //JButton division21Button;
    public JButton derivate1Button;
    public JButton derivate2Button;
    public JButton integrate1Button;
    public JButton integrate2Button;

    JLabel firstPoly;
    JLabel secondPoly;
    public JTextArea result;

    JLabel title;
    JLabel rules;
    JLabel rules2;
    JLabel rules3;
    JLabel resultLabel;

    JPanel panel;

    public JTextField poly1;
    public JTextField poly2;


    public View(JFrame parent) {

        frame = new JFrame();

        frame.setMinimumSize(new Dimension(800, 700));

        additionButton = new JButton("Addition");

        substraction12Button = new JButton("Substraction first minus second");

        substraction21Button = new JButton("Substraction second minus first");

        multiplicationButton = new JButton("Multiplication");

        divisionButton = new JButton("Division (does not work yet)");

        //division21Button = new JButton("Division second by first");

        derivate1Button = new JButton("Derivate first polynomial");

        derivate2Button = new JButton("Derivate second polynomial");

        integrate1Button = new JButton("Integrate first polynomial");

        integrate2Button = new JButton("Integrate second polynomial");


        firstPoly = new JLabel("First polynomial:");
        secondPoly = new JLabel("Second polynomial:");

        result = new JTextArea();

        title = new JLabel("Polynomial Calculator");
        rules = new JLabel("MAKE SURE TO ALSO SPECIFY THE DEGREE FOR x^1 AND x^0");
        rules2 = new JLabel("without using spaces between coefficients, degrees or mathematical symbols");
        rules3 = new JLabel("Example: 2*x^2+3*x^1+4*x^0");
        resultLabel = new JLabel("Result:");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        poly1 = new JTextField();
        poly2 = new JTextField();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Polynomial Calculator");

        frame.pack();

        panel.add(title);
        panel.add(rules);
        panel.add(rules2);
        panel.add(rules3);

        panel.add(firstPoly);
        panel.add(poly1);

        panel.add(secondPoly);
        panel.add(poly2);


        panel.add(additionButton);
        panel.add(substraction12Button);
        panel.add(substraction21Button);
        panel.add(multiplicationButton);
        panel.add(divisionButton);
        //panel.add(division21Button);
        panel.add(derivate1Button);
        panel.add(derivate2Button);
        panel.add(integrate1Button);
        panel.add(integrate2Button);

        panel.add(resultLabel);
        panel.add(result);

        result.setEditable(false);

        frame.setVisible(true);
    }

    public void addButtonActionListener(ActionListener e) {
        this.additionButton.addActionListener(e);
    }
    public void actionSubstraction12(ActionListener e) {
        this.substraction12Button.addActionListener(e);
    }
    public void actionSubstraction21(ActionListener e) {
        this.substraction21Button.addActionListener(e);
    }
    public void actionMultiplication(ActionListener e) {
        this.multiplicationButton.addActionListener(e);
    }

    public void actionDivision12(ActionListener e) {
        this.divisionButton.addActionListener(e);
    }
    /*
    public void actionDivision21(ActionListener e) {
        this.division21Button.addActionListener(e);
    }
    */

    public void actionDerivate1(ActionListener e) {
        this.derivate1Button.addActionListener(e);
    }
    public void actionDerivate2(ActionListener e) {
        this.derivate2Button.addActionListener(e);
    }
    public void actionIntegrate1(ActionListener e) {
        this.integrate1Button.addActionListener(e);
    }
    public void actionIntegrate2(ActionListener e) {
        this.integrate2Button.addActionListener(e);
    }


/*
    public void actionSubstraction12(ActionEvent e) {

        result.setText("Substraction first minus second: ");
    }

    public void actionSubstraction21(ActionEvent e) {
        result.setText("Subtraction second minus first: ");
    }

    public void actionMultiplication(ActionEvent e) {

        result.setText("Multiplication: ");
    }
    public void actionDivision12(ActionEvent e) {
        result.setText("Division first by second: ");
    }
    public void actionDivision21(ActionEvent e) {
        result.setText("Division second by first: ");
    }


    public void actionDerivate1(ActionEvent e) {

        result.setText("First polynomial derivated: ");
    }

    public void actionIntegrate1(ActionEvent e) {

        result.setText("First polynomial derivated: ");
    }

    public void actionDerivate2(ActionEvent e) {

        result.setText("Second polynomial derivated: ");
    }

    public void actionIntegrate2(ActionEvent e) {

        result.setText("Second polynomial integrated: ");
    }



    public void actionPerformed(ActionEvent e) {

    }

 */


    public static void main(String[] args) {
        new View(null);
    }

    public void displayErrorMessage(String s) { JOptionPane.showMessageDialog(new JPanel(), s);
    }
}
