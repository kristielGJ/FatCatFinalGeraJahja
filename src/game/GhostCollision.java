package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class handles the collision between the Enemy objects
 * and the Defence Attack object fired by the DefenceBird
 */
public class GhostCollision implements CollisionListener {


    private GameLevel gameLevel;
    private FatCat cat;
    private Milk milk;
    private DefenseAttack attack;
    private Vec2 lastVecOfEnemy;
    private DefenceBird bird;

    //public Pickup(Enemy enemy) {this.enemy = enemy;}

    public GhostCollision(GameLevel gameLevel){

        this.gameLevel = gameLevel;

    }
    /**
     * When the enemy is shot by the defenceBird the enemy is destroyed
     * it is replaced by a milk object therefore shooting
     * an enemy enables the fatCat player to gain a life
     * if they pickup the milk object created in the position of the enemy that was destroyed
     */

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy && e.getReportingBody() instanceof DefenseAttack) {
            lastVecOfEnemy = new Vec2(e.getOtherBody().getPosition());
            e.getReportingBody().destroy();
            e.getOtherBody().destroy();
            milk = new Milk(gameLevel);
            milk.setPosition(lastVecOfEnemy);
            milk.addCollisionListener(new MilkCollision());

        }
    }
}
