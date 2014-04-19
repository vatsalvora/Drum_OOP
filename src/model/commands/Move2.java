package model.commands;

import model.Command;
import model.GameFacade;

public class Move2 implements Command {
	private GameFacade b;

<<<<<<< Updated upstream
	public Move2(GameFacade gameFacade) {
		// TODO Auto-generated constructor stub
        try{

        }
        catch(Exception e){
            System.out.println();
        }
=======
	public Move2(GameFacade b) {
		this.b = b;
>>>>>>> Stashed changes
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
		b.move2();
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName();
	}
}
