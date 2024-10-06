package baseball;

public class GameManager {
    private boolean isGameActive;

    public GameManager() {
        this.isGameActive = true;
    }

    public void startGame() {
        while (isGameActive) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Game game = new Game();
            game.play();
            askForRestart();
        }
    }

    private void askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        UserInput userInput = new UserInput();
        isGameActive = userInput.getRestartChoice() == 1;
    }
}