import sys
from collections import deque

T = int(sys.stdin.readline())
dir = [[1, 0], [-1, 0], [0, -1], [0, 1]]

def bfs(r, c):
    queue = deque()
    queue.append((r, c))

    if graph[r][c] == 0: return False

    while queue:
        r, c = queue.popleft()
        graph[r][c] = 0

        for i in range(4):
            nr = r + dir[i][0]
            nc = c + dir[i][1]

            if 0 <= nr < N and 0 <= nc < M and graph[nr][nc] == 1:
                graph[nr][nc] = 0
                queue.append((nr, nc))
    return True

for t in range(T):
    cnt = 0
    N, M, K = map(int, sys.stdin.readline().split())

    graph = [[0] * M for _ in range(N)]

    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        graph[X][Y] = 1

    for i in range(N):
        for j in range(M):
            if bfs(i, j) == True:
                cnt += 1
    print(cnt)