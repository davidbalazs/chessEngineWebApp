package com.davidbalazs.chess.movegenerator.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.movegenerator.PossibleMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by David on 10/11/2015.
 */
public class MainPossibleMovesGenerator implements PossibleMovesGenerator {
    List<PossibleMovesGenerator> possibleMoveGenerators;

    @Override
    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition) {
        //todo: assertNotNull(possibleMoveGenerators);

//     todo:   before generating the next move, check if there is an attacked piece.
        TreeSet<Integer> generatedMoves = new TreeSet<Integer>(Collections.reverseOrder());

        for (PossibleMovesGenerator possibleMovesGenerator : possibleMoveGenerators) {
            generatedMoves.addAll(possibleMovesGenerator.generateWhiteMoves(chessPosition));
        }

        return generatedMoves;
    }

    @Override
    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition) {
        //todo: assertNotNull(possibleMoveGenerators);

        TreeSet<Integer> generatedMoves = new TreeSet<Integer>(Collections.reverseOrder());

        for (PossibleMovesGenerator possibleMovesGenerator : possibleMoveGenerators) {
            generatedMoves.addAll(possibleMovesGenerator.generateBlackMoves(chessPosition));
        }

        return generatedMoves;
    }

    @Required
    public void setPossibleMoveGenerators(List<PossibleMovesGenerator> possibleMoveGenerators) {
        this.possibleMoveGenerators = possibleMoveGenerators;
    }
}
