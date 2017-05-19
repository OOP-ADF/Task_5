/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mura23
 */
public class Controller implements ActionListener {

    private Application model;
    private View view;
    
     public Controller(){
        model = new Application();
        view = new View();        
        view.setVisible(true);
        view.addActionListener(this);
        view.setListMusic(model.getMusicList());
    }
    

    @Override
     public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        try{
            if(click.equals(view.getButtonAdd())){
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3 Files", "mp3", "mp3");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(view);
                
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    String path = fc.getSelectedFile().getAbsolutePath();
                    model.addMusic(path);
                    view.setListMusic(model.getMusicList());
                }
            }
            else if(click.equals(view.getButtonDelete())){
                int selected = view.getSelectedMusic();
                model.removeMusic(selected);
                view.setListMusic(model.getMusicList());
            }
            else if(click.equals(view.getButtonNext())){
                model.next();
                view.setFieldPlaying(model.getNowPlayed());
            }
            else if(click.equals(view.getButtonPlay())){
                int selected = view.getSelectedMusic();
                model.stop();
                model.play(selected);
                view.setFieldPlaying(model.getNowPlayed());
            }
            else if(click.equals(view.getButtonPrev())){
                model.prev();
                view.setFieldPlaying(model.getNowPlayed());
            }
            else if(click.equals(view.getButtonStop())){
                model.stop();
                view.setFieldPlaying("");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}