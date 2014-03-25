package blackjack.models;

import java.util.ArrayList;

public class BlackJackGame implements CardGame {
	
	private ArrayList<Player> players;
	private Dealer dealer;
	
	public BlackJackGame(){
		players = new ArrayList<Player>();
	}
	
	@Override
	public void addPlayer(Player p) {
		players.add(p);		
	}

	@Override
	public void setDealer(Dealer d) {
		dealer = d;
	}

	@Override
	public void initializeGame(int numberOfPlayers) {
		Deck gameDeck = generateDeck();
		for(int i = 0; i < numberOfPlayers; i++){
			addPlayer(new BlackJackPlayer());
		}
		setDealer(new BlackJackDealer(gameDeck));
	}

	@Override
	public void quitGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}
	
	// TODO implement this.
	public Deck generateDeck(){
		return null;
	}
	

}
