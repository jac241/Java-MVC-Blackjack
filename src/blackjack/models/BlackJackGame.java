package blackjack.models;

import java.util.ArrayList;

public class BlackJackGame implements CardGame {
	
	private ArrayList<Player> players;
	private BlackJackDealer dealer;
	private Player currentPlayer;
	
	public BlackJackGame(){
		players = new ArrayList<Player>();
	}
	
	@Override
	public void addPlayer(Player p) {
		players.add(p);		
	}

	@Override
	public void setDealer(Dealer d) {
		dealer = (BlackJackDealer) d;
	}

	@Override
	public void initializeGame(int numberOfPlayers) {
		Deck<Card> gameDeck = generateDeck();
		//add user player
		addPlayer(new BlackJackPlayer(true));
		for(int i = 0; i < numberOfPlayers - 1; i++){
			addPlayer(new BlackJackPlayer(false));
		}
		setDealer(new BlackJackDealer(gameDeck));
	}

	@Override
	public void quitGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGame() {
		BlackJackCard c;
		for(Player p : players){
			c = (BlackJackCard) dealer.dealCard();
			c.setFaceUp();
			p.takeCard(c);			
		}
		c = (BlackJackCard) dealer.dealCard();
		c.setFaceUp();
		dealer.takeCard(c);
		for(Player p : players){
			c = (BlackJackCard) dealer.dealCard();
			c.setFaceUp();
			p.takeCard(c);			
		}
		c = (BlackJackCard) dealer.dealCard();
		c.setFaceDown();
		dealer.takeCard(c);
		
		currentPlayer = players.get(0);
	}
	
	public Deck<Card> generateDeck(){
		Deck<Card> d = new Deck<>();
		ArrayList<Card> cards = new ArrayList<>();
		for(int value = 1; value <= 13; value++){
			cards.add(new BlackJackCard(Suit.CLUB, value));
			cards.add(new BlackJackCard(Suit.HEART, value));
			cards.add(new BlackJackCard(Suit.SPADE, value));
			cards.add(new BlackJackCard(Suit.DIAMOND, value));
		}
		d.setDeckOfCards(cards);
		return d;
	}
	

}
