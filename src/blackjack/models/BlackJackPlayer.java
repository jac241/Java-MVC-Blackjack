package blackjack.models;

public class BlackJackPlayer implements Player {
	
	private BlackJackHand hand;
	private boolean isUser;
	
	public BlackJackPlayer(boolean isUser){
		hand = new BlackJackHand();
		this.isUser = isUser;
	}
	
	@Override
	public void hit(Dealer d) {
		takeCard(d.dealCard());

	}

	@Override
	public void stand() {

	}

	@Override
	public void takeCard(Card c) {
		hand.addCard((BlackJackCard) c);
	}

	@Override
	public boolean canHit() {
		boolean canHit = false;
		if(!hand.busted() && !hand.is21()){
			canHit = true;
		}
		return canHit;
	}

}
