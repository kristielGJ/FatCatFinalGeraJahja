package game;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The game.GameSaver class - used to save game state
 */

public class GameSaver {

    private String fileName;
    private GameLevel gameLevel;
    private FatCat cat;


    /**
     * Initialise a new game.GameReader
     * <p>
     *   Initialise a new game.GameReader, used to read save game state and load them
     * </p>
     * @param fileName the name to save the game state in
     * @param gameLevel the current game level
     */


    public GameSaver(String fileName, GameLevel gameLevel) {
        this.fileName = fileName;
        this.gameLevel = gameLevel;
    }


    /**
     * Used to write game state into a file
     * <p>
     *   Used to write save game level
     * </p>
     */


    public void saveGame(GameLevel gameWorld,FatCat cat) throws IOException {
        //instants the ship
        this.cat = cat;
        //instants the file reader
        FileWriter writer = null;
        try {
            //instants of the file writer
            writer = new FileWriter(fileName);
            //instants of the file writer
            PrintWriter clearFile = new PrintWriter(fileName);
            // empty the file
            clearFile.print("");
            // close the file
            clearFile.close();
            // writes to the file
            writer.write(gameWorld.getLevelNumber() + "," +
                    gameWorld.getPlayer().getPosition().x + "," +
                    gameWorld.getPlayer().getPosition().y + "\n");

        } finally {
            // close the file
            if (writer != null) {
                writer.close();
            }
        }
    }
}


