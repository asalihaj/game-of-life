
public class Neighbours {
    static int getNeighbours(Cell[][] sourceCells, int row, int column) {

        int length = sourceCells.length - 1;
        int count = 0;

        int[] n = getNorth(length, row, column);
        int[] s = getSouth(length, row, column);
        int[] w = getWest(length, row, column);
        int[] e = getEast(length, row, column);
        int[] sw = getSouth(length, w[0], w[1]);
        int[] se = getSouth(length, e[0], e[1]);
        int[] nw = getNorth(length, w[0], w[1]);
        int[] ne = getNorth(length, e[0], e[1]);

        if(sourceCells[n[0]][n[1]].isAlive()) {
            count++;
        }

        if(sourceCells[s[0]][s[1]].isAlive()) {
            count++;
        }

        if(sourceCells[w[0]][w[1]].isAlive()) {
            count++;
        }

        if(sourceCells[e[0]][e[1]].isAlive()) {
            count++;
        }

        if(sourceCells[ne[0]][ne[1]].isAlive()) {
            count++;

        }

        if(sourceCells[nw[0]][nw[1]].isAlive()) {
            count++;
        }

        if(sourceCells[sw[0]][sw[1]].isAlive()) {
            count++;
        }

        if(sourceCells[se[0]][se[1]].isAlive()) {
            count++;
        }

        return count;
    }

    private static int[] getNorth(int length, int row, int column) {
        int[] northCoordinates = new int[2];
        if(row == 0) {
            northCoordinates[0] = length;
            northCoordinates[1] = column;
            return northCoordinates;
        }
        northCoordinates[0] = row - 1;
        northCoordinates[1] = column;
        return northCoordinates;
    }

    private static int[] getSouth(int length, int row, int column) {
        int[] southCoordinates = new int[2];
        if(row == length) {
            southCoordinates[1] = column;
            return southCoordinates;
        }
        southCoordinates[0] = row + 1;
        southCoordinates[1] = column;
        return southCoordinates;
    }

    private static int[] getWest(int length, int row, int column) {
        int[] westCoordinates = new int[2];
        if(column == 0) {
            westCoordinates[0] = row;
            westCoordinates[1] = length;
            return westCoordinates;
        }
        westCoordinates[0] = row;
        westCoordinates[1] = column - 1;
        return westCoordinates;
    }

    private static int[] getEast(int length, int row, int column) {
        int[] eastCoordinates = new int[2];
        if(column == length) {
            eastCoordinates[0] = row;
            return eastCoordinates;
        }
        eastCoordinates[0] = row;
        eastCoordinates[1] = column + 1;
        return eastCoordinates;
    }
}
