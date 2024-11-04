class TropViteException extends Exception {

    public TropViteException(int v) {
        super("C'est une exception de type TropViteException. Vitesse en cause : " + v);
    }
}