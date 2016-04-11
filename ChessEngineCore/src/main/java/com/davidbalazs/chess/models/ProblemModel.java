package com.davidbalazs.chess.models;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ProblemModel {
    private String name;
    private String description;
    private String initialPositionFen;
    private List<MoveEntityModel> movesForSolution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInitialPositionFen() {
        return initialPositionFen;
    }

    public void setInitialPositionFen(String initialPositionFen) {
        this.initialPositionFen = initialPositionFen;
    }

    public List<MoveEntityModel> getMovesForSolution() {
        return movesForSolution;
    }

    public void setMovesForSolution(List<MoveEntityModel> movesForSolution) {
        this.movesForSolution = movesForSolution;
    }
}
