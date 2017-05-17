package Task_5;

import java.awt.event.ActionListener;

public class PlayerGui extends javax.swing.JFrame 
{
    public PlayerGui() 
	{
        initComponents();
    }
 
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() 
	{
 
        jScrollPane1 = new javax.swing.JScrollPane();
        listMusic = new javax.swing.JList<String>();
        txFieldPlaying = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        listMusic.setBackground(new java.awt.Color(153, 153, 153));
        listMusic.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        listMusic.setForeground(new java.awt.Color(255, 255, 255));
        listMusic.setModel(new javax.swing.AbstractListModel() 
	    {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
		jScrollPane1.setViewportView(listMusic);
 
        txFieldPlaying.setEditable(false);
        txFieldPlaying.addActionListener(new java.awt.event.ActionListener() 
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
                txFieldPlayingActionPerformed(evt);
            }
        });
 
        jLabel1.setText("Now Playing");

        btnNext.setText("> >");
 
        btnStop.setText("Stop");
 
        btnPlay.setText("Play");
 
        btnPrev.setText("< <");
 
        btnDelete.setText("Delete");
 
        btnAdd.setText("Add");
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext))
                            .addComponent(txFieldPlaying))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(txFieldPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnStop)
                    .addComponent(btnPlay)
                    .addComponent(btnPrev)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addContainerGap(13, Short.MAX_VALUE))
        );
 
        pack();
    }// </editor-fold>//GEN-END:initComponents
 
     private void txFieldPlayingActionPerformed(java.awt.event.ActionEvent evt) 
	{//GEN-FIRST:event_txFieldPlayingActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_txFieldPlayingActionPerformed
 
    public Object getBtnAdd() 
	{
        return btnAdd;
    }
     
    public Object getBtnDelete() 
	{
        return btnDelete;
    }
     
    public Object getBtnNext() 
	{
        return btnNext;
    }
    
    public Object getBtnPlay() 
	{
        return btnPlay;
    }
     
    public Object getBtnPrev() 
	{
        return btnPrev;
    }
     
    public Object getBtnStop() 
	{
        return btnStop;
    }
     
    public void setListMusic(String[] musicList) 
	{
        listMusic.setListData(musicList);
    }
     
    public void setTxFieldPlaying(String filename) 
	{
        txFieldPlaying.setText(filename);
    }
     
    public int getSelectedMusic() 
	{
         if(listMusic.getSelectedIndex() == -1) 
		{
            throw new IllegalStateException("Please select any music");
        }
        return listMusic.getSelectedIndex();
    }
     
    public void AddListener(ActionListener e) 
	{
        btnAdd.addActionListener(e);
        btnDelete.addActionListener(e);
        btnNext.addActionListener(e);
        btnPlay.addActionListener(e);
        btnPrev.addActionListener(e);
        btnStop.addActionListener(e);
    }
 
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