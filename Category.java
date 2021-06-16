package club.machine.features.module;

import java.awt.*;

public enum Category {
    Combat(new Color(255, 50, 50)),
    Movement(new Color(50, 100, 255)),
    Player(new Color(255, 100, 50)),
    Visuals(new Color(255, 255, 100)),
    Exploit(new Color(200, 50, 200)),
    Misc(new Color(50, 255, 50)),
    Hidden(new Color(0, 0, 0));

    Color color;

    Category(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
