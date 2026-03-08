package sn.tbalde221.cardgame.games;

import sn.tbalde221.cardgame.controller.GameController;
import sn.tbalde221.cardgame.controller.HighCardGameEvaluator;
import sn.tbalde221.cardgame.controller.LowCardGameEvaluator;
import sn.tbalde221.cardgame.model.Deck;
import sn.tbalde221.cardgame.view.View;

public class Games {

	public static void main(String[] args) {
		//GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
		GameController gc = new GameController(new Deck(), new View(), new LowCardGameEvaluator());
		gc.run();

	}

}
