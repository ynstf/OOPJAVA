
# Travail Pratique (TP): Gestion des Exceptions Personnalisées en Java


## Exercice 1 : TropViteException

1. **Classe `TropViteException`** : Hérite de la classe `Exception`. Cette exception est déclenchée lorsque la vitesse d'un véhicule dépasse une limite définie.
   - Le constructeur prend un entier `vitesse` en paramètre et appelle le constructeur de `Exception` avec le message :
     `"C'est une exception de type TropViteException. Vitesse en cause : " + vitesse`.

   ```java
   public class TropViteException extends Exception {
       public TropViteException(int vitesse) {
           super("C'est une exception de type TropViteException. Vitesse en cause : " + vitesse);
       }
   }
   ```

2. **Classe `Vehicule`** :
   - Constructeur vide.
   - Méthode `testVitesse(int vitesse)` : Lance une `TropViteException` si la vitesse est supérieure à 90.

   ```java
   public class Vehicule {
       public Vehicule() { }

       public void testVitesse(int vitesse) throws TropViteException {
           if (vitesse > 90) {
               throw new TropViteException(vitesse);
           }
       }
   }
   ```

3. **Méthode `main` dans `Application`** :
   - Teste `testVitesse()` avec des valeurs inférieures et supérieures à 90 pour gérer et afficher la pile d'appel.

   ```java
   class Application {
       public static void main(String[] args) {
           Vehicule vehicule = new Vehicule();
           try {
               vehicule.testVitesse(80);
               System.out.println("Vitesse testée à 80 km/h : Pas d'exception.");
           } catch (TropViteException e) {
               e.printStackTrace();
           }

           try {
               vehicule.testVitesse(100);
           } catch (TropViteException e) {
               e.printStackTrace();
           }
       }
   }
   ```

---

## Exercice 2 : RacineCarreeException

1. **Classe `RacineCarreeException`** : Hérite de `Exception` pour indiquer qu'un nombre négatif ne peut pas être utilisé pour une racine carrée.
   - Le constructeur prend un entier `nombre` et appelle le constructeur de `Exception` avec le message :
     `"C'est une exception de type RacineCarreeException. Nombre négatif : " + nombre`.

   ```java
   public class RacineCarreeException extends Exception {
       public RacineCarreeException(int nombre) {
           super("C'est une exception de type RacineCarreeException. Nombre négatif : " + nombre);
       }
   }
   ```

2. **Classe `Calculateur`** :
   - Constructeur vide.
   - Méthode `testRacineCarree(int nombre)` : Lance une `RacineCarreeException` si le nombre est négatif.

   ```java
   public class Calculateur {
       public Calculateur() { }

       public void testRacineCarree(int nombre) throws RacineCarreeException {
           if (nombre < 0) {
               throw new RacineCarreeException(nombre);
           }
       }
   }
   ```

3. **Méthode `main` dans `Calculateur`** :
   - Appelle `testRacineCarree()` avec -5 et 25 et gère les exceptions en affichant la pile d'appel.

   ```java
   public class Calculateur {
       public static void main(String[] args) {
           Calculateur calculateur = new Calculateur();
           try {
               calculateur.testRacineCarree(-5);
           } catch (RacineCarreeException e) {
               e.printStackTrace();
           }

           try {
               calculateur.testRacineCarree(25);
               System.out.println("Calcul racine carrée pour 25 : Pas d'exception.");
           } catch (RacineCarreeException e) {
               e.printStackTrace();
           }
       }
   }
   ```

---

## Exercice 3 : NoteInvalideException

1. **Classe `NoteInvalideException`** : Hérite de `Exception` pour signaler une note invalide.
   - Le constructeur prend un entier `note` et appelle le constructeur de `Exception` avec le message :
     `"Exception de type NoteInvalideException. Note invalide : " + note`.

   ```java
   public class NoteInvalideException extends Exception {
       public NoteInvalideException(int note) {
           super("Exception de type NoteInvalideException. Note invalide : " + note);
       }
   }
   ```

2. **Classe `Evaluateur`** :
   - Constructeur vide.
   - Méthode `verifierNote(int note)` : Lance une `NoteInvalideException` si la note est inférieure à 0 ou supérieure à 20.

   ```java
   public class Evaluateur {
       public Evaluateur() { }

       public void verifierNote(int note) throws NoteInvalideException {
           if (note < 0 || note > 20) {
               throw new NoteInvalideException(note);
           }
       }
   }
   ```

3. **Méthode `main` dans `Evaluateur`** :
   - Appelle `verifierNote()` avec 15 puis 25, et gère les exceptions pour afficher le message et la pile d'appel.

   ```java
   public class Evaluateur {
       public static void main(String[] args) {
           Evaluateur evaluateur = new Evaluateur();
           try {
               evaluateur.verifierNote(15);
               System.out.println("Note 15 : valide.");
           } catch (NoteInvalideException e) {
               e.printStackTrace();
           }

           try {
               evaluateur.verifierNote(25);
           } catch (NoteInvalideException e) {
               e.printStackTrace();
           }
       }
   }
   ```

---

### Conclusion
Ces exercices démontrent comment créer et utiliser des exceptions personnalisées pour gérer des cas spécifiques en Java. Chacun des exercices montre l'importance des exceptions pour éviter des erreurs de programme et faciliter le débogage en affichant la pile d'appel.
