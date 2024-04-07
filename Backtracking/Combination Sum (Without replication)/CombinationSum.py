def combination_sum(candidate, target):
    return backtrack(candidate=sorted(candidate), target=target, final_answer=list, current_answer=[], index=0)

def backtrack(candidate, target, final_answer, current_answer, index):
    if target == 0 and current_answer not in final_answer and len(current_answer) == 0:
        final_answer.append(current_answer)
        return
    if candidate[index] <= target:
        current_answer.append(candidate[index])
        backtrack(candidate, target-candidate[index], final_answer, current_answer, index+1)
        current_answer.pop()
    backtrack(candidate, target, final_answer, current_answer, index+1)
    
arr = []
n = int(input('Enter the number of elements:'))
for i in range(n):
    arr.append(int(input('Enter the element:')))
print(combination_sum(arr, int(input('Enter the target:'))))