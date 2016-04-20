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

    @Column(name = "DIFFICULTY_LEVEL")
    @Enumerated(EnumType.STRING)
    private ChessProblemDifficultyLevel difficultyLevel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ChessMovePairModel> movePairsForSolution;

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

    public ChessProblemDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(ChessProblemDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<ChessMovePairModel> getMovePairsForSolution() {
        return movePairsForSolution;
    }

    public void setMovePairsForSolution(List<ChessMovePairModel> movePairsForSolution) {
        this.movePairsForSolution = movePairsForSolution;
    }
}
