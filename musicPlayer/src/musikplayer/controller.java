/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musikplayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Reza22
 */
public class controller implements ActionListener{
    private application app;
    private PlayerGUI view;
    public controller() {
        app = new application();
        view = new PlayerGUI();
        view.setVisible(true);
        view.AddListener(this);
        view.setListMusic(app.getMusicList());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source.equals(view.getBtnAdd())) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 FILES", "mp3", "m4a");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(view);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
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
            } else if (source.equals(view.getBtnStop())) {
                app.stop();
                view.setTxFieldPlaying(" ");
            } else if (source.equals(view.getBtnNext())) {
                app.next();
                view.setTxFieldPlaying(app.getNowPlayed());
            } else if (source.equals(view.getBtnPrev())) {
                app.prev();
                view.setTxFieldPlaying(app.getNowPlayed());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
}
