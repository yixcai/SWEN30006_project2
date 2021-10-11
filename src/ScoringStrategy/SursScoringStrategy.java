package ScoringStrategy;

import ch.aplu.jcardgame.Hand;

public class SursScoringStrategy implements IScoringStrategy {
	private static final int POINT_PER_SUR=5;
	
	public SursScoringStrategy() {}
	
	public int calculateScore(Hand pickedCards, Hand surs) {
		return surs.getNumberOfCards()*POINT_PER_SUR;
	};
}
