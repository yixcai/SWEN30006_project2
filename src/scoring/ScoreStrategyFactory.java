package scoring;

import java.util.ArrayList;

import ch.aplu.jcardgame.Card;
import pasur.Player;
import pasur.Rank;
import pasur.Suit;

public class ScoreStrategyFactory {
	private static ScoreStrategyFactory instance; // Since this is a singleton, we store its instance
	
	// We store a number of different "rule-sets", i.e. composite strategies, that this game could have
	// For instance, different Pasur games may have different rule-sets. What if we want to be able
	// to switch from rule-set to rule-set easily? (In this assignment, there is only one rule-set, but
	// we want to make ours more extendible)
	// Thus, store our rule-sets, and have a designated "default" one
	private static ArrayList<CompositeScoreStrategy> compStrats = new ArrayList<CompositeScoreStrategy>();
	private static CompositeScoreStrategy defaultCompStrat;
	
	private ScoreStrategyFactory() { }
	
	// Since this is a singleton, we define a "getInstance" method
	public static ScoreStrategyFactory getInstance() {
		if(instance==null) {
			instance = new ScoreStrategyFactory();
			init();
		}
		return instance;
	}
	
	// Sets up the scoring system, by adding the rule-set/s (i.e. composite strategy/s)
	// We could extend this, adding more rule-sets for the future if necessary.
	private static void init() {
		// For now, we only create one rule-set, i.e. compStrat
		CompositeScoreStrategy compStrat = new CompositeScoreStrategy();
    	
		// Add all the leaf strategies to our compStrat
    	// Player who has 7 or more clubs: 7 points (there are only
    	// 13 clubs so they must have the most if they have 7 or more)
    	MinimumScoreStrategy strat1 = new MinimumScoreStrategy(Suit.CLUBS, null, 7, 7);
    	compStrat.addScoreStrategy(strat1);
    	
    	// Player who has the 10 of diamonds: 3 points
    	ForEachScoreStrategy strat2 = new ForEachScoreStrategy(Suit.DIAMONDS, Rank.TEN, 3);
    	compStrat.addScoreStrategy(strat2);
    	
    	// Player who has the 2 of clubs: 2 points
    	ForEachScoreStrategy strat3 = new ForEachScoreStrategy(Suit.CLUBS, Rank.TWO, 2);
    	compStrat.addScoreStrategy(strat3);
    	
    	// Each Ace: 1 point
    	ForEachScoreStrategy strat4 = new ForEachScoreStrategy(null, Rank.ACE, 1);
    	compStrat.addScoreStrategy(strat4);
    	
    	// Each Jack: 1 point
    	ForEachScoreStrategy strat5 = new ForEachScoreStrategy(null, Rank.JACK, 1);
    	compStrat.addScoreStrategy(strat5);
    	
    	// Each Sur: 5 points
    	SurScoreStrategy strat6 = new SurScoreStrategy(5);
    	compStrat.addScoreStrategy(strat6);
    	
    	// Now that we have our desired rule-set, add it to the factory and make it the default
    	addCompStrat(compStrat, true);
	}
	
	// Add a new rule-set to the game, and optionally set it to the default
	public static void addCompStrat(CompositeScoreStrategy compStrat, boolean isDefault) {
		// Add it to the rule-sets
		compStrats.add(compStrat);
		
		if (isDefault) {
			// Set it to the default
			defaultCompStrat = compStrat;
		}
	}
	
	// Calculates the player's current score, using the default rule-set
	public static int calculateScore(Player player) {
		// Calculate the total (added to their existing total) using the default rule-set
    	return player.getTotalScore() + defaultCompStrat.getAddedScore(player);
	}
	
	// Helper function: given a card, check if it matches the given suit and/or rank
	public static boolean cardMatches(Card card, Suit suit, Rank rank) {
		boolean matches = false;
		
		// both suit and rank specified
		if (suit != null && rank != null) {
			if (card.getSuit().equals(suit) && card.getRank().equals(rank)) {
				matches = true;
    		}
		}
		// only suit specified
		if (suit != null && rank == null && card.getSuit().equals(suit)) {
			matches = true;
		}
		// only rank specified
		if (suit == null && rank != null && card.getRank().equals(rank)) {
			matches = true;
		}
		
		return matches;
	}
}