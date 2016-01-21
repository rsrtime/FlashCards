package GUI;

import Engine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsr on 19/01/16.
 */
public class MainPanel extends JPanel{
    private JTextField answer, question;
    private JTextArea progress, result;
    private Game game;
    private final static Font font1 = new Font("SansSerif", Font.BOLD, 25);
    public MainPanel(){
        List<String> files = new ArrayList<>();
        files.add("/home/rsr/Documents/farsi.txt");
        try{
            game = new Game(files);
        }catch (IOException e){
            e.printStackTrace();
        }
        setLayout(new GridLayout(6, 1));
        add(new JLabel("Question"));
        createQuestion();
        add(new JLabel("Answer"));
        createAnswer();
        createResult();
        createProgress();
        setQuestion();
    }

    private void setQuestion(){
        question.setText(game.getQuestion());
    }

    private void createAnswer() {
        answer = new JTextField(4);
        answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        answer.setFont(font1);
        add(answer);
    }

    private void createQuestion(){
        question = new JTextField(4);
        question.setEditable(false);
        question.setFont(font1);
        add(question);
    }

    private void createResult(){
        result = new JTextArea();
        result.setEditable(false);
        result.setFont(font1);
        add(result);
    }

    private void createProgress(){
        progress = new JTextArea();
        progress.setEditable(false);
        add(progress);
        updateProgress();
    }

    private void updateProgress(){
        String total = game.getProgress() + 1 + "/" + game.getSize();
        String right = "Number right: " + game.getNumberRight();
        String wrong = "Number wrong: " + game.getNumberWrong();
        progress.setText(total + "\n" + right + "\n" + wrong);
    }

    private void checkAnswer(){
        String answerStr = answer.getText();
        String question = game.getAnswer();
        answer.setText("");
        if (game.testAnswer(answerStr)){
            result.setText("Correct");
        } else{
            result.setText("Wrong. Answer: " + question);
        }
        setQuestion();
        updateProgress();
    }
}
