package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public List<Integer> getUserInput() {
        while (true) {
            String input = Console.readLine();
            List<Integer> answers = validateInput(input);
            if (answers != null) {
                return answers;
            }
        }
    }

    private List<Integer> validateInput(String input) {
        String[] userInputs = input.split("");
        List<Integer> answers = new ArrayList<>();

        if (userInputs.length != 3) {
            throw new IllegalArgumentException("3자리까지 입력이 가능합니다");
        }

        for (String userInput : userInputs) {
            if (!userInput.matches("\\d+")) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다");
            }
            int number = Integer.parseInt(userInput);
            if (number <= 0 || number > 9) {
                throw new IllegalArgumentException("1-9까지만 입력 가능합니다.");
            }
            if (answers.contains(number)) {
                throw new IllegalArgumentException("같은 숫자는 입력 불가합니다");
            }
            answers.add(number);
        }
        return answers;
    }

    public int getRestartChoice() {
        while (true) {
            String choice = Console.readLine();
            int choiceNumber = Integer.parseInt(choice);
            if (choiceNumber == 1 || choiceNumber == 2) {
                return choiceNumber;
            }
            System.out.println("숫자는 1 또는 2만 입력 가능합니다");
        }
    }
}