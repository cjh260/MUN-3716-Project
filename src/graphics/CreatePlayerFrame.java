/**
 * COMP 3716 Final Project: Game.java
 *
 * Group 8:
 * - Chris Babstock (200152353)
 * - Stephen Brinson (200838720)
 * - Jarret Kolanko (200858181)
 * - Christopher Healey (201034766)
 */
package graphics;

import game.GameControllerInterface;
import game.GameModelInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import player.Happiness;
import player.Player;

/**
 * 
 * @author Chris Babstock
 */
public class CreatePlayerFrame extends JFrame {

    private GameControllerInterface controller;
    private GameModelInterface model;
    private JFrame parent;

    private JTextField nameField;
    private JTextField wealthField;
    private JTextField powerField;
    private JTextField solitudeField;

    /**
         *
         */
    private static final long serialVersionUID = -4631560646174313927L;

    /**
     * Creates new form NewJFrame
     */
    public CreatePlayerFrame(JFrame parent, GameControllerInterface c,
            GameModelInterface m) {
        this.controller = c;
        this.model = m;
        this.parent = parent;

        initComponents();
    }

    private void initComponents() {
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 250));

        this.setLayout(new BorderLayout(2, 2));

        JPanel namePanel = new JPanel(new BorderLayout(2, 2));
        nameField = new JTextField();
        namePanel.add(new JLabel("Create your character:"), BorderLayout.NORTH);
        namePanel.add(new JLabel("Name:"), BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.CENTER);

        JPanel types = new JPanel(new GridLayout(0, 1, 1, 1));
        types.add(new JLabel("Wealth:"));
        types.add(new JLabel("Power:"));
        types.add(new JLabel("Solitude:"));

        JPanel percents = new JPanel(new GridLayout(0, 1, 1, 1));
        percents.setBorder(new TitledBorder(
                "Enter integer percentages adding to 100%:"));
        wealthField = new JTextField();
        powerField = new JTextField();
        solitudeField = new JTextField();
        percents.add(wealthField);
        percents.add(powerField);
        percents.add(solitudeField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ok = new JButton("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(ok);

        this.add(namePanel, BorderLayout.NORTH);
        this.add(types, BorderLayout.WEST);
        this.add(percents, BorderLayout.CENTER);
        this.add(ok, BorderLayout.SOUTH);
        this.pack();

    }

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Happiness h = null;
        Player p = null;

        Integer wealth = 0;
        Integer power = 0;
        Integer solitude = 0;
        String name = nameField.getText();

        if (wealthField.getText() == "")
            wealth = 0;
        else {
            if (isInt(wealthField.getText()))
                wealth = Integer.parseInt(wealthField.getText());
        }

        if (powerField.getText() == "")
            power = 0;
        else {
            if (isInt(powerField.getText()))
                power = Integer.parseInt(powerField.getText());
        }

        if (solitudeField.getText() == "")
            solitude = 0;
        else {
            if (isInt(solitudeField.getText()))
                solitude = Integer.parseInt(solitudeField.getText());
        }

        if (name.compareTo("") != 0) {

            if (wealth + power + solitude == 100) {
                h = new Happiness(Arrays.asList(new Integer[] { wealth, power,
                        solitude }));
                p = new Player(nameField.getText(), h);
                
                controller.addPlayerToMap(p);
                controller.setActivePlayer(p);
                parent.setVisible(true);
                this.dispose();
            }
        }
    }

    private boolean isInt(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}