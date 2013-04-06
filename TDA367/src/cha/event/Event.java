package cha.event;

public enum Event {
//	MakeBet,		//F�RS�K F� BORT DEN H�R
	StartMission, 	//Done. Malla
	TimeTick,		//Checked, Malla.	(Is published when clock ticks in Mission)
	TimeOver,		//M�STE FIXAS SNYGGARE
	NextPlayer, 	//Done. Malla.
	OldPosition,	//Checked, Malla.	(Is published when piece is moved)
	NewPosition,	//Checked, Malla.	(Is published when piece is moved)
	CreateBoard,	//Ok.
	GameOver,		//Ok.
	IsChallenge, 	//Used when it is a challenge to show the correct buttons. Johan
	ChaMissionOver,
	ChaOver,
	
	MakeABet,		//Checked, Malla 	(Is published when a new turn is initialized and it is a NormalTurn.)
	UpdateBet, 		//Checked, Malla. 	(Is published at NormalTurn when player clicks a tile(updating his/her bet.)
	GetChallengeScore,
	MissionOver
}
