import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int[] arr = new int[N];
        int temp = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }

//        for(int i = 0; i < N-1; i++) {
//            for(int j = i+1; j < N; j++) {
//                if(arr[i] > arr[j]) {
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        sort(arr);

        System.out.println(arr[0] + " " + arr[N-1]);
    }
}
