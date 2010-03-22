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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Box;

import java.awt.event.*;
import javax.swing.BoxLayout;

public class CreatePanel1 {

    //A reference the controller of this panel
    IntroOutro superior;

    //**************************************************************************
    //Attributes for main GUI
    //**************************************************************************

    //The top level panel
    JPanel createPanel1;
    //The lower level Panels
    JPanel subCreatePanel1;
    JPanel navigationPanel;
    JPanel generalInfoLabelPanel;
    //The list containing the ongoing games
    List gameList;
    //The panel information
    JLabel generalInfoLabel;

    //Button to cancel
    JButton cancelButton;
    JButton backButton;
    JButton nextButton;

    //**************************************************************************
    //Attributes for sub GUI
    //**************************************************************************

    JLabel titleLabel;
    JLabel max10CharLabel;
    JLabel joinPlayersLabel;
    JLabel difficultyLabel;
    JTextField titleTextField;
    JPanel joinPlayerRadioButtonsPanel;
    ButtonGroup joinPlayerRadioButtons;
    JRadioButton yesJoinPlayer;
    JRadioButton noJoinPlayer;
    JPanel difficultyRadioButtonsPanel;
    ButtonGroup difficultyRadioButtons;
    JRadioButton easyDifficulty;
    JRadioButton normalDificulty;
    JRadioButton geniusDifficulty;

    public CreatePanel1(IntroOutro superior) {
         this.superior = superior;
         initComponents();
    }
    private void initComponents() {

        //Creating the top level panel
        createPanel1 = new JPanel();
        createPanel1.setOpaque(false);
        createPanel1.setPreferredSize(IntroOutro.contentPanelDim);
        createPanel1.setLayout(new BorderLayout());

        //Creating the panel used for the "General Info" label
        generalInfoLabelPanel = new JPanel();
        generalInfoLabelPanel.setPreferredSize(new Dimension(300, 115));
        generalInfoLabelPanel.setOpaque(false);
        GridBagLayout g1 = new GridBagLayout();
        generalInfoLabelPanel.setLayout(g1);
        GridBagConstraints c1 = new GridBagConstraints();

        //Creating the panel used for the cancel button
        navigationPanel =new JPanel();
        navigationPanel.setPreferredSize(new Dimension(300, 40));
        navigationPanel.setOpaque(false);
        GridBagLayout g2 = new GridBagLayout();
        navigationPanel.setLayout(g2);
        GridBagConstraints c2 = new GridBagConstraints();

        //Creating the lower level create panel
        subCreatePanel1 = new JPanel();
        subCreatePanel1.setOpaque(false);
        subCreatePanel1.setPreferredSize(new Dimension(300,400));
        GridBagLayout g3 = new GridBagLayout();
        subCreatePanel1.setLayout(g3);
        GridBagConstraints c3 = new GridBagConstraints();
        subCreatePanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        //************************************************************************
        //Constructing the content of the sub create panel
        //************************************************************************
        titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font("Tahoma", 1, 14));

        max10CharLabel = new JLabel("   (Maximum 10 characters)");
        max10CharLabel.setFont(new Font("Tahoma", 1, 12));

        joinPlayersLabel = new JLabel("Will people be able to join this game once it started? ");
        joinPlayersLabel.setFont(new Font("Tahoma", 1, 14));

        difficultyLabel = new JLabel("Difficulty: ");
        difficultyLabel.setFont(new Font("Tahoma", 1, 14));

        titleTextField = new JTextField ();
        titleTextField.setSize(new Dimension(150, 25));
        titleTextField.setPreferredSize(new Dimension(150, 25));
        titleTextField.setMaximumSize(new Dimension(150, 25));
        titleTextField.setMinimumSize(new Dimension(150, 25));

        yesJoinPlayer = new JRadioButton("Yes");
        yesJoinPlayer.setOpaque(false);
        yesJoinPlayer.setSelected(true);
        noJoinPlayer = new JRadioButton("No");
        noJoinPlayer.setOpaque(false);

        joinPlayerRadioButtons = new ButtonGroup();
        joinPlayerRadioButtons.add(yesJoinPlayer);
        joinPlayerRadioButtons.add(noJoinPlayer);
        joinPlayerRadioButtonsPanel = new JPanel();
        joinPlayerRadioButtonsPanel.setOpaque(false);
        joinPlayerRadioButtonsPanel.setLayout(new BoxLayout(joinPlayerRadioButtonsPanel, BoxLayout.Y_AXIS));
        joinPlayerRadioButtonsPanel.add(Box.createRigidArea(new Dimension(0,30)));
        joinPlayerRadioButtonsPanel.add(yesJoinPlayer);
        joinPlayerRadioButtonsPanel.add(noJoinPlayer);

        easyDifficulty = new JRadioButton("Easy");
        easyDifficulty.setOpaque(false);
        normalDificulty = new JRadioButton("Normal");
        normalDificulty.setOpaque(false);
        normalDificulty.setSelected(true);
        geniusDifficulty = new JRadioButton("Genius");
        geniusDifficulty.setOpaque(false);

        difficultyRadioButtons = new ButtonGroup();
        difficultyRadioButtons.add(easyDifficulty);
        difficultyRadioButtons.add(normalDificulty);
        difficultyRadioButtons.add(geniusDifficulty);
        difficultyRadioButtonsPanel = new JPanel();
        difficultyRadioButtonsPanel.setOpaque(false);
        difficultyRadioButtonsPanel.setLayout(new BoxLayout(difficultyRadioButtonsPanel, BoxLayout.Y_AXIS));
        //difficultyRadioButtonsPanel.add(Box.createRigidArea(new Dimension(0,50)));
        difficultyRadioButtonsPanel.add(easyDifficulty);
        difficultyRadioButtonsPanel.add(normalDificulty);
        difficultyRadioButtonsPanel.add(geniusDifficulty);
        
        //Adding the components in the grid
        
        //First Row
        c3.gridx =0;
        c3.gridy =0;
        c3.anchor = GridBagConstraints.LINE_START;
        subCreatePanel1.add(titleLabel, c3);
        c3.gridx =1;
        c3.gridy =0;
        c3.anchor = GridBagConstraints.LINE_START;
        subCreatePanel1.add(titleTextField, c3);
        c3.gridx =2;
        c3.gridy =0;
        subCreatePanel1.add(max10CharLabel, c3);
        c3.gridx =4;
        c3.gridy =0;
        subCreatePanel1.add(Box.createRigidArea(new Dimension(100,30)), c3);

        //Second Row
        c3.gridx =0;
        c3.gridy =1;
        c3.gridwidth = 3;
        c3.anchor = GridBagConstraints.LINE_START;
        subCreatePanel1.add(joinPlayersLabel, c3);
        c3.gridx =4;
        c3.gridy =1;
        c3.gridwidth = 1;
        subCreatePanel1.add(joinPlayerRadioButtonsPanel, c3);
        
        //Third Row
        c3.gridx =0;
        c3.gridy =2;
        c3.anchor = GridBagConstraints.PAGE_START;
        subCreatePanel1.add(difficultyLabel, c3);
        c3.gridx =1;
        c3.gridy =2;
        subCreatePanel1.add(difficultyRadioButtonsPanel, c3);

        //Fourth Row (Empty, used for spacing)
        c3.gridx =1;
        c3.gridy =3;
        subCreatePanel1.add(Box.createRigidArea(new Dimension(0,100)), c3);

        //************************************************************************
        //End of the construction of the sub create panel
        //************************************************************************


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
        //Cancel button is used to ge back
        backButton.setEnabled(false);

        //Creating the next button
        nextButton = new JButton();
        nextButton.setSize(IntroOutro.navigationButtonDim);
        nextButton.setPreferredSize(IntroOutro.navigationButtonDim);
        nextButton.setMaximumSize(IntroOutro.navigationButtonDim);
        nextButton.setMinimumSize(IntroOutro.navigationButtonDim);
        nextButton.setBackground(new Color(53, 212, 160));
        nextButton.setFont(new Font("Tahoma", 1, 14));
        nextButton.setText("Next");
        nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //Creating the "General Info" label
        generalInfoLabel = new JLabel("General Info");
        generalInfoLabel.setFont(new Font("Tahoma", 1, 22));

        
        //Adding the components in the lower level panels
        c1.gridx = 0;
        c1.gridy = 0;
        generalInfoLabelPanel.add(Box.createRigidArea(new Dimension(50,50)),c1);
        c1.gridx = 1;
        c1.gridy = 0;
        c1.anchor = GridBagConstraints.CENTER;
        generalInfoLabelPanel.add(generalInfoLabel, c1);
        c1.gridx=2;
        c1.gridy=0;
        generalInfoLabelPanel.add(Box.createRigidArea(new Dimension(400,50)),c1);

        
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
        navigationPanel.add(nextButton, c2);
        c2.gridx = 4;
        c2.gridy = 0;
        navigationPanel.add(Box.createRigidArea(new Dimension(15,40)),c2);
        c2.gridx=5;
        c2.gridy=0;
        c2.anchor = GridBagConstraints.CENTER;
        navigationPanel.add(cancelButton, c2);


        //Adding the lower level panel to the top level panel with some formatting
        //createPanel1.add(Box.createRigidArea(new Dimension(50,30)), BorderLayout.PAGE_START);
        createPanel1.add(generalInfoLabelPanel, BorderLayout.PAGE_START);
        createPanel1.add(subCreatePanel1, BorderLayout.CENTER);
        createPanel1.add(navigationPanel, BorderLayout.PAGE_END);
        createPanel1.add(Box.createRigidArea(new Dimension(35,30)), BorderLayout.LINE_END);
        //createPanel1.add(Box.createRigidArea(new Dimension(250,30)), BorderLayout.LINE_END);


        //Event action for cancel button
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.closeSubPanel();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.changeCreatePanelForward();
            }
        });



    }

}
