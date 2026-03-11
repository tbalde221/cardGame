package sn.tbalde221.cardgame.games;

import sn.tbalde221.cardgame.controller.GameController;
import sn.tbalde221.cardgame.controller.HighCardGameEvaluator;
import sn.tbalde221.cardgame.controller.LowCardGameEvaluator;
import sn.tbalde221.cardgame.model.Deck;
import sn.tbalde221.cardgame.model.DeckFactory;
import sn.tbalde221.cardgame.model.DeckFactory.DeckType;
import sn.tbalde221.cardgame.view.CommandLineView;
import sn.tbalde221.cardgame.view.GameSwingView;

public class Games {

	public static void main(String[] args) {
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		//GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), gsv, new LowCardGameEvaluator());
		gc.run();

	}

}
