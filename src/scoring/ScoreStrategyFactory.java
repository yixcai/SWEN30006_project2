package scoring;

import java.util.ArrayList;

import ch.aplu.jcardgame.Card;
import pasur.Player;
import pasur.Rank;
import pasur.Suit;

public class ScoreStrategyFactory {
	private static ScoreStrategyFactory instance; // Since this is a singleton, we store its instance
	
	private ScoreStrategyFactory() { }
	
	// Since this is a singleton, we define a "getInstance" method
	public static ScoreStrategyFactory getInstance() {
		if(instance==null) {
			instance = new ScoreStrategyFactory();
		}
		return instance;
	}
	
	// Sets up the scoring system, by adding the rule-set/s (i.e. composite strategy/s)
	// We could extend this, adding more rule-sets for the future if necessary.
	public IScoreStrategy getCompositeScoreStrategy() {
		// For now, we only create one rule-set, i.e. compStrat
		CompositeScoreStrategy compStrat = new CompositeScoreStrategy();
    	
		// Add all the leaf strategies to our compStrat
		
		// ------------------------- MINIMUM STRATEGIES -------------------------
    	// Player who has 7 or more clubs: 7 points (there are only
    	// 13 clubs so they must have the most if they have 7 or more)
    	compStrat.addScoreStrategy(new MinimumScoreStrategy(Suit.CLUBS, null, 7, 7));
    	// ----------------------------------------------------------------------
    	
    	// ------------------------- FOR EACH STRATEGIES -------------------------
    	// Player who has the 10 of diamonds: 3 points
    	compStrat.addScoreStrategy(new ForEachScoreStrategy(Suit.DIAMONDS, Rank.TEN, 3));
    	
    	// Player who has the 2 of clubs: 2 points
    	compStrat.addScoreStrategy(new ForEachScoreStrategy(Suit.CLUBS, Rank.TWO, 2));
    	
    	// Each Ace: 1 point
    	compStrat.addScoreStrategy(new ForEachScoreStrategy(null, Rank.ACE, 1));
    	
    	// Each Jack: 1 point
    	compStrat.addScoreStrategy(new ForEachScoreStrategy(null, Rank.JACK, 1));
    	// -----------------------------------------------------------------------
    	
    	// ------------------------- SUR STRATEGIES -------------------------
    	// Each Sur: 5 points
    	compStrat.addScoreStrategy(new SurScoreStrategy(5));
    	// ------------------------------------------------------------------
    	
    	return compStrat;
	}
}