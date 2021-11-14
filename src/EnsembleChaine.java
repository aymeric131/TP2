import java.util.ArrayList;

public class EnsembleChaine {
    ArrayList<String> liste;

    public EnsembleChaine() {
        liste = new ArrayList<String>();
    }

    //Ajoute la chaine ch, si elle n’existe pas déjà, à l’ensemble
    public boolean ajouter(String ch) {

        Boolean success;

        if (liste.isEmpty()) {
            liste.add(ch);
            success = true;
        } else {
            if (liste.contains(ch)) {
                success = false;
            } else {
                liste.add(ch);
                success = true;
            }

        }
        return success;
    }


    //Test si l’ensemble e est équivalent à l’ensemble courant
    public boolean equals(EnsembleChaine e) {
        Boolean eq = null;
        int occ = 0;
        if (liste.size() != e.liste.size()) {
            eq = false;
        } else {
            for (String str : e.liste) {
                if (liste.contains(str)) {
                    occ += 1;
                }
            }
            if (occ != e.liste.size()) {
                eq = false;
            } else {
                eq = true;
            }
        }
        return eq;
    }

    //Renvoie l’union de l’ensemble e et l’ensemble courant
    public EnsembleChaine union(EnsembleChaine e) {
        EnsembleChaine union = new EnsembleChaine();
        if (!liste.isEmpty() || !e.liste.isEmpty()) {
            for (String str : liste) {
                union.ajouter(str);
            }
            for (String str : e.liste) {
                if (!union.liste.contains(str)) {
                    union.ajouter(str);
                }
            }
        }
        return union;
    }

    //Renvoie l’intersection de l’ensemble e et l’ensemble courant
    public EnsembleChaine intersection(EnsembleChaine e) {
        EnsembleChaine intersection = new EnsembleChaine();
        if (!liste.isEmpty() || !e.liste.isEmpty()) {
            for (String str : liste) {
                if (e.liste.contains(str)) {
                    intersection.ajouter(str);
                }
            }
        }
        return intersection;
    }

    //Renvoie l’union disjointe de l’ensemble e et l’ensemble courant
    public EnsembleChaine unionDisjointe(EnsembleChaine e) {
        EnsembleChaine unionDisjointe = new EnsembleChaine();
        if (!liste.isEmpty() || !e.liste.isEmpty()) {
            for (String str : liste) {
                if (!e.liste.contains(str)) {
                    unionDisjointe.ajouter(str);
                }
            }
            for (String str : e.liste) {
                if (!liste.contains(str)) {
                    unionDisjointe.ajouter(str);
                }
            }
        }
        return unionDisjointe;
    }
}

