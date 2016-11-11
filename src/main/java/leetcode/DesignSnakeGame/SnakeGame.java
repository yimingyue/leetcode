package leetcode.DesignSnakeGame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 7/26/16.
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class SnakeGame {
    private Deque<Integer> queue;
    private Set<Integer> snake;
    private int[][] food;
    private int width;
    private int height;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        this.snake = new HashSet<>();
        snake.add(0);
        this.queue = new ArrayDeque<>();
        queue.offer(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int pos = queue.peekLast();
        int x = pos / width;
        int y = pos % width;
        switch (direction) {
            case "U":   x--;    break;
            case "L":   y--;    break;
            case "R":   y++;    break;
            case "D":   x++;    break;
            default: throw new IllegalArgumentException("Invalid direction " + direction);
        }
        if (x < 0 || x == height || y < 0 || y == width)
            return -1;
        if (queue.size() > food.length || x != food[queue.size()-1][0] || y != food[queue.size()-1][1])
            snake.remove(queue.poll());

        pos = x * width + y;
        if (!snake.add(pos))
            return -1;
        queue.offer(pos);
        return queue.size()-1;
    }
}
