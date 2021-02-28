package game;

import city.cs.engine.*;

import java.util.Timer;
import java.util.TimerTask;
/**
 * DefenceAttack is the object that is shot upwards
 * at a mouse click from the defence bird's position
 * (the location of the mouse.)
 */
public class DefenseAttack extends DynamicBody {
    private static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    private static final BodyImage image =
            new BodyImage("data/lifeHeart.png", 1);

    Timer timer = new Timer();
    TimerTask task;

    public DefenseAttack(World world) {
        super(world, shape);
        addImage(image);
    }


    public void TimerSetUp(int attackLifeSpan){//used when the defenceAttack object is triggered
        task = new TimerForAttack(this,getTimer());
        timer.schedule(task,1000,attackLifeSpan);
    }

    public Timer getTimer(){
        return timer;
    }
}
