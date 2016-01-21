package Engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rsr on 20/01/16.
 */
public class Game {
    private List<QuestionAnswer> words;
    private List<QuestionAnswer> wrong;
    private int i, numberRight, progress;
    private Random random;
    public Game(List<String> files) throws IOException{
        words = WordLoader.loadWords(files);
        wrong = new ArrayList<>();
        random = new Random();
        i = randomInt(0, words.size());
        progress = 0;
    }

    public String getQuestion(){
        return words.get(i).getQuestion();
    }

    public String getAnswer(){
        return words.get(i).getAnswer();
    }

    public int getProgress() {
        return progress;
    }

    public int getSize(){
        return words.size();
    }

    public int getNumberRight() {
        return numberRight;
    }

    public int getNumberWrong(){
        return wrong.size();
    }

    public boolean testAnswer(String answer){
        boolean test = words.get(i).compare(answer);
        if(!test){
            wrong.add(words.get(i));
        }else{
            numberRight++;
        }
        words.remove(i);
        i = randomInt(0, words.size());
        return test;
    }

    private int randomInt(int min, int max){
        return random.nextInt(max - min) + min;
    }
}
