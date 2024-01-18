#include <iostream>
#include <stack>
#include <cstring>

using namespace std;

struct Point {
	int row, col;
};

int T, M, N, K;
int Map[51][51];
int visited[51][51] = { false };
int D[4][2] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };


void DFS(int row, int col) {
	stack<Point> stack;
	stack.push({ row, col });

	while (!stack.empty()) {
		Point cur = stack.top();
		stack.pop();

		visited[cur.row][cur.col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = cur.row + D[i][0], nc = cur.col + D[i][1];
			
			if (nr < 0 || nr > M - 1 || nc < 0 || nc > N - 1) continue;
			if (Map[nr][nc] == 0) continue;
			if (visited[nr][nc]) continue;

			stack.push({ nr, nc });
		}
	}
}


int main() {
	cin >> T;

	for (int i = 0; i < T; i++) {
		int cnt = 0;
		cin >> M >> N >> K;

		for (int j = 0; j < K; j++) {
			int X, Y;
			cin >> X >> Y;
			Map[X][Y] = 1;
		}

		for (int mi = 0; mi < M; mi++) {
			for (int nj = 0; nj < N; nj++) {

				if (!visited[mi][nj] && Map[mi][nj] == 1) {
					DFS(mi, nj);
					cnt++;
				}
			}
		}
		cout << cnt << '\n';

		memset(Map, 0, sizeof(Map));
		memset(visited, false, sizeof(visited));
	}
}