import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.next());
        int K = Integer.parseInt(sc.next());
        int cnt = 0; int result = 0;

        for(int i = 1; i <= N; i++) {
            if(N % i == 0) {
                cnt++;
                if(cnt == K) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);

    }
}
