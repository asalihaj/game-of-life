import java.util.Random;

public class Universe {
    private Cell[][] cells;

    public Universe(int initialSize) {
        setSize(initialSize);
    }

    private void setSize(int size) {
        Random random = new Random();
        cells = new Cell[size][size];

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(random.nextBoolean());
            }
        }
    }

    public void update() {
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                cells[i][j].updateState();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

}
