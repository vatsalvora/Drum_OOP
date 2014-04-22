package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class SpringBox extends JFrame {
	int numberOfPlayers;
	String names[];

	SpringBox() {
		this.getContentPane().setLayout(new GridLayout(8, 8));

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setSize(400, 300);
		this.setResizable(false);

		showLogin(this);

		JTextField field2 = new JTextField(10);

		// create JTextField with specified number of columns
		JTextField field3 = new JTextField(10);

		// create JTextField with default text and columns
		JTextField field4 = new JTextField("Java Code Geeks", 10);
		for (int i = 1; i <= numberOfPlayers; i++) {
			add(new JLabel("Player " + i));

			add(new JTextField(10));
		}
	}

	private static void createAndShowGUI() {

		JFrame frame = new SpringBox();

		frame.pack();

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void showLogin(JFrame frame) {
		JPanel p = new JPanel(new BorderLayout(5, 5));

		JPanel labels = new JPanel(new BorderLayout(5, 5));
		labels.add(new JLabel("How many Players", SwingConstants.RIGHT));
		p.add(labels, BorderLayout.WEST);

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField username = new JTextField("2");
		controls.add(username);
		p.add(controls, BorderLayout.CENTER);

		// LayoutManager l = new GroupLayout(p);
		// p.setLayout(l);
		JOptionPane.showMessageDialog(frame, p, "Log In",
				JOptionPane.QUESTION_MESSAGE);
		numberOfPlayers = Integer.parseInt(username.getText());
		while (numberOfPlayers > 4 || numberOfPlayers < 2)
		{
			JOptionPane.showMessageDialog(frame, "Please choose a number between 2 and 4");

			JOptionPane.showMessageDialog(frame, p, "hehehe",
					JOptionPane.QUESTION_MESSAGE);
			numberOfPlayers = Integer.parseInt(username.getText());
		}
	}

	/**
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {
		createAndShowGUI();
	}

}

class RequestFocusListener implements AncestorListener {
	private boolean removeListener;

	/*
	 * Convenience constructor. The listener is only used once and then it is
	 * removed from the component.
	 */
	public RequestFocusListener() {
		this(true);
	}

	/*
	 * Constructor that controls whether this listen can be used once or
	 * multiple times.
	 * 
	 * @param removeListener when true this listener is only invoked once
	 * otherwise it can be invoked multiple times.
	 */
	public RequestFocusListener(boolean removeListener) {
		this.removeListener = removeListener;
	}

	@Override
	public void ancestorAdded(AncestorEvent e) {
		JComponent component = e.getComponent();
		component.requestFocusInWindow();

		if (removeListener)
			component.removeAncestorListener(this);
	}

	@Override
	public void ancestorMoved(AncestorEvent e) {
	}

	@Override
	public void ancestorRemoved(AncestorEvent e) {
	}
}