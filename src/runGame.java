import javax.swing.SwingUtilities;

import view.hexgame;
import model.*;

public class RunGame {
	public static void main(String[] args) {
		final String[] names = { "Lucas", "Bob", "Billy" };

		SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GameFacade b = new GameFacade(names);
				new hexgame(b);
			}
		});
	}
}
