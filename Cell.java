import javax.swing.JPanel;
import java.awt.*;

public class Cell extends JPanel {
    private boolean alive;
    private boolean nextState;

    public Cell(boolean alive) {
        this.alive = alive;
        draw();
    }

    public void die() {
        nextState(false);
    }

    public void live() {
        nextState(true);
    }

    public boolean isAlive() {
        return alive;
    }

    public void nextState(boolean isAlive) {
        this.nextState = isAlive;
    }

    public void updateState() {
        alive = nextState;
        draw();
    }

    public void draw() {
        if(isAlive()) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.LIGHT_GRAY);
        }
    }
}
