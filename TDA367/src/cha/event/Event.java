package cha.event;

public enum Event {
	MakeBet,
	ShowBet,
	StartMission,
	TimeTick,
	MissionDone,
	TimeOver,
	MissionSuccess,
	MissionFail,
	NextPlayer,
	OldPosition,//Only removes piece when moved. Called from 2 methods in Piece.
	NewPosition,//Only adds piece when moved. And repaints. Called from 2 methods in Piece.
	CreateBoard,
	NewGame,
	GameOver,
	ShowGameRules,
	ShowStartPanel,
	NextCard, 
	ContinueGame, 
	Challenge
}
