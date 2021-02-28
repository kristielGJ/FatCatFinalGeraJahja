package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the cat to collect the Milk.
 */
public class MilkCollision implements CollisionListener {
    private GameLevel gameLevel;
    private FatCat cat;
    private Milk milk;
    private DefenseAttack attack;
    private Vec2 lastVecOfEnemy;
    private DefenceBird bird;

    //public Pickup(Enemy enemy) {this.enemy = enemy;}

    public MilkCollision(){

    }

    //public Pickup(DefenseAttack attack) { this.attack = attack; }
    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof Milk && e.getOtherBody() instanceof FatCat) {
            e.getReportingBody().destroy();
            ((FatCat) e.getOtherBody()).incrementLiveCount();

        }

    }

}
