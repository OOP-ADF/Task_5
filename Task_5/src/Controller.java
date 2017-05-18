
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class Controller implements ActionListener {
    private Application app;
    private PlayerGui view;
    
    public Controller() {
        app = new Application();
        view = new PlayerGui();
        view.setVisible(true);
        view.addListener(this);
        view.setMusicList(app.getMusicList());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if(source.equals(view.getBtnAdd())) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(view);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    String path = fc.getSelectedFile().getAbsolutePath();
                    app.addMusic(path);
                    view.setMusicList(app.getMusicList());
                }
            }
            else if(source.equals(view.getBtnAdd())) {
                int selected = view.getSelectedMusic();
                app.removeMusic(selected);
                view.setMusicList(app.getMusicList());
            }
            else if(source.equals(view.getBtnPlay())) {
                int selected = view.getSelectedMusic();
                app.stop();
                app.play(selected);
                view.setTxFieldPlaying(app.getNowPlaying());
            }
            else if(source.equals(view.getBtnStop())) {
                app.stop();
                view.setTxFieldPlaying("");
            }
            else if(source.equals(view.getBtnNext())) {
                app.next();
                view.setTxFieldPlaying(app.getNowPlaying());
            }
            else if(source.equals(view.getBtnPrev())) {
                app.prev();
                view.setTxFieldPlaying(app.getNowPlaying());
            }
        }
        catch(Exception err) {
            JOptionPane.showMessageDialog(view, err.getMessage());
        }
    }
}
