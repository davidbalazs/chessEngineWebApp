package com.davidbalazs.chess.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CHESS_STRATEGY")
public class ChessStrategyModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private ChessStrategyCategory category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ChessStrategyMovePairModel> movePairs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChessStrategyCategory getCategory() {
        return category;
    }

    public void setCategory(ChessStrategyCategory category) {
        this.category = category;
    }

    public List<ChessStrategyMovePairModel> getMovePairs() {
        return movePairs;
    }

    public void setMovePairs(List<ChessStrategyMovePairModel> movePairs) {
        this.movePairs = movePairs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
