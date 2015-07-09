package project1;

public class CloseDoor implements Door {

	@Override
	public void Action(DoorContext Door,String doorType) {
		System.out.println("Closing door of "+doorType);
	}

	public String toString(){ 
	      return "closing door State"; 
	   } 
}
