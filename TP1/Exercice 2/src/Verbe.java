public class Verbe {

	public static boolean deleteEr(String verbe) {
        // convert all verbes to lower case
        verbe = verbe.toLowerCase();
        // check if Regular verbe
        if (verbe.equals("aller")){
            System.out.println("this is a irregular.");
        }
        else {
            // chack if the verb end by er
            if (!(verbe.substring(verbe.length()-2, verbe.length())).equals("er")){
                System.out.println("not end by 'er'");
            }
            // delete the er
            else{
                System.out.println(verbe.substring(0, verbe.length()-2));
                return true;
            }
        }
        return false;
	}

}