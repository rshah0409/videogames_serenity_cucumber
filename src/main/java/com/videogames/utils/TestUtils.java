package com.videogames.utils;

import java.util.Random;

public class TestUtils {

	public static String getRandomValue(){
		Random random = new Random();
		int randomInt = random.nextInt(100000);
		return Integer.toString(randomInt);


	}
	public static int getRandomValueInt() {
		Random random = new Random();
		int randomInt = random.nextInt(10000);
		return randomInt;
	}
}
