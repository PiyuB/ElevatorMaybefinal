package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Elevator {
	ArrayList<PanelButton> pb;
	DoorContext ElevatorDoor;
	OpenDoor od;
	CloseDoor cd;
	Scanner sc;
	int currentFloor;
	private static Elevator ele=null;

	public Elevator(){ 
		pb=new ArrayList<PanelButton>();
		ElevatorDoor=new DoorContext();
		od=new OpenDoor();
		cd=new CloseDoor(); 
		currentFloor=0;
		
		for(int i=0;i<=6;i++){
			pb.add(new PanelButton(i));
			pb.get(i).id=i;
		}
	}

	public Elevator creator(){
		if(ele==null){
			return new Elevator();
		}
		else
			return ele;
	}

	public void Goup(int destination){
		currentFloor=destination;

	}

	public void Godown(int destination){
		currentFloor=destination;

	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public void OpenDoor(String type){
		od.Action(ElevatorDoor,type);
	}

	public void CloseDoor(String type){
		cd.Action(ElevatorDoor,type);
	}

	public void Click(int index){
		 pb.get(index).getId();
	}
	
	public void ElevatorService(Elevator ele,ArrayList<Floor> Floors){
		int floor,currentFloor,destination;

		floor=ele.getUsersFloor(Floors);
		do{
			currentFloor=ele.getCurrentFloor();
			if(floor>currentFloor){
				ele.Goup(floor);
				currentFloor++;
				ele.setCurrentFloor(currentFloor);
				System.out.println("elevator on Floor no "+currentFloor);
			}
			if(floor<currentFloor){
				ele.Godown(floor);
				currentFloor--;
				ele.setCurrentFloor(currentFloor);
				System.out.println("elevator on Floor no "+currentFloor);
			}
		}while(currentFloor!=floor);
		if(currentFloor==floor){
			ele.OpenDoor("Elevator");
			Floors.get(currentFloor).OpenDoor("Floor");
			Floors.get(currentFloor).CloseDoor("Floor");
			ele.CloseDoor("Elevator");
			destination=getUserDestination(Floors);
			do{
				currentFloor=ele.getCurrentFloor();
				if(destination>currentFloor){
					ele.Goup(destination);
					currentFloor++;
					ele.setCurrentFloor(currentFloor);
					System.out.println("elevator on Floor no "+currentFloor);
				}
				if(destination<currentFloor){
					ele.Godown(destination);
					currentFloor--;
					ele.setCurrentFloor(currentFloor);
					System.out.println("elevator on Floor no "+currentFloor);
				}
			}while(currentFloor!=destination);
			
			if(currentFloor==floor){
				ele.OpenDoor("Elevator");
				Floors.get(currentFloor).OpenDoor("Floor");
				Floors.get(currentFloor).CloseDoor("Floor");
				ele.CloseDoor("Elevator");
			}
		}

	}



	public int getUsersFloor(ArrayList<Floor> Floors){
		int myFloor;
		boolean status;
		sc=new Scanner(System.in);
		do{
			System.out.println("Welcome:\n Enter the floor you are on");
			myFloor=sc.nextInt();
			status=checkfloor(myFloor,Floors);
		}while(status!=true);
		return myFloor;

	}

	public boolean checkfloor(int floornum,ArrayList<Floor> Floors){
		boolean status=false;
		for(int flr=0 ; flr < Floors.size(); flr++){

			if(Floors.get(flr).getFloorValue() == floornum)
				status=true;
		}
		return status;
	}

	public int getUserDestination(ArrayList<Floor> Floors){
		int destination;
		boolean status;
		do{
			System.out.println("Enter which floor you want to go to");
			destination=sc.nextInt();
			status=checkfloor(destination, Floors);
		}while(status!=true);
		return destination;
	}

}
