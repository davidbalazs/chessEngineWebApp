package com.davidbalazs.chess.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "CHESS_PROBLEM")
public class ChessProblemModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "INITIAL_POSITION_FEN")
    private String initialPositionFen;

    @Column(name = "IS_PROBLEM_OF_THE_DAY")
    private boolean isProblemOfTheDay;

    @OneToMany(cascade = CascadeType.ALL)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isProblemOfTheDay() {
        return isProblemOfTheDay;
    }

    public void setIsProblemOfTheDay(boolean isProblemOfTheDay) {
        this.isProblemOfTheDay = isProblemOfTheDay;
    }
}
