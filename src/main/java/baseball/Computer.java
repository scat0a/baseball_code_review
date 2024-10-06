package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(random)) {
                computerNumbers.add(random);
            }
        }
        return computerNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}