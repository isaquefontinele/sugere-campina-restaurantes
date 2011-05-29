/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaGerica.java
 *
 * Created on 28/05/2011, 11:15:40
 */

package Projeto;

import javax.swing.Icon;

/**
 *
 * @author laerton
 */
public class JanelaGerica extends javax.swing.JFrame {

    /** Creates new form JanelaGerica */
    public JanelaGerica() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListaRanking = new javax.swing.JList();
        jBtOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ranking");
        setIconImages(null);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jListaRanking.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListaRanking.setName("jListaRanking"); // NOI18N
        jScrollPane1.setViewportView(jListaRanking);

        jBtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/Spell.png"))); // NOI18N
        jBtOk.setText("OK");
        jBtOk.setToolTipText("Ok");
        jBtOk.setName("jBtOk"); // NOI18N
        jBtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acaoBtOK(evt);
            }
        });

        jLabel1.setText("Lista de estabelecimentos com popularidade");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jBtOk, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtOk)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acaoBtOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acaoBtOK
        dispose();
    }//GEN-LAST:event_acaoBtOK

    /**
    * @param args the command line arguments
    */
    public void povoaListaRanking (final String[] ranking ){
    	jListaRanking.setModel(new javax.swing.AbstractListModel() {
            String[] strings = ranking;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }});
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaGerica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListaRanking;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
