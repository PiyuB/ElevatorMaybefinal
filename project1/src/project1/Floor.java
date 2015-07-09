package project1;

public class Floor {
	
		FloorButton fb;
		DoorContext FloorDoor;
		OpenDoor od;
		CloseDoor cd;
		
		private int FloorValue;
		
		public Floor(){
			fb=new FloorButton();
			FloorDoor=new DoorContext();
			od=new OpenDoor();
			cd=new CloseDoor();
			FloorValue=0;
		}
		
		public int getFloorValue() {
			return FloorValue;
		}
		
		public void setFloorValue(int floorValue) {
			FloorValue = floorValue;
		}
		
		public void OpenDoor(){
			od.Action(FloorDoor);
		}

		public void CloseDoor(){
			cd.Action(FloorDoor);
		}
}
