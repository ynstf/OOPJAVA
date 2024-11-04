class Evaluateur{
    public Evaluateur(){}

    public void verifierNote(int n) throws NoteInvalideException{
        if (n < 0 || n>20) {throw new NoteInvalideException(n);}
    }

    public static void main(String[] args){

        Evaluateur eval = new Evaluateur();

        try {
            System.out.println("pour 21 : ");
            eval.verifierNote(21);
            
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("pour 17: ");
            eval.verifierNote(17);
            System.out.println("Pas d'exception.");
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }
        
    }
}