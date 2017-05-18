package project;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.util.*;
import java.io.*;

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
        @Override
        public void run(){
            try {
                FileInputStream fis = new FileInputStream(filepath);
                player = new Player(fis);
                player.play();
            }
            catch(FileNotFoundException e) {
                throw new IllegalStateException("File " + filepath + " not found!");
            }
            catch(JavaLayerException e){
                throw new IllegalStateException("ERROR while playing this file");
            }
        }
    }
    public Application(){
        musicList = new ArrayList<>();
    }
    public void addMusic(String path){
        musicList.add(path);
    }
    public String[] getMusicList(){
        return (String[]) musicList.toArray(new String[0]);
    }
    public String getNowPlayed(){
        return musicList.get(nowPlaying);
    }
    public void removeMusic(int i){
        musicList.remove(i);
    }
    public void play(int i){
        nowPlaying = 1;
        String filepath = musicList.get(i);
        thread = new ThreadPlayer(filepath);
        thread.start();
    }
    public void stop(){
        if(thread != null){
            thread.stop();
        }
    }
    public void next(){
        if(nowPlaying <= musicList.size()-1){
            stop();
            play(nowPlaying+1);
        }
    }
    public void prev(){
        if(nowPlaying != 1){
            stop();
            play(nowPlaying-1);
        }
    }
}
