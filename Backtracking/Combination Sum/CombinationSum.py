from pprint import pprint
def combinationSum(candidates, target):
    """
    :type candidates: List[int]
    :type target: int
    :rtype: List[List[int]]
    """
    # candidates=[]
    dp = {}
    candidates.sort()
    for i in range(1,target+1):
        dp[i]=[]
        for candy in candidates:
            if candy>i:
                break
            # else:
            if i%candy==0:
                dp[i].append([candy]*(i//candy))
            else:
                for j in dp[i-candy]:
                    if j[-1]<=candy:
                        dp[i].append(j+[candy])
    pprint(dp)
    return dp[target]
    # return [x for z in dp[target] for x in [sorted(z)]]

print(combinationSum([2,3,7],18))
print("_________________________________________________________________")
print(combinationSum([2,3,6,7],7))
print("_________________________________________________________________")
print(combinationSum([2,3,5],8))
print("_________________________________________________________________")
print(combinationSum([2],1))
print("_________________________________________________________________")
print(combinationSum([8,7,4,3],11))


    