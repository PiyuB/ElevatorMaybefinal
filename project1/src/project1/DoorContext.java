package project1;

public class DoorContext {

	private Door doorstate;
	
	public DoorContext(){
		this.doorstate=null;
	}
	
	public Door getDoorstate() {
		return doorstate;
	}
	public void setDoorstate(Door doorstate) {
		this.doorstate = doorstate;
	}
}
