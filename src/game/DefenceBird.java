package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.geom.Point2D;
import java.net.UnknownServiceException;

/**
 * Bird player controlled by mouse clicks that can shoot at instances of the enemy class
 */
public class DefenceBird extends Walker implements StepListener {//step listener is required so that i can access the mouse position , since the defence bird will be able to shoot from mouse position and follow the mouse
    private static final Shape shape = new PolygonShape(
            0.562f, 0.581f, 1.099f, 0.026f, 0.884f, -0.9f, -0.532f, -0.727f, -0.836f, -0.428f, -0.902f, 0.593f, -0.406f, 0.677f);

    private static final BodyImage image =
            new BodyImage("data/DefenseBird.png", 2.25f);


    private static UserView view;

    private Game game;
    private GameLevel gameLevel;

    public DefenceBird(GameLevel gameLevel, Game game) {
        super(gameLevel, shape);
        addImage(image);
        gameLevel.addStepListener(this);//allows shooting to happen in the game world
        this.game =game;
        this.gameLevel = gameLevel;//ensures the bird is in the right level
        setGravityScale(0.0f);//bird does not drop to the ground

    }

    /**
     * returns the Bird's x position in the game (unused)
     * @return
     */
    public static float getBirdLocationX() {// throws InterruptedException {

        // TimeUnit.SECONDS.sleep(1 / 2);
        double x1 = MouseInfo.getPointerInfo().getLocation().getX();//gets current mouse position
        float x2 = (float) x1;//converted to a float so these values can be accessed later        //System.out.print(x2);
        return x2;

    }

    /**
     * returns the Bird's y position in the game (unused)
     * @return
     */

    public static float getBirdLocationY() {//throws InterruptedException {

        //   TimeUnit.SECONDS.sleep(1 / 2);
        double y1 = MouseInfo.getPointerInfo().getLocation().getY();//actual y coordinates of the mouse
        float y2 = (float) y1;//converted to float so that it can be used in set position later
        //System.out.print(y2);//just to check the coords are being found
        return y2;
    }

    /**
     * enables the bird to follow the mouse while its moving
     * on screen (unused since it lags, I use mouse clicks instead)
     * @param stepEvent
     */

    @Override
    public void preStep(StepEvent stepEvent) {//from engine, allows an action to take place after every 'step', allows for constant updates of x and y locations of the mouse
        //the code bellow would allow the bird to follow the mouse , this happens using step listener since it updates the position at every frame.
 /*
        Point p = new Point();
        p.setLocation(getBirdLocationX() / 2, getBirdLocationY() / 2);
        Vec2 gg = MouseInfo.getPointerInfo().getLocation();
        Point2D.Float f1 = view.viewToWorld(MouseInfo.getPointerInfo().getLocation());
        Vec2 position = (game.getView().viewToWorld(p));//dependencies required to convert coordinates to game
        gameLevel.getBird().setPosition(position);//sets birds position in gameWorld
 */
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }




}