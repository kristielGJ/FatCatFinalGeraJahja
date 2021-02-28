package game;

import city.cs.engine.WorldView;
import game.Game;
import game.GameLevel;
import game.GameLoader;
import game.GameSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ControlPanel {
    private JButton pauseButton;
    private JButton exitButton;
    private JButton helpButton;
    private JButton skipButton;
    private JPanel MainPanel;
    private JButton saveButton;
    private JButton loadButton;
    private WorldView view;
    private Game game;
    private GameLevel gameLevel;

    public JPanel GetMainPanel(){
        return MainPanel;
    }

    public  ControlPanel(WorldView view,Game game ,GameLevel gameLevel){
        this.view = view;
        this.game=game;
        this.gameLevel=gameLevel;

        this.pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.getWorld().isRunning()) {
                    view.getWorld().stop();//stops game movement
                    gameLevel.getPlayer().getMusic().pause();//pauses music
                    pauseButton.setText("Resume Game");//option to resume the game replaces the original text
                } else {
                    view.getWorld().start();
                    gameLevel.getPlayer().getMusic().resume();
                    pauseButton.setText("Pause");//if button is not clicked button will display pause as text
                }

            }
        });

        this.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(view.getWorld().isRunning()) { ;
                    System.exit(0);//closes game window
                }
            }
        });
        this.skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(view.getWorld().isRunning()) {
                    gameLevel.isCompleted();
                    game.goNextLevel();
                }
            }

        });
        this.helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (view.getWorld().isRunning()) {
                    view.getWorld().stop();//pauses the game so that user can read the help instructions
                    helpButton.setText("Resume Game");//option to resume the game replaces the original text
                    JOptionPane.showMessageDialog(null, "Bird: Shoot enemies with the mouse to protect your fat cat!" +
                            " Cat: Use Arrow keys to eat cake, gain lives , stay away from ghosts to store energy! " +
                            "Collect all cakes and touch the heart to proceed to the next level." +
                            " Milk and cake increment your lives :)", "Help",JOptionPane.INFORMATION_MESSAGE);

                } else {
                    view.getWorld().start();
                    helpButton.setText("Help");//if button not clicked the text is displayed on the button
                }
            }
        });
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fc = new JFileChooser();

                Component controlPanel;
                int returnVal = fc.showSaveDialog(MainPanel);

                if (returnVal == JFileChooser.APPROVE_OPTION) {

                    File file = fc.getSelectedFile();
                    String filePath = file.getAbsolutePath();
                    GameSaver sw = new GameSaver(filePath, getGameLevel());
                    try{
                        //Saving the data
                        System.out.println("GameLevel: " + getGameLevel());
                        sw.saveGame(getGameLevel(), getGameLevel().getPlayer());
                    }
                    catch(IOException ex){
                        ex.printStackTrace();
                    }

                }
            }
        });

        this.loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();

                int returnVal = fc.showOpenDialog(MainPanel);

                if (returnVal == JFileChooser.APPROVE_OPTION) {

                    File file = fc.getSelectedFile();
                    file.getName();
                    String filePath = file.getAbsolutePath();
                    System.out.println(file.getName());

                    GameLoader sr = new GameLoader( filePath, game);
                    try{
                        //Going to the saved level and position
                        GameLevel loadedGame = sr.loadGame();
                        game.goToLevel(loadedGame);
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }

                }

            }
        });



    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }
    }


