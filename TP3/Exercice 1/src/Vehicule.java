class Vehicule{

    public Vehicule(){
    }

    public void testVitesse(int v) throws TropViteException{
        if (v > 90) {throw new TropViteException(v);}
    }
}