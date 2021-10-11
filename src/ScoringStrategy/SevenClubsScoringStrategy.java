package ScoringStrategy;

import ch.aplu.jcardgame.Hand;
import pasur.Suit;

public class SevenClubsScoringStrategy implements IScoringStrategy{
	private static final int POINTS = 7;
	private static final int NUM_CARDS = 7;
	
	public SevenClubsScoringStrategy(){}
	
	public int calculateScore(Hand pickedCards ,Hand surs) {
		int inPicked = pickedCards.getNumberOfCardsWithSuit(Suit.CLUBS);
		int inSurs = surs.getNumberOfCardsWithSuit(Suit.CLUBS);
		
		return ((inPicked+inSurs) >= NUM_CARDS ? POINTS :0);
	}
}
