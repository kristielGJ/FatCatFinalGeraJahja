package game;
import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

/**
 * moves enemy
 */
public class moveEnemy implements StepListener {
    private GameLevel view;
    private Enemy enemy;

    public moveEnemy(GameLevel view,Enemy enemy){
        this.view = view;
        this.enemy= enemy;

    }

    @Override


    public void preStep(StepEvent stepEvent) {


        if ((enemy.getPosition().x <= -3)) {
            enemy.setLinearVelocity(new Vec2(3, 0)); //right
        } else if (enemy.getPosition().x >= 4) {
            enemy.setLinearVelocity(new Vec2(-3, 0)); //left
        }
    }
    @Override
    public void postStep (StepEvent stepEvent){
    }

}