public class FightDemo {
    public static void ability(int[][] wizard, int[][] target){ // способности персонажей и их цели



    }







    public static int speed(int chara){ //скорость персонажей - определяет очерёдность хода в бою
        int sp = 2;
        return sp;
    }







    public static boolean fight(int[][] t1, int[][] t2){ // собсна, бой
        boolean t1d = false;
        boolean t2d = false; //Вводим переменные, не мертвы ли наши команды(Считается, что изначально нет)
        int[] t1h1 = new int[2];
        int[] t1h2 = new int[2];
        int[] t1h3 = new int[2];
        int[] t2h1 = new int[2];
        int[] t2h2 = new int[2];
        int[] t2h3 = new int[2];
        int[] t2h4 = new int[2];
        







        int[] acthero = new int[7];
        for(int i = 0; i<3; i++){
        if(t1[i][0] > 0){
            acthero[i] = t1[i][1];}
            if(t2[i][0] > 0){
                acthero[6-i] = t2[i][1];}
        }
        acthero[3] = t2[3][1];
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(speed(acthero[j]) < speed(acthero[j+1])){
                    int t = acthero[j];
                    acthero[j] = acthero[j+1];
                    acthero[j+1] = t;
                }
            }
        }
                       //Тут мы считали очерёдность хода. В принципе, этого достаточно, чтобы начать бой





    if(t1d){return false;}else{return true;}
    }
    public static void main(String[] args){




    }
}
