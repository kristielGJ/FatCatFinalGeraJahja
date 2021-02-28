package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

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

        // walls
        Shape leftWallShape = new BoxShape(0.2f, 40, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.2f, 40, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make platforms
        Shape boxShape = new BoxShape(3.5f, 1);

        Body platform1 = new StaticBody(this, boxShape);
        BodyImage pImage = new BodyImage("data/cloud.png", 3);
        platform1.addImage(pImage);
        platform1.setPosition(new Vec2(-7, 5.5f));

        Body platform2 = new StaticBody(this, boxShape);
        platform2.addImage(pImage);
        platform2.setPosition(new Vec2(5, -2.5f));

        Body platform3 = new StaticBody(this, boxShape);
        platform3.addImage(pImage);
        platform3.setPosition(new Vec2(1, 0));

        Body platform4 = new StaticBody(this, boxShape);
        platform4.addImage(pImage);
        platform4.setPosition(new Vec2(-1.5f, 8.5f));

        Body platform5 = new StaticBody(this, boxShape);
        platform5.addImage(pImage);
        platform5.setPosition(new Vec2(-6.5f, -4.5f));
        for (int i = 2; i < 11; i++) {
            Body cake = new Cake(this);
            cake.setPosition(new Vec2(i * 2 - 10, 10));
            cake.addCollisionListener(new Pickup(getPlayer()));
        }
        for (int i = 2; i < 4; i++) {
            Body milk = new Milk(this);
            milk.setPosition(new Vec2(-10+i, 10));
            milk.addCollisionListener(new Pickup(getPlayer()));
        }
        for (int i = 2; i < 5; i++) {
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(0+i, i));
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
        return 3;
    }
}
