public class Sommeur implements Runnable {
    private int debut;
    private int fin;
    private long resultat;

    public Sommeur(int debut, int fin) {
        this.debut = debut;
        this.fin = fin;
        this.resultat = 0;
    }

    @Override
    public void run() {
        for (int i = debut; i <= fin; i++) {
            resultat += i;
        }
    }

    public long getSomme() {
        return resultat;
    }
}
