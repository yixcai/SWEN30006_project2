package scoring;

import java.util.List;

import ch.aplu.jcardgame.Card;
import pasur.Player;

public class SurScoreStrategy implements IScoreStrategy {
	private int addedScore;

	public SurScoreStrategy(int addedScore) {
		this.addedScore = addedScore;
	}
	
	public int getAddedScore(Player player) {
		return player.getSurs().getCardList().size() * addedScore;
	}
}
