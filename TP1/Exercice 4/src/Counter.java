public class Counter {

	public static void calculate(String ch) {


		// table to store the number of occurrences of the 26 letters of the alphabet
        int[] nb_occurrences = new int[26];
        ch = ch.toUpperCase();

		// count the number of each char
        for (int i = 0; i < ch.length(); i++) {
            char c = ch.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                nb_occurrences[c - 'A']++;
            }
        }
		
		// show letters that appear at least once
        System.out.println("La chaîne \"" + ch + "\" contient :");
        for (int i = 0; i < nb_occurrences.length; i++) {
            if (nb_occurrences[i] > 0) {
                // Convert the index to lettre
                char lettre = (char) (i + 'A');
                System.out.println(nb_occurrences[i] + " fois la lettre '" + lettre + "'");
            }
        }
	
	
	}
}