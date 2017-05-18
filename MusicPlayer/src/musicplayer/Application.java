/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 *
 * @author amalyacitra
 */
public class Application {
    private List<String> musicList;
    private ThreadPlayer thread;
    private int nowPlaying;
    
    class ThreadPlayer extends Thread{
        private String filepath;
        private Player player;
        public ThreadPlayer(String filepath){
            this.filepath = filepath;
        }
        public void run(){
            try {
                FileInputStream fis = new FileInputStream(filepath);
                player = new Player(fis);
                player.play();
            } catch(FileNotFoundException ef){
                throw new IllegalStateException("File " + filepath + "not Found");
            } catch(JavaLayerException el){
                throw new IllegalStateException("Error while playing file "); 
            }
        }
    }

    public Application() {
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
        nowPlaying = i;
        String filepath = musicList.get(i);
        thread = new ThreadPlayer(filepath);
        thread.start();
   }
    
    public void stop(){
        if(thread!=null ){
            thread.stop();
        }
    }
    
    public void next(){
        if(nowPlaying<musicList.size() -1){
            stop();
            play(nowPlaying+1);
        }
    }
    
    public void prev(){
        stop();
        if(nowPlaying!=0)
        {play(nowPlaying -1);
        }
    }
}
