class NoteInvalideException extends Exception {

    public NoteInvalideException(int n) {
        super("Exception de type NoteInvalideException. Note invalide : " + n);
    }
}