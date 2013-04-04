package cha.domain;

import cha.domain.Categories.Category;

public abstract class TurnType {
	
	protected Mission mission;

	public abstract void startMission(Category category);
	public abstract void missionDone();
	public Mission getMission(){
		return mission;
	}

}
