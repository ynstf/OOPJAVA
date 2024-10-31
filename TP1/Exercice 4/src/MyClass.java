import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		String ch;
		
		do {
        System.out.print("Entrez une ligne de texte (max. 100 caractères) :");
        ch = scanner.nextLine();
		} while (ch.length()>100);

		if(ch.length()<=100){
			Counter.calculate(ch);
		}

	}

}