package baseball;

import java.util.List;
import java.util.Objects;

public class GameResult {
    private int strike;
    private int ball;

    public void checkResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            }
            if(!Objects.equals(computerNumbers.get(i), userNumbers.get(i)) && computerNumbers.contains(userNumbers.get(i))){
                ball++;
            }
        }

        displayResult();
    }

    private void displayResult() {
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean isWin() {
        return strike == 3;
    }
}