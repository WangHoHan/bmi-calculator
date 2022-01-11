package com.epam.bootcamp.bmi_calculator;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

import com.epam.bootcamp.bmi_calculator.interfacesImplements.MetricBMI;

public class BMITest {

	App app;
	
	/*@Test
	public void GuessTheUnitsTest1() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits(1.7,50.0);
		assertEquals(gtu.getUnitType(),"metric");
	}
	
	@Test
	public void GuessTheUnitsTest2() throws Exception{
		
	}*/

	@Before
	public void setup(){
		app = new App();
	}

	@Test
	public void BMITest1() throws Exception{
		app.setHeight(1.7);
		app.setWeight(50);
		assertEquals(app.calculateBMI(),17.3,1);
		assertEquals(app.bmiResult(),"Thinness");
	}

	@Test
	public void BMITest2() throws Exception{
		try{
			app.setHeight(0);
			app.setWeight(50.0);
			app.calculateBMI();
		}catch(Exception e){
			assertEquals(e.getMessage(),"Height is equals or less than zero.");
		}
	}

	@Test
	public void BMITest3() throws Exception{
		try{
			app.setHeight(1);
			app.setWeight(-3);
			app.calculateBMI();
		}catch(Exception e){
			assertEquals(e.getMessage(),"Weight is equals or less than zero.");
		}
	}

	@Test
	public void BMITest4() throws Exception{
		try{
			app.setHeight(170);
			app.setWeight(1764);
			app.calculateBMI();
		}catch(Exception e){
			assertEquals(e.getMessage(),"Height and weight is in different metric.");
		}
	}

	@Test
	public void BMITest5() throws Exception{
		app.setHeight(170);
		app.setWeight(50.0);
		assertEquals(app.calculateBMI(),17.3,1);
		assertEquals(app.bmiResult(),"Thinness");
	}

	@Test
	public void BMITest6() throws Exception{
		app.setHeight(5.58);
		app.setWeight(1764);
		assertEquals(app.calculateBMI(),17.3,1);
		assertEquals(app.bmiResult(),"Thinness");
	}

	@Test
	public void BMITest7() throws Exception{
		app.setHeight(86.7);
		app.setWeight(6349.3);
		assertEquals(app.calculateBMI(),37.19,0.5);
		assertEquals(app.bmiResult(),"Heavily overweight");
	}

	@Test
	public void BMITest8() throws Exception{
		app.setHeight(6.56);
		app.setWeight(220.47);
		assertEquals(app.calculateBMI(),25,0.5);
		assertEquals(app.bmiResult(),"Overweight");
	}

	@Test
	public void BMITest9() throws Exception{
		app.setHeight(200);
		app.setWeight(80);
		assertEquals(app.calculateBMI(),20,0.0);
		assertEquals(app.bmiResult(),"Normal");
	}

	@Test
	public void BMITest10() throws Exception {
		try{
			app.setHeight(0);
			app.setWeight(0);
			app.calculateBMI();
		}catch(Exception e){
			assertEquals(e.getMessage(),"Weight is equals or less than zero.");
		}
	}

	@Test
	public void BMITest11() throws Exception{
		app.setHeight(200);
		app.setWeight(74);
		assertEquals(app.calculateBMI(),18.5,0.0);
		assertEquals(app.bmiResult(),"Normal");
	}

	@Test
	public void BMITest12() throws Exception{
		app.setHeight(200);
		app.setWeight(99.6);
		assertEquals(app.calculateBMI(),24.9,0.0);
		assertEquals(app.bmiResult(),"Normal");
	}

	@Test
	public void BMITest13() throws Exception{
		app.setHeight(200);
		app.setWeight(119.6);
		assertEquals(app.calculateBMI(),29.9,0.0);
		assertEquals(app.bmiResult(),"Overweight");
	}

}