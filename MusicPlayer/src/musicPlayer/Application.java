/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicPlayer;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * @author Muhammad Hariz Arasy
 * 1301140259
 * IF-38-09
 */
public class Application {
    private ArrayList<String> musicList;
    private ThreadPlayer thread;
    private int nowPlaying;
    
    public class ThreadPlayer extends Thread {
        private String filepath;
        private Player player;
        
        public ThreadPlayer(String filepath) {
            this.filepath = filepath;
        }
        
        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(filepath);
                player = new Player(fis);
                player.play();
            } catch(FileNotFoundException exc) {
                throw new IllegalStateException("File " + filepath + " not Found");
            } catch(JavaLayerException exc) {
                throw new IllegalStateException("ERROR while playing file");
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
        return (String[]) musicList.toArray(new String[0]);
    }

    public String getNowPlayed() {
        return musicList.get(nowPlaying);
    }
            
    public void removeMusic(int i) {
        musicList.remove(i);
    }
    
    public void play(int i) {
        nowPlaying = 1;
        String filepath = musicList.get(i);
        thread = new ThreadPlayer(filepath);
        thread.start();
    }
    
    public void stop() {
        if (thread != null)
            thread.stop();
    }
    
    public void next() {
        if (nowPlaying < musicList.size() - 1) {
            stop();
            play(nowPlaying - 1);
        }
    }
    
    public void prev() {
        stop();
        if (nowPlaying != 0)
            play(nowPlaying - 1);
    }
}
