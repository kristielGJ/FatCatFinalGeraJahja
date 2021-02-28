package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    private static final int cakeCount = 9;
    private Enemy enemy;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground

        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        BodyImage groundImage = new BodyImage("data/cloud.png", 3);
        ground.addImage(groundImage);
        ground.setPosition(new Vec2(0, -11.5f));

        Shape BreakBigShape = new BoxShape(11, 0.5f);
        Body BreakBig = new StaticBody(this, BreakBigShape);
        BreakBig.addImage(groundImage);
        BreakBig.setPosition(new Vec2(0, 5));//all the energy stored by the cat allows the cat to shoot


        // walls
        Shape leftWallShape = new BoxShape(0.2f, 40, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.2f, 40, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make platforms
        Shape boxShape = new BoxShape(3.5f, 1);

        Body platform1 = new StaticBody(this, boxShape);
        BodyImage cloud = new BodyImage("data/cloud.png", 3);
        platform1.addImage(cloud);
        platform1.setPosition(new Vec2(-7, -4.5f));


        Body platform3 = new StaticBody(this, boxShape);
        platform3.addImage(cloud);
        platform3.setPosition(new Vec2(1, 0));

        for (int i = 2; i < 11; i++) {
            Body cake = new Cake(this);
            cake.setPosition(new Vec2(i * 2 - 10, 10));
            cake.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = -3; i < 3; i++) {
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(i, 10));
            enemy.addCollisionListener(new Pickup(getPlayer()));
        }

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCakeCount() == 0;
    }

    @Override
    public int getLevelNumber() {
        return 4;
    }
}
