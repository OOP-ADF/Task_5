package musicplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Ihsan Fajri
 */
public class ThreadPlayer {
    private String filePath;
    private Player player;

    public ThreadPlayer(String filePath) {
        this.filePath = filePath;
    }
    
    public void run() throws FileNotFoundException, JavaLayerException{
       
       try{
           FileInputStream fis = new FileInputStream(filePath);
           player = new Player(fis);
           player.play();
       } catch (FileNotFoundException exc) {
           throw new IllegalStateException("File " + filePath + "not Found");
       } catch (JavaLayerException exc){
           throw new IllegalStateException("ERROR While playing file");
       }
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


    
    
}
