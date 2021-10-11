package ScoringStrategy;

import ch.aplu.jcardgame.Hand;
import pasur.Rank;

public class JackScoringStrategy implements IScoringStrategy{
	private static final int POINTS = 1;
	
	public JackScoringStrategy() {}
	
	public int calculateScore(Hand pickedCards, Hand surs) {
		int inPicked = pickedCards.getNumberOfCardsWithRank(Rank.JACK);
		int inSurs = surs.getNumberOfCardsWithRank(Rank.JACK);
		
		return (inPicked+inSurs)*POINTS;
	}
}
