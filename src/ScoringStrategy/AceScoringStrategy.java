package ScoringStrategy;

import ch.aplu.jcardgame.Hand;
import pasur.Rank;

public class AceScoringStrategy implements IScoringStrategy{
	private static final int POINTS = 1;
	
	public AceScoringStrategy() {}
	
	public int calculateScore(Hand pickedCards, Hand surs) {
		int inPicked = pickedCards.getNumberOfCardsWithRank(Rank.ACE);
		int inSurs = surs.getNumberOfCardsWithRank(Rank.ACE);
		return (inPicked+inSurs)*POINTS;
	}
}
