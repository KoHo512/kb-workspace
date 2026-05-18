class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        answer = []

        n = len(nums)
        visited = [False] * n

        def permutations(cur):
            if len(cur) == n:
                answer.append(cur[:])
                return

            for idx in range(0, n):
                if not visited[idx]:
                    visited[idx] = True
                    cur.append(nums[idx])
                    permutations(cur)
                    visited[idx] = False
                    cur.pop()
        
        permutations([])

        return answer