package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        String[] userInputs = input.split("");

        List<Integer> answers = new ArrayList<>();
        // todo : 예외처리
        //  - [] 숫자만 입력되어야 한다
        //  - [] 1-9까지만 입력 가능하다.
        //  - [] 사용자는 3자리 숫자만 입력가능하다.

        for (int i = 0; i < userInputs.length; i++) {
            answers.add(Integer.parseInt(userInputs[i]));
        }

        // todo : 컴퓨터의 숫자와 사용자가 입력한 숫자를 비교한다
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if(Objects.equals(computerNumbers.get(i), answers.get(i))){
                strike++;
            }
            if(!Objects.equals(computerNumbers.get(i), answers.get(i))&& computerNumbers.contains(answers.get(i))){
                ball++;
            }
        }

        System.out.println(strike);
        System.out.println(ball);

    }
}
