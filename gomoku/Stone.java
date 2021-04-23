public class Stone implements Teisuu{
    
    Board board = new Board();


    //石が正常に置けたらtrue,置けなかったらfalse
    private boolean stoneSet;
    public boolean getStoneSet() {
        return stoneSet;
    }
    public void setStoneSet(boolean stoneSet) {
        this.stoneSet = stoneSet;
    }


    //石の位置に関するフィールド
    private int tate;
    private int yoko;
    public int getTate() {
        return tate;
    }
    public void setTate(int tate) {
        this.tate = tate;
    }
    public int getYoko() {
        return yoko;
    }
    public void setYoko(int yoko) {
        this.yoko = yoko;
    }


    //石配置処理
    //@SuppressWarnings("resource")
    public void stoneConfig(boolean stoneColor) {
        //引数stoneColorがtrueで黒、falseで白
        System.out.println("石の位置を入力してください");

        //入力時に例外が発生する可能性があるのでtry catchを書く
        try {
        //縦の要素指定
        int tate = new java.util.Scanner(System.in).nextInt();
        //横の要素指定
        int yoko = new java.util.Scanner(System.in).nextInt();

        //入力された値が要素数の範囲内かどうかのif文
        if((tate>=0&&yoko>=0)&&(tate<BOARD_SIZE && yoko<BOARD_SIZE)) {
            
            //指定した位置がEMPTYの場合board内に定義されているメソッド（borad)を実行する
            if(Board.getPosition(tate, yoko)==EMPTY) {
                setTate(tate);
                setYoko(yoko);
                board.board(getTate(), getYoko(), stoneColor);
                setStoneSet(true);
            }

            //指定した位置にblackかwhiteがある場合
            else {
                setStoneSet(false);
                System.out.println("石が置かれていない場所を選択してください");
            }
        }

        //指定位置が要素数を超えている場合
        else {
            setStoneSet(false);
            System.out.println("0～"+(BOARD_SIZE-1)+"のどれかで入力してください");
        }
        }
        //整数以外の入力がされた場合
        catch(Exception e) {
            setStoneSet(false);
            System.out.println("整数で入力してください");
        }
    }

}
