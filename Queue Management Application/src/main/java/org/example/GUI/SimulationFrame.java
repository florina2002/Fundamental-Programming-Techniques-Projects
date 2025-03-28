package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {
    public JLabel nrClientsLabel;
    public JLabel nrQueuesLabel;
    public JLabel simIntervalLabel;
    public JLabel minArrivalLabel;
    public JLabel maxArrivalLabel;
    public JLabel minServiceLabel;
    public JLabel maxServiceLabel;

    public JTextField nrClientsText;
    public JTextField nrQueuesText;
    public JTextField simIntervalText;
    public JTextField minArrivalText;
    public JTextField maxArrivalText;
    public JTextField minServiceText;
    public JTextField maxServiceText;

    public JTextArea queueTextArea;

    public JButton startButton;
    public JScrollPane scrollPane;
    public JFrame frame;
    public JPanel panel;
    public JPanel panel1;
    public JPanel panel2;

    public JComboBox strategy;

    public SimulationFrame(JFrame parent) {
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 700));
        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        panel.setLayout(new GridLayout(0, 4, 0, 0));
        panel2.setLayout(new GridLayout(2, 1, 0, 0));
        frame.setSize(755, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);

        frame.add(panel1, BorderLayout.CENTER);
        frame.setTitle("Simulation");
        frame.pack();
        frame.setVisible(true);

        panel1.add(panel, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.CENTER);
        queueTextArea = new JTextArea();
        queueTextArea.setEditable(false);
        scrollPane = new JScrollPane(queueTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        nrClientsLabel = new JLabel("Nr. of clients:");
        nrClientsText = new JTextField();

        nrQueuesLabel = new JLabel("Nr. of queues:");
        nrQueuesText = new JTextField();

        simIntervalLabel = new JLabel("Interval:");
        simIntervalText = new JTextField();

        minArrivalLabel = new JLabel("Min arrival:");
        minArrivalText = new JTextField();
        maxArrivalLabel = new JLabel("Max arrival:");
        maxArrivalText = new JTextField();

        minServiceLabel = new JLabel("Min service:");
        minServiceText = new JTextField();
        maxServiceLabel = new JLabel("Max service:");
        maxServiceText = new JTextField();

        startButton = new JButton("Start Simulation");



        panel.add(nrClientsLabel);
        panel.add(nrClientsText);
        panel.add(new JLabel());
        panel.add(new JLabel());


        panel.add(nrQueuesLabel);
        panel.add(nrQueuesText);
        panel.add(new JLabel());
        panel.add(new JLabel());


        panel.add(simIntervalLabel);
        panel.add(simIntervalText);
        panel.add(new JLabel());
        panel.add(new JLabel());


        panel.add(minArrivalLabel);
        panel.add(minArrivalText);
        panel.add(new JLabel());
        panel.add(new JLabel());


        panel.add(maxArrivalLabel);
        panel.add(maxArrivalText);
        panel.add(new JLabel());
        panel.add(new JLabel());


        panel.add(minServiceLabel);
        panel.add(minServiceText);
        panel.add(new JLabel());
        panel.add(new JLabel());


        panel.add(maxServiceLabel);
        panel.add(maxServiceText);
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Startegy:"));

        String combo[] = {"SHORTEST_QUEUE", "SHORTEST_TIME"};
        strategy = new JComboBox(combo);

        panel.add(strategy);



        panel2.add(startButton);
        panel2.add(scrollPane);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimulationFrame(null);
    }

    public void addStartButtonListener(ActionListener listenForStartButton) {
        startButton.addActionListener(listenForStartButton);
    }
}
