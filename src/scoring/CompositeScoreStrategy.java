package scoring;

import java.util.ArrayList;

import pasur.Player;

public class CompositeScoreStrategy implements IScoreStrategy {
	private ArrayList<IScoreStrategy> scoreStrategies = new ArrayList<IScoreStrategy>();
	
	public void addScoreStrategy(IScoreStrategy scoreStrategy) {
		scoreStrategies.add(scoreStrategy);
	}
	
	public void removeScoreStrategy(IScoreStrategy scoreStrategy) {
		scoreStrategies.remove(scoreStrategy);
	}
	
	public int getAddedScore(Player player) {
		int score = 0;
		for (int i=0; i<scoreStrategies.size(); i++) {
			score += scoreStrategies.get(i).getAddedScore(player);
		}
		return score;
	}
}
