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
			       addFloor(i);
					Floors.get(i).setFloorValue(i);
				}
				
			}
		
			public boolean addFloor(int Floornum){
				if(Floors.add(new Floor())){
					flr.setFloorValue(Floornum);
					return true;
				}
				else
				return false;
				
			}
			
			public void ElevatorService(){
				String choice=null;
				do{
				ele.ElevatorService(ele, Floors);
				System.out.println("Do you want to use elevator any more? Y-yes N-No ");
				choice=sc.nextLine();
				}while(!choice.equals("Y"));
			
				
			}
			
			
}
