package ro.tuc.logic;

import ro.tuc.gui.View;
import ro.tuc.logic.Operations;
import ro.tuc.model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        view.additionButton.addActionListener(new addButtonActionListener());
        view.substraction12Button.addActionListener(new sub12ButtonActionListener());
        view.substraction21Button.addActionListener(new sub21ButtonActionListener());
        view.multiplicationButton.addActionListener(new multButtonActionListener());
        //view.division12Button.addActionListener(new division12ButtonActionListener());
        //view.division21Button.addActionListener(new div21ButtonActionListener());
        view.derivate1Button.addActionListener(new deriv1ButtonActionListener());
        view.derivate2Button.addActionListener(new deriv2ButtonActionListener());
        view.integrate1Button.addActionListener(new integ1ButtonActionListener());
        view.integrate2Button.addActionListener(new integ2ButtonActionListener());
    }

    public class addButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());


            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.addition(firstPoli, secondPoli)).toString());
        }
    }

    public class sub12ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.subtraction(firstPoli, secondPoli)).toString());
        }
    }
    public class sub21ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();


            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.subtraction(secondPoli, firstPoli)).toString());
        }
    }
    public class multButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.multiplication(firstPoli, secondPoli)).toString());
        }
    }

    /*
    public class division12ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (NumberFormatException ex) {
                System.out.println(ex);

                view.displayErrorMessage("You Need to Enter valid data");
            }

            view.result.setText((Operations.division(firstPoli, secondPoli)).toString());
        }
    }
    public class div21ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (NumberFormatException ex) {
                System.out.println(ex);

                view.displayErrorMessage("You Need to Enter valid data");
            }

            view.result.setText((Operations.division(secondPoli, firstPoli)).toString());
        }
    }
     */
    public class deriv1ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();


            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.derivation(firstPoli)).toString());
        }
    }
    public class deriv2ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();


            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.derivation(secondPoli)).toString());
        }
    }
    public class integ1ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.integration(firstPoli)).toString());
        }
    }
    public class integ2ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom firstPoli = new Polinom();
            Polinom secondPoli = new Polinom();

            try {
                firstPoli = Polinom.parsare(view.poly1.getText());
                secondPoli = Polinom.parsare(view.poly2.getText());
            } catch (Exception ex) {
                System.out.println(ex);

                view.displayErrorMessage("Wrong format input");
            }

            view.result.setText((Operations.integration(secondPoli)).toString());
        }
    }
}

