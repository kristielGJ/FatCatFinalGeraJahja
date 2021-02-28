package game;

import java.util.Timer;
import java.util.TimerTask;


public class TimerForAttack extends TimerTask
{
    private DefenseAttack attack;
    public int i = 0;
    private Timer timer;
    public void run()
    {
        i = i  + 1;
        // System.out.println("Timer ran " + i);
        if (i == 40){
            attack.destroy();
            i = 0;
            timer.cancel();
        }
    }

    public TimerForAttack(DefenseAttack attack, Timer timer){
        this.attack = attack;
        this.timer = timer;
    }




}