package client.gui;

import javax.swing.*;

public class MainFrame extends JFrame{
    private JButton creazaJocButton;
    private JButton intraInJocButton;
    private JTextField textField1;
    private JPanel mainPanel;

    public MainFrame(){

        creazaJocButton.addActionListener(ev->{
            dispose();
            new CreateGameFrame();
        });

        intraInJocButton.addActionListener(ev->{
            dispose();
            String gameId = textField1.getText();

            new JoinGameFrame(gameId);
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
