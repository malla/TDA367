package cha.event;

public enum Event {
	MakeBet,	//Is done when player presses a tile t make a bet.
	ShowBet,
	StartMission, //Done Johan
	TimeTick,
	MissionDone,
	TimeOver,
	MissionSuccess, //Done Johan
	MissionFail, //Done Johan
	NextPlayer,// Is called when mission(Y/N button) or challenge is over. Only repaints the GUI.
	OldPosition,//DONE. Only removes piece when moved. Called from 2 methods in Piece.
	NewPosition,//DONE. Only adds piece when moved. And repaints. Called from 2 methods in Piece.
	CreateBoard,
	NewGame,
	GameOver,
	ShowGameRules,
	ShowStartPanel,
	NextCard, 
	ContinueGame, 
	Challenge
}
