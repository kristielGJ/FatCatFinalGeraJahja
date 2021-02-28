package game;

import city.cs.engine.*;

import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class FatCat extends Walker {
    private int cakeCount;
    private int liveCount;
    private int energy;

    private static final Shape shape = new PolygonShape(
            0.72f,0.995f, 1.107f,0.234f, 0.684f,-0.922f, -1.026f,-0.931f, -0.936f,0.999f);

    private final BodyImage image =
            new BodyImage("data/FatCatRight.gif", 2.25f);

    private static SoundClip music;//plays music during the game levels since cat is always present in the game world so will the music
    private static SoundClip munch,milk,ouch;//plays music during the game levels since cat is always present in the game world so will the music

    static{
        try{
            music = new SoundClip("data/ilomilo.wav");
            munch= new SoundClip("data/pacman_eatfruit.wav");
            milk= new SoundClip("data/pacman_eatghost.wav");
            ouch= new SoundClip("data/pacman_death.wav");
        }catch(LineUnavailableException | IOException | UnsupportedAudioFileException e){
            System.out.println(e);
        }
    }



    public FatCat(World world) {
        super(world, shape);
        //allows cat to be displayed in game world
        addImage(image);
        music.play();
        //every time a cat is in the game world there will be music, prevents overlapping sound tracks because there can only be one cat at a time
        cakeCount = 0;
        liveCount = 9;
    }

    public int getCakeCount() {
        return cakeCount;
    }

    public  int getLiveCount() { return liveCount; }

    public  int getEnergyCount() { return energy;}

    public void incrementCakeCount() {
        cakeCount++;
        energy++;
        munch.play();
        System.out.println("Tasty!  Cake count = " + cakeCount);
        System.out.println("Energy = " + energy);
    }


    public void decrementLiveCount() {
        liveCount--;
        if (liveCount >= 0) {
            ouch.play();
            System.out.println("Ouch! Lives left:" + liveCount);
        } else {
            liveCount = 0;
        }
    }

    public void decrementCakeCount() {
        for (int i = 0; i < 9; i++) {
        cakeCount--;
        }
        System.out.println("9 cakes for an extra life! Cakes Left:" + cakeCount); }

    public void incrementLiveCount() {
        liveCount++;
        if(liveCount>=0 ){
            milk.play();
            System.out.println("Yay! Lives left:" + liveCount);}
        else{
            liveCount=0;
        }

    }

    public void setCakeCount(int CakeNo){ cakeCount=CakeNo;}
    public void setEnergyCount(int engNo){ energy=engNo;}
    public void setLiveCount(int liveNo){ liveCount=liveNo;}
    public static SoundClip getMusic() {
        return music;
    }
}


