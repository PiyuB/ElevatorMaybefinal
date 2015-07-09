package project1;

public class FloorButton implements Button{

	boolean status;

	public void goUp(Elevator Ele){
		Ele.Goup();
	}

	public void goDown(Elevator Ele) {
		Ele.Godown();
	}
}
