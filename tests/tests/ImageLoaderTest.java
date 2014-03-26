package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import blackjack.models.*;

public class ImageLoaderTest {

	@Test
	public final void testGetImageLocation() {
		Suit s = Suit.HEART;
		int value = 5;
		
		assertEquals("5 of HEARTs is ../../../resources/h5.png",
					 "../../../resources/h5.png",
					 CardImageLoader.getImageLocation(s, value));
	}

}
