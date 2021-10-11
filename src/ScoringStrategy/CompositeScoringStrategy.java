package ScoringStrategy;

import java.util.ArrayList;

import ch.aplu.jcardgame.Hand;

public class CompositeScoringStrategy implements IScoringStrategy{
	ArrayList<IScoringStrategy> strats = new ArrayList<IScoringStrategy>();
	
	public CompositeScoringStrategy() {}
	
	public int calculateScore(Hand pickedCards, Hand surs) {
		int totalScore = 0;
		for(IScoringStrategy rule : strats) {
			totalScore += rule.calculateScore(pickedCards,surs);
		}
		return totalScore;
	}
	
	public void addStrategy(IScoringStrategy strat) {
		strats.add(strat);
	}
	
}
