package scoring;

import java.util.List;

import ch.aplu.jcardgame.Card;
import pasur.Player;
import pasur.Rank;
import pasur.Suit;

public class MinimumScoreStrategy implements IScoreStrategy {
	private Suit suit;
	private Rank rank;
	private int addedScore;
	private int minimum;
	
	public MinimumScoreStrategy(Suit suit, Rank rank, int addedScore, int minimum) {
//		if (suit == null && rank == null) {
//			throw new Exception("Initialised with a null Suit and null Rank.");
//		}
		this.suit = suit;
		this.rank = rank;
		this.addedScore = addedScore;
		this.minimum = minimum;
	}
	
	public int getAddedScore(Player player) {
		List<Card> pickedCardsList = player.getPickedCards().getCardList();
		List<Card> sursList = player.getSurs().getCardList();
		
		int count = 0;
    	for (int i=0; i<pickedCardsList.size(); i++) {
    		Card pickedCard = pickedCardsList.get(i);
    		if (cardMatches(pickedCard, suit, rank)) {
    			count++;
    		}
    	}
    	for (int i=0; i<sursList.size(); i++) {
    		Card surCard = sursList.get(i);
    		if (cardMatches(surCard, suit, rank)) {
    			count++;
    		}
    	}
    	if (count >= minimum) {
    		return addedScore;
    	}
    	return 0;
	}

}
