import javax.swing.*;

public class Driver {

    public static void main(String[] args) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        GridPanel grid = new GridPanel(720,480);
        CharBoard chars = grid.getCharPanel();
        StatusPanel sp = grid.getSp();
        container.add(chars);
        container.add(grid);
        container.add(sp);
        SwingUtilities.invokeLater(() -> {
            JFrame game = new JFrame("Game");
            game.add(container);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.pack();
            game.setLocationRelativeTo(null);
            game.setVisible(true);
            game.setResizable(false);
        });
    }
}
