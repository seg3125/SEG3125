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
import java.io.IOException;

public class CreatePanel2 {

    //A reference the controller of this panel
    IntroOutro superior;

    //**************************************************************************
    //Attributes for GUI
    //**************************************************************************

    //The top level panel
    JPanel createPanel2;
    //The lower level Panels
    JPanel subCreatePanel2;
    JPanel navigationPanel;
    JPanel TeamInfoLabelPanel;
    //The list containing the ongoing games
    List gameList;
    //The panel information
    JLabel TeamInfoLabel;

    //Button to cancel
    JButton cancelButton;
    JButton backButton;
    JButton finishButton;

    public CreatePanel2(IntroOutro superior) {
         this.superior = superior;
         initComponents();
    }
    private void initComponents() {

        //Creating the top level panel
        createPanel2 = new JPanel();
        createPanel2.setOpaque(false);
        createPanel2.setPreferredSize(IntroOutro.contentPanelDim);
        createPanel2.setLayout(new BorderLayout());

        //Creating the lower level create panel
        subCreatePanel2 = new JPanel();
        subCreatePanel2.setOpaque(false);
        subCreatePanel2.setPreferredSize(new Dimension(300,400));
        subCreatePanel2.setLayout(new BorderLayout(0, 10));
        subCreatePanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        //Creating the panel used for the "General Info" label
        TeamInfoLabelPanel = new JPanel();
        TeamInfoLabelPanel.setPreferredSize(new Dimension(300, 115));
        TeamInfoLabelPanel.setOpaque(false);
        GridBagLayout g1 = new GridBagLayout();
        TeamInfoLabelPanel.setLayout(g1);
        GridBagConstraints c1 = new GridBagConstraints();

        //Creating the panel used for the cancel button
        navigationPanel =new JPanel();
        navigationPanel.setPreferredSize(new Dimension(300, 40));
        navigationPanel.setOpaque(false);
        GridBagLayout g2 = new GridBagLayout();
        navigationPanel.setLayout(g2);
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

        //Creating the back button
        backButton = new JButton();
        backButton.setSize(IntroOutro.navigationButtonDim);
        backButton.setPreferredSize(IntroOutro.navigationButtonDim);
        backButton.setMaximumSize(IntroOutro.navigationButtonDim);
        backButton.setMinimumSize(IntroOutro.navigationButtonDim);
        backButton.setBackground(new Color(53, 212, 160));
        backButton.setFont(new Font("Tahoma", 1, 14));
        backButton.setText("Back");
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //Disabling the back button since it leads nowhere in this panel
        

        //Creating the next button
        finishButton = new JButton();
        finishButton.setSize(IntroOutro.navigationButtonDim);
        finishButton.setPreferredSize(IntroOutro.navigationButtonDim);
        finishButton.setMaximumSize(IntroOutro.navigationButtonDim);
        finishButton.setMinimumSize(IntroOutro.navigationButtonDim);
        finishButton.setBackground(new Color(53, 212, 160));
        finishButton.setFont(new Font("Tahoma", 1, 14));
        finishButton.setText("Finish");
        finishButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        //Creating the "General Info" label
        TeamInfoLabel = new JLabel("Team Info");
        TeamInfoLabel.setFont(new Font("Tahoma", 1, 22));


        //Adding the components in the lower level panels
        c1.gridx = 0;
        c1.gridy = 0;
        TeamInfoLabelPanel.add(Box.createRigidArea(new Dimension(50,50)),c1);
        c1.gridx = 1;
        c1.gridy = 0;
        c1.anchor = GridBagConstraints.CENTER;
        TeamInfoLabelPanel.add(TeamInfoLabel, c1);
        c1.gridx=2;
        c1.gridy=0;
        TeamInfoLabelPanel.add(Box.createRigidArea(new Dimension(400,50)),c1);


        c2.gridx = 0;
        c2.gridy = 0;
        navigationPanel.add(Box.createRigidArea(new Dimension(200,40)),c2);
        c2.gridx=1;
        c2.gridy=0;
        c2.anchor = GridBagConstraints.CENTER;
        navigationPanel.add(backButton, c2);
        c2.gridx = 2;
        c2.gridy = 0;
        navigationPanel.add(Box.createRigidArea(new Dimension(15,40)),c2);
        c2.gridx=3;
        c2.gridy=0;
        c2.anchor = GridBagConstraints.CENTER;
        navigationPanel.add(finishButton, c2);
        c2.gridx = 4;
        c2.gridy = 0;
        navigationPanel.add(Box.createRigidArea(new Dimension(15,40)),c2);
        c2.gridx=5;
        c2.gridy=0;
        c2.anchor = GridBagConstraints.CENTER;
        navigationPanel.add(cancelButton, c2);




        //Adding the lower level panel to the top level panel with some formatting
        //createPanel1.add(Box.createRigidArea(new Dimension(50,30)), BorderLayout.PAGE_START);
        createPanel2.add(TeamInfoLabelPanel, BorderLayout.PAGE_START);
        createPanel2.add(subCreatePanel2, BorderLayout.CENTER);
        createPanel2.add(navigationPanel, BorderLayout.PAGE_END);
        createPanel2.add(Box.createRigidArea(new Dimension(35,30)), BorderLayout.LINE_END);
        //createPanel1.add(Box.createRigidArea(new Dimension(250,30)), BorderLayout.LINE_END);



       finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
					superior.goToNewGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.closeSubPanel();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.changeCreatePanelBackward();
            }
        });



    }

}
