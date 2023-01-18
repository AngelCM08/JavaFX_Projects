package com.example.tictacpuig;

public class Player {
    public final boolean computer;
    public final String symbol;
    private String name;

    public Player(boolean computer, String symbol) {
        this.computer = computer;
        this.symbol = symbol;
    }

    public void move(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
