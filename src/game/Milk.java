package game;

import city.cs.engine.*;

public class Milk extends DynamicBody {
    private static final Shape shape = new PolygonShape(
            0.532f,1.081f, 0.968f,0.52f, 0.977f,-1.081f, -0.992f,-1.057f, -0.982f,0.491f, -0.61f,0.898f);

    private static final BodyImage image =
            new BodyImage("data/milk.png", 2.25f);


    public Milk(World world) {
        super(world, shape);
        addImage(image);

    }
}
