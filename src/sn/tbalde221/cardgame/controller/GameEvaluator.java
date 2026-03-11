package sn.tbalde221.cardgame.controller;

import java.util.List;

import sn.tbalde221.cardgame.model.IPlayer;
import sn.tbalde221.cardgame.model.PlayingCard;

public interface GameEvaluator {
	public IPlayer evaluateWinner(List<IPlayer> players);

}
