package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ElevatorTest {
    Elevator ele=new Elevator();
	ArrayList<Floor> Floors=new ArrayList<Floor>();

	@Test
	public void testCheckfloor() {
		assertEquals(true,ele.checkfloor(0, Floors));
	}

}
