package scoring;

import ch.aplu.jcardgame.Card;
import pasur.Player;
import pasur.Rank;
import pasur.Suit;

public interface IScoreStrategy {
	public int getAddedScore(Player player);
	// Helper function: given a card, check if it matches the given suit and/or rank
	default boolean cardMatches(Card card, Suit suit, Rank rank) {
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
