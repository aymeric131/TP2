import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class EnsembleChaineTest {

    EnsembleChaine e1 = new EnsembleChaine();

    @Test
    // Vrai : element pas présent et ajouté  Faux : element déja present et non ajouté
    public void ajouterTest() {
        String str1 = "abc";
        assertTrue(e1.ajouter(str1) && e1.liste.size() == 1 && e1.liste.contains(str1));

        //2 cas " Ajout dans un ensemble non vide"
        String str2 = "123";
        assertTrue(e1.ajouter(str2) && e1.liste.size() == 2 && e1.liste.contains(str1) && e1.liste.contains(str2));

        //3 cas " Ajout d'un élément déja existant"
        String str3 = "abc";
        assertTrue(!e1.ajouter(str3) && e1.liste.size() == 2 && e1.liste.contains(str1) && e1.liste.contains(str2));

        //Cas 4 "Ajout d'une chaine vide"
        String str4 = "";
        assertTrue(e1.ajouter(str4) && e1.liste.size() == 3 && e1.liste.contains(str1) && e1.liste.contains(str2) && e1.liste.contains(str4));

        //Cas 5 "Ajout chaine existante et dans le désordre"
        String str5 = "cba";
        assertTrue(e1.ajouter(str5) && e1.liste.size() == 4 && e1.liste.contains(str1) && e1.liste.contains(str2) && e1.liste.contains(str4) && e1.liste.contains(str5));

        //Cas 6 "Ajout d'une chaine null"
        String str6 = null;
        assertTrue(e1.ajouter(str6) && e1.liste.size() == 5 && e1.liste.contains(str1) && e1.liste.contains(str2) && e1.liste.contains(str4) && e1.liste.contains(str5) && e1.liste.contains(str6));

        // Cas 7
        String str7 = null;
        assertTrue(!e1.ajouter(str7) && e1.liste.size() == 5 && e1.liste.contains(str1) && e1.liste.contains(str2) && e1.liste.contains(str4) && e1.liste.contains(str5) && e1.liste.contains(str6));

        //Cas 8
        String str8 = "cba";
        assertTrue(!e1.ajouter(str8) && e1.liste.size() == 5 && e1.liste.contains(str1) && e1.liste.contains(str2) && e1.liste.contains(str4) && e1.liste.contains(str5) && e1.liste.contains(str6));
    }

    @Test
    public void testEquals() {

    }

    @Test
    public void union() {
    }

    @Test
    public void intersection() {
    }

    @Test
    public void unionDisjointe() {
    }
}