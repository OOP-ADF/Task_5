/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

import java.util.ArrayList;
import java.util.List;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/**
 *
 * @author MuRa23
 */
public class Application {
    private int nowPlaying;
    private ArrayList<String> musiclist;
    private Thread ThreadPlayer;

   public Application(){
        musiclist = new ArrayList<>();
    }
    

    public void addMusic (String path){
        this.musiclist.add(path);
    }
    
    public String[] getMusicList(){
        return (String[]) musiclist.toArray(new String[0]);
    }
    
    public String getNowPlayed(){
        return musiclist.get(nowPlaying);
    }
    
    public void removedMusic(int i){
        this.musiclist.remove(i);
    }
    
    public void play (int i){
        nowPlaying = i;
        String filepath = musiclist.get(i);
        ThreadPlayer = new Thread(filepath);
        ThreadPlayer.start();
    }

    
   public void stop(){
        if(ThreadPlayer != null){
            ThreadPlayer.stop();
        }
   }
   
    public void next(){
        if(nowPlaying < musiclist.size() - 1){
            stop();
            play(nowPlaying + 1);
        }
    }
   
   public void prev(){
        if(nowPlaying != 0){
            stop();
            play(nowPlaying - 1);
        }
    }

    void removeMusic(int selected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   private class ThreadPlayer extends Thread{
       private String filepath;
       private Player player;
       
    public  ThreadPlayer (String filepath){
        this.filepath = filepath;
    }
    
       @Override
    public void run (){
        
    }
   }
   
       
}
