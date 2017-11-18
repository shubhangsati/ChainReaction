package application;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class Player {
    String name;
    int r, g, b;
    PhongMaterial material;

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public Player(String n, int red, int green, int blue) {
        name = n;
        r = red; b = blue; g = green;
        Color diffuse = Color.rgb(r, g, b);
        Color specular = Color.rgb(max(0, r - 10), max(0, g - 10), max(0, b - 10));
        material = new PhongMaterial();
        material.setDiffuseColor(diffuse);
        material.setSpecularColor(specular);
    }
}
