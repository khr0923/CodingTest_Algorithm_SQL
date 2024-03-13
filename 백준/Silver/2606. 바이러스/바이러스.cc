#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int N, M, Graph[101][101];
int Vr, Vc;
int visited[101] = { false };

int BFS(int node) {
	queue<int> queue;
	queue.push(node);
	visited[node] = true;
	int count = 0;

	while (!queue.empty()) {
		int cur = queue.front();
		queue.pop();

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && Graph[cur][i]) {
				queue.push(i);
				visited[i] = true;
				count++;
			}
		}
	}

	return count;
}

int main() {
	cin >> N;
	cin >> M;
	memset(Graph, 0, sizeof(Graph));

	for (int i = 1; i <= M; i++) {
		cin >> Vr >> Vc;
		Graph[Vr][Vc] = Graph[Vc][Vr] = true;
	}	

	cout << BFS(1);

	return 0;
}