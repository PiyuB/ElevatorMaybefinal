package project1;

public class CloseDoor implements Door {

	@Override
	public void Action(DoorContext Door) {
		System.out.println("Closing door of ");
	}

	public String toString(){ 
	      return "closing door State"; 
	   } 
}
