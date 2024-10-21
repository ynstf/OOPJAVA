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
		System.out.println();

		System.out.println("showing degrees : ");
		Arrays.show(notes);
		System.out.println();

		System.out.println("sorting ... ");
		Arrays.sort(notes);
		System.out.println();

		System.out.println("showing sorted degrees : ");
		Arrays.show(notes);
		System.out.println();

		System.out.println("average of degrees : ");
		System.out.println(Arrays.average(notes));
		System.out.println();

		System.out.println("Min & Max of degrees : ");
		Arrays.minmax(notes);
		System.out.println();

		System.out.print("number of students With Degree (10) : ");
		System.out.print(Arrays.studentWithDegree(notes,10));
		System.out.println();

	}

}