package pasur;

import ScoringStrategy.CompositeScoringStrategy;
import ScoringStrategy.IScoringStrategy;
import ScoringStrategy.ScoringStrategyFactory;

public class ScoringConfiguration {
	public static void setDefaultScoringStrategy() {
		// set default scoring strategy for the game
        ScoringStrategyFactory instance = ScoringStrategyFactory.getInstance();
        IScoringStrategy defaultRule = instance.getCompositeScoringStrategy();
        
        ((CompositeScoringStrategy) defaultRule).addStrategy(instance.getAceScoringStrategy());
		((CompositeScoringStrategy) defaultRule).addStrategy(instance.getJackScoringStrategy());
		
		((CompositeScoringStrategy) defaultRule).addStrategy(instance.getTenOfDiamondsScoringStrategy());
		((CompositeScoringStrategy) defaultRule).addStrategy(instance.getTwoOfClubsScoringStrategy());
		
		((CompositeScoringStrategy) defaultRule).addStrategy(instance.getSevenClubsScoringStrategy());
		
		((CompositeScoringStrategy) defaultRule).addStrategy(instance.getSursScoringStrategy());
		
		instance.setDefaultStrategy(defaultRule);
	}
}
