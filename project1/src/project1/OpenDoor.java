package project1;

public class OpenDoor implements Door {

	@Override
	public void Action(DoorContext Door) {
		System.out.println("Opening Door of ");
		
	}

	public String toString(){ 
	      return "Opening door State"; 
	   } 
}
