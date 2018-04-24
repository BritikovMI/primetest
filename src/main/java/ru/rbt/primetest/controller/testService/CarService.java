/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.rbt.primetest.controller.testService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static ru.rbt.primetest.model.jdbc.Main.getDBInf;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {
	static String[][] context;

	public static String getYyyr() {
		return yyyr;
	}

	public static void setYyyr(String yyyr) {
		CarService.yyyr = yyyr;
	}

	private static String yyyr = "12";

	private final static String[] colors;
	
	private final static String[] brands;
    
    static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";
		
		brands = new String[10];
		brands[0] = "BMW";
		brands[1] = "Mercedes";
		brands[2] = "Volvo";
		brands[3] = "Audi";
		brands[4] = "Renault";
		brands[5] = "Fiat";
		brands[6] = "Volkswagen";
		brands[7] = "Honda";
		brands[8] = "Jaguar";
		brands[9] = "Ford";
	}
    
    public List<Car> createCars(int size) {
        List<Car> list = new ArrayList<Car>();
		for(int i = 0 ; i < size ; i++) {
			list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear()));
        }
        return list;
    }
    
    private String getRandomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}
    
    private int getRandomYear() {
		return (int) (Math.random() * 50 + 1960);
	}
	
	private String getRandomBrand() {
		return brands[(int) (Math.random() * 10)];
	}

	public static void updTab(){
		colors[0] = context[1][0];
		colors[1] = context[1][1];
		colors[2] = context[1][2];
		colors[3] = context[1][3];
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";
	}

}
