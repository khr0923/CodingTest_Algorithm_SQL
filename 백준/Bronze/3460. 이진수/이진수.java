import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.next());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(sc.next());
            int cnt = -1;

                while(n > 0) {
                    cnt++;
                    if(n % 2 == 1){
                        System.out.print(cnt);
                        System.out.print(" ");
                    }
                    n = n / 2;

                }
        }


    }
}
