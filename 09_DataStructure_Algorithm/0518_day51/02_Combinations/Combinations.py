class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        answer = []

        def combinations(cur, start):
            if len(cur) == k:
                answer.append(cur[:])
                return

            for num in range(start, n + 1):
                cur.append(num)
                combinations(cur, num + 1)
                cur.pop()

        combinations([], 1)

        return answer
