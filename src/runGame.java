import javax.swing.SwingUtilities;

import view.hexgame;
import model.*;
import model.state.*;

public class RunGame {
	public static void main(String[] args) {
		String[] names = { "Lucas", "Bob", "Billy" };

		final GameFacade b = new GameFacade(names);

		State s = new Turn(b);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new hexgame(b);
			}
		});
	}
}
