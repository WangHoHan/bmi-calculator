package com.epam.bootcamp.bmi_calculator;

import com.epam.bootcamp.bmi_calculator.interfacesImplements.*;

public class App extends Exception
{

	private double weight;
	private double height;
	private double bmi;
	
	/**
	 * A ZeroChecker megnézi, hogy nulla vagy kevesebb-e a súly vagy a magasság.
	 * Ha valamelyik nulla vagy kevesebb, akkor hibát dob.
	 */
	private void ZeroChecker() throws Exception{
		if(this.weight <= 0){
			throw new Exception("Weight is equals or less than zero.");
		}
		if(this.height <= 0){
			throw new Exception("Height is equals or less than zero.");
		}	
	}
	
	/**
	 * Ez adja értéknek a BMI-t a bmi változónak.
	 * Először megnézi a ZeroCheckerrel a kapott értékeket.
	 * Meghívja a GuessTheUnits osztályt, ami kitalálja, hogy milyen mértékegységekkel számoljuk a BMI-t(US vagy metric).
	 * Attól függően, hogy mi a mértékegység, hívjuk meg a számolót.
	 * @return a bmi értékével tér vissza a metódus
	 * @throws Exception
	 */
	public double calculateBMI() throws Exception{ //végül kiszámoljuk a BMI-t
		ZeroChecker();
		GuessTheUnits gtu = new GuessTheUnits(this.height, this.weight);
		if(gtu.getUnitType().equals("US")){
			UsBMI ubmi = new UsBMI();
			ubmi.setBMI(gtu.getWeight(), gtu.getHeight());
			this.bmi = ubmi.getBMI();
		}else{
			MetricBMI mbmi = new MetricBMI();
			mbmi.setBMI(gtu.getWeight(), gtu.getHeight());
			this.bmi = mbmi.getBMI();
		}
		return this.bmi;
	}
	
	/**
	 * A bmi változó értékétől függően kapjuk meg az adott ember értékelését
	 * @return Egy string, ami tartalmazza az értékelést
	 */
	public String bmiResult(){
		if(this.bmi < 18.5){ // Sovány
			return "Thinness";
		}else if(this.bmi <= 24.9){ // Normál testalkatú
			return "Normal";
		}else if(this.bmi <= 29.9){ // Túlsúlyos
			return "Overweight";
		}else{ // Erősen túlsúlyos
			return "Heavily overweight";
		}
	}
	
	/**
	 * Súly beállítása
	 * @param weight a súly
	 */
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	/**
	 * Magasság beállítása
	 * @param height a magasság
	 */
	public void setHeight(double height){
		this.height = height;
	}
}
