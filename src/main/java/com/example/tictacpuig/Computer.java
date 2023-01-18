package com.example.tictacpuig;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    public static Button selectButton(ArrayList<Button> game_buttons){
        Random rd = new Random();
        int num;
        while(true){
            num = rd.nextInt(9);
            if(game_buttons.get(num).getText().equals("")) return game_buttons.get(num);
        }
    }
}
