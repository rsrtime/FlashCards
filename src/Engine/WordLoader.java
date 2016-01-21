package Engine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsr on 11/12/15.
 */
public class WordLoader {
    public static List<QuestionAnswer> loadWords(List<String> files) throws IOException{
        List<QuestionAnswer> words = new ArrayList<>();
        for(String filePath : files){
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                String[] splitArr = line.split(",");
                //"english,spanish\n"
                words.add(new QuestionAnswer(splitArr[0], splitArr[1]));
            }
            br.close();
            fr.close();
        }
        return words;
    }
}
