package bsp;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Graphics2D;

public class JogoComAcao extends Game{

    int x;
    int y;
    int sx;
    int sy;

    public void onLoad() {
        x = 0;
        y = 0;
        sx = 10;
        sy = 10;
    }

    public void onUnload() {
    }

    public void onUpdate() {
        x += sx;
        y += sy;
        if (x < 0 || x > getWidth()) {
            sx *= -1;
        }
        if (y < 0 || y > getHeight()) {
            sy *= -1;
        }
    }

    public void onRender(Graphics2D g) {
        g.setColor(Color.white);
        g.drawOval(x, y, 10, 10);
        g.drawLine(10, 10, 200, 200);
    }
}

