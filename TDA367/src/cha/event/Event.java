package cha.event;

public enum Event {
	MakeBet,		//Done. Is done when player presses a tile t make a bet.
	ShowBet, 		//Done. Malla.
	StartMission, 	//B�R FIXAS!
	TimeTick,		//Ok.
	TimeOver,		//Ok.
	MissionOver, 	//Done Malla.
	NextPlayer, 	//Done. Malla.
	OldPosition,	//DONE. Only removes piece when moved. Called from 2 methods in Piece.
	NewPosition,	//DONE. Only adds piece when moved. And repaints. Called from 2 methods in Piece.
	CreateBoard,	//Ok.
	GameOver,		//Ok.
	ShowStartPanel,	//B�R FIXAS!
	NextCard, 		//B�R FIXAS!
	Challenge 		//�r ingenting.
}
