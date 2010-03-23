import java.util.Random;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Control extends JFrame{

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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        help = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        dice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlPanel.setOpaque(false);
        controlPanel.setPreferredSize(GameBoard.controlPanelSize);
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));


        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Your Team");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        help.setIcon(new javax.swing.ImageIcon("images/helpIcon.jpg")); // NOI18N
        help.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon("images/exitIcon.jpg")); // NOI18N
        exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.setMaximumSize(new java.awt.Dimension(20, 133));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        dice.setIcon(new javax.swing.ImageIcon("images/Dice.jpg")); // NOI18N
        dice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dice.setDisabledIcon(new javax.swing.ImageIcon("images/DiceDisable.jpg")); // NOI18N
        dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(help, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dice, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diceActionPerformed(java.awt.event.ActionEvent evt) {
        if (dice.isEnabled()){
            //Random number generation
            Random randomGenerator = new Random();
            int rand = randomGenerator.nextInt(5) + 1;
            try{
                game.updateGameBoard(rand);
            }
            catch (Exception ex){
            }
            //Disabling the dice button so it looks gray
           //dice.setEnabled(false);
        }
    }

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {
        // Tell the GameBoard to display the help window
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        game.exitGame();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public GameBoard game;
    public javax.swing.JPanel controlPanel;
    public javax.swing.JButton dice;
    public javax.swing.JButton exit;
    public javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
