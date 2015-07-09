package project1;

public class FloorButton implements Button{

	boolean status;

	public void goUp(Elevator Ele,int num){
		Ele.Goup(num);
	}

	public void goDown(Elevator Ele,int num) {
		Ele.Godown(num);
	}
}
