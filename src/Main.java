//import Engine.QuestionAnswer;
//import Engine.WordLoader;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
///**
// * Created by rsr on 11/12/15.
// */
//public class Main {
//    public static void main(String[] args) {
//        try{
//            List<QuestionAnswer> words, wrong;
//            words = WordLoader.loadWords(getFile());
//            int go = 1;
//            while(go != 2){
//                words = test(words);
//                printWrong(words);
//                go = questionAgain();
//            }
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException iEx){
//            iEx.printStackTrace();
//        }
//    }
//
//    private static int questionAgain()throws IOException{
//        System.out.println("Redo wrong words?");
//        System.out.println("1. Yes");
//        System.out.println("2. No");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        return br.read() - '0';
//    }
//
//    private static void printWrong(List<QuestionAnswer> wrong) {
//        System.out.println("\n\n*******************************Finished*********************\n\n");
//        for (QuestionAnswer w : wrong){
//            System.out.println(w.getQuestion() + " : " + w.getAnswer());
//        }
//    }
//
//    public static List<QuestionAnswer> test(List<QuestionAnswer> words)throws  IOException{
//        List<QuestionAnswer> wrong = new ArrayList<QuestionAnswer>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int total = words.size();
//        int amount = 1;
//        while(words.size() > 0){
//            System.out.println(amount++ + " out of " + total);
//            QuestionAnswer w = words.get(generateRandomNumber(0, words.size()));
//            int ind = 0;//= generateRandomNumber(0, 2);
//            System.out.print(w.getStatement(ind));
//            String answer = br.readLine();
//            if (w.compare(answer, ind)) {
//                System.out.println("Correct");
//            }else{
//                System.out.println("Wrong. Answer: " + w.getOpposite(ind));
//                wrong.add(w);
//            }
//            words.remove(w);
//        }
//        return wrong;
//    }
//
//    public static int generateRandomNumber(int low, int high){
//        Random r = new Random();
//        return r.nextInt(high - low) + low;
//    }
//
//    public static List<String> getFile()throws IOException{
//        String base = "/home/rsr/Programming/School/SPAN_101/FlashCards/chapters/";
//
//        System.out.println("1. Chapter 1");
//        System.out.println("2. Chapter 2");
//        System.out.println("3. Chapter 3");
//        System.out.println("4. Chapter 4");
//        System.out.println("5. Chapter 5");
//        System.out.println("6. Chapter 6");
//        System.out.println("7. Chapter 7");
//        System.out.println("8. All");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int selection = br.read() - '0';
//        List<String> chapters = new ArrayList<String>();
//        switch (selection){
//            case 1:
//                chapters.add(base + "chapter1.txt");
//                break;
//            case 2:
//                chapters.add(base + "chapter2.txt");
//                break;
//            case 3:
//                chapters.add(base + "chapter3.txt");
//                break;
//            case 4:
//                chapters.add(base + "chapter4.txt");
//                break;
//            case 5:
//                chapters.add(base + "chapter5.txt");
//                break;
//            case 6:
//                chapters.add(base + "chapter6.txt");
//                break;
//            case 7:
//                chapters.add(base + "chapter7.txt");
//                break;
//            case 8:
//                chapters.add(base + "chapter1.txt");
//                chapters.add(base + "chapter2.txt");
//                chapters.add(base + "chapter3.txt");
//                chapters.add(base + "chapter4.txt");
//                chapters.add(base + "chapter5.txt");
//                chapters.add(base + "chapter6.txt");
//            default:
//                chapters.add(base + "chapter1.txt");
//                break;
//        }
//        return chapters;
//    }
//}
