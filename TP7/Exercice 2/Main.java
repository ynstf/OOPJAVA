public class Main {
    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int nombreThreads = 2;

        Thread[] threads = new Thread[nombreThreads];
        Sommeur[] sommeurs = new Sommeur[nombreThreads];

        int taillePartie = tableau.length / nombreThreads;

        for (int i = 0; i < nombreThreads; i++) {
            int debut = i * taillePartie + 1;
            
            int fin;
            if (i == nombreThreads - 1) {
                fin = tableau.length;
            } else {
                fin = (i + 1) * taillePartie;
            }
        
            sommeurs[i] = new Sommeur(debut, fin);
            threads[i] = new Thread(sommeurs[i]);
            threads[i].start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long sommeTotal = 0;
        for (Sommeur s : sommeurs) {
            sommeTotal += s.getSomme();
        }

        System.out.println("La somme totale est : " + sommeTotal);
    }
}