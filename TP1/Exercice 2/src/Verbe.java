public class Verbe {

    public static Result deleteEr(String verbe) {
        // Convert all verbes to lower case
        verbe = verbe.toLowerCase();
        
        // Check if it is an irregular verbe
        if (verbe.equals("aller")) {
            System.out.println("This is an irregular verb.");
        } else {
            // Check if the verb ends with 'er'
            if (!verbe.endsWith("er")) {
                System.out.println("Does not end with 'er'.");
            } else {
                // Remove 'er' from the verb
                String verbRoot = verbe.substring(0, verbe.length() - 2);
                return new Result(true, verbRoot);
            }
        }
        return new Result(false, "");
    }

    public static void generateConj(String verbRoot) {
        // dabject & endings for present
        String[] subjects = {"je", "tu", "il/elle", "nous", "vous", "ils/elles"};
        String[] endings = {"e", "es", "e", "ons", "ez", "ent"};
        
        // show the table
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + " " + verbRoot + endings[i]);
        }
    }
}
