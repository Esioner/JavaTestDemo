package CommonUseClass;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] temp = {1,4,5,7,8,9,3,2,6};
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		Arrays.fill(temp, 233);
		System.out.println(Arrays.toString(temp));
	}
	
}

