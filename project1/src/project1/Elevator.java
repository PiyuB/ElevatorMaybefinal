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

	public int Goup(){
		return currentFloor++;

	}

	public int Godown(){
		return currentFloor--;

	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public void OpenDoor(){
		od.Action(ElevatorDoor);
	}

	public void CloseDoor(){
		cd.Action(ElevatorDoor);
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
				currentFloor=ele.Goup();
				ele.setCurrentFloor(currentFloor);
			}
			if(floor<currentFloor){
				currentFloor=ele.Godown();
				ele.setCurrentFloor(currentFloor);
			}
		}while(currentFloor!=floor);
		if(currentFloor==floor){
			ele.OpenDoor();
			Floors.get(currentFloor).OpenDoor();
			Floors.get(currentFloor).CloseDoor();
			ele.CloseDoor();
			destination=getUserDestination(Floors);
			do{
				currentFloor=ele.getCurrentFloor();
				if(destination>currentFloor){
					currentFloor=ele.Goup();
					ele.setCurrentFloor(currentFloor);
				}
				if(destination<currentFloor){
					currentFloor=ele.Godown();
					ele.setCurrentFloor(currentFloor);
				}
			}while(currentFloor!=floor);
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
		boolean status = false;
		for(int flr=0 ; flr < Floors.size(); flr++){

			if(Floors.get(flr).getFloorValue() == floornum)
				status= true;
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
