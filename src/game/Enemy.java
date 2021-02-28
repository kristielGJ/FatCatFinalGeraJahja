package game;

import city.cs.engine.*;

public class Enemy extends Walker {
    private static final Shape shape = new PolygonShape(
            0.21f,1.71f, 0.71f,1.07f, 1.3f,-0.84f, -0.82f,-0.87f, -1.29f,-0.35f, -1.64f,0.65f, -0.71f,1.73f);

    private static final BodyImage image =
            new BodyImage("data/enemy.png", 5.25f);


    public Enemy(World world) {
        super(world, shape);
        addImage(image);
    }


}
