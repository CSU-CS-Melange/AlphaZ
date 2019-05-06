package edu.csu.melange.alphaz.mde.tests.regression;

public class RandomeInputGenerator {

	
	public static void main(String[] args) {
		int N = 5050;
		for (int i = 0; i < N; i++) {
//			System.out.println((Math.random()*(1)*0.000001+1));
			System.out.println(randInt(0, 100));
//			System.out.println(1);
		}
		
	}
	
	
	public static int randInt(int start, int end) {
		end = end + 1;
		return start + (int)Math.floor(Math.random()*(end - start));
	}
}
