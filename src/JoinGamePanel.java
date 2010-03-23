/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phil
 */

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;

import java.awt.event.*;

public class JoinGamePanel {

    //A reference the controller of this panel
    IntroOutro superior;

    //**************************************************************************
    //Attributes for GUI
    //**************************************************************************

    //The top level panel
    JPanel joinPanel;
    //The lower level Panels
    JPanel subJoinPanel;
    JPanel cancelPanel;
    JPanel clickLabelPanel;
    //The list containing the ongoing games
    List gameList;
    //The panel information
    JLabel clickLabel;

    //Button to cancel
    JButton cancelButton;

    public JoinGamePanel(IntroOutro superior) {
         this.superior = superior;
         initComponents();
    }
    private void initComponents() {

        //Creating the top level panel
        joinPanel = new JPanel();
        joinPanel.setOpaque(false);
        joinPanel.setPreferredSize(IntroOutro.contentPanelDim);
        joinPanel.setLayout(new BorderLayout());

        //Creating the lower level join panel
        subJoinPanel = new JPanel();
        subJoinPanel.setOpaque(false);
        subJoinPanel.setPreferredSize(new Dimension(300,500));
        subJoinPanel.setLayout(new BorderLayout(0, 10));

        //Creating the panel used for the "click to join" label
        clickLabelPanel = new JPanel();
        clickLabelPanel.setPreferredSize(new Dimension(300, 50));
        clickLabelPanel.setOpaque(false);
        GridBagLayout g1 = new GridBagLayout();
        clickLabelPanel.setLayout(g1);
        GridBagConstraints c1 = new GridBagConstraints();

        //Creating the panel used for the cancel button
        cancelPanel =new JPanel();
        cancelPanel.setPreferredSize(new Dimension(300, 60));
        cancelPanel.setOpaque(false);
        GridBagLayout g2 = new GridBagLayout();
        cancelPanel.setLayout(g2);
        GridBagConstraints c2 = new GridBagConstraints();

        //Creating the join button
        cancelButton = new JButton();
        cancelButton.setSize(IntroOutro.navigationButtonDim);
        cancelButton.setPreferredSize(IntroOutro.navigationButtonDim);
        cancelButton.setMaximumSize(IntroOutro.navigationButtonDim);
        cancelButton.setMinimumSize(IntroOutro.navigationButtonDim);
        cancelButton.setBackground(new Color(53, 212, 160));
        cancelButton.setFont(new Font("Tahoma", 1, 14));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //Creating the list of ongoing games
        gameList = new List();
        gameList.setBackground(new Color(230,230,230));
        gameList.setSize(new Dimension(350,400));
        gameList.setPreferredSize(new Dimension(350,400));
        gameList.setMaximumSize(new Dimension(350,400));
        gameList.setMinimumSize(new Dimension(350,400));

        //Dummy games
        gameList.add("Jade's game");
        gameList.add("Somebody else's game");

        //Creating the "Click to Join" label

        clickLabel = new JLabel("Double-click to Join");
        clickLabel.setFont(new Font("Tahoma", 1, 21));

        //Adding the components in the lower level panels
        c1.gridx=0;
        c1.gridy=0;
        clickLabelPanel.add(clickLabel, c1);

        
        c2.gridx = 0;
        c2.gridy = 0;
        cancelPanel.add(Box.createRigidArea(new Dimension(200,30)),c2);
        c2.gridx=1;
        c2.gridy=0;
        cancelPanel.add(cancelButton, c2);
        
        subJoinPanel.add(clickLabelPanel, BorderLayout.PAGE_START);
        subJoinPanel.add(gameList, BorderLayout.CENTER);
        subJoinPanel.add(cancelPanel, BorderLayout.PAGE_END);

        //Adding the lower level panel to the top level panel with some formatting
        joinPanel.add(Box.createRigidArea(new Dimension(50,30)), BorderLayout.PAGE_START);
        joinPanel.add(subJoinPanel, BorderLayout.CENTER);
        joinPanel.add(Box.createRigidArea(new Dimension(50,30)), BorderLayout.LINE_START);
        joinPanel.add(Box.createRigidArea(new Dimension(250,30)), BorderLayout.LINE_END);

        //Event action for cancel button
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.closeSubPanel();
            }
        });
        //When a user selects a game, the existing game appears
        gameList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.goToExistingGame();
            }
        });



    }

}
