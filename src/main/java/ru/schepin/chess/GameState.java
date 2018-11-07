package ru.schepin.chess;

public enum GameState {
    Finished("Фигура Финиширует"),
    HitedBarrier("Фигура попадет на препятствие"),
    CanNotFinished("Фигура не дойдет до финиша");

    private String  result;

     GameState(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}



