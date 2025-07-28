package client.gui;

import client.listener.DispatcherService;
import client.listener.JoinEventListener;
import client.service.GameController;
import lib.event.JoinEvent;
import lib.model.Player;
import lib.model.Question;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class CreateGameFrame extends JFrame implements JoinEventListener {
    private JList list1;
    private JButton incepeJocButton;
    private JLabel label1;
    private JPanel mainPanel;

    private DefaultListModel<Player> model;

    public CreateGameFrame(){

        String gameId = GameController.getInstance().createGame(createGame());
        label1.setText(gameId);

        incepeJocButton.addActionListener(ev->{
            dispose();
            Question q = GameController.getInstance().startGame(gameId);

            JOptionPane.showMessageDialog(null, q.getContent());

            // TODO: deschide fereastra cu intrebarea curenta

            new MainFrame();

            DispatcherService.getInstance(gameId).removeListener(this);

        });

        model = new DefaultListModel<>();
        list1.setModel(model);

        DispatcherService.getInstance(gameId).addListener(this);


        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private List<Question> createGame(){
        Question q1 = new Question(
                1,
                "Ce e o clasa?",
                Map.of(
                        "un prototip", true,
                        "o instanta", false,
                        "o variabila", false,
                        "un limbaj", false
                )
        );

        Question q2 = new Question(
                2,
                "Ce reprezinta int?",
                Map.of(
                        "un tip de data", true,
                        "o clasa", false,
                        "o variabila", false,
                        "un limbaj", false
                )
        );

        return List.of(q1,q2);
    }


    @Override
    public void accept(JoinEvent event) {
       Player player = event.getPlayer();
       model.addElement(player);
    }
}
