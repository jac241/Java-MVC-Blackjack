package blackjack.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import blackjack.models.BlackJackCard;
import blackjack.models.BlackJackDealer;
import blackjack.models.BlackJackModel;
import blackjack.models.BlackJackPlayer;
import blackjack.models.CardImageLoader;
import blackjack.models.Player;
import blackjack.views.BlackJackView;

public class BlackJackController implements ActionListener {
	
	private static final int TESTPLAYERS = 1;
	private BlackJackModel game;
	private BlackJackView view;
	
	public BlackJackController(BlackJackModel game, BlackJackView view){
		this.game = game;
		this.view = view;
		initialize();
	}
	
	private void initialize(){
		game.startGame();
		ArrayList<String> dealerStrings = getHandImageStrings(game.getDealer());
		
		assert(game.getPlayers().size() == 1);
		ArrayList<String> userStrings = getHandImageStrings(game.getPlayers().get(0)); // TODO make this better, assumes dealer is last
		
		view.setDealerCards(dealerStrings);
		view.setUserCards(userStrings);
	}
	
	private ArrayList<String> getHandImageStrings(BlackJackDealer dealer) {
		ArrayList<String> imageList = new ArrayList<String>(5);
		for(BlackJackCard c : dealer.getHand().getCards()){
			imageList.add(c.getCardImageLocation());
		}
		return imageList;
	}

	private ArrayList<String> getHandImageStrings(Player p){
		ArrayList<String> imageList = new ArrayList<String>(5);
		for(BlackJackCard c : p.getHand().getCards()){
			imageList.add(c.getCardImageLocation());
		}
		return imageList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		game.update(command);
	}

}
