package controller;

import model.Board;
import model.Space;
import view.AreaViewport;
import view.keypressed.KeyPressed;

import java.awt.*;
import java.util.List;

public class AreaViewportController {

	private AreaViewport areaViewport;

	public AreaViewportController(Board board) {
		areaViewport = new AreaViewport(board);
	}

	public void render(Board board) {
		areaViewport.render(board);
	}
    public void render(Board board,List<Space> path) {
        areaViewport.render(board,path);
    }

	public void addListeners(List<KeyPressed> keySet) {
		areaViewport.addKeyListeners(keySet);
	}

	// public final static boolean orFLAT = true;
	// public final static boolean orPOINT = false;
	public void setDevColor(Color color) {
		areaViewport.setDevColor(color);
	}

	public int getPalaceLvl() {
		return areaViewport.getPalaceLvl();
	}

	public void setPalaceLvl(int lvl) {
		areaViewport.setPalaceLvl(lvl);
	}

	public void setMovementColor(Color color) {
		areaViewport.setMovement(color);
	}
	// public void scroll(){areaViewport.scrolldown++;};

}