package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlaceRiceTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceRiceTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

    @Override
	public void execute() {
		b.placeRiceTile(l);
	}

    @Override
	public void undo() {

	}

    @Override
    public String toString(){
        return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation();
    }
}
