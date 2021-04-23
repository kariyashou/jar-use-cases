public class Board implements Teisuu{
    
    //盤面の二次元配列をnewする際に定数をあてることで定数を変更するだけで変更できる
    private static String[][] position = new String[BOARD_SIZE][BOARD_SIZE];
    
    //Positionのセッター
    public static void setPosition(int tate, int yoko, String stone) {
        position[tate][yoko] = stone;
    }

    //Positionのゲッター
    public static String getPosition(int tate, int yoko) {
        return position[tate][yoko];
    }

    //trueなら黒、falseなら白
    private Boolean stoneColor;
    //stonecolorのgetter
    public Boolean isStoneColor() {
        return stoneColor;
    }
    //stoneColorのsetter
    public void setStoneColor(Boolean stoneColor) {
        this.stoneColor = stoneColor;
    }

    public void firstShowBoard() {
        //碁盤の数字表示
        for(int i=0; i<BOARD_SIZE;i++) {
            if(i==(BOARD_SIZE-1)) {
                System.out.println(i);
                }
            else if(i==0) {
                System.out.print(" "+i+"|");
            }
            else {
                System.out.print(i + "|");
                }
                }
        for(int j=0; j<BOARD_SIZE; j++) {
            System.out.println(j);
        }

        //position配列のすべての座標に"□"を格納し
        //position参照時のnullを防ぐ
        for(int i=0; i<BOARD_SIZE;i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                setPosition(i,j,EMPTY);
                System.out.print(EMPTY);
            }
            System.out.println("");
        }
    }

    //碁盤作成メソッド
    public void board(int tate, int yoko, boolean stoneColor) {
        //stoneColorがtrueで黒,falseで白
        setStoneColor(stoneColor);

        for(int i=0; i<BOARD_SIZE; i++) {
            //盤面の縦のループ
            for(int j=0; j<BOARD_SIZE; j++) {
                //盤面の横のループ
                if((i==tate) && (j==yoko)) {
                    if(isStoneColor()) {
                        setPosition(tate,yoko,BLACK);
                        System.out.print(getPosition(tate,yoko));
                    }
                    else{
                        setPosition(tate,yoko,WHITE);
                        System.out.print(getPosition(tate,yoko));
                    }
                }
                else {
                    System.out.print(getPosition(i,j));
                }
            }
            System.out.println("");
        }
    }
}
