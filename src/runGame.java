import javax.swing.SwingUtilities;

import view.hexgame;
import model.*;

public class RunGame {
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
