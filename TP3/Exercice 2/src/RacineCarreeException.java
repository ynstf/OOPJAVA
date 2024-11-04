class RacineCarreeException extends Exception {

    public RacineCarreeException(int n) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + n);
    }
}