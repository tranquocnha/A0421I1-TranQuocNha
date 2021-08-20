package b8.clean_code_and_refactoring.bai_tap;

public class TennisGame {
    static String message = "";
    static  String SCORE = "Love-All";
    static  String SCORE1 = "Fifteen-All";
    static  String SCORE2 = "Thirty-All";
    static  String SCORE3 = "Forty-All";
    static  String SCORE4 = "Love";
    static  String SCORE5 = "Fifteen";
    static  String SCORE6 = "Thirty";
    static  String SCORE7 = "Forty";
    static  String MORE = "Deuce";

    public static String getScore(String player1Name, String player2Name, int markScore1, int markScore2) {
        if (markScore1 == markScore2) {
            return switchMarkScore(markScore1);
        } else if (markScore1 >= 4 || markScore2 >= 4) {
            return checkWinTennis(markScore1, markScore2);
        } else {
            return pointTennis(markScore1, markScore2);
        }
    }

    public static String pointTennis(int markScore1, int markScore2) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = markScore1;
            } else {
                message += "-";
                tempScore = markScore2;
            }
            switch (tempScore) {
                case 0:
                    message += SCORE4;
                    break;
                case 1:
                    message += SCORE5;
                    break;
                case 2:
                    message += SCORE6;
                    break;
                case 3:
                    message += SCORE7;
                    break;
            }
        }
        return message;
    }

    public static String checkWinTennis(int markScore1, int markScore2) {
        int minusResult = markScore1 - markScore2;
        if (minusResult == 1) {
            return message = "Advantage player1";
        } else if (minusResult == -1) {
            return message = "Advantage player2";
        } else if (minusResult >= 2) {
            return message = "Win for player1";
        } else {
            return message = "Win for player2";
        }
//        if (minusResult >0 ) {
//            else if (minusResult==1){
//                return message="Advantage player1";
//            }else {
//                return message="Win for player1";
//            }
//        } else{
//            if (minusResult == -1) {
//                return message="Advantage player2";
//            }else {
//                return message="Win for player2";
//            }
//        }
    }

    public static String switchMarkScore(int markScore1) {
        switch (markScore1) {
            case 0:
                return message = SCORE;
            case 1:
                return message = SCORE1;
            case 2:
                return message = SCORE2;
            case 3:
                return message = SCORE3;
            default:
                return message = MORE;
        }
    }
}
