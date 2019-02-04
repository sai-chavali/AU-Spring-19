package com.springMVC.bowling;

import java.util.ArrayList;
import java.util.List;

public class App 
{
	private List<Integer> pins = new ArrayList<Integer>();

    public void roll(int numberOfPins) {
        pins.add(numberOfPins);
    }

    public int finalScore() {
        int score = 0;
        int ball = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += pins.get(ball);
            score += pins.get(ball + 1);

            if (isStrike(ball)) {
                score += pins.get(ball + 2);
                ball++;
            } else if (isSpare(ball)) {
                score += pins.get(ball + 2);
                ball += 2;
            } else {
                ball += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int ball) {
        return pins.get(ball) == 10;
    }

    private boolean isSpare(int ball) {
        return pins.get(ball) + pins.get(ball + 1) == 10;
    }
}
