package game;

import city.cs.engine.*;

/**
 * Cake objects that are displayed in the world and eaten by the FatCat
 */
public class Cake extends DynamicBody{//object that can be picked up by Fat cat only

    private static final Shape shape = new PolygonShape(
            -0.784f,-0.676f, 0.848f,-0.68f, 0.824f,-0.032f, 0.112f,0.6f, -0.968f,-0.12f);

    private static final BodyImage image =
            new BodyImage("data/cake.png", 2);

    /**
     * Displays Cake object with image file in the game world
     * @param world
     */
    public Cake(World world) {
        super(world, shape);
        addImage(image);
    }
}
