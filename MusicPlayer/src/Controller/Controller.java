/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI.playerGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import musicplayer.Application;

/**
 *
 * @author Ulid
 */
public class Controller implements ActionListener {
    private Application app;
    private playerGui view;
    
    public Controller(){
        app = new Application();
        view = new playerGui();
        view.setVisible(true);
        view.addListener(this);
        view.setListMusic(app.getMusicList());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
            if(source.equals(view.getBtnAdd())){
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 FILES","mp3", "mp3");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(view);
                if (returnVal == JFileChooser.APPROVE_OPTION){
                    String path = fc.getSelectedFile().getAbsolutePath();
                    app.addMusic(path);
                    view.setListMusic(app.getMusicList());
                }
            } else if (source.equals(view.getBtnDelete())){
                int selected = view.getSelectedMusic();
                app.removeMusic(selected);
                view.setListMusic(app.getMusicList());
            } else if (source.equals(view.getBtnPlay())){
                int selected = view.getSelectedMusic();
                app.stop();
                app.play(selected);
                view.setTxtFieldPlaying(app.getNowPLayed());
            } else if (source.equals(view.getBtnStop())){
                app.stop();
                view.setTxtFieldPlaying("");
            } else if (source.equals(view.getBtnNext())){
                app.next();
                view.setTxtFieldPlaying(app.getNowPLayed());
            } else if (source.equals(view.getBtnPrev())){
                app.prev();
                view.setTxtFieldPlaying(app.getNowPLayed());
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
