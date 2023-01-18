package com.example.tictacpuig;

public class Stats {
    private Player player;
    private boolean win;
    private boolean draw;

    public Stats(Player player, boolean win, boolean draw) {
        this.player = player;
        this.win = win;
        this.draw = draw;
    }
}
