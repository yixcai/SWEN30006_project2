package ScoringStrategy;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Deck;
import ch.aplu.jcardgame.Hand;
import pasur.Rank;
import pasur.Suit;

public class TwoOfClubsScoringStrategy implements IScoringStrategy{
	private static final int POINTS = 2;
	
	public TwoOfClubsScoringStrategy() {}
	
	public int calculateScore(Hand pickedCards, Hand surs) {
		if(pickedCards.getNumberOfCards()>0) {
			Deck d = pickedCards.get(0).getDeck();
					
			return (pickedCards.contains(new Card(d, Suit.CLUBS, Rank.TWO))
					|| surs.contains(new Card(d, Suit.CLUBS, Rank.TWO))
					? POINTS : 0);
		}
		return 0;
	}
}
