public class Judge implements Teisuu{

    private int win = 0;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win += win;
    }
    public void resetWin() {
        this.win = 0;
    }


    public boolean winJudge() {
        //勝利回数を+1と-1にすることでBLACKとWHITEに当てはめている

        //横列の勝利判定
        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                if(Board.getPosition(i, j)==BLACK) {
                    setWin(1);
                }
                else if(Board.getPosition(i, j)==WHITE) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }

            if((getWin()==BOARD_SIZE) || (getWin()==(-BOARD_SIZE))) {
                return true;
            }
            else {
                resetWin();
            }
        }

        //縦列の勝利判定
        //iとjを反対にすることでgetterの引数と逆になり、縦の判定になる
        for(int j=0; j<BOARD_SIZE; j++){
            for(int i=0; i<BOARD_SIZE; i++)
             {
                if(Board.getPosition(i, j)==BLACK) {
                    setWin(1);
                }
                else if(Board.getPosition(i, j)==WHITE) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }

            if((getWin()==BOARD_SIZE) || (getWin()==(-BOARD_SIZE))) {
                return true;
            }
            else {
                resetWin();
            }
        }

        //左斜め列の勝利判定
        //iとjが同じ値の時を条件のifをつけることで斜め判定になる
        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                if((i==j) && (Board.getPosition(i, j)==BLACK)) {
                    setWin(1);
                }
                else if((i==j) && (Board.getPosition(i, j)==WHITE)) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }
            }
        if((getWin()==BOARD_SIZE) || (getWin()==(-BOARD_SIZE))) {
            return true;
        }
        else {
            resetWin();
        }

        //右斜め列の勝利判定
        //i+jが定数sizeと一致するときというif文
        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                if((i+j == (BOARD_SIZE - 1)) && (Board.getPosition(i, j)==BLACK)) {
                    setWin(1);
                }
                else if((i+j == (BOARD_SIZE - 1)) && (Board.getPosition(i, j)==WHITE)) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }
            }
        if((getWin()==BOARD_SIZE) || (getWin()==(-BOARD_SIZE))) {
            return true;
        }
        else {
            resetWin();
        }

        return false;
    }

}