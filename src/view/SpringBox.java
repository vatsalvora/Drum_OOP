package view;

import model.GameFacade;
import model.state.State;
import model.state.Turn;
import view.keypressed.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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
	static int numberOfPlayers;
	static String[] names;
    private static JTextField[] fields;
	SpringBox() {
		this.getContentPane().setLayout(new GridLayout(8, 8));

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setSize(400, 300);
		this.setResizable(false);

		showLogin(this);

        if(numberOfPlayers>4) numberOfPlayers =4;
        fields = new JTextField[numberOfPlayers];
        names = new String[numberOfPlayers];
		for (int i = 1; i <= numberOfPlayers; i++) {
			add(new JLabel("Player " + i));
            fields[i-1] = new JTextField(10);
			getContentPane().add(fields[i - 1]);
            fields[i-1].addKeyListener(new EnterListener(numberOfPlayers, names, fields));
		}


	}

	public static void createAndShowGUI() {

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

	}

}
class EnterListener extends KeyAdapter {
    private int numberOfPlayers;
    private String[] names;
    private JTextField[] fields;
    public EnterListener(int numberOfPlayers, String[] names, JTextField[] fields) {
            this.numberOfPlayers = numberOfPlayers;
            this.names = names;
            this.fields = fields;
    }

    public void keyTyped(KeyEvent ke) {

        if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
            System.out.println(ke.toString());
            boolean ready = true;
            for (int i = 1; i <= numberOfPlayers; i++) {

                names[i-1] = names[i-1] = fields[i-1].getText();
                if(names[i-1] == "") ready = false;
                System.out.println(names[i-1]);
            }
            if(ready){
                GameFacade b = new GameFacade(names);
                List<KeyPressed> keySet = createListeners(b);
                b.addKeyListeners(keySet);
            }
        }
    }
    public static List<KeyPressed> createListeners(GameFacade b) {
        State state = new Turn(b);
        List<KeyPressed> keySet = new ArrayList<KeyPressed>();

        keySet.add(new KeyPressed1(state));
        keySet.add(new KeyPressed2(state));
        keySet.add(new KeyPressed3(state));
        keySet.add(new KeyPressed7(state));
        keySet.add(new KeyPressed8(state));
        keySet.add(new KeyPressed9(state));
        keySet.add(new KeyPressedTab(state));
        keySet.add(new KeyPressedR(state));
        keySet.add(new KeyPressedP(state));
        keySet.add(new KeyPressedV(state));
        keySet.add(new KeyPressedI(state));
        keySet.add(new KeyPressedX(state));
        keySet.add(new KeyPressedA(state));
        keySet.add(new KeyPressedESC(state));
        keySet.add(new KeyPressedF(state));
        keySet.add(new KeyPressedU(state));
        keySet.add(new KeyPressedW(state));
        keySet.add(new KeyPressedE(state));
        keySet.add(new KeyPressed4(state));
        keySet.add(new KeyPressed6(state));
        keySet.add(new KeyPressedS(state));
        keySet.add(new KeyPressedEnter(state));
        keySet.add(new KeyPressedSpace(state));
        keySet.add(new KeyPressedT(state));
        keySet.add(new KeyPressedC(state));
        keySet.add(new KeyPressedM(state));
        keySet.add(new KeyPressedJ(state));
        keySet.add(new KeyPressedK(state));
        keySet.add(new KeyPressedD(state));
        return keySet;
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