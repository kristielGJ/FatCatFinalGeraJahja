package game;


import city.cs.engine.SoundClip;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * A MouseListener that drops a DefenceAttack on each mouse press at the position of the DefenceBird
 */
public class DropLaserLaser extends MouseAdapter {

    private WorldView view;
    private DefenceBird bird;
    private DefenseAttack attack;
    private GameLevel gameLevel;

    /**
     * Construct a listener.
     * @param view the view the mouse will be clicked on
     */
    public DropLaserLaser(WorldView view, DefenceBird bird,GameLevel world) {

        this.view = view;
        this.bird = bird;
        //this.gameLevel= (GameLevel) view.getWorld();
        this.gameLevel= world;

    }

    /**
     * Create a DefenceAttack at the current mouse position.
     * @param e event object containing the mouse position
     */
    @Override
    public void mousePressed(MouseEvent e) {
        attack = new DefenseAttack(gameLevel);//object that is shot
        attack.setPosition(new Vec2(gameLevel.getBird().getPosition().x ,gameLevel.getBird().getPosition().y ));//bird's current position is the start position of the defenceAttack object
        attack.setGravityScale(0.0f);//shoots upwards
        attack.setLinearVelocity(new Vec2(0.0f,12.0f));//upwards
        attack.addCollisionListener(new Pickup(attack,gameLevel, bird));//collision listener is here so easier to call Pickup
        attack.TimerSetUp(40);
    }




}
