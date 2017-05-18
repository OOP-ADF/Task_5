/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author PRAKTIKUM
 */
public class Controller implements ActionListener {
    Application app;
    PlayerGui view;
    
    public Controller () {
        app = new Application();
        view = new PlayerGui();
        view.setVisible(true);
        view.addListener(this);
        view.setListMusic(app.getMusicList());
    }
    
    @Override
    public void actionPerformed (ActionEvent ae) {
        Object source = ae.getSource();
        try {
            if (source.equals(view.getBtnAdd())) {
                try {
                    JFileChooser fc = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mp3");
                    fc.setFileFilter(filter);
                    int returnVal = fc.showOpenDialog(view);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String path = fc.getSelectedFile().getAbsolutePath();
                        app.addMusic(path);
                        view.setListMusic(app.getMusicList());
                    }
                } catch (Exception e) {
                    System.out.println("Error : " + e.getMessage());
                }
            } else if (source.equals(view.getBtnPlay())) {
                int selected = view.getSelectedMusic();
                app.stop();
                app.play(selected);
                view.setTxFieldPlaying(app.getNowPlayed());
            } else if (source.equals(view.getBtnStop())) {
                app.stop();
                view.setTxFieldPlaying("");
            } else if (source.equals(view.getBtnNext())) {
                app.next();
                view.setTxFieldPlaying(app.getNowPlayed());
            } else if (source.equals(view.getBtnPrev())) {
                app.prev();
                view.setTxFieldPlaying(app.getNowPlayed());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
}
