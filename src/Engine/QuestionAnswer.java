package Engine;

/**
 * Created by rsr on 11/12/15.
 */
public class QuestionAnswer {
    private String question, answer;
    public QuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }



    public boolean compare(String str){
        return str.equalsIgnoreCase(answer);
    }

    public String getStatement(int index){
        switch (index){
            case 0:
                return "English: " + question + "\nSpanish: ";
            case 1:
                return "Spanish: " + answer + "\nEnglish: ";
        }
        return "";
    }
}
