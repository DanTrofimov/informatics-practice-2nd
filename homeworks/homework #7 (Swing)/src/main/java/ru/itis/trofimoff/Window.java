package ru.itis.trofimoff;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;

public class Window {
    private JFrame mainFrame;
    private JPanel mainContent;
    private JLabel footer;
    private int angle;

    public Window() {
        mainFrame = new JFrame("Simple Application");
        mainContent = new JPanel();
        createGUI();
    }

    private void createGUI() {
        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menu.add(new ExitAction());

        JButton about = new JButton("About");
        about.addActionListener(new AboutAction());

        menuBar.add(menu);
        menuBar.add(about);

        mainFrame.setJMenuBar(menuBar);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 30;
        constraints.weightx = 15;
        constraints.fill = GridBagConstraints.BOTH;
        mainFrame.getContentPane().add(mainContent, constraints);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.weightx = 3;
        mainFrame.add(buttonsPanel, constraints);

        JButton firstButton = new JButton();
        firstButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstButton.setText("square");
        firstButton.addActionListener(new ShowRectangle());
        buttonsPanel.add(firstButton);
        addHoverListener(firstButton, "showing square");

        JButton secondButton = new JButton();
        secondButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondButton.setText("animate");
        secondButton.addActionListener(new AnimateRectangle());
        buttonsPanel.add(secondButton);
        addHoverListener(secondButton, "animating square");

        JButton thirdButton = new JButton();
        thirdButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        thirdButton.setText("form");
        thirdButton.addActionListener(new ShowForm());
        buttonsPanel.add(thirdButton);
        addHoverListener(thirdButton, "adding form on the page");

        footer = new JLabel();
        footer.setText("Status: ");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 1;
        mainFrame.getContentPane().add(footer, constraints);

        mainFrame.setVisible(true);
    }

    public void addHoverListener(JButton button, String text) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                footer.setText("Status: " + text);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                footer.setText("Status: -");
            }
        });
    }

    private class ExitAction extends AbstractAction {
        ExitAction() {
            putValue(NAME, "Exit");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AboutAction extends AbstractAction {
        AboutAction() {
            putValue(NAME, "About");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel label = new JLabel("About");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);
            JDialog about = new JDialog(mainFrame, "About", false);
            about.add(label);
            about.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            about.setSize(300, 250);
            about.setLocationRelativeTo(mainFrame);
            about.setVisible(true);
        }
    }

    private class ShowForm extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();


            JLabel nameLabel = new JLabel("Name: ");
            constraints.gridx = 0;
            constraints.gridy = 0;
            formPanel.add(nameLabel, constraints);

            JTextField nameField = new JTextField(15);
            constraints.gridx = 1;
            constraints.gridy = 0;
            formPanel.add(nameField, constraints);

            JLabel passwordLabel = new JLabel("Password: ");
            constraints.gridx = 0;
            constraints.gridy = 1;
            formPanel.add(passwordLabel, constraints);

            JPasswordField passwordField = new JPasswordField(15);
            constraints.gridx = 1;
            constraints.gridy = 1;
            formPanel.add(passwordField, constraints);

            JLabel passwordLabelRepeat = new JLabel("Repeat: ");
            constraints.gridx = 0;
            constraints.gridy = 2;
            formPanel.add(passwordLabelRepeat, constraints);

            JPasswordField passwordFieldRepeat = new JPasswordField(15);
            constraints.gridx = 1;
            constraints.gridy = 2;
            formPanel.add(passwordFieldRepeat, constraints);

            JButton formButton = new JButton();
            formButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            formButton.setText("submit");
            addHoverListener(formButton, "animating square");
            constraints.gridx = 1;
            constraints.gridy = 3;
            formPanel.add(formButton, constraints);

            formPanel.setVisible(true);

            mainContent.removeAll();
            mainContent.add(formPanel);
        }
    }

    private class ShowRectangle extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            MyJPanel myJPanel = new MyJPanel();
            myJPanel.setPreferredSize(new Dimension(500, 500));
            mainContent.removeAll();
            myJPanel.setVisible(true);
            mainContent.add(myJPanel);
        }
    }

    private class MyJPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics = (Graphics2D) g;
            Image img = null;
            try {
                img = ImageIO.read(new File("src\\main\\resources\\images\\dog.png"));
            } catch (IOException e) {
                System.err.println("image download problems: " + e.getMessage());
            }
            graphics.drawImage(img, 0, 0, null);
        }
    }

    private class AnimateRectangle extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            MyAnimateJPanel myAnimateJPanel = new MyAnimateJPanel();
            myAnimateJPanel.setPreferredSize(new Dimension(500, 500));
            mainContent.removeAll();
            myAnimateJPanel.setVisible(true);
            mainContent.add(myAnimateJPanel);
        }
    }

    private class MyAnimateJPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics = (Graphics2D) g;
            Image img = null;
            try {
                img = ImageIO.read(new File("src\\main\\resources\\images\\dog.png"));
            } catch (IOException e) {
                System.err.println("image download problems: " + e.getMessage());
            }
            angle+=10;
            graphics.rotate(Math.toRadians(angle));
            graphics.drawImage(img, 0, 0, null);
        }
    }
}
