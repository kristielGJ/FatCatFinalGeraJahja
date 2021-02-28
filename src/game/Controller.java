package game;

import city.cs.engine.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 30;
    private static final float WALKING_SPEED = 8;
    private long lastFireTime = 0;
    private World world;
    
    private Walker body;
    private GameLevel currentLevel;
    
    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // up = jump
             //Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            //if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            //}
        } else if (code == KeyEvent.VK_LEFT) {
            body.removeAllImages();
            body.addImage(new BodyImage("data/FatCatLeft.gif",2));
            body.startWalking(-WALKING_SPEED); // left = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.removeAllImages();
            body.addImage(new BodyImage("data/FatCatRight.gif",2));
            body.startWalking(WALKING_SPEED); // right = walk right
        }else if (code == KeyEvent.VK_SPACE) {
            if (System.currentTimeMillis() - lastFireTime > 1000) {
            lastFireTime = System.currentTimeMillis();
            //new DefenseAttack(world,this);
            }
            }
        }

    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }


    public void setBody(Walker body) {
        this.body = body;
    }
}
