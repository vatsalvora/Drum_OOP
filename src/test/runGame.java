package test;

import model.GameFacade;
import view.hexgame;

import javax.swing.*;

public class runGame {
	public static void main(String[] args) {
		String[] names = { "Lucas", "Bob", "Billy" };

		final GameFacade b = new GameFacade(names);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new hexgame(b);
			}
		});
	}
}
