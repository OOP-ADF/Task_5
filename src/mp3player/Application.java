    package mp3player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.util.ArrayList;

/**
 *
 * @author g40
 */

public class Application {
    private ArrayList<String> musicList;
    private ThreadPlayer thread;
    private int nowPlaying;
    
    public class ThreadPlayer extends Thread{
        private String filePath;
        private Player player;
        
        public ThreadPlayer(String filepath){
            this.filePath = filepath; 
        }
        
        @Override
        public void run(){
            try {
                FileInputStream fis = new FileInputStream(filePath);
                player = new Player(fis);
                player.play();
            } catch(FileNotFoundException fe) {
                throw new IllegalStateException("File " + filePath + " not found!");
            } catch(JavaLayerException je){
                throw new IllegalStateException("Error while playing file!");
            }
            
        }
    
    }
    
    public Application() {
        musicList = new ArrayList<>();
    }
    
    public void addMusic(String path) {
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
        this.thread = new ThreadPlayer(filepath);
        thread.start();
    }
    
    public void stop(){
        if(thread != null)
            thread.stop();
        else
            System.out.println("Already stopped");
    }
    
    public void next(){
        if(nowPlaying < musicList.size() - 1){
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
    
    
}
