package scoring;

import java.util.List;

import ch.aplu.jcardgame.Card;
import pasur.Player;
import pasur.Rank;
import pasur.Suit;

public class ForEachScoreStrategy implements IScoreStrategy {
	private Suit suit;
	private Rank rank;
	private int addedScore;

	public ForEachScoreStrategy(Suit suit, Rank rank, int addedScore) {
//		if (suit == null && rank == null) {
//			throw new Exception("Initialised with a null Suit and null Rank.");
//		}
		this.suit = suit;
		this.rank = rank;
		this.addedScore = addedScore;
	}
	
	public int getAddedScore(Player player) {
		List<Card> pickedCardsList = player.getPickedCards().getCardList();
		List<Card> sursList = player.getSurs().getCardList();
		
		int count = 0;
    	for (int i=0; i<pickedCardsList.size(); i++) {
    		Card pickedCard = pickedCardsList.get(i);
    		if (ScoreStrategyFactory.cardMatches(pickedCard, suit, rank)) {
    			count++;
    		}
    	}
    	for (int i=0; i<sursList.size(); i++) {
    		Card surCard = sursList.get(i);
    		if (ScoreStrategyFactory.cardMatches(surCard, suit, rank)) {
    			count++;
    		}
    	}
    	return count*addedScore;
	}

}
