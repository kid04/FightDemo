import java.util.Scanner;

public class FightDemo {
    public static void ability(int[] wizard, int[] target, int spell){ // способности персонажей и их цели



    }
    public static void ai(int[] hero, int[][] t1, int[][] t2){


    }





    public static String name(int chara){
        String n = "Герой";
        return n;
    }







    public static int speed(int chara){ //скорость персонажей - определяет очерёдность хода в бою
        int sp = 2;
        return sp;
    }







    public static boolean fight(int[][] t1, int[][] t2){ // собсна, бой
        Scanner in = new Scanner(System.in);
        boolean t1d = false;
        boolean t2d = false; //Вводим переменные, не мертвы ли наши команды(Считается, что изначально нет)
        int[] t1h1 = new int[2];
        int[] t1h2 = new int[2];
        int[] t1h3 = new int[2];
        int[] t2h1 = new int[2];
        int[] t2h2 = new int[2];
        int[] t2h3 = new int[2];
        int[] t2h4 = new int[2];
        if(t1[0][0]>0){t1h1[0] = t1[0][0]; t1h1[1] = t1[0][1]; }
        if(t1[1][0]>0){t1h2[0] = t1[1][0]; t1h2[1] = t1[1][1]; }
        if(t1[2][0]>0){t1h3[0] = t1[2][0]; t1h3[1] = t1[2][1]; }
        if(t2[0][0]>0){t2h1[0] = t1[0][0]; t2h1[1] = t2[0][1]; }
        if(t2[1][0]>0){t2h2[0] = t1[1][0]; t2h2[1] = t2[1][1]; }
        if(t2[2][0]>0){t2h3[0] = t1[2][0]; t2h3[1] = t2[2][1]; }
        if(t2[3][0]>0){t2h4[0] = t1[3][0]; t2h4[1] = t2[3][1]; } //создаём массив для каждого героя, говорящего его здоровье и кто он по жизни

        int[][] acthero = new int[7][2];
        acthero[0] = t1h1;
        acthero[1] = t1h2;
        acthero[2] = t1h3;
        acthero[3] = t2h1;
        acthero[4] = t2h2;
        acthero[5] = t2h3;
        acthero[6] = t2h4;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(speed(acthero[j][0]) < speed(acthero[j+1][0])){
                    int[] t = acthero[j];
                    acthero[j] = acthero[j+1];
                    acthero[j+1] = t;
                }
            }
        }
//Тут мы считали очерёдность хода. В принципе, этого достаточно, чтобы начать бой 
        do{
            for(int i = 0; i<7; i++){
                if(acthero[i][0]>0 && acthero[i][1]>0){
                    if(acthero[i][0]<4){
                        System.out.println("Какую способность "+name(acthero[i][0])+" использует?");
                        int spell = in.nextInt();
                        System.out.println("На кого?");
                        int target = in.nextInt();
                        ability(acthero[i],t2[target],spell);
                    }else{
                        ai(acthero[i],t1,t2);
                    }

                }

            }




        }while (!t1d && !t2d);





        if(t1d){return false;}else{return true;}
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);



    }
}