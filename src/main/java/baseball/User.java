package baseball;

import java.util.List;

public class User {
    private final List<Integer> numbers;

    public User(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}