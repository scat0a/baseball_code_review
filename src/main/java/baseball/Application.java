package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumbers = new ArrayList<>();
        while (true){
            for (int i = 0; i < 3; i++) {
                int random = Randoms.pickNumberInRange(1,9);
                if(!computerNumbers.contains(random)){
                    computerNumbers.add(random);
                }
            }
            if(computerNumbers.size() == 3){
                break;
            }
        }


        System.out.println(computerNumbers);
    }
}
