package game;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import org.jbox2d.common.Vec2;


/**
 * The game.GameLoader class - used to load game state
 */

public class GameLoader {

    private String fileName;
    private Game game;

    public GameLoader(String fileName, Game game) {
        this.fileName = fileName;
        this.game = game;
    }


    public GameLevel loadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            String[] tokens = line.split(",");

            int levelNumber = Integer.parseInt(tokens[0]);

            float xPlayer  = Float.parseFloat(tokens[1]);
            float yPlayer = Float.parseFloat(tokens[2]);


            Vec2 posPlayer = new Vec2(xPlayer, yPlayer);

            GameLevel level = null;

            //saving depending on the level number
            if (levelNumber == 1) {
                level = new Level1();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
                // level.getShip().getScore() = (int) scorePlayer;
            } else if (levelNumber == 2) {
                level = new Level2();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            } else if (levelNumber == 3) {
                level = new Level3();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            } else if (levelNumber == 4) {
                level = new Level4();
                level.populate(game);
                level.getPlayer().setPosition(posPlayer);
            }

            return level;


        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }


    }
}