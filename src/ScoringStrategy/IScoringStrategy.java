package ScoringStrategy;

import ch.aplu.jcardgame.Hand;

public interface IScoringStrategy {
	int calculateScore(Hand pickedCards, Hand surs);
}
