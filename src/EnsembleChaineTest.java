import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class EnsembleChaineTest {


    @Test
    // Vrai : element pas présent et ajouté      Faux : element déja present et non ajouté
    public void ajouterTest() {
        EnsembleChaine e1 = new EnsembleChaine();
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

        //Cas 9 Ajout d'une chaine contenant une partie d'une autre chaine
        String str9 = "abcd";
        assertTrue(e1.ajouter(str9) && e1.liste.size() == 6 && e1.liste.contains(str1) && e1.liste.contains(str2) && e1.liste.contains(str4) && e1.liste.contains(str5) && e1.liste.contains(str6) && e1.liste.contains(str9));

    }

    @Test
    public void testEquals() {

        EnsembleChaine e1 = new EnsembleChaine();
        EnsembleChaine e2 = new EnsembleChaine();
        EnsembleChaine e2bis = new EnsembleChaine();
        EnsembleChaine e3 = new EnsembleChaine();
        EnsembleChaine e4 = new EnsembleChaine();
        EnsembleChaine e5 = new EnsembleChaine();
        EnsembleChaine e6 = new EnsembleChaine();

        // 1 cas : Les deux ensembles sont vides Renvoie Vrai
        assertTrue(e1.equals(e2));

        // 2 cas : e1 contient une chaine "ABC" et e2 est vide Renvoie Faux
        e1.ajouter("ABC");
        assertFalse(e1.equals(e2));

        // 3 cas : Les deux ensembles contiennent la chaine "ABC" Renvoie Vrai
        e2.ajouter("ABC");
        assertTrue(e2.equals(e1));

        //3 cas bis: Les deux ensembles contiennent ABC. 1 en majuscule et l'autre en minuscule Renvoie Faux
        e2bis.ajouter("abc");
        assertFalse(e1.equals(e2bis));

        // 4 cas : e3 contient une chaine et e4 contient la même chaine à l'envers, les deux ensembles ne sont pas égaux.
        e3.ajouter("123");
        e4.ajouter("321");
        assertFalse(e3.equals(e4));

        // 6 cas : Les deux ensembles contiennent les mêmes chaines dans un ordre différent. Renvoie Vrai
        e5.ajouter("abc");
        e5.ajouter("123");
        e6.ajouter("123");
        e6.ajouter("abc");
        assertTrue(e5.equals(e6));

        // 7 cas : Les ensembles e5 et e6 contiennent aussi une chaine null
        e5.ajouter(null);
        e6.ajouter(null);
        assertTrue(e5.equals(e6));

    }

    @Test
    public void union() {
        EnsembleChaine ensemble1 = new EnsembleChaine();
        EnsembleChaine ensemble2 = new EnsembleChaine();

        //Cas 1 les deux ensembles sont vides
        EnsembleChaine union = ensemble1.union(ensemble2);
        assertTrue(union.liste.size() == 0);

        //Cas 2 Un ensemble contient un chaine
        ensemble1.ajouter("abc");
        EnsembleChaine union2 = ensemble1.union(ensemble2);
        assertTrue(union2.liste.contains("abc") && union2.liste.size() == 1);

        //Cas 3 Les deux ensembles contiennent une chaine
        ensemble2.ajouter("123");
        EnsembleChaine union3 = ensemble1.union(ensemble2);
        assertTrue(union3.liste.contains("abc") && union3.liste.contains("123") && union3.liste.size() == 2);

        //Cas 4 L'ensemble 2 contient aussi abc donc l'union contiendra 1 seul fois abc.
        ensemble2.ajouter("abc");
        EnsembleChaine union4 = ensemble1.union(ensemble2);
        assertTrue(union4.liste.contains("abc") && union4.liste.contains("123") && union4.liste.size() == 2);

        //Cas 5 Les deux ensembles contiennent une chaine = null
        EnsembleChaine e4 = new EnsembleChaine();
        EnsembleChaine e3 = new EnsembleChaine();
        e3.ajouter(null);
        e4.ajouter(null);
        EnsembleChaine union5 = e3.union(e4);
        assertTrue(union5.liste.contains(null) && union5.liste.size() == 1);

        //Cas 6
        EnsembleChaine e5 = new EnsembleChaine();
        EnsembleChaine e6 = new EnsembleChaine();
        e5.ajouter("123");
        e5.ajouter("abc");

        e6.ajouter("abc");
        e6.ajouter("321");
        EnsembleChaine union6 = e5.union(e6);
        assertTrue(union6.liste.contains("123") && union6.liste.contains("321") && union6.liste.contains("abc") && union6.liste.size() == 3);

    }


    @Test
    public void intersection() {

    }

    @Test
    public void unionDisjointe() {
    }
}