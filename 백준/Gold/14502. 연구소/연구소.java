import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{

    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int maxSafeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    //벽을 세개 세우는 모든 경우의 수 ---> dfs
    public static void dfs(int wallCnt) {
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    //상하좌우로 바이러스 전파 시킴 ---> bfs
    public static void bfs() {

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    q.offer(new Point(i, j));
                }
            }
        }

        copyMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            int r = p.x;
            int c = p.y;

            for(int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if(copyMap[nr][nc] == 0) { //0이면 바이러스 퍼트림
                        q.add(new Point(nr, nc));
                        copyMap[nr][nc] = 2;
                    }
                }
            }
        }

        funcSafeZone(copyMap);

    }

    public static void funcSafeZone(int[][] copyMap) {
        int safeZone = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if(maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }
}


