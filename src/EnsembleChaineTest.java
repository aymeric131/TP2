/**
 * BARDU Aymeric L3 MIAGE
 * ELELOUE Rayan L3 MIAGE
 * TP Tests Unitaires
 */

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

        //8 cas : Les ensembles contiennent une chaine vide
        e5.ajouter("");
        e6.ajouter("");
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


        //Cas 7 On ajoute une chaine vide à un ensemble
        e6.ajouter("");
        EnsembleChaine union7 = e5.union(e6);
        assertTrue(union7.liste.contains("123") && union7.liste.contains("321") && union7.liste.contains("abc") && union7.liste.contains("") && union7.liste.size() == 4);

    }

    @Test
    public void intersection() {
        EnsembleChaine e1 = new EnsembleChaine();
        EnsembleChaine e2 = new EnsembleChaine();

        //Cas 1 : Les deux ensembles sont vide donc l'intersection est aussi vide
        assertTrue(e1.intersection(e2).liste.size() == 0);

        //Cas 2 : Les deux ensembles contiennent les mêmes éléments
        e1.ajouter("123");
        e2.ajouter("123");
        EnsembleChaine commun = e1.intersection(e2);
        assertTrue( commun.liste.contains("123") && commun.liste.size() == 1);

        // Cas 3 : Les deux ensembles contiennent le même élément null
        EnsembleChaine e3 = new EnsembleChaine();
        EnsembleChaine e4 = new EnsembleChaine();
        e3.ajouter(null);
        e4.ajouter(null);
        EnsembleChaine commun2 = e3.intersection(e4);
        assertTrue( commun2.liste.contains(null) && commun2.liste.size() == 1);

        //Cas 4 : Le premier ensemble contient une chaine et l'autre contient la même chaine à l'envers 123 et 321
        EnsembleChaine e5 = new EnsembleChaine();
        EnsembleChaine e6 = new EnsembleChaine();
        e5.ajouter("123");
        e6.ajouter("321");
        EnsembleChaine commun3 = e5.intersection(e6);
        assertTrue( commun3.liste.size() == 0);

        //Cas 5 : Les ensembles contiennent les mêmes éléments donc ils apparaissent 1 seul fois dans l'intersection
        EnsembleChaine e7 = new EnsembleChaine();
        EnsembleChaine e8 = new EnsembleChaine();
        e7.ajouter("123");
        e7.ajouter("321");
        e8.ajouter("123");
        e8.ajouter("321");
        EnsembleChaine commun4 = e7.intersection(e8);
        assertTrue( commun4.liste.contains("123") && commun4.liste.contains("321") && commun4.liste.size() == 2);

        EnsembleChaine e9 = new EnsembleChaine();
        EnsembleChaine e10 = new EnsembleChaine();
        e9.ajouter("abc");
        e10.ajouter("cba");
        EnsembleChaine commun5 = e9.intersection(e10);
        assertTrue( commun5.liste.size() == 0);

        //Cas 7
        EnsembleChaine groupe1 = new EnsembleChaine();
        EnsembleChaine groupe2 = new EnsembleChaine();
        groupe1.ajouter("Aymeric");
        groupe1.ajouter("Rayan");
        groupe2.ajouter("Abare");
        groupe2.ajouter("Hermanes");
        groupe2.ajouter("Aymeric");

        EnsembleChaine classe = groupe1.intersection(groupe2);
        assertTrue( classe.liste.contains("Aymeric") && classe.liste.size() == 1);


    }

    @Test
    public void unionDisjointe() {
        EnsembleChaine e1 = new EnsembleChaine();
        EnsembleChaine e2 = new EnsembleChaine();

        //Cas 1 : Les deux ensembles sont vides
        EnsembleChaine unionDis1 =  e1.unionDisjointe(e2);
        assertTrue(unionDis1.liste.size() == 0);

        //Cas 2 : e1 contient abc et e2 est vide
        e1.ajouter("abc");
        EnsembleChaine unionDis2 =  e1.unionDisjointe(e2);
        assertTrue(unionDis2.liste.contains("abc") && unionDis2.liste.size() == 1);

        //Cas 3: e1 et e2 n'ont aucun cas en commun
        e2.ajouter("123");
        EnsembleChaine unionDis3 =  e1.unionDisjointe(e2);
        assertTrue(unionDis3.liste.contains("abc") && unionDis3.liste.contains("123") && unionDis3.liste.size() == 2);

        //Cas 4 : e1 contient (abc,cde,fgh) , e2 contient (123,abc)
        e1.ajouter("cde");
        e1.ajouter("fgh");
        e2.ajouter("abc");
        EnsembleChaine unionDis4 =  e1.unionDisjointe(e2);
        assertTrue(unionDis4.liste.contains("cde") && unionDis4.liste.contains("fgh") && unionDis4.liste.contains("123") && unionDis4.liste.size() == 3);

        //Cas 5 les des ensembles contiennent un seul élément null
        EnsembleChaine e3 = new EnsembleChaine();
        EnsembleChaine e4 = new EnsembleChaine();

        e3.ajouter(null);
        e4.ajouter(null);
        EnsembleChaine unionDis5 = e3.unionDisjointe(e4);
        assertTrue(unionDis5.liste.size() == 0);

        //Cas 6 On ajoute une chaine vide à e4 on verifie que l'union disjointe là contient
        e3.ajouter("azerty");
        e3.ajouter("123");
        e4.ajouter("123");
        e4.ajouter("");
        EnsembleChaine unionDis6 =  e3.unionDisjointe(e4);
        assertTrue(unionDis6.liste.contains("azerty") && unionDis6.liste.contains("") && unionDis6.liste.size() == 2);


    }
}