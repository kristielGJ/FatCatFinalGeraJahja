package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    private static SoundClip nextLev;//plays music during the game levels since cat is always present in the game world so will the music

    static{
        try{
            nextLev= new SoundClip("data/jump.wav");
        }catch(LineUnavailableException | IOException | UnsupportedAudioFileException e){
            System.out.println(e);
        }
    }
    public DoorListener(Game game) {
        this.game = game;
    }

    /**
     * if all the cakes have been eaten in the current level,
     * the collision between the main char (FatCat) and the Door
     * object results in going to a new game (next level).
     */

    @Override
    public void collide(CollisionEvent e) {
        FatCat player = game.getPlayer();
        if (e.getOtherBody() instanceof FatCat && game.isCurrentLevelCompleted()) {
           nextLev.play();
           System.out.println("Going to next level...");
           game.goNextLevel();
        }
    }
}
