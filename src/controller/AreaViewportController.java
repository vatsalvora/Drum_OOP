package controller;

import model.Board;
import view.AreaViewport;
import view.keypressed.KeyPressed;

import java.awt.*;
import java.util.*;
import java.util.List;


public class AreaViewportController {

    private AreaViewport areaViewport;

    public AreaViewportController(Board board){
            areaViewport = new AreaViewport(board);
    }

    public void render(Board board){
        areaViewport.render(board);
    }

    public void addListeners(List<KeyPressed> keySet){
        areaViewport.addKeyListeners(keySet);
    }
//    public final static boolean orFLAT = true;
//    public final static boolean orPOINT = false;

    public void setMovementColor(Color color){
        areaViewport.setMovement(color);
    }


}