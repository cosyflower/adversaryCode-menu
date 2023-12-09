package menu;

import menu.view.InputView;
import menu.view.OutputView;

public class FoodRecommendator {
    private final InputView inputView;
    private final OutputView outputView;

    public FoodRecommendator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setAllFoods();
        recommendFoods();
        terminate();
    }

    private void setAllFoods() {
        // Foods 정보를 저장 먼저 하고
    }

    private void recommendFoods() {
        // 핵심 로직을 수행한다 (입력을 받고, 메뉴를 추천한다
    }

    private void terminate() {
        // 종료한다
    }


}
