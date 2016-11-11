package google.Maze;

/**
 * Created by ymyue on 10/10/16.
 */
public class MazeSolution extends MazeBase {
    public boolean maze() {
        if (isExit())
            return true;
        move();
        if (maze())
            return true;

        // come back
        leftTurn();
        leftTurn();
        move();

        leftTurn();
        move();
        if (maze())
            return true;
        leftTurn();
        leftTurn();
        move();

        leftTurn();
        move();
        if (maze())
            return true;
        leftTurn();
        leftTurn();
        move();

        leftTurn();
        move();
        if (maze())
            return true;
        leftTurn();
        leftTurn();
        move();

        leftTurn();
        return false;
    }
}
