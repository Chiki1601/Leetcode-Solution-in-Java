class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        if k == 0:
            return sum(reward2)
        difference = [reward1[i] - reward2[i] for i in range(len(reward1))]
        sorted_diff = sorted(difference, reverse=True)
        max_diff = sorted_diff[:k][-1]
        skip = sorted_diff[k:].count(max_diff)
        i, j, res = 0, 0, 0
        while i < len(reward1):
            if j == k:
                res += reward2[i]
            elif difference[i] == max_diff and skip > 0:
                res += reward2[i]
                skip -= 1
            elif difference[i] >= max_diff:
                res += difference[i] + reward2[i]
                j += 1
            else:
                res += reward2[i]
            i += 1
        return res
