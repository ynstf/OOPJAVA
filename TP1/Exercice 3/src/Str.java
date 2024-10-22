import java.util.Scanner;

public class Str {

	String content;

	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter la valeur : ");
		String content = scanner.nextLine();
		this.content = content;
	}

	public void show() {
		System.out.println(this.content);
	}

	public void reverse() {
		String cont = this.content;
		String inver = "";
		for (int i = cont.length()-1; i >= 0 ; i--){
			System.out.print(cont.charAt(i));
		}
		System.out.println();
	}

	public void countWords() {
		String[] cont = this.content.split(" ");
		int count = 0;
		for (int i = 0 ; i < cont.length ; i++){
			count++;
		}
		System.out.println(count);
	}

}