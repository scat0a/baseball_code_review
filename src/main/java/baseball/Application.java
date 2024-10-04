package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        boolean isGame = true;
        while (isGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> computerNumbers = new ArrayList<>();
            while (true) {
                for (int i = 0; i < 3; i++) {
                    int random = Randoms.pickNumberInRange(1, 9);
                    if (!computerNumbers.contains(random)) {
                        computerNumbers.add(random);
                    }
                }
                if (computerNumbers.size() == 3) {
                    break;
                }
            }

            System.out.println(computerNumbers);

            // 3개의 숫자를 맞출때 까지 반복한다.

            while (true) {
                String input = Console.readLine();
                String[] userInputs = input.split("");

                List<Integer> answers = new ArrayList<>();
                for (int i = 0; i < userInputs.length; i++) {
                    if (!userInputs[i].matches("\\d+")) {
                        throw new IllegalArgumentException("숫자만 입력 가능합니다");
                    }
                    if (userInputs.length != 3) {
                        throw new IllegalArgumentException("3자리까지 입력이 가능합니다");
                    }

                    if (Integer.parseInt(userInputs[i]) <= 0 || Integer.parseInt(userInputs[i]) > 9) {
                        throw new IllegalArgumentException("1-9까지만 입력 가능합니다.");
                    }

                    if (answers.contains(Integer.parseInt(userInputs[i]))) {
                        throw new IllegalArgumentException("같은 숫자는 입력 불가합니다");
                    }
                    answers.add(Integer.parseInt(userInputs[i]));
                }

                // todo : 컴퓨터의 숫자와 사용자가 입력한 숫자를 비교한다
                int strike = 0;
                int ball = 0;

                for (int i = 0; i < computerNumbers.size(); i++) {
                    if (Objects.equals(computerNumbers.get(i), answers.get(i))) {
                        strike++;
                    }
                    if (!Objects.equals(computerNumbers.get(i), answers.get(i)) && computerNumbers.contains(
                            answers.get(i))) {
                        ball++;
                    }
                }

                System.out.println(strike);
                System.out.println(ball);

                if (ball != 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike != 0) {
                    System.out.print(strike + "스트라이크");
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }

                System.out.println();
                if (strike == 3) {
                    break;
                }

            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            int choiceNumber = Integer.parseInt(Console.readLine());

            while (true) {
                if (!choice.matches("\\d+")) {
                    throw new IllegalArgumentException("숫자만 입력 가능합니다");
                }

                if (choiceNumber != 1 && choiceNumber != 2) {
                    throw new IllegalArgumentException("숫자는 1 또는 2만 입력 가능합니다");
                }

                if (choiceNumber == 1) {
                    break;
                }

                if (choiceNumber == 2) {
                    isGame = false;
                    break;
                }
            }


        }

    }

}



