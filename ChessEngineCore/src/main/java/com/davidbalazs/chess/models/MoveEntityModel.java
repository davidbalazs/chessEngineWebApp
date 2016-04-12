package com.davidbalazs.chess.models;

import javax.persistence.*;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "MOVE_ENTITY")
public class MoveEntityModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "FEN_POSITION")
    private String fenPosition;

    @Column(name = "MOVE_THAT_WAS_MADE")
    private String moveThatWasMade;

    public String getFenPosition() {
        return fenPosition;
    }

    public void setFenPosition(String fenPosition) {
        this.fenPosition = fenPosition;
    }

    public String getMoveThatWasMade() {
        return moveThatWasMade;
    }

    public void setMoveThatWasMade(String moveThatWasMade) {
        this.moveThatWasMade = moveThatWasMade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
