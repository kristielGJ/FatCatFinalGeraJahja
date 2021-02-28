package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private FatCat cat;
    private DefenceBird bird;
    private UserView view;
    private DefenseAttack bullet;


    
    public FatCat getPlayer() {
        return cat;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        bird = new DefenceBird(this,game);
        //bird.addCollisionListener(new DefenceBirdMouse(bird,game.getView()));


        cat = new FatCat(this);
        cat.setPosition(startPosition());
        cat.setGravityScale(4);

        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();

    /**levels report back their numbers*/
    public abstract int getLevelNumber();

    public DefenceBird getBird() { return bird; }//required for displaying the moving bird that follows the mouse coordinates

    //public FatCat getCat() { return cat; }

    public UserView getView(){//required for moving bird that follows the mouse coordinates
        return view;
    }


}
