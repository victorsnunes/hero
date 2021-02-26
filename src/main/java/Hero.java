import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private Position position;

    public Hero(int x, int y) {
        position = new Position (x, y);
    }

    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }

    public void setX(int x) {
        position.setX(x);
    }
    public void setY(int y) {
        position.setY(y);
    }

    public void setPosition(Position position) { this.position = position; }

    public void draw(Screen screen) {

        try {
            screen.clear();
            screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }
}
