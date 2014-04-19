package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class start {

	// TODO why is there the main in here?!
	public static void main(String[] args) {
		new start();
	}

	public start() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public class TestPane extends JPanel {

		private static final long serialVersionUID = 1L;
		private List<String> menuItems;
		private String selectMenuItem;
		private String focusedItem;

		private MenuItemPainter painter;
		private Map<String, Rectangle> menuBounds;

		public TestPane() {
			setBackground(Color.BLACK);
			painter = new MenuPainter();
			menuItems = new ArrayList<String>();
			menuItems.add("Start Game");
			menuItems.add("Load Game");
			menuItems.add("Exit");
			selectMenuItem = menuItems.get(0);

			InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
			ActionMap am = getActionMap();

			im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "arrowDown");
			im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arrowUp");

			am.put("arrowDown", new MenuAction(1));
			am.put("arrowUp", new MenuAction(-1));

		}

		public void invalidate() {
			menuBounds = null;
			super.invalidate();
		}

		public Dimension getPreferredSize() {
			return new Dimension(400, 400);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			if (menuBounds == null) {
				menuBounds = new HashMap<String, Rectangle>(menuItems.size());
				int width = 0;
				int height = 0;
				for (String text : menuItems) {
					Dimension dim = painter.getPreferredSize(g2d, text);
					width = Math.max(width, dim.width);
					height = Math.max(height, dim.height);
				}

				int x = (getWidth() - (width + 10)) / 2;

				int totalHeight = (height + 10) * menuItems.size();
				totalHeight += 5 * (menuItems.size() - 1);

				int y = (getHeight() - totalHeight) / 2;

				for (String text : menuItems) {
					menuBounds.put(text, new Rectangle(x, y, width + 10, height + 10));
					y += height + 10 + 5;
				}

			}
			for (String text : menuItems) {
				Rectangle bounds = menuBounds.get(text);
				boolean isSelected = text.equals(selectMenuItem);
				boolean isFocused = text.equals(focusedItem);
				painter.paint(g2d, text, bounds, isSelected, isFocused);
			}
			g2d.dispose();
		}

		public class MenuAction extends AbstractAction {

			private final int delta;

			public MenuAction(int delta) {
				this.delta = delta;
			}

			public void actionPerformed(ActionEvent e) {
				int index = menuItems.indexOf(selectMenuItem);
				if (index < 0) {
					selectMenuItem = menuItems.get(0);
				}
				index += delta;
				if (index < 0) {
					selectMenuItem = menuItems.get(menuItems.size() - 1);
				} else if (index >= menuItems.size()) {
					selectMenuItem = menuItems.get(0);
				} else {
					selectMenuItem = menuItems.get(index);
				}
				repaint();
			}

		}

	}

	public interface MenuItemPainter {

		public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected,
				boolean isFocused);

		public Dimension getPreferredSize(Graphics2D g2d, String text);

	}

	public class MenuPainter implements MenuItemPainter {

		public Dimension getPreferredSize(Graphics2D g2d, String text) {
			return g2d.getFontMetrics().getStringBounds(text, g2d).getBounds().getSize();
		}

		public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected,
				boolean isFocused) {
			FontMetrics fm = g2d.getFontMetrics();
			int x = bounds.x + ((bounds.width - fm.stringWidth(text)) / 2);
			int y = bounds.y + ((bounds.height - fm.getHeight()) / 2) + fm.getAscent();
			g2d.setColor(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
			g2d.drawString(text, x, y);
		}

		protected void paintBackground(Graphics2D g2d, Rectangle bounds, Color background,
				Color foreground) {
			g2d.setColor(background);
			g2d.fill(bounds);
			g2d.setColor(foreground);
			g2d.draw(bounds);
		}

	}

}
