package codeUp;

import java.io.IOException;
import java.util.Scanner;

public class Remote {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int now = sc.nextInt();
        int aim = sc.nextInt();
        int count = 0;

        while(gap(now,aim) != 0){
            int gap = gap(now,aim);
            count++;
            if(gap >= 8){
                aim -= 10;
            }else if(gap <= -8){
                aim += 10;
            }else if(gap >= 4){
                aim -= 5;
            }else if(gap <= -4){
                aim += 5;
            } else if (gap >= 1){
                aim -= 1;
            } else if (gap <= -1){
                aim += 1;
            }
        }
        System.out.println(count);
     }
    public static int gap(int now,int aim){
        return aim - now;
    }
}
