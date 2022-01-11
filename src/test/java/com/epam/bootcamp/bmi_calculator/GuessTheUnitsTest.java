package com.epam.bootcamp.bmi_calculator;

import static org.junit.Assert.*;

import org.junit.*;

public class GuessTheUnitsTest {
	
	@Test
	public void GuessTheUnitsTest1() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(1.7,50.0);
		assertEquals(gtu.getUnitType(),"metric");
	}
	
	@Test
	public void GuessTheUnitsTest2() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(170,50.0);
		assertEquals(gtu.getUnitType(),"metric");
	}
	
	@Test
	public void GuessTheUnitsTest3() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(5.58,1764);
		assertEquals(gtu.getUnitType(),"US");
		assertEquals(gtu.getWeight(),110,1);
	}
	
	@Test
	public void GuessTheUnitsTest4() throws Exception{
		try{
			GuessTheUnits gtu = new GuessTheUnits(170,1764);
			assertEquals(gtu.getUnitType(),"US");
		}catch(Exception e){
			assertEquals(e.getMessage(),"Height and weight is in different metric.");
		}
	}

	@Test
	public void GuessTheUnitTest5() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(100,1000);
		assertEquals(gtu.getUnitType(),"metric");
		assertEquals(gtu.getWeight(),1000,1);
	}

	@Test
	public void GuessTheUnitTest6() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(10,1000);
		assertEquals(gtu.getUnitType(),"US");
		assertEquals(gtu.getWeight(),1000,1);
	}

	@Test
	public void GuessTheUnitTest7() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(3,100);
		assertEquals(gtu.getUnitType(),"metric");
		assertEquals(gtu.getWeight(),100,1);
	}

}