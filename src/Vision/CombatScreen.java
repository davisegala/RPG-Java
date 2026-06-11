package Vision;

import Control.Entity.Combat.Combat;
import Entity.Combat.Skill;
import Entity.Entity;
import Itens.Item;
import javax.swing.JButton;

public class CombatScreen extends javax.swing.JFrame {
    private final Combat combat = new Combat();
    
    private final JButton[] JButtonSkills;
    private Entity player;
    private Entity enemy;
    private boolean isPlayerTurn = true;
    
    public CombatScreen() {
        initComponents();
        this.JButtonSkills = new JButton[] {jButtonSkill1, jButtonSkill2, jButtonSkill3, jButtonSkill4};
    }
    
    public void init(Entity player, Entity enemy) {
        jPanelAttack.setVisible(false);
        int x = 0;
        for (Skill skill : player.getCombatManager().getSkills()) {
            this.JButtonSkills[x].setText(skill.getName());
            x++;
        }
        
        this.setVisible(true);
    }
    
    public void refreshInfo() {
        jLabelPlayerHp.setText(
            String.valueOf(player.getCombatManager().getHp()) + "/" + String.valueOf(player.getCombatManager().getMaxHp())
        );
        jLabelEnemyHp.setText(String.valueOf(
            enemy.getCombatManager().getHp()) + "/" + String.valueOf(enemy.getCombatManager().getMaxHp())
        );
        printInventory();
    }
    
    public void startBattle(Entity player, Entity enemy) {
        this.player = player;
        this.enemy = enemy;
        
        init(player, enemy);
        
        while (player.getCombatManager().getHp() > 0 && enemy.getCombatManager().getHp() > 0) {
            if (!isPlayerTurn) enemyTurn();
            this.refreshInfo();
        }
        
        if (player.getCombatManager().getHp() > 0 && enemy.getCombatManager().getHp() <= 0) {
            combat.isPlayerDie(enemy);
            combat.reward(player, enemy);
        } else {
            combat.isPlayerDie(player);
            combat.reward(player, player);
        }
    }
    
    private void enemyTurn() {
        combat.useSkill(enemy, combat.randomSkill(enemy), player);
        isPlayerTurn = true;
    }
    
    public void useSkill(int index) {
        try {
            Skill skill = player.getCombatManager().getSkills()[index];
            if (isPlayerTurn) {
                combat.useSkill(player, skill, enemy);
                isPlayerTurn = false;
                this.refreshInfo();
            }
        } catch (Exception e) {}
    }
    
    public void printInventory() {
        jComboBox1.removeAllItems();
        for (Item item : player.getInventoryManager().getInventory().keySet()) {
            try {
                jComboBox1.addItem(item.getName());
            } catch (Exception e) {}
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAttack = new javax.swing.JPanel();
        jButtonSkill1 = new javax.swing.JButton();
        jButtonSkill2 = new javax.swing.JButton();
        jButtonSkill3 = new javax.swing.JButton();
        jButtonSkill4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAttack = new javax.swing.JButton();
        jButtonInventory = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanelInventory = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabelItemDisplay = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelEnemyHp = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabelPlayerHp = new javax.swing.JLabel();

        jPanelAttack.setBackground(new java.awt.Color(92, 131, 116));

        jButtonSkill1.setBackground(new java.awt.Color(158, 200, 185));
        jButtonSkill1.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 14)); // NOI18N
        jButtonSkill1.setForeground(new java.awt.Color(4, 13, 18));
        jButtonSkill1.setText("Attack1");
        jButtonSkill1.addActionListener(this::jButtonSkill1ActionPerformed);

        jButtonSkill2.setBackground(new java.awt.Color(158, 200, 185));
        jButtonSkill2.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 14)); // NOI18N
        jButtonSkill2.setForeground(new java.awt.Color(4, 13, 18));
        jButtonSkill2.setText("Attack1");
        jButtonSkill2.addActionListener(this::jButtonSkill2ActionPerformed);

        jButtonSkill3.setBackground(new java.awt.Color(158, 200, 185));
        jButtonSkill3.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 14)); // NOI18N
        jButtonSkill3.setForeground(new java.awt.Color(4, 13, 18));
        jButtonSkill3.setText("Attack1");
        jButtonSkill3.addActionListener(this::jButtonSkill3ActionPerformed);

        jButtonSkill4.setBackground(new java.awt.Color(158, 200, 185));
        jButtonSkill4.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 14)); // NOI18N
        jButtonSkill4.setForeground(new java.awt.Color(4, 13, 18));
        jButtonSkill4.setText("Attack1");
        jButtonSkill4.addActionListener(this::jButtonSkill4ActionPerformed);

        javax.swing.GroupLayout jPanelAttackLayout = new javax.swing.GroupLayout(jPanelAttack);
        jPanelAttack.setLayout(jPanelAttackLayout);
        jPanelAttackLayout.setHorizontalGroup(
            jPanelAttackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAttackLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanelAttackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAttackLayout.createSequentialGroup()
                        .addComponent(jButtonSkill4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonSkill3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAttackLayout.createSequentialGroup()
                        .addComponent(jButtonSkill1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonSkill2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanelAttackLayout.setVerticalGroup(
            jPanelAttackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAttackLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelAttackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSkill1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSkill2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelAttackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSkill4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSkill3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Combat");
        setBackground(new java.awt.Color(7, 15, 43));
        setPreferredSize(new java.awt.Dimension(768, 576));
        setResizable(false);
        setSize(new java.awt.Dimension(768, 576));

        jPanel1.setBackground(new java.awt.Color(7, 15, 43));

        jPanel2.setBackground(new java.awt.Color(147, 177, 166));

        jButtonAttack.setBackground(new java.awt.Color(92, 131, 116));
        jButtonAttack.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jButtonAttack.setForeground(new java.awt.Color(4, 13, 18));
        jButtonAttack.setText("Attack");
        jButtonAttack.addActionListener(this::jButtonAttackActionPerformed);

        jButtonInventory.setBackground(new java.awt.Color(92, 131, 116));
        jButtonInventory.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jButtonInventory.setForeground(new java.awt.Color(4, 13, 18));
        jButtonInventory.setText("Inventory");
        jButtonInventory.addActionListener(this::jButtonInventoryActionPerformed);

        jButtonRun.setBackground(new java.awt.Color(92, 131, 116));
        jButtonRun.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jButtonRun.setForeground(new java.awt.Color(4, 13, 18));
        jButtonRun.setText("Run");

        jPanel3.setBackground(new java.awt.Color(92, 131, 116));

        jPanelInventory.setBackground(new java.awt.Color(92, 131, 116));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Use");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanelInventoryLayout = new javax.swing.GroupLayout(jPanelInventory);
        jPanelInventory.setLayout(jPanelInventoryLayout);
        jPanelInventoryLayout.setHorizontalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelItemDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelInventoryLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelInventoryLayout.setVerticalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jLabelItemDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jButtonAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(147, 177, 166));

        jLabelEnemyHp.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabelEnemyHp.setForeground(new java.awt.Color(4, 13, 18));
        jLabelEnemyHp.setText("000/000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEnemyHp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelEnemyHp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(147, 177, 166));

        jLabelPlayerHp.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabelPlayerHp.setForeground(new java.awt.Color(4, 13, 18));
        jLabelPlayerHp.setText("000/000");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelPlayerHp)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabelPlayerHp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttackActionPerformed
       jPanelAttack.setVisible(true);
       jPanelInventory.setVisible(false);
    }//GEN-LAST:event_jButtonAttackActionPerformed

    private void jButtonSkill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSkill1ActionPerformed
        useSkill(0);
    }//GEN-LAST:event_jButtonSkill1ActionPerformed

    private void jButtonSkill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSkill2ActionPerformed
        useSkill(1);
    }//GEN-LAST:event_jButtonSkill2ActionPerformed

    private void jButtonSkill3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSkill3ActionPerformed
        useSkill(2);
    }//GEN-LAST:event_jButtonSkill3ActionPerformed

    private void jButtonSkill4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSkill4ActionPerformed
        useSkill(3);
    }//GEN-LAST:event_jButtonSkill4ActionPerformed

    private void jButtonInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventoryActionPerformed
        jPanelInventory.setVisible(true);
        jPanelAttack.setVisible(false);
    }//GEN-LAST:event_jButtonInventoryActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jLabelItemDisplay.setText(
            player.getInventoryManager().getItem(
                jComboBox1.getSelectedIndex()
            ).display()
        );
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (isPlayerTurn) {
            player.getInventoryManager().getItem(jComboBox1.getSelectedIndex()).use(player);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAttack;
    private javax.swing.JButton jButtonInventory;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonSkill1;
    private javax.swing.JButton jButtonSkill2;
    private javax.swing.JButton jButtonSkill3;
    private javax.swing.JButton jButtonSkill4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelEnemyHp;
    private javax.swing.JLabel jLabelItemDisplay;
    private javax.swing.JLabel jLabelPlayerHp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelAttack;
    private javax.swing.JPanel jPanelInventory;
    // End of variables declaration//GEN-END:variables
}
