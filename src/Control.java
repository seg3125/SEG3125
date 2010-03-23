/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Control.java
 *
 * Created on 20-Mar-2010, 3:11:47 PM
 */

/**
 *
 * @author Phil
 */
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;

import java.util.Random;

public class Control {

    public GameBoard game;
    public javax.swing.JPanel controlPanel;
    private javax.swing.JPanel teamColorPanel;
    private javax.swing.JLabel teamColorLabel;
    private javax.swing.JPanel controlButtonPanel;
    public javax.swing.JButton dice;
    public javax.swing.JButton exit;
    public javax.swing.JButton help;

    /** Creates new form Control */
    public Control(GameBoard game) {
        initComponents();
        dice.setEnabled(true);
        this.game=game;
    }

    public void enableDice(){
        dice.setEnabled(true);
    }

    public void disableDice(){
        dice.setEnabled(false);
    }
    
    public void enableHelp(){
        help.setEnabled(true);
    }
    
    public void disableHelp(){
        help.setEnabled(false);
    }

    private void initComponents() {

        //Main Panel
        controlPanel = new javax.swing.JPanel(new BorderLayout());
        controlPanel.setOpaque(false);
		controlPanel.setPreferredSize(GameBoard.controlPanelSize);
		controlPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));

        //Team color Panel
        teamColorPanel = new javax.swing.JPanel();
        teamColorPanel.setSize(new Dimension(148, 100));
        teamColorPanel.setPreferredSize(new Dimension(148, 75));
        teamColorPanel.setMaximumSize(new Dimension(148, 75));
        teamColorPanel.setMinimumSize(new Dimension(148, 75100));
        teamColorPanel.setBackground(new java.awt.Color(45, 255, 255));
        GridBagLayout g1 = new GridBagLayout();
        teamColorPanel.setLayout(g1);
        GridBagConstraints c1 = new GridBagConstraints();

        //Team color Label
        teamColorLabel = new javax.swing.JLabel();
        teamColorLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        teamColorLabel.setText("Your team");

        //Adding the team color label to the team color panel
        c1.gridx = 0;
        c1.gridy = 0;
        teamColorPanel.add(teamColorLabel, c1);
        
        //Creation of the control button Panel
        controlButtonPanel = new javax.swing.JPanel();
        controlButtonPanel.setOpaque(false);
        controlButtonPanel .setSize(new Dimension(150, 500));
        controlButtonPanel .setPreferredSize(new Dimension(150, 500));
        controlButtonPanel .setMaximumSize(new Dimension(150, 500));
        controlButtonPanel .setMinimumSize(new Dimension(150, 500498));
        GridBagLayout g2 = new GridBagLayout();
        controlButtonPanel .setLayout(g2);
        GridBagConstraints c2 = new GridBagConstraints();
        
        //Creation of the Help Icon
        help = new javax.swing.JButton();
        help.setCursor(new Cursor(Cursor.HAND_CURSOR));
        help.setPressedIcon(new javax.swing.ImageIcon("images/PressedHelpIcon.jpg"));
        help.setIcon(new javax.swing.ImageIcon("images/helpIcon.jpg"));
        help.setDisabledIcon(new javax.swing.ImageIcon("images/HelpDisable.png")); 
        help.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        help.setMaximumSize(new java.awt.Dimension(100, 100));
        help.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        //Creation of the Exit Icon
        exit = new javax.swing.JButton();
        exit.setPressedIcon(new javax.swing.ImageIcon("images/PressedExitIcon.jpg"));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setIcon(new javax.swing.ImageIcon("images/ExitIcon.jpg"));
        exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        //Creation of the Dice Icon
        dice = new javax.swing.JButton();
        dice.setPressedIcon(new javax.swing.ImageIcon("images/PressedDice.jpg"));
        dice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dice.setIcon(new javax.swing.ImageIcon("images/Dice.jpg")); //
        dice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dice.setDisabledIcon(new javax.swing.ImageIcon("images/DiceDisable.jpg")); 
        dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceActionPerformed(evt);
            }
        });

        //Adding the buttons to the control button Panel
        c2.gridx = 0;
        c2.gridy = 0;
        controlButtonPanel.add(dice, c2);
        c2.gridx = 0;
        c2.gridy = 1;
        controlButtonPanel.add(Box.createRigidArea(new Dimension(0,3)), c2);
        c2.gridx = 0;
        c2.gridy = 2;
        controlButtonPanel.add(help, c2);
        c2.gridx = 0;
        c2.gridy = 3;
        controlButtonPanel.add(Box.createRigidArea(new Dimension(0,3)), c2);
        c2.gridx = 0;
        c2.gridy = 4;
        controlButtonPanel.add(exit, c2);

        //Adding the team color panel to the control panel
        controlPanel.add(teamColorPanel, BorderLayout.PAGE_START);
        controlPanel.add(controlButtonPanel, BorderLayout.CENTER);
      
    }

    private void diceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diceActionPerformed
        if (dice.isEnabled()){
            //Random number generation
            Random randomGenerator = new Random();
            int rand = randomGenerator.nextInt(5) + 1;
            try{
                game.updateGameBoard(1);
            }
            catch (Exception ex){
            }
            //Disabling the dice button so it looks gray
           //dice.setEnabled(false);
        }
    }

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {
        game.displayHelp();
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        game.exitGame();
    }
}

/*
 *  if you could add game.exitGame() to the close button listener, that'd be great
 also game.displayHelp() to the question mark listener, but i don't have that written yet
*/