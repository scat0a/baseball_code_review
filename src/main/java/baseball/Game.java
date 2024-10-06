package baseball;

import java.util.List;

public class Game {
    private Computer computer;
    private User user;
    private UserInput userInput;
    private GameResult gameResult;

    public Game() {
        this.computer = new Computer();
        this.userInput = new UserInput();
        this.gameResult = new GameResult();
    }

    public void play() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumbers = userInput.getUserInput();
            user = new User(userNumbers);
            gameResult.checkResult(computer.getNumbers(), user.getNumbers());
            if (gameResult.isWin()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}