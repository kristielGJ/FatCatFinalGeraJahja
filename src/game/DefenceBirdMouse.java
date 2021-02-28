package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
/**
 * This class looks for an event (a mouse press)
 * allows mouse press to  both change location for the DefenceBird,
 * and shoot a DefenseAttack upwards
 */
public class DefenceBirdMouse extends MouseAdapter implements CollisionListener {

    private WorldView view;
    private DefenceBird bird;
    private static SoundClip shoot;//plays music during the game levels since cat is always present in the game world so will the music


    static{
        try{
            shoot= new SoundClip("data/pacman_chomp.wav");//sound made when mouse is pressed
        }catch(LineUnavailableException | IOException | UnsupportedAudioFileException e){
            System.out.println(e);
        }
    }

    /**
     * displays bird in Game World
     * @param bird
     * @param view
     */
    public DefenceBirdMouse(DefenceBird bird, UserView view){
        this.bird = bird;
        this.view = view;//allows bird to be displayed in game
    }

    /**
     * moves the bird to the position of the mouse click
     * and shoots a laser from that position
     * @param e
     */
    @Override
    public void mousePressed (MouseEvent e){
        bird.setPosition(view.viewToWorld(e.getPoint()));
        shoot.play();

    }

    /**
     * This deals with collisions with instances of this class
     * @param collisionEvent
     */

    @Override
    public void collide(CollisionEvent collisionEvent) {

    }

    public void setView(WorldView view) {
        this.view = view;
    }

    public void setBird(DefenceBird bird) {
        this.bird = bird;
    }
}
