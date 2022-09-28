package com.design_shinbi.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Quiz {
    private static double PASS_PERCENTAGE = 0.8;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        start(reader);

        reader.close();
    }

    public static void start(BufferedReader reader) throws IOException {
        List<Question> questions = Question.getQuestions();
        Collections.shuffle(questions);

        int correct = 0;
        for(Question question : questions) {
            List<String> items = question.display();

            String input = getInput(reader, items);

            if(input.equals(question.getCorrectItem())) {
                System.out.println("〇 正解です。");
                correct += 1;
            }
            else {
                System.out.println("× 間違いです。");
            }
        }

        System.out.println(
            String.format("%d 問中 %d 問正解です。", questions.size(), correct)
        );

        double percentage = (double)correct / (double)questions.size();
        if(percentage >= PASS_PERCENTAGE) {
            System.out.println("合格です。");
        }
        else {
            System.out.println("不合格です。");
        }
    }

    public static String getInput(BufferedReader reader, List<String> items) {
        int index = -1;
        while(index < 0 || index >= items.size()) {
            System.out.println(
                String.format("0 ～ %d までの数字を入力してください。", items.size() - 1)
            );

            try {
                String line = reader.readLine();
                index = Integer.parseInt(line);
            }
            catch(Exception e) {
            }
        }

        String input = items.get(index);
        return input;
    }
}
