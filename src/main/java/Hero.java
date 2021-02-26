import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private int x;
    private int y;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void draw(Screen screen) {

        try {
            screen.clear();
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void moveUp() {
        y -= 1;
    }
    public void moveDown() {
        y += 1;
    }
    public void moveLeft() {
        x -= 1;
    }
    public void moveRight() {
        x += 1;
    }
}
