package sn.tbalde221.cardgame.view;

import sn.tbalde221.cardgame.controller.GameController;

public interface GameViewable {
	public void setController(GameController gc);
	public void promptForPlayerName();
	public void promptForFlip();
	public void promptForNewGame();
	public void showWinner(String name);
	public void showPlayerName(int playerIndex, String playerName);
	public void showFaceDownCardForPlayer(int playerIndex, String name);
	public void showCardForPlayer(int i, String name, String rank, String suit);
}
