package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ElevatorTest {
    Elevator ele=new Elevator();
	ArrayList<Floor> Flrs=new ArrayList<Floor>();

	@Test
	public void testCheckfloor() {
		assertEquals(false,ele.checkfloor(3, Flrs));
	}

}
