class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        visited = [False] * n

        def dfs(cur):
            visited[cur] = True

            for nxt in rooms[cur]:
                if not visited[nxt]:
                    dfs(nxt)
        
        visited[0] = True
        dfs(0)

        for v in visited:
            if not v:
                return False
        
        return True