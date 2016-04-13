INSERT INTO `chessenginedatabase`.`quote_of_the_day` (`ID`, `AUTHOR`, `IS_QUOTE_OF_THE_DAY`, `QUOTE`) VALUES ('1', 'David', true, 'Nu lasa pe maine ce poti face azi');
INSERT INTO `chessenginedatabase`.`quote_of_the_day` (`ID`, `AUTHOR`, `IS_QUOTE_OF_THE_DAY`, `QUOTE`) VALUES ('2', 'Confucius', false, 'Bla bla bla');

INSERT INTO `chessenginedatabase`.`latest_news` (`ID`, `TEXT`, `TITLE`) VALUES ('1', 'Site is now online!', 'Greate news!');
INSERT INTO `chessenginedatabase`.`latest_news` (`ID`, `TEXT`, `TITLE`) VALUES ('2', 'Virtual player is working!', 'Virtual Player');

INSERT INTO `chessenginedatabase`.`chess_problem` (`ID`, `DESCRIPTION`, `INITIAL_POSITION_FEN`, `IS_PROBLEM_OF_THE_DAY`, `NAME`) VALUES ('1', 'first chess problem description', 'r1bqkbnr/ppQQ1ppp/2n5/1B2p3/4P3/5R2/PPPP1PPP/RNBQK2R', true, 'first chess problem');
INSERT INTO `chessenginedatabase`.`chess_strategy` (`ID`, `CATEGORY`, `NAME`) VALUES ('1', 'OPENING', 'Queen\'s gambit');
