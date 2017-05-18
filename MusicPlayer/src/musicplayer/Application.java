package musicplayer;

import java.util.ArrayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Ihsan Fajri
 */
public class Application {
    private ArrayList <String> musicList;
    private ThreadPlayer thread;
    private int nowPlaying;

    public Application() {
        musicList = new ArrayList();
    }
    
    public void addMusic( String path ){
        musicList.add(path);
    }
    
    public String[] getMusicList(){
        return (String []) musicList.toArray(new String[0]);
    }
    
    public String getNowPlayed(){
        return musicList.get(nowPlaying);
    }
    
    public void removeMusic( int i){
        musicList.remove(i);
    }
    
    public void play (int i){
        nowPlaying = i;
        String filePath = musicList.get(i);
        thread = new ThreadPlayer(filePath);
        thread.start();
    }
    public void stop(){
        if(thread != null){
            thread.stop();
        }
    }
    
    public void next(){
        if(nowPlaying < musicList.size() - 1){
            stop();
            play(nowPlaying + 1);
        }
    }
    
    public void prev(){
        if(nowPlaying < musicList.size() - 1){
            stop();
            play(nowPlaying - 1);
        }
    }
}
