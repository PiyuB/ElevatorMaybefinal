package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Building {
   
	Elevator ele;
	Floor flr;
	Scanner sc;
	ArrayList<Floor> Floors=new ArrayList<Floor>();
	
			public Building(){
				ele=new Elevator().creator();
				flr=new Floor();
				
				for(int i=0;i<6;i++){
					Floors.add(new Floor());
					Floors.get(i).setFloorValue(i);
				}
				
			}
		
			public boolean addFloor(int Floornum){
				if(this.addFloor(Floornum)){
					return true;
				}
				else
				return false;
				
			}
			
			public void ElevatorService(){
				String choice;
				do{
				ele.ElevatorService(ele, Floors);
				System.out.println("Do you want to use elevator any more? Y-yes N-No ");
				choice=sc.next();
				}while(!choice.equalsIgnoreCase("Y"));
			
				
			}
			
			
}
