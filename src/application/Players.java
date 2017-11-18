package application;

import java.awt.*;

public class Players {
    int numberOfPlayer;
    int currentPlayer;
    int nextPlayer;
    Player[] list;
    public Players (int n) {
        numberOfPlayer = n;
        list = new Player[numberOfPlayer];
        for (int i = 0; i < numberOfPlayer; i += 2) {
            list[i] = new Player("Player " + i, 0, 255, 0);
            list[i + 1] = new Player("Player " + (i + 2), 0, 0, 255);
        }
        currentPlayer = 0;
        nextPlayer = 1;
    }
}
