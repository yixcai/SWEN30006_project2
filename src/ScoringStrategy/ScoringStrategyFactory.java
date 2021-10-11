package ScoringStrategy;

public class ScoringStrategyFactory {
	private static ScoringStrategyFactory instance;
	private static IScoringStrategy defaultStrat;
	
	
	private ScoringStrategyFactory() {}
	
	public static ScoringStrategyFactory getInstance() {
		if(instance==null) {
			instance = new ScoringStrategyFactory();
		}
		return instance;
	}
	
	public static IScoringStrategy getDefaultScoringStrategy() throws Exception {
		if(defaultStrat==null) {
			throw new Exception("Default scoring strategy not found!");
		} else {
			return defaultStrat;
		}
	}
	
	public static void setDefaultStrategy(IScoringStrategy strat) {
		defaultStrat = strat;
	}
	
	// Individual Rules
	
	public IScoringStrategy getAceScoringStrategy() {
		return new AceScoringStrategy();
	}
	
	public IScoringStrategy getJackScoringStrategy() {
		return new JackScoringStrategy();
	}
	
	public IScoringStrategy getTenOfDiamondsScoringStrategy() {
		return new TenOfDiamondsScoringStrategy();
	}
	
	public IScoringStrategy getTwoOfClubsScoringStrategy() {
		return new TwoOfClubsScoringStrategy();
	}
	
	public IScoringStrategy getSevenClubsScoringStrategy() {
		return new SevenClubsScoringStrategy();
	}
	
	public IScoringStrategy getSursScoringStrategy() {
		return new SursScoringStrategy();
	}
	
	// Composite Rules
	
	public IScoringStrategy getCompositeScoringStrategy() {
		return new CompositeScoringStrategy();
	}
	
	
	/**
	 * Scoring ruleset of all cards, excluding Surs, 
	 * since the sur and pickedCard hands are separate
	 * @return defaultRule set of rules as defined in spec.
	 */
//	public IScoringStrategy getDefaultCardScoringStrategy() {
//		CompositeScoringStrategy defaultRule = new CompositeScoringStrategy();
//		
//		defaultRule.addStrategy(new AceScoringStrategy());
//		defaultRule.addStrategy(new JackScoringStrategy());
//		
//		defaultRule.addStrategy(new TenOfDiamondsScoringStrategy());
//		defaultRule.addStrategy(new TwoOfClubsScoringStrategy());
//		
//		defaultRule.addStrategy(new SevenClubsScoringStrategy());
//		
//		return defaultRule;
//	}
}
