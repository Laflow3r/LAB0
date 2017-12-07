package com.lafleur.alexandre.lab0;

import android.widget.TextView;

/**
 * Created by laflo on 2017-12-07.
 */

public class Joueur {
    private String texte1;
    private String texte2;

    public String getTexte1() {
        return texte1;
    }

    public void setTexte1(String texte1) {
        this.texte1 = texte1;
    }

    public String getTexte2() {
        return texte2;
    }

    public void setTexte2(String texte2) {
        this.texte2 = texte2;
    }

    public Joueur(String texte1, String texte2) {

        this.texte1 = texte1;
        this.texte2 = texte2;
    }
}
