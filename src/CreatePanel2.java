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
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Box;

import java.awt.event.*;

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

    JPanel teamInfoPanel1;
    JPanel teamInfoPanel2;

    JPanel TeamInfoLabelPanel1;
            JPanel subTeam1InfoPanel1;
            JPanel subTeam1InfoPanel2;
                    ButtonGroup team1ColorRadioButtons;
                    JRadioButton team1Blue;
                    JRadioButton team1Red;
                    JRadioButton team1Green;
                    JRadioButton team1Yellow;
                    JLabel team1ColorLabel;
                    JLabel team1PlayerLabel;
                    List team1PlayerList;
                    JButton team1AddPlayer;
                    JButton team1removePlayer;
    
                    JPanel teamInfoLabelPanel2;
            JPanel subTeam2InfoPanel1;
            JPanel subTeam2InfoPanel2;
                    ButtonGroup team2ColorRadioButtons;
                    JRadioButton team2Blue;
                    JRadioButton team2Red;
                    JRadioButton team2Green;
                    JRadioButton team2Yellow;
                    JLabel team2ColorLabel;
                    JLabel team2PlayerLabel;
                    List team2PlayerList;
                    JButton team2AddPlayer;
                    JButton team2removePlayer;
                    
    JLabel TeamInfoLabel1;
    JLabel TeamInfoLabel2;
    
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
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        finishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        TeamInfoLabel.setFont(new Font("Tahoma", 1, 21));


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

        //Constructing the information area

        subCreatePanel2 = new JPanel();
        subCreatePanel2.setOpaque(false);
        subCreatePanel2.setPreferredSize(new Dimension(550,400));
        subCreatePanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        GridBagLayout g3 = new GridBagLayout();
        subCreatePanel2.setLayout(g3);
        GridBagConstraints c3 = new GridBagConstraints();

        teamInfoPanel1 = new JPanel();
        teamInfoPanel1.setOpaque(false);
        teamInfoPanel1.setPreferredSize(new Dimension(525,140));
        teamInfoPanel1.setLayout(new BorderLayout());
        teamInfoPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

                subTeam1InfoPanel1 = new JPanel();
                subTeam1InfoPanel1.setOpaque(false);
                subTeam1InfoPanel1.setPreferredSize(new Dimension(200,140));
                subTeam1InfoPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                GridBagLayout g4 = new GridBagLayout();
                subTeam1InfoPanel1.setLayout(g4);
                GridBagConstraints c4 = new GridBagConstraints();

                                team1Blue = new JRadioButton("Blue");
                                team1Blue.setOpaque(false);
                                team1Blue.setSelected(true);
                                team1Red = new JRadioButton("Red");
                                team1Red.setOpaque(false);
                                team1Green = new JRadioButton("Green");
                                team1Green.setOpaque(false);
                                team1Yellow = new JRadioButton("Yellow");
                                team1Yellow.setOpaque(false);
                                team1ColorRadioButtons =  new ButtonGroup();
                                team1ColorRadioButtons.add(team1Blue);
                                team1ColorRadioButtons.add(team1Red);
                                team1ColorRadioButtons.add(team1Green);
                                team1ColorRadioButtons.add(team1Yellow);
                                team1ColorLabel= new JLabel("Team Color:");
                                team1ColorLabel.setFont(new Font("Tahoma", 1, 14));

                                        c4.gridx = 0;
                                        c4.gridy = 0;
                                        c4.ipadx =15;
                                        c4.ipady =15;
                                        c4.anchor = GridBagConstraints.LINE_START;
                                        subTeam1InfoPanel1.add(team1ColorLabel,c4);
                                        c4.gridx=0;
                                        c4.gridy=1;
                                        subTeam1InfoPanel1.add(team1Blue, c4);
                                        c4.gridx = 1;
                                        c4.gridy = 1;
                                        subTeam1InfoPanel1.add(team1Red, c4);
                                        c4.gridx=0;
                                        c4.gridy=2;
                                        subTeam1InfoPanel1.add(team1Green, c4);
                                        c4.gridx = 1;
                                        c4.gridy = 2;
                                        subTeam1InfoPanel1.add(team1Yellow, c4);
                                        c4.gridx = 0;
                                        c4.gridy = 3;
                                        subTeam1InfoPanel1.add(Box.createRigidArea(new Dimension(0,15)), c4);

                subTeam1InfoPanel2 = new JPanel();
                subTeam1InfoPanel2.setOpaque(false);
                subTeam1InfoPanel2.setPreferredSize(new Dimension(255,140));
                subTeam1InfoPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                GridBagLayout g5 = new GridBagLayout();
                subTeam1InfoPanel2.setLayout(g5);
                GridBagConstraints c5 = new GridBagConstraints();
                
                                team1PlayerLabel= new JLabel("Team Players:");
                                team1PlayerLabel.setFont(new Font("Tahoma", 1, 14));

                                team1PlayerList = new List();
                                team1PlayerList.setSize(new Dimension(50,50));
                                team1PlayerList.setPreferredSize(new Dimension(50,50));
                                team1PlayerList.setMaximumSize(new Dimension(50,50));
                                team1PlayerList.setMinimumSize(new Dimension(50,50));
                                team1PlayerList.setBackground(new Color(192, 244, 0));
                                team1PlayerList.add("Philippe");
                                team1PlayerList.add("Mikie");

                                team1AddPlayer  = new JButton();
                                team1AddPlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                team1AddPlayer .setSize(new Dimension(150,20));
                                team1AddPlayer .setPreferredSize(new Dimension(150,25));
                                team1AddPlayer .setMaximumSize(new Dimension(150,25));
                                team1AddPlayer .setMinimumSize(new Dimension(150,25));
                                team1AddPlayer .setBackground(new Color(53, 212, 160));
                                team1AddPlayer .setFont(new Font("Tahoma", 1, 14));
                                team1AddPlayer .setText("Add new player");
                                team1AddPlayer .setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                                team1removePlayer  = new JButton();
                                team1removePlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                team1removePlayer .setSize(new Dimension(150,25));
                                team1removePlayer .setPreferredSize(new Dimension(150,25));
                                team1removePlayer .setMaximumSize(new Dimension(150,25));
                                team1removePlayer .setMinimumSize(new Dimension(150,25));
                                team1removePlayer .setBackground(new Color(53, 212, 160));
                                team1removePlayer .setFont(new Font("Tahoma", 1, 14));
                                team1removePlayer .setText("Remove player");
                                team1removePlayer .setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                                JPanel leftTeamPleyerPanel1 = new JPanel();
                                leftTeamPleyerPanel1.setOpaque(false);
                                GridBagLayout g6 = new GridBagLayout();
                                leftTeamPleyerPanel1.setLayout(g6);
                                GridBagConstraints c6 = new GridBagConstraints();

                                JPanel rigthTeamPleyerPanel1 = new JPanel();
                                rigthTeamPleyerPanel1.setOpaque(false);
                                GridBagLayout g7 = new GridBagLayout();
                                rigthTeamPleyerPanel1.setLayout(g7);
                                GridBagConstraints c7 = new GridBagConstraints();

                                c6.gridx = 0;
                                c6.gridy = 0;
                                c6.anchor = GridBagConstraints.LINE_START;
                                leftTeamPleyerPanel1.add(team1PlayerLabel, c6);
                                c6.gridx = 0;
                                c6.gridy = 1;
                                leftTeamPleyerPanel1.add(Box.createRigidArea(new Dimension(0,20)), c6);
                                c6.gridx = 0;
                                c6.gridy = 2;
                                leftTeamPleyerPanel1.add(team1PlayerList, c6);
                                c6.gridx = 0;
                                c6.gridy = 3;
                                leftTeamPleyerPanel1.add(Box.createRigidArea(new Dimension(0,20)), c6);


                                c7.gridx = 0;
                                c7.gridy = 0;
                                rigthTeamPleyerPanel1.add(Box.createRigidArea(new Dimension(0,20)), c7);
                                c7.gridx = 0;
                                c7.gridy = 1;
                                rigthTeamPleyerPanel1.add(team1AddPlayer, c7);
                                c7.gridx = 0;
                                c7.gridy = 2;
                                rigthTeamPleyerPanel1.add(Box.createRigidArea(new Dimension(0,10)), c7);
                                c7.gridx = 0;
                                c7.gridy = 3;
                                rigthTeamPleyerPanel1.add(team1removePlayer, c7);



               c5.gridx = 0;
               c5.gridy = 0;
               subTeam1InfoPanel2.add(leftTeamPleyerPanel1,c5);
               c5.gridx=1;
               c5.gridy=0;
               subTeam1InfoPanel2.add(Box.createRigidArea(new Dimension(15,0)), c5);
               c5.gridx=2;
               c5.gridy=0;
               subTeam1InfoPanel2.add(rigthTeamPleyerPanel1, c5);


                subTeam2InfoPanel1 = new JPanel();
                subTeam2InfoPanel1.setOpaque(false);
                subTeam2InfoPanel1.setPreferredSize(new Dimension(200,140));
                subTeam2InfoPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                GridBagLayout g8 = new GridBagLayout();
                subTeam2InfoPanel1.setLayout(g8);
                GridBagConstraints c8 = new GridBagConstraints();

                                team2Blue = new JRadioButton("Blue");
                                team2Blue.setOpaque(false);
                                team2Red = new JRadioButton("Red");
                                team2Red.setSelected(true);
                                team2Red.setOpaque(false);
                                team2Green = new JRadioButton("Green");
                                team2Green.setOpaque(false);
                                team2Yellow = new JRadioButton("Yellow");
                                team2Yellow.setOpaque(false);
                                team2ColorRadioButtons =  new ButtonGroup();
                                team2ColorRadioButtons.add(team2Blue);
                                team2ColorRadioButtons.add(team2Red);
                                team2ColorRadioButtons.add(team2Green);
                                team2ColorRadioButtons.add(team2Yellow);
                                team2ColorLabel= new JLabel("Team Color:");
                                team2ColorLabel.setFont(new Font("Tahoma", 1, 14));

                                        c8.gridx = 0;
                                        c8.gridy = 0;
                                        c8.ipadx =15;
                                        c8.ipady =15;
                                        c8.anchor = GridBagConstraints.LINE_START;
                                        subTeam2InfoPanel1.add(team2ColorLabel,c8);
                                        c8.gridx=0;
                                        c8.gridy=1;
                                        subTeam2InfoPanel1.add(team2Blue, c8);
                                        c8.gridx = 1;
                                        c8.gridy = 1;
                                        subTeam2InfoPanel1.add(team2Red, c8);
                                        c8.gridx=0;
                                        c8.gridy=2;
                                        subTeam2InfoPanel1.add(team2Green, c8);
                                        c8.gridx = 1;
                                        c8.gridy = 2;
                                        subTeam2InfoPanel1.add(team2Yellow, c8);
                                        c8.gridx = 0;
                                        c8.gridy = 3;
                                        subTeam2InfoPanel1.add(Box.createRigidArea(new Dimension(0,15)), c8);

                subTeam2InfoPanel2 = new JPanel();
                subTeam2InfoPanel2.setOpaque(false);
                subTeam2InfoPanel2.setPreferredSize(new Dimension(255,140));
                subTeam2InfoPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                GridBagLayout g9 = new GridBagLayout();
                subTeam2InfoPanel2.setLayout(g9);
                GridBagConstraints c9 = new GridBagConstraints();

                                team2PlayerLabel= new JLabel("Team Players:");
                                team2PlayerLabel.setFont(new Font("Tahoma", 1, 14));

                                team2PlayerList = new List();
                                team2PlayerList.setSize(new Dimension(50,50));
                                team2PlayerList.setPreferredSize(new Dimension(50,50));
                                team2PlayerList.setMaximumSize(new Dimension(50,50));
                                team2PlayerList.setMinimumSize(new Dimension(50,50));
                                team2PlayerList.setBackground(new Color(192, 244, 0));
                                team2PlayerList.add("Jade");
                                team2PlayerList.add("Nick");

                                team2AddPlayer  = new JButton();
                                team2AddPlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                team2AddPlayer .setSize(new Dimension(150,20));
                                team2AddPlayer .setPreferredSize(new Dimension(150,25));
                                team2AddPlayer .setMaximumSize(new Dimension(150,25));
                                team2AddPlayer .setMinimumSize(new Dimension(150,25));
                                team2AddPlayer .setBackground(new Color(53, 212, 160));
                                team2AddPlayer .setFont(new Font("Tahoma", 1, 14));
                                team2AddPlayer .setText("Add new player");
                                team2AddPlayer .setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                                team2removePlayer  = new JButton();
                                team2removePlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                team2removePlayer .setSize(new Dimension(150,25));
                                team2removePlayer .setPreferredSize(new Dimension(150,25));
                                team2removePlayer .setMaximumSize(new Dimension(150,25));
                                team2removePlayer .setMinimumSize(new Dimension(150,25));
                                team2removePlayer .setBackground(new Color(53, 212, 160));
                                team2removePlayer .setFont(new Font("Tahoma", 1, 14));
                                team2removePlayer .setText("Remove player");
                                team2removePlayer .setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                                JPanel leftTeamPleyerPanel2 = new JPanel();
                                leftTeamPleyerPanel2.setOpaque(false);
                                GridBagLayout g10 = new GridBagLayout();
                                leftTeamPleyerPanel2.setLayout(g10);
                                GridBagConstraints c10 = new GridBagConstraints();

                                JPanel rigthTeamPleyerPanel2 = new JPanel();
                                rigthTeamPleyerPanel2.setOpaque(false);
                                GridBagLayout g11 = new GridBagLayout();
                                rigthTeamPleyerPanel2.setLayout(g11);
                                GridBagConstraints c11 = new GridBagConstraints();

                                c10.gridx = 0;
                                c10.gridy = 0;
                                c10.anchor = GridBagConstraints.LINE_START;
                                leftTeamPleyerPanel2.add(team2PlayerLabel, c10);
                                c10.gridx = 0;
                                c10.gridy = 1;
                                leftTeamPleyerPanel2.add(Box.createRigidArea(new Dimension(0,20)), c10);
                                c10.gridx = 0;
                                c10.gridy = 2;
                                leftTeamPleyerPanel2.add(team2PlayerList, c10);
                                c10.gridx = 0;
                                c10.gridy = 3;
                                leftTeamPleyerPanel2.add(Box.createRigidArea(new Dimension(0,20)), c10);


                                c11.gridx = 0;
                                c11.gridy = 0;
                                rigthTeamPleyerPanel2.add(Box.createRigidArea(new Dimension(0,20)), c11);
                                c11.gridx = 0;
                                c11.gridy = 1;
                                rigthTeamPleyerPanel2.add(team2AddPlayer, c11);
                                c11.gridx = 0;
                                c11.gridy = 2;
                                rigthTeamPleyerPanel2.add(Box.createRigidArea(new Dimension(0,10)), c11);
                                c11.gridx = 0;
                                c11.gridy = 3;
                                rigthTeamPleyerPanel2.add(team2removePlayer, c11);



               c9.gridx = 0;
               c9.gridy = 0;
               subTeam2InfoPanel2.add(leftTeamPleyerPanel2,c9);
               c9.gridx=1;
               c9.gridy=0;
               subTeam2InfoPanel2.add(Box.createRigidArea(new Dimension(15,0)), c9);
               c9.gridx=2;
               c9.gridy=0;
               subTeam2InfoPanel2.add(rigthTeamPleyerPanel2, c9);





        teamInfoPanel1.add(subTeam1InfoPanel1,BorderLayout.LINE_START);
        teamInfoPanel1.add(subTeam1InfoPanel2,BorderLayout.CENTER);


        teamInfoPanel2 = new JPanel();
        teamInfoPanel2.setOpaque(false);
        teamInfoPanel2.setPreferredSize(new Dimension(525,140));
        teamInfoPanel2.setLayout(new BorderLayout());
        teamInfoPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        teamInfoPanel2.add(subTeam2InfoPanel1,BorderLayout.LINE_START);
        teamInfoPanel2.add(subTeam2InfoPanel2,BorderLayout.CENTER);

        TeamInfoLabel1 = new JLabel("Team 1");
        TeamInfoLabel1.setFont(new Font("Tahoma", 1, 16));

        TeamInfoLabel2 = new JLabel("Team 2");
        TeamInfoLabel2.setFont(new Font("Tahoma", 1, 16));

        c3.gridx = 0;
        c3.gridy = 0;
        c3.anchor = GridBagConstraints.LINE_START;
        subCreatePanel2.add(TeamInfoLabel1,c3);
        c3.gridx=0;
        c3.gridy=1;
        subCreatePanel2.add(teamInfoPanel1, c3);
        c3.gridx = 0;
        c3.gridy = 2;
        subCreatePanel2.add(Box.createRigidArea(new Dimension(0,15)),c3);
        c3.gridx=0;
        c3.gridy=3;
        c3.anchor = GridBagConstraints.LINE_START;
        subCreatePanel2.add(TeamInfoLabel2,c3);
        c3.gridx=0;
        c3.gridy=4;
        subCreatePanel2.add(teamInfoPanel2, c3);

        //c3.anchor = GridBagConstraints.CENTER;




        //Adding the lower level panel to the top level panel with some formatting
        //createPanel1.add(Box.createRigidArea(new Dimension(50,30)), BorderLayout.PAGE_START);
        createPanel2.add(TeamInfoLabelPanel, BorderLayout.PAGE_START);
        createPanel2.add(subCreatePanel2, BorderLayout.CENTER);
        createPanel2.add(navigationPanel, BorderLayout.PAGE_END);
        createPanel2.add(Box.createRigidArea(new Dimension(35,30)), BorderLayout.LINE_END);
        //createPanel1.add(Box.createRigidArea(new Dimension(250,30)), BorderLayout.LINE_END);



       finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                superior.goToNewGame();
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
