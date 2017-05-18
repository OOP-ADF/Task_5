/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Irfan
 */
public class PlayerGui extends javax.swing.JFrame {

    /**
     * Creates new form PlayerGui
     */
    public PlayerGui() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listMusic = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txFieldPlaying = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listMusic.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listMusic);

        jLabel1.setText("Now Playing");

        txFieldPlaying.setEditable(false);
        txFieldPlaying.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFieldPlayingActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setLabel("Delete");

        btnPrev.setLabel("<<");

        btnPlay.setLabel("Play");

        btnStop.setLabel("Stop");

        btnNext.setLabel(">>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txFieldPlaying))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txFieldPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnPrev)
                    .addComponent(btnPlay)
                    .addComponent(btnStop)
                    .addComponent(btnNext))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Object getBtnAdd() {
            return btnAdd;
    }
    
    public Object getBtnDelete() {
        return btnDelete;
    }
    
    public Object getBtnNext() {
        return btnNext;
    }
    
    public Object getBtnPlay() {
        return btnPlay;
    }
    
    public Object getBtnPrev() {
        return btnPrev;
    }
    
    public Object getBtnStop() {
        return btnStop;
    }
    
    public void setListMusic(String[] musicList){
        listMusic.setListData(musicList);
    }
    
    public void setTxFieldPlaying(String filename){
        txFieldPlaying.setText(filename);
    }
    
    public int getSelectedMusic(){
        if(listMusic.getSelectedIndex()==-1){
            throw new IllegalStateException("Please sleect any music ");
        }
        return listMusic.getSelectedIndex();
    }
    
    public void addListener(ActionListener e){
        btnAdd.addActionListener(e);
        btnDelete.addActionListener(e);
        btnNext.addActionListener(e);
        btnPlay.addActionListener(e);
        btnPrev.addActionListener(e);
        btnStop.addActionListener(e);
    }
    private void txFieldPlayingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFieldPlayingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txFieldPlayingActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listMusic;
    private javax.swing.JTextField txFieldPlaying;
    // End of variables declaration//GEN-END:variables

}

