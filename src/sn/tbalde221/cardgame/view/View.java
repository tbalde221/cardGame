package sn.tbalde221.cardgame.view;

import java.util.Scanner;

import sn.tbalde221.cardgame.controller.GameController;

public class View {
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	public void setController(GameController gc) {
		this.controller = gc;
	};
	public void promptForPlayerName() {
		System.out.println("Enter player name:");
		String name = keyboard.nextLine();
		if (name.isEmpty()) {
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}
	}
	public void promptForFlip() {
		System.out.println("Press enter to reveal cards");
		keyboard.nextLine();
		controller.flipCards();
	}
	public void promptForNewGame() {
		System.out.println("Press enter to deal again");
		keyboard.nextLine();
		controller.startGame();
	}
	public void showWinner(String name) {
		System.out.println("Winner is "+name+" !");
	}
	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("["+playerIndex+"]["+playerName+"]");
	}
	public void showFaceDownCardForPlayer(int playerIndex, String name) {
		System.out.println("["+playerIndex+"]["+name+"][x][x]");
	}
	public void showCardForPlayer(int i, String name, String rank, String suit) {
		System.out.println("["+i+"]["+name+"]["+rank+"]["+suit+"]");
	};
}
