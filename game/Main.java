import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Ship ship3 = new Ship();
        ship1.Move();
        ship2.Move();
        ship3.Move();
        int turn=1;
        while(ship1.lp!=0||ship2.lp!=0||ship3.lp!=0){
        System.out.println("=====第"+turn+"回=====");
        turn++;
        showStatus(ship1.lp,ship2.lp,ship3.lp);
        System.out.println("Xを入力ください");
        int x=sc.nextInt();
        System.out.println("Yを入力ください");
        int y=sc.nextInt();
        System.out.print("船1:");
        ship1.checkAttack(x, y);
        System.out.print("船2:");
        ship2.checkAttack(x, y);
        System.out.print("船3:");
        ship3.checkAttack(x, y);
        }
        System.out.println("おめでとうございます");
    }

    public static class Ship {
        int lp=3;
        int x=0;
        int y=0;
        public void Move(){
            this.x=(int)(Math.random()*5)+1;
            //System.out.println(this.x);
            this.y=(int)(Math.random()*5)+1;
            //System.out.println(this.y);
        }
        public void checkAttack(int a,int b){
        if(a==this.x&&b==this.y){
            System.out.println("命中しました");
            this.lp--;
            if(this.lp>0){
                this.Move();
                System.out.println("船を逃げました");
            }
        }else if((this.x==a&&((this.y-1)==b||(this.y+1)==b))||(this.y==b&&((this.x-1)==a||(this.x+1)==a))){
            System.out.println("波高し");
        }else{
            System.out.println("外れ");
        }
        }
    }
    
    public static void showStatus(int a,int b,int c) {
        if(a>0){
            System.out.println("船1：生きてる");
        }else{
            System.out.println("船1：沈む");
        }
        if(b>0){
            System.out.println("船2：生きてる");
        }else{
            System.out.println("船2：沈む");
        }
        if(c>0){
            System.out.println("船3：生きてる");
        }
        else{
            System.out.println("船3：沈む");
        }
        
    }
    

}
