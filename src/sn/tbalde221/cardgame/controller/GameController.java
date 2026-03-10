package sn.tbalde221.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import sn.tbalde221.cardgame.model.Deck;
import sn.tbalde221.cardgame.model.Player;
import sn.tbalde221.cardgame.model.PlayingCard;
import sn.tbalde221.cardgame.view.CommandLineView;
import sn.tbalde221.cardgame.view.GameViewable;


public class GameController {
	Deck deck;
	List<Player> players;
	Player winner;
	GameViewable view;
	GameState gameState;
	GameEvaluator evaluator;
	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
		this.deck = deck;
		this.view =view;
		this.players = new ArrayList<Player>();
		this.gameState = GameState.AddingPlayers;
		view.setController(this);
		this.evaluator = evaluator;
	}
	public void run() {
		while(gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}
	public void addPlayer(String namePlayer) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(namePlayer));
			view.showPlayerName(players.size(),namePlayer);
		}
	}
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for(Player player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++,player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run();
	}
	public void flipCards() {
		int playerIndex = 1;
		for(Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++,player.getName(),pc.getRank().toString(),pc.getSuit().toString());
		}
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}
	private void evaluateWinner() {
		
			winner = evaluator.evaluateWinner(players);
		
		
	}
	private void rebuildDeck() {
		for(Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
		
	}
	private void displayWinner() {
		view.showWinner(winner.getName());
		
	}
	void exitGame() {
		System.exit(0);
	}
	public void nextAction(String nextChoise) {
		if ("+q".equals(nextChoise)) {
			exitGame();
		} else {
			startGame();
		}
		
	}
}
