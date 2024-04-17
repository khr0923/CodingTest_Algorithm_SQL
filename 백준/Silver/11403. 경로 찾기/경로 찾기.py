import sys

INF = int(1e9)
N = int(sys.stdin.readline())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

for k in range(N):
    for a in range(N):
        for b in range(N):
            if(graph[a][k] == 1 and graph[k][b] == 1):
                graph[a][b] = 1

for i in range(N):
    for j in range(N):
        print(graph[i][j], end=" ")
    print()