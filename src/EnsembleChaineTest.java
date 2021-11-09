import org.junit.Assert;

import static org.junit.Assert.*;

public class EnsembleChaineTest {

    EnsembleChaine EnsembleChaine = new EnsembleChaine();
    String str = "abc";

    @org.junit.Test
    public void ajouterTest() {
        Boolean exist = false;
        for (String ch : EnsembleChaine.liste) {
            if (str.equals(ch)) {
                exist = true;
            } else {
                exist = false;
            }
        }
        assertFalse(exist);
    }

    @org.junit.Test
    public void testEquals() {

    }

    @org.junit.Test
    public void union() {
    }

    @org.junit.Test
    public void intersection() {
    }

    @org.junit.Test
    public void unionDisjointe() {
    }
}