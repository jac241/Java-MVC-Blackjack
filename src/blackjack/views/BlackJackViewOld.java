package blackjack.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import blackjack.models.BlackJackGame;

public class BlackJackViewOld extends JFrame {
	
	private JPanel playerPanel;
	
	private JMenu optionsMenu;
	
	private JLabel score;
	
	private BlackJackGame game;
	
	public BlackJackViewOld(BlackJackGame game){
		super("Blackjack");
		this.game = game;
		initializeView();
	}
	
	private void initializeView(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		optionsMenu = new JMenu("Game");
		menuBar.add(optionsMenu);
		
		
		optionsMenu.add(new JMenuItem("New Game"));
		optionsMenu.add(new JMenuItem("Exit"));
		
		
		
	}
}
