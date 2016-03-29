package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.exceptions.ChessFenRepresentationException;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.service.FriendlyChessBoardService;
import com.davidbalazs.chess.service.impl.DefaultFriendlyChessBoardService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author: david.balazs@iquestgroup.com
 */

public class ChessPositionConverterTest {
    private ChessPositionConverter chessPositionConverter = new ChessPositionConverter();

    private FriendlyChessBoardService chessBoardService = new DefaultFriendlyChessBoardService();

    private static final String VALID_FEN_POSITION = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    private static final String INVALID_CHAR_FEN_POSITION = "rnbqkbnr/ppppXppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    private static final String INVALID_NUMBER_OF_LINES_FEN_POSITION = "rnbqkbnr/8/8/8/8/PPPPPPPP/RNBQKBNR";

    @Test
    public void convertGivenInitialChessPositionFenExpectedInitialChessPosition() {
        ChessPosition chessPosition = chessPositionConverter.convert(VALID_FEN_POSITION);

        ChessPosition expectedChessPosition = chessBoardService.initializeChessBoard();
        assertEquals(expectedChessPosition, chessPosition);
        chessBoardService.displayChessBoard(chessPositionConverter.convert("2R5/8/8/2K4k/8/8/8/8"));
    }

    @Test(expected = ChessFenRepresentationException.class)
    public void convertGivenWrongCharsInFenChessPositionExpectedException() {
        chessPositionConverter.convert(INVALID_CHAR_FEN_POSITION);
    }

    @Test(expected = ChessFenRepresentationException.class)
    public void convertGivenWrongNumberOfLinesInFenChessPositionExpectedException() {
        chessPositionConverter.convert(INVALID_NUMBER_OF_LINES_FEN_POSITION);
    }
}
