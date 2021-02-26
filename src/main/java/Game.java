import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Terminal terminal;
    private Screen screen;

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

    private void draw() {

        try {
            screen.clear();
            screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        draw();
    }
}
