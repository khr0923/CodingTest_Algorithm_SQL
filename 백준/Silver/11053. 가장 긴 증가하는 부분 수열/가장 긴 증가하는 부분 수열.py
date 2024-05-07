import sys
N = int(sys.stdin.readline())
lst = [0] + list(map(int, sys.stdin.readline().split()))
dp = [0] * (N+1) #dp 테이블 생성 및 초기화

for i in range(1, N+1):
    mx = 0
    for j in range(0, i):
        if(lst[i] > lst[j]): #0 ~ i-1 중에서 max 값(나보다 작은 값 중)
            mx = max(mx, dp[j])
    dp[i] = mx + 1

#중간에 최대값이 있을 수 있으므로 max 찾아야 함
print(max(dp))
