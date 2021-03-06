package graphics;

import game.GameControllerInterface;
import game.GameModelInterface;
import player.Player;

public class CharacterPanel extends javax.swing.JPanel {

    private GameControllerInterface controller;
    private GameModelInterface model;
    
    /**
     * Creates new form CharacterPanel
     */
    public CharacterPanel(GameControllerInterface c, GameModelInterface m) {
        this.controller = c;
        this.model = m;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        inventoryLabel = new javax.swing.JLabel();
        playerNameLabel = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        happinessLabel = new javax.swing.JLabel();
        rankLabel = new javax.swing.JLabel();
        citizenshipLabel = new javax.swing.JLabel();
        rankValueLabel = new javax.swing.JLabel();
        citizenshipValueLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        locationValueLabel = new javax.swing.JLabel();
        mailboxLabel = new javax.swing.JLabel();
        mailboxValueLabel = new javax.swing.JLabel();
        advancePlayerInfoButton = new javax.swing.JButton();

        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        inventoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventoryLabel.setText("Inventory");

        setPreferredSize(new java.awt.Dimension(175, 300));

        playerNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        playerNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNameLabel.setText("Player Name");
        playerNameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);        

        happinessLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        happinessLabel.setText("Happiness");

        rankLabel.setText("Rank:");
        rankValueLabel.setText("Sheep");
        
        citizenshipLabel.setText("Citizenship:");
        citizenshipValueLabel.setText("Sheep");

        locationLabel.setText("Location:");
        locationValueLabel.setText("Sheep");

        mailboxLabel.setText("Mailbox:");
        mailboxValueLabel.setText("New Sheep");

        advancePlayerInfoButton.setText("Advanced Info");
        advancePlayerInfoButton.setMaximumSize(new java.awt.Dimension(75, 23));
        advancePlayerInfoButton.setMinimumSize(new java.awt.Dimension(75, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(happinessLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rankLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rankValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(citizenshipLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(citizenshipValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(locationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advancePlayerInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mailboxLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mailboxValueLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(happinessLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rankLabel)
                    .addComponent(rankValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(citizenshipValueLabel)
                    .addComponent(citizenshipLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(locationValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailboxLabel)
                    .addComponent(mailboxValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancePlayerInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    void update(Player p) {
        playerNameLabel.setText(p.getName());
        rankValueLabel.setText(p.getRank().toString());
        if (p.getLocation() == null) {
            locationValueLabel.setText("Nowhere");
        }
        else {
            locationValueLabel.setText(p.getLocation().getName());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton advancePlayerInfoButton;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JLabel locationValueLabel;
    private javax.swing.JLabel mailboxLabel;
    private javax.swing.JLabel mailboxValueLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel happinessLabel;
    private javax.swing.JLabel inventoryLabel;
    private javax.swing.JLabel rankLabel;
    private javax.swing.JLabel citizenshipLabel;
    private javax.swing.JLabel rankValueLabel;
    private javax.swing.JLabel citizenshipValueLabel;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
