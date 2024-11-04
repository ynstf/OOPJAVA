class Calculateur{

    public Calculateur(){
    }

    public static void main(String[] args){

        Calculateur calc = new Calculateur();

        try {
            System.out.println("pour -5 : ");
            calc.testRacineCarree(-5);
            
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("pour 25: ");
            calc.testRacineCarree(25);
            System.out.println("Pas d'exception.");
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }
        
    }

    public void testRacineCarree(int n) throws RacineCarreeException{
        if (n < 0) {throw new RacineCarreeException(n);}
    }
}