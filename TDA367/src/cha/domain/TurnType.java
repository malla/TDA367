package cha.domain;


public abstract class TurnType {
	
	protected Mission mission;

	public abstract void startMission(Category category);
	public abstract void missionDone();
	public Mission getMission(){
		return mission;
	}
	public abstract void setScore(int i);
	
}
