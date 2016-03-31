package com.davidbalazs.chess.model;

/**
 * Created by David on 3/17/2016.
 */
public class MinimaxEntity {
    private int move;
    private long evaluationScore;

    public MinimaxEntity(int move, long evaluationScore) {
        this.move = move;
        this.evaluationScore = evaluationScore;
    }

    public MinimaxEntity(long evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public MinimaxEntity() {
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public long getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(long evaluationScore) {
        this.evaluationScore = evaluationScore;
    }
}