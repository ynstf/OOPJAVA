import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		float[] notes = new float[5];

		for (int i=0; i<5;i++) {
			System.out.print("Note (" + i + ") :");
			float t = scanner.nextFloat();
			
			notes[i] = t;

		}
		Arrays.show(notes);


	}

}