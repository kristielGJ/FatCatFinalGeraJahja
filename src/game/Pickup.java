package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private GameLevel gameLevel;
    private FatCat cat;
    private Milk milk;
    private DefenseAttack attack;
    private Vec2 lastVecOfEnemy;
    private DefenceBird bird;


    public Pickup(FatCat cat) {
        this.cat = cat;
    }

    //public Pickup(Enemy enemy) {this.enemy = enemy;}

    public Pickup(DefenseAttack attack, GameLevel gameLevel, DefenceBird bird){
        this.attack = attack;
        this.gameLevel = gameLevel;
        this.bird = bird;
    }

    //public Pickup(DefenseAttack attack) { this.attack = attack; }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Cake && e.getOtherBody() == cat) {
            cat.incrementCakeCount();
            e.getReportingBody().destroy();
            if(cat.getCakeCount()==9){
                cat.incrementLiveCount();
                cat.decrementCakeCount();
            }
        }
        else if (e.getReportingBody() instanceof Milk && e.getOtherBody() == cat) {

            e.getReportingBody().destroy();
            cat.incrementLiveCount();

        }
        else if (e.getReportingBody() instanceof Enemy && e.getOtherBody() == cat) {
            cat.decrementLiveCount();
            if (cat.getLiveCount()==0){
                cat.destroy();
                //dead cat ghostly fixture.
            } }
        else if (e.getOtherBody() instanceof Enemy && e.getReportingBody() == attack) {
            lastVecOfEnemy = new Vec2(e.getOtherBody().getPosition());
            e.getReportingBody().destroy();
            e.getOtherBody().destroy();
            milk = new Milk(gameLevel);
            milk.setPosition(lastVecOfEnemy);
            milk.addCollisionListener(new MilkCollision());
        }

    }

    public void setCat(FatCat cat) {
        this.cat = cat;
    }
}
