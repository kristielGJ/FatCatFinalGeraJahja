package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {
    private int width;
    private GameLevel gameLevel;//allows us to access the level Number
    private int levelNr;//required for changing the background image per level.
    private FatCat cat;//current cat player
    //private Image background;

    MyView(World w, int width, int height,FatCat cat) {
        super(w, width, height);
        levelNr =1;
        this.cat = cat;
        this.width = width;
        this.gameLevel = gameLevel;

    }
    public void IncrementLevel(){
        levelNr++;
    }//incrementing this value results in a new game (next level)

    protected void paintBackground(Graphics2D g){
        //super.paintBackground(g);
        if (levelNr==1){
            Image background =new ImageIcon("data/Background.jpg").getImage();
            g.drawImage(background, 0,0, null);}
        else if (levelNr==2){
            Image background=new ImageIcon("data/Background2.jpg").getImage();
            g.drawImage(background, 0,0, null);}
        else if (levelNr==3){
            Image background=new ImageIcon("data/Background3.jpg").getImage();
            g.drawImage(background, 0,0, null);}
        else if (levelNr==4){
            Image background=new ImageIcon("data/Background4.jpg").getImage();
            g.drawImage(background, 0,0, null);}
    }
    protected void paintForeground(Graphics2D g){//stats on screen are displayed in the top left corner
        g.fillRect(0, 0,width,30);
        g.setColor(Color.pink);
        g.drawString("Fat Cat Game ", 420, 10);
        g.drawString("Cakes eaten: " + cat.getCakeCount(),  20, 20);//get's cake count from Fatcat class method, cake count goes to 0 for each level
        g.drawString( "Lives Left: " + cat.getLiveCount(), 120, 20);//gets lives count from FatCat class method, 9 cake pickup's equal a life, and a milk pickup equals a life
        g.drawString( "Energy: " + cat.getEnergyCount(), 220, 20);//energy is the overall number of cakes eaten throughout the game (high score value)


    }
    public void setGameLevel(FatCat cat){
        this.cat=cat;
    }}//gets the current cat player s that it can access its method during game play , allows us to get live count etc in real time.