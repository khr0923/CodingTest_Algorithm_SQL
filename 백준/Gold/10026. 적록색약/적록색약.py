import sys
from collections import deque

N = int(input())
graph = [list(input()) for _ in range(N)]
queue = deque()


def bfs(r, c):
    queue.append((r, c))
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    visited[r][c] = 1

    while queue:
        r, c = queue.popleft()
    

        for i in range(4):
            nr = r + dx[i]
            nc = c + dy[i]

            if 0 <= nr < N and 0 <= nc < N and graph[nr][nc] == graph[r][c] and not visited[nr][nc]:
                queue.append((nr, nc))
                visited[nr][nc] = 1

visited = [[0] * N for _ in range(N)]
cnt1 = 0
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(i, j)
            cnt1 += 1


for i in range(N):
    for j in range(N):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

visited = [[0] * N for _ in range(N)]
cnt2 = 0
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(i, j)
            cnt2 += 1

print(cnt1, cnt2)