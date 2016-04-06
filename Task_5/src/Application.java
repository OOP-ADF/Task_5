
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class Application {
    private ArrayList<String> musicList;
    private ThreadPlayer thread;
    private int nowPlaying;
    
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
            } catch (FileNotFoundException | JavaLayerException ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    public Application() {
        musicList = new ArrayList<>();
    }
    
    public void addMusic(String path) {
        musicList.add(path);
    }
    
    public String[] getMusicList() {
        return (String[]) musicList.toArray();
    }
    
    public String getNowPlaying() {
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
        if(nowPlaying < musicList.size()-1) {
            stop();
            play(nowPlaying + 1);
        }
    }
    
    public void prev() {
        if(nowPlaying > 0) {
            stop();
            play(nowPlaying-1);
        }
    }
}
