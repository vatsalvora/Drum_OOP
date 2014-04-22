package controller;

import model.PalaceFestival;
import view.PalaceFestivalView;

/**
 * Created by devan on 4/21/14.
 */
public class PalaceFestivalController {
    private PalaceFestival palaceFestival;
    private PalaceFestivalView palaceFestivalView;

    public PalaceFestivalController(PalaceFestival palaceFestival) {
        this.palaceFestival = palaceFestival;
        palaceFestivalView = new PalaceFestivalView();
    }

    public void render() {

    }
}
