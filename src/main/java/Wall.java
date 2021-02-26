import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position position;

    public Wall(Position position) {
        this.position = position;
    }
    public Wall(int x, int y) { this.position = new Position(x, y); }

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

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#EF8433"));
        graphics.putString(new TerminalPosition(getX(), getY()), "A");
    }

}
