import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Terminal terminal;
    private Screen screen;

    private int x = 10;
    private int y = 10;

    private Hero hero = new Hero(x, y);

    public Game() {
        try {

            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

            terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);     //we don't need a cursor
            screen.startScreen();               //screens must be started
            screen.doResizeIfNecessary();       //resize screen if necessary
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            
            hero.draw(screen);
            KeyStroke key = screen.readInput();;
            while ( !(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') && !(key.getKeyType() == KeyType.EOF)) {
                processKey(key);
                hero.draw(screen);
                key = screen.readInput();
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

    private void processKey(KeyStroke key) {

        switch (key.getKeyType()) {
            case ArrowUp:
                hero.moveUp();
                break;

            case ArrowDown:
                hero.moveDown();
                break;

            case ArrowLeft:
                hero.moveLeft();
                break;

            case ArrowRight:
                hero.moveRight();
                break;

            default:
                break;
        }
    }
}
