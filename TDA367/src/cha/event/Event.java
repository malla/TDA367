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
	OldPosition,
	NewPosition,
	
	// TODO: CreateBoard should be called one time (when the object is created) otherway, 
//	it's called NewGame, so should it be possible to publish a CreateBoard? 
//	All components listening to CreateBoard, shouldn't they be listening to NewGame instead? 
	CreateBoard,
	
	NewGame,
	GameOver,
	ShowGameRules,
	ShowStartPanel,
	NextCard
}
