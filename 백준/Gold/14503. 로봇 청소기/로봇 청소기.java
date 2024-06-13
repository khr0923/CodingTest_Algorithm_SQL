import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r, c, d;
    static int[][] map;
    static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
    //북쪽(0) -> 서쪽(3), 동쪽(1) -> 북쪽(0), 남쪽(2)-> 동쪽(1), 서쪽(3) -> 남쪽(2)
    static int count = 1; //시작 부분은 항상 청소 되어있지 않으므로 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int robot_d) {
        map[x][y] = -1; //현재 위치 청소 완료 표시

        for(int i = 0; i < 4; i++) { //현재위치의 주변 4방향 재귀함수를 돌며 모두 청소
            robot_d = (robot_d+3)%4;

            int nr = x + dir[robot_d][0];
            int nc = y + dir[robot_d][1];

            if(0 <= nr && nr < N && 0 <= nc && nc < M) {
                if(map[nr][nc] == 0) {
                    count++;
                    clean(nr, nc, robot_d);
                    return;
                }
            }
        }

        int d = (robot_d+2)%4; //후진
        int br = x + dir[d][0];
        int bc = y + dir[d][1];

        if(0 <= br && br < N && 0 <= bc && bc < M && map[br][bc] != 1) {
            clean(br, bc, robot_d); //바라보는 방향을 유지한채 후진
        }
    }
}
