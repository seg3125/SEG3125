import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;

import java.awt.event.*;

public class IntroOutro{

    public GameBoard game;

    //**************************************************************************
    //Attributes for GUI
    //**************************************************************************

    //The top level panel
    javax.swing.JPanel mainPanel;
    //The panel in which the content will be changed
    javax.swing.JPanel contentPanel;
    //The panel to house the main buttons
    javax.swing.JPanel highLevelMainButtonPanel;
    javax.swing.JPanel mainButtonPanel;

    //The panel used to navigate through GUI
    JoinGamePanel joinGamePanel;
    CreatePanel1 createGamePanel1;
    CreatePanel2 createGamePanel2;


    //The buttons in the top level panel
    private javax.swing.JButton createButton;
    private javax.swing.JButton joinButton;

    static final Dimension mainPanelButtonDim = new Dimension(200, 50);
    static final Dimension navigationButtonDim = new Dimension(100, 30);

    static final Dimension mainPanelDim = new Dimension(900, 550);
    static final Dimension contentPanelDim = new Dimension(600, 525);



    //**************************************************************************
    //Attributes used to keep game data
    //**************************************************************************

    
    /** Creates new form IntroOutro */
    public IntroOutro(GameBoard game) {
         this.game = game;
         initComponents();
    }

    private void initComponents() {

        //Creating the top level panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(192, 244, 0));
        mainPanel.setPreferredSize(mainPanelDim);
        mainPanel.setLayout(new BorderLayout());

        //Creating the panel used to display the information
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(contentPanelDim);
        contentPanel.setOpaque(false);
        //contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));


        //Creating the panel used to placed the main buttons
        highLevelMainButtonPanel =new JPanel();
        highLevelMainButtonPanel.setPreferredSize(new Dimension(250, 550));
        highLevelMainButtonPanel.setOpaque(false);
        mainButtonPanel = new JPanel();
        mainButtonPanel.setPreferredSize(new Dimension(250, 200));
        mainButtonPanel.setOpaque(false);
        GridBagLayout g = new GridBagLayout();
        mainButtonPanel.setLayout(g);
        GridBagConstraints c = new GridBagConstraints();

        //Creating the join button
        joinButton = new JButton();
        joinButton.setSize(mainPanelButtonDim);
        joinButton.setPreferredSize(mainPanelButtonDim);
        joinButton.setMaximumSize(mainPanelButtonDim);
        joinButton.setMinimumSize(mainPanelButtonDim);
        joinButton.setBackground(new Color(192, 244, 0));
        joinButton.setFont(new Font("Tahoma", 1, 18));
        joinButton.setText("Join Game");
        joinButton.setBorder(BorderFactory.createLineBorder(new Color(245,61,104), 2));
        joinButton.setFocusPainted(false);

        //Creating the create button
        createButton = new JButton();
        createButton.setSize(mainPanelButtonDim);
        createButton.setPreferredSize(mainPanelButtonDim);
        createButton.setMaximumSize(mainPanelButtonDim);
        createButton.setMinimumSize(mainPanelButtonDim);
        createButton.setBackground(new java.awt.Color(192, 244, 0));
        createButton.setFont(new Font("Tahoma", 1, 18));
        createButton.setText("Create Game");
        createButton.setBorder(BorderFactory.createLineBorder(new Color(245,61,104), 2));
        createButton.setFocusPainted(false);

        //Adding the main buttons in the mainbutton grid
        c.gridx = 0;
        c.gridy = 1;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(50,50)),c);
        c.gridx = 1;
        c.gridy = 1;
        mainButtonPanel.add(createButton,c);
        c.gridx = 2;
        c.gridy = 1;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(25,50)),c);
        c.gridx = 0;
        c.gridy = 2;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(50,25)),c);
        c.gridx = 1;
        c.gridy = 2;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(200,25)),c);
        c.gridx = 2;
        c.gridy = 2;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(25,25)),c);
        c.gridx = 0;
        c.gridy = 3;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(50,50)),c);
        c.gridx = 1;
        c.gridy = 3;
        mainButtonPanel.add(joinButton,c);
        c.gridx = 3;
        c.gridy = 3;
        mainButtonPanel.add(Box.createRigidArea(new Dimension(25,50)),c);

        //Adding the lower level panels to the top level panel
        highLevelMainButtonPanel.add(mainButtonPanel, BorderLayout.PAGE_START);
        mainPanel.add( highLevelMainButtonPanel, BorderLayout.LINE_START);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        //Event action for join game button
       createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                displayCreateGamePanel1();
            }
        });

       joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                displayJoinGamePanel();
            }
        });

    }
    
    public void displayJoinGamePanel(){
        contentPanel.removeAll();
        contentPanel.repaint();
        joinGamePanel = new JoinGamePanel(this);
        contentPanel.add(joinGamePanel.joinPanel);
        contentPanel.validate();
        mainPanel.validate();
        joinButton.setEnabled(false);
        joinButton.setBackground(new Color(245,61,104));
        //Toggling the state other main button
        createButton.setEnabled(true);
        createButton.setBackground(new Color(192, 244, 0));
    }
    
    public void closeSubPanel(){
        contentPanel.removeAll();
        contentPanel.repaint();
        joinButton.setBackground(new Color(192, 244, 0));
        joinButton.setEnabled(true);
        createButton.setBackground(new Color(192, 244, 0));
        createButton.setEnabled(true);
    }
    
    public void displayCreateGamePanel1(){
        contentPanel.removeAll();
        contentPanel.repaint();
        createGamePanel1 = new CreatePanel1(this);
        contentPanel.add(createGamePanel1.createPanel1);
        contentPanel.validate();
        mainPanel.validate();
        createButton.setEnabled(false);
        createButton.setBackground(new Color(245,61,104));
        //Toggling the state other main button
        joinButton.setEnabled(true);
        joinButton.setBackground(new Color(192, 244, 0));  
    }
   
    public void changeCreatePanelFoward(){
        contentPanel.removeAll();
        contentPanel.repaint();
        createGamePanel2 = new CreatePanel2(this);
        contentPanel.add(createGamePanel2.createPanel2);
        contentPanel.validate();
        mainPanel.validate();
        createButton.setEnabled(false);
        createButton.setBackground(new Color(245,61,104));
        //Toggling the state other main button
        joinButton.setEnabled(true);
        joinButton.setBackground(new Color(192, 244, 0));
    }

    public void changeCreatePanelBackward(){
        contentPanel.removeAll();
        contentPanel.repaint();
        createGamePanel1 = new CreatePanel1(this);
        contentPanel.add(createGamePanel1.createPanel1);
        contentPanel.validate();
        mainPanel.validate();
        createButton.setEnabled(false);
        createButton.setBackground(new Color(245,61,104));
        //Toggling the state other main button
        joinButton.setEnabled(true);
        joinButton.setBackground(new Color(192, 244, 0));
    }

    public void goToExistingGame(){
        try {
            game.showGame();
        } 
        catch (Exception ex) {
        }
    }
    

    public void goToNewGame(){
        try {
            game.showGame();
        }
        catch (Exception ex){
        }
    }

}
