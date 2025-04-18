package org.example;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Transparent JLabel");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            // Background panel
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(new Color(100, 150, 255));  // Blue background
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            panel.setLayout(null);
            panel.setBounds(0, 0, 400, 300);

            // Transparent label
            JLabel label = new JLabel("I am Transparent!");
            label.setBounds(100, 100, 200, 30);
            label.setForeground(Color.WHITE);     // Text color
            label.setOpaque(true);               // Make label transparent

            // Add components
            panel.add(label);
            frame.add(panel);
            frame.setVisible(true);
        }
        }

