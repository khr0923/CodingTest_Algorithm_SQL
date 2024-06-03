def dfs(numbers, idx, values, target):
    global cnt
    if(idx == len(numbers) and values == target):
        cnt += 1
        return
    elif(idx == len(numbers)):
        return

    dfs(numbers, idx+1, values + numbers[idx], target)
    dfs(numbers, idx+1, values - numbers[idx], target)
def solution(numbers, target):
    global cnt
    cnt = 0
    dfs(numbers, 0, 0, target)
    return cnt