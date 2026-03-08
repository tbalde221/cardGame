package sn.tbalde221.cardgame.controller;

import java.util.List;

import sn.tbalde221.cardgame.model.Player;
import sn.tbalde221.cardgame.model.PlayingCard;

public interface GameEvaluator {
	public Player evaluateWinner(List<Player> players);

}
