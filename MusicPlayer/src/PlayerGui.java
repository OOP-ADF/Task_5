
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PRAKTIKUM
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
        listMusic = new javax.swing.JList();
        txFieldPlaying = new javax.swing.JTextField();
        txLabelNowPlaying = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listMusic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listMusic.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listMusic);

        txFieldPlaying.setEditable(false);
        txFieldPlaying.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txFieldPlaying.setName(""); // NOI18N
        txFieldPlaying.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFieldPlayingActionPerformed(evt);
            }
        });

        txLabelNowPlaying.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txLabelNowPlaying.setText("Now Playing");

        btnAdd.setText("Add");

        btnDelete.setText("Delete");

        btnPrev.setText("<<");

        btnPlay.setText("Play");

        btnStop.setText("Stop");

        btnNext.setText(">>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txLabelNowPlaying, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txFieldPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txFieldPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txLabelNowPlaying))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnPrev)
                    .addComponent(btnPlay)
                    .addComponent(btnStop)
                    .addComponent(btnNext))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txFieldPlayingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFieldPlayingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txFieldPlayingActionPerformed

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

    public Object getjScrollPane1() {
        return jScrollPane1;
    }

    public Object getListMusic() {
        return listMusic;
    }

    public Object getTxFieldPlaying() {
        return txFieldPlaying;
    }

    public Object getTxLabelNowPlaying() {
        return txLabelNowPlaying;
    }
    
    public void setListMusic (String[] musicList) {
        listMusic.setListData(musicList);
    }
    
    public void setTxFieldPlaying (String filename) {
        txFieldPlaying.setText(filename);
    }
    
    public int getSelectedMusic () {
        if (listMusic.getSelectedIndex() == -1) {
            throw new IllegalStateException("Please select any music"); 
        }
        return listMusic.getSelectedIndex();
    }
    
    public void addListener (ActionListener e) {
            btnAdd.addActionListener(e);
            btnDelete.addActionListener(e);
            btnPrev.addActionListener(e);
            btnPlay.addActionListener(e);
            btnStop.addActionListener(e);
            btnNext.addActionListener(e);
    }

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listMusic;
    private javax.swing.JTextField txFieldPlaying;
    private javax.swing.JLabel txLabelNowPlaying;
    // End of variables declaration//GEN-END:variables
}
