package project1;

public class OpenDoor implements Door {

	@Override
	public void Action(DoorContext Door, String doorType) {
		System.out.println("Opening Door of "+ doorType);
		
	} 

	public String toString(){ 
	      return "Opening door State"; 
	   }


}
