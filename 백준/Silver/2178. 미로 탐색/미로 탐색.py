import sys
from collections import deque

N, M = map(int, input().split())
graph = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]
dir = [[1, 0], [-1, 0], [0, -1], [0, 1]]
visited = [[False] * M for _ in range(N)]


def bfs(startR, startC):
    queue = deque()
    queue.append((startR, startC, 1))
    visited[startR][startC] = True

    while queue:
        r, c, d = queue.popleft()

        if r == N-1 and c == M-1:
            print(d)
            break

        for i in range(4):
            nr = r + dir[i][0]
            nc = c + dir[i][1]

            if nr < 0 or nr > N-1 or nc < 0 or nc > M-1: continue
            if visited[nr][nc] == True: continue
            if graph[nr][nc] == 0: continue

            queue.append((nr, nc, d+1))
            visited[nr][nc] = True


bfs(0, 0)