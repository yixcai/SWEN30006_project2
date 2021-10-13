package scoring;

import java.util.ArrayList;

import ch.aplu.jcardgame.Card;
import pasur.Player;
import pasur.Rank;
import pasur.Suit;

public class CompositeScoreStrategy implements IScoreStrategy {
	private ArrayList<IScoreStrategy> scoreStrategies = new ArrayList<IScoreStrategy>();
	
	public void addScoreStrategy(IScoreStrategy scoreStrategy) {
		scoreStrategies.add(scoreStrategy);
	}
	
	public void removeScoreStrategy(IScoreStrategy scoreStrategy) {
		scoreStrategies.remove(scoreStrategy);
	}
	
	public int getAddedScore(Player player) {
		int addedScore = 0;
		for (int i=0; i<scoreStrategies.size(); i++) {
			addedScore += scoreStrategies.get(i).getAddedScore(player);
		}
		return addedScore;
	}
}
