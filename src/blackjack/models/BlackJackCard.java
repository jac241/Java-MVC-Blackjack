package blackjack.models;

import java.awt.image.BufferedImage;

public class BlackJackCard extends Card implements Facing {
	
	private BufferedImage cardImage;
	private Face facing;
	
	public BlackJackCard(Suit s, int value) {
		super(s, value);
		cardImage = CardImageLoader.loadImage(s, value);
	}
	
	public int value(){
		if(isAce()){
			return 1;
		}
		else if (faceValue >= 11 && faceValue <= 13) {
			return 10;
		}
		else {
			return faceValue;
		}
	}
		
	public int minValue(){
		if (isAce()){
			return 1;
		}
		else {
			return value();
		}
	}
	
	public int maxValue() {
		if (isAce()){
			return 11;
		}
		else {
			return value();
		}
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}

	@Override
	public void setFaceUp() {
		facing = Face.UP;
	}

	@Override
	public void setFaceDown() {
		facing = Face.DOWN;
	}

	public BufferedImage getCardImage() {
		return cardImage;
	}

	public void setCardImage(BufferedImage cardImage) {
		this.cardImage = cardImage;
	}

	public Face getFacing() {
		return facing;
	}

	public void setFacing(Face facing) {
		this.facing = facing;
	}
	
}
