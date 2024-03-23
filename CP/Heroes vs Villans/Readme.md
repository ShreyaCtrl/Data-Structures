## Problem Description

In this scenario, there's a battle between heroes and villains. You have a certain number of heroes, each with the same health. There are also villains with varying health values. The battle proceeds in a specific order, with each hero fighting villains one by one.

1. **Battles and Outcomes**:
    - When a hero with health H battles a villain with health VI:
        - If H > VI, the villain is defeated, and the hero's health decreases by VI.
        - If H < VI, the villain wins, and neither the villain's health nor the hero's health changes.
        - If H = VI, both the hero and the villain are considered defeated, and neither can fight.

2. **Objective**:
   Your task is to ensure the victory of all heroes by removing some villains from the front of the battle sequence. You need to find the minimum number of villains you must remove from the front so that all heroes can defeat the remaining villains and emerge victorious.

3. **Input Parameters**:
    - `M`: Number of heroes.
    - `H`: Health of each hero.
    - `N`: Number of villains.
    - `V`: List of integers representing the health of each villain.

4. **Approach**:
    - You start by iterating through the battle sequence, where each hero fights villains one by one.
    - For each hero, you check if their health is sufficient to defeat the current villain. If yes, the hero defeats the villain, and the hero's health decreases accordingly.
    - If the hero's health is not enough to defeat the villain, you remove that villain from the battle sequence and continue with the next hero.
    - Repeat this process until either all heroes are defeated or all villains are defeated. Note that if the last battle results in both the hero and villain being defeated, it's still considered a victory since all villains are defeated.

5. **Output**:
   Your function should return the minimum number of villains that need to be removed from the front of the battle sequence to ensure the victory of all heroes.

6. **Example**:
    - Input: M = 3 (heroes), H = 4 (hero health), N = 5 (villains), V = [4, 3, 2, 5, 1] (villain health)
    - Output: 2 (minimum villains to remove for hero victory)

7. **Doubt**:
   - What about the case when some villan has health more than the hero ?
   - Moreover, what if the villan with greater health than hero has been placed at end ?

This problem involves strategy and optimization, as you want to minimize the number of villains removed while ensuring hero victory. The provided Java code snippet implements a solution based on this approach, where heroes battle villains sequentially, and the necessary adjustments are made to guarantee hero victories.