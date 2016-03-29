package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.service.FriendlyChessBoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * @author: david.balazs@iquestgroup.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"../../../main/webapp/WEB-INF/chessEngine-servlet.xml"})
public class ChessPositionConverterTest {
    @Resource(name = "chessPositionConverter")
    private ChessPositionConverter chessPositionConverter;

    @Resource(name = "friendlyChessBoardService")
    private FriendlyChessBoardService chessBoardService;

    private static final String VALID_FEN_POSITION = "2R5/8/8/k1K5/8/8/8/8";

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        ChessPosition chessPosition = chessPositionConverter.convert(VALID_FEN_POSITION);
        System.out.println(chessBoardService.getFriendlyChessPosition(chessPosition));
        assertEquals("10 x 0 must be 0", 0);
    }
}
