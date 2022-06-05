import javax.swing.*;

public class Driver {

    public static void main(String[] args) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        GamePanel gp = new GamePanel(860,1920);
        container.add(gp);
        container.add(gp.getBottomPanel());
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
