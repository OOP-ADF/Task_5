/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Ekaaaa
 * NIM 1301144312
 * Kelas IF-38-02
 */
public class Application {
    private ArrayList<String> musicList;
    private ThreadPlayer thread;
    private int nowPlaying;
    
    public Application() {
        musicList = new ArrayList<>();
    }
    
    public void addMusic(String path) {
        musicList.add(path);
    }
    
    public String[] getMusicList() {
        return (String[]) musicList.toArray(new String[0]);
    }
    
    public String getNowPlayed() {
        return musicList.get(nowPlaying);
    }
    
    public void removeMusic(int i) {
        musicList.remove(i);
    }
    
    public void play(int i) {
        nowPlaying = i;
        String filepath = musicList.get(i);
        thread = new ThreadPlayer(filepath);
        thread.start();
    }
    
    public void stop() {
        if(thread != null) {
            thread.stop();
        }
    }
    
    public void next() {
        if(nowPlaying < musicList.size() -1) {
            stop();
            play(nowPlaying +1);
        }
    }
    
    public void prev() {
        if(nowPlaying < musicList.size() +1) {
            stop();
            play(nowPlaying -1);
        }
    }
    
    class ThreadPlayer extends Thread {
        private String filepath;
        private Player player;
        
        public ThreadPlayer(String filepath) {
            this.filepath = filepath;
        }
        
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(filepath);
                player = new Player(fis);
                player.play();
            } catch (FileNotFoundException exc) {
                throw new IllegalStateException("FIle " + filepath + " not found");
            } catch (JavaLayerException exc) {
                throw new IllegalStateExcepption("ERROR while playing file ");
            }
        }
    }
}
