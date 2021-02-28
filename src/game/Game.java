package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    private int level;

    private Controller controller;
    private DefenceBirdMouse defenceBirdMouse;

    /**
     * Initialise a new Game.
     */
    public Game() {

        level = 1;
        world = new Level1();//world setup
        world.populate(this);

        view = new MyView(world, 500, 600,world.getPlayer());
        // world.setView(view);

        final JFrame frame = new JFrame("Event handling");
        ControlPanel buttons = new ControlPanel(view,this,world);
        frame.add(buttons.GetMainPanel(), BorderLayout.SOUTH);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// quit the application when the game window is closed
        frame.setLocationByPlatform(true);// display the world in the window

        frame.add(view);// don't let the game window be resized
        frame.add(new AudioControl().getPnlControls(),BorderLayout.NORTH);
        frame.setResizable(false);// size the game window to fit the world view
        frame.pack();
        frame.setVisible(true);// make the window visible
        frame.requestFocus();// get keyboard focus
        view.addMouseListener(new GiveFocus(frame));// give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new DropLaserLaser(view, world.getBird(),world));


        frame.addKeyListener(new Controller(world.getPlayer()));
        defenceBirdMouse = new DefenceBirdMouse(world.getBird(),view);
        view.addMouseListener(defenceBirdMouse);
        // world.addStepListener(new Tracker(view, world.getPlayer())); // track the cat
        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        world.start();
    }

    /**
     * The player in the current level.
     */
    public FatCat getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * allows the load button to access the current game level
     * @param world
     */
    public void goToLevel(GameLevel world) {
        if (level == 4) {
            System.out.println("checking if level is 4");
        } else {
            world.stop();
            level = world.getLevelNumber();
        }
    }
    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel(){
        world.stop();
        FatCat lastLevelCat=world.getPlayer();
        if (level == 4) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            view.IncrementLevel();
            world = new Level2();
            world.populate(this);
            view.setGameLevel(world.getPlayer());//continue counter
            //switch controls
            controller.setBody(world.getPlayer());
            //transfer stats
            world.getPlayer().setCakeCount(lastLevelCat.getCakeCount());
            world.getPlayer().setEnergyCount(lastLevelCat.getEnergyCount());
            world.getPlayer().setLiveCount(lastLevelCat.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
            //allow bird to follow mouse in next level
            defenceBirdMouse.setView(view);
            defenceBirdMouse.setBird(world.getBird());//gets a new bird
            view.addMouseListener(new DropLaserLaser(view, world.getBird(),world));//mouse events so when clicked bird appears at mouse position
            //start level
            world.start();
        } else if (level == 2) {
            level++;
            view.IncrementLevel();
            world = new Level3();
            world.populate(this);
            view.setGameLevel(world.getPlayer());//continue counter
            //switch controls
            controller.setBody(world.getPlayer());
            //transfer stats
            world.getPlayer().setCakeCount(lastLevelCat.getCakeCount());
            world.getPlayer().setEnergyCount(lastLevelCat.getEnergyCount());
            world.getPlayer().setLiveCount(lastLevelCat.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
            //allow bird to follow mouse in next level
            defenceBirdMouse.setView(view);
            defenceBirdMouse.setBird(world.getBird());//gets a new bird
            view.addMouseListener(new DropLaserLaser(view, world.getBird(),world));//mouse events so when clicked bird appears at mouse position
            //start level
            world.start();

        }
        else if (level == 3) {
            level++;
            view.IncrementLevel();
            world = new Level4();
            world.populate(this);
            view.setGameLevel(world.getPlayer());//continue counter
            //switch controls
            controller.setBody(world.getPlayer());
            //transfer stats
            world.getPlayer().setCakeCount(lastLevelCat.getCakeCount());
            world.getPlayer().setEnergyCount(lastLevelCat.getEnergyCount());
            world.getPlayer().setLiveCount(lastLevelCat.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
            //allow bird to follow mouse in next level
            defenceBirdMouse.setView(view);
            defenceBirdMouse.setBird(world.getBird());//gets a new bird
            view.addMouseListener(new DropLaserLaser(view, world.getBird(),world));//mouse events so when clicked bird appears at mouse position
            //start level
            world.start();
        }
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    public void setView(MyView view) {
        this.view = view;
    }

    public MyView getView() {
        return view;
    }
}
