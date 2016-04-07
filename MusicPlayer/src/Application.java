/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author PRAKTIKUM
 */
public class Application {
    List<String> musicList;
    ThreadPlayer thread;
    int nowPlaying;
    
    public Application () {
        musicList = new ArrayList<>();
    }
    
    class ThreadPlayer extends Thread {
        String filepath;
        Player player;

        public ThreadPlayer (String filename) {
            this.filepath = filepath;
        }
        
        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(filepath);
                player = new Player(fis);
                player.play();
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("File "+filepath+" not Found");
            } catch (JavaLayerException exc) {
                throw new IllegalStateException("ERROR While playing file");
            }
        }
    }
    
    public void addMusic (String path) {
        musicList.add(path);
    }
    
    public String[] getMusicList () {
        return (String[]) musicList.toArray(new String[0]);
    } 
    
    public void removeMusic (int i) {
        musicList.remove(i);
    }
    
    public void play (int i) {
        nowPlaying = i;
        String filepath = musicList.get(i);
        thread = new ThreadPlayer(filepath);
        thread.start();
    }
    
    public void stop () {
        if (thread != null) {
                thread.stop();
        }
    }
    
    public void next() {
        if (nowPlaying < musicList.size() - 1) {
            stop();
            play(nowPlaying + 1);
        }
    }
    
    public void prev() {
        if (nowPlaying > 0) {
            stop();
            play(nowPlaying - 1);
        }
    }
    
    public String getNowPlayed () {
        return musicList.get(nowPlaying);
    }
}
