/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author g40
 */
public class Controller implements ActionListener{
    
    private Application app;
    private PlayerGUI view;
    
    public Controller(){
        app = new Application();
        view = new PlayerGUI();
        view.setVisible(true);
        view.addListener(this);
        view.setListMusic(app.getMusicList());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source.equals(view.getBtnAdd())){
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Mp3 Files", "mp3");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(view);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    String path = fc.getSelectedFile().getAbsolutePath();
                    app.addMusic(path);
                    view.setListMusic(app.getMusicList());
                }
            } else if (source.equals(view.getBtnDelete())) {
                int selected = view.getSelectedMusic();
                app.removeMusic(selected);
                view.setListMusic(app.getMusicList());
                
            } else if (source.equals(view.getBtnPlay())) {
                int selected = view.getSelectedMusic();
                app.stop();
                app.play(selected);
                view.setTxFieldPlaying(app.getNowPlayed());
            
            } else if (source.equals(view.getBtnNext())) {
                app.next();
                view.setTxFieldPlaying(app.getNowPlayed());
                
            } else if (source.equals(view.getBtnPrev())) {
                app.prev();
                view.setTxFieldPlaying(app.getNowPlayed());
                
            } else if (source.equals(view.getBtnStop())) {
                app.stop();
                view.setTxFieldPlaying("");
                
            } 
        } catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    
}
