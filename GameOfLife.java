import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GameOfLife extends JFrame {
    JLabel generationNumber = new JLabel("0");
    JLabel aliveNumber = new JLabel("0");
    JLabel alive = new JLabel("Alive #");
    JLabel generation = new JLabel("Generation #");
    JButton forward = new JButton();
    JButton reset = new JButton();
    JSlider speed = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
    JPanel infoPanel = new JPanel();
    JPanel cellPanel = new JPanel();
    Universe universe = new Universe(Main.getInitialState());
    Generator generator = new Generator(universe);
    JToggleButton play = new JToggleButton();
    Timer timer;

    public GameOfLife() {
        setName("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);



    }

    public void initComponents() {
        JPanel mainPanel = new JPanel();
        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel speedPanel = new JPanel();
        JPanel heading = new JPanel();

        mainPanel.setLayout(new GridLayout(3, 1, 5, 5));
        firstPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setLayout(new GridLayout(1, 3, 5, 5));
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        speedPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        mainPanel.add(firstPanel);
        mainPanel.add(heading);
        mainPanel.add(secondPanel);

        firstPanel.add(buttonPanel);
        firstPanel.add(textPanel);
        firstPanel.add(speedPanel);

        speed.setMinorTickSpacing(2);
        speed.setMajorTickSpacing(2);
        speed.setPaintLabels(true);
        speed.setPaintTicks(true);

        cellComponents(universe.getCells().length);
        start();

        buttonPanel.add(forward);
        buttonPanel.add(play);
        buttonPanel.add(reset);
        textPanel.add(generation);
        textPanel.add(generationNumber);
        textPanel.add(alive);
        textPanel.add(aliveNumber);
        speedPanel.add(speed);

        infoPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        cellPanel.setLayout(new GridLayout(universe.getCells().length, universe.getCells().length, 1, 1));

        setLayout(new BorderLayout(10, 10));
        add(mainPanel, BorderLayout.WEST);
        add(cellPanel, BorderLayout.CENTER);
        timer.start();
    }

    public void start() {
        timer = new Timer(speed.getValue() * 100, e -> {
            try {
                if(speed.getValue() * 100 != timer.getDelay()) {
                    timer.setDelay(speed.getValue() * 100);
                }
                    nextCells();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        play.addActionListener(arg0 -> {
            if (play.isSelected()) {
                timer.stop();
            } else {
                timer.restart();
            }
        });

        reset.addActionListener(e -> {
            timer.stop();
            universe = new Universe(Main.getInitialState());
            generator = new Generator(universe);
            Component[] comps = cellPanel.getComponents();
            for(Component c : comps) {
                cellPanel.remove(c);
            }
            cellPanel.repaint();
            cellPanel.setLayout(new GridLayout(universe.getCells().length, universe.getCells().length, 1, 1));
            cellComponents(universe.getCells().length);
            play.setSelected(false);
            timer.start();
        });

    }


    public void cellComponents(int size) {

        Cell[][] initCells = universe.getCells();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                cellPanel.add(initCells[i][j]);
            }
        }
        aliveNumber.setText(String.valueOf(generator.countAlive()));
        generationNumber.setText("1");
    }

    public void nextCells() {
        int i = Integer.parseInt(generationNumber.getText());
        i++;
        int getAlive = generator.generate();
        aliveNumber.setText(String.valueOf(getAlive));
        generationNumber.setText(String.valueOf(i));
    }

}


