public class Generator {
    private Universe universe;

    public Generator(Universe universe) {
        this.universe = universe;
    }

    public int generate() {
        Cell[][] cells = universe.getCells();

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                boolean isAlive = cells[i][j].isAlive();
                int neighbours = Neighbours.getNeighbours(cells, i, j);

                if(neighbours == 3) {
                    cells[i][j].live();
                } else if(isAlive && neighbours == 2) {
                    cells[i][j].live();
                } else {
                    cells[i][j].die();
                }
            }
        }

        universe.update();

        return countAlive();
    }

    public int countAlive() {
        Cell[][] cells = universe.getCells();
        int count = 0;

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                if(cells[i][j].isAlive())
                    count++;
            }
        }
        return count;
    }

    public void display() {
        Cell[][] cells = universe.getCells();

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                char cell = cells[i][j].isAlive() ? 'O' : ' ';
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
