class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        parent = list(range(26))  # Union-Find for 26 lowercase letters

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            px = find(x)
            py = find(y)
            if px != py:
                # Always keep the smaller one as parent
                if px < py:
                    parent[py] = px
                else:
                    parent[px] = py

        # Build equivalence classes
        for a, b in zip(s1, s2):
            union(ord(a) - ord('a'), ord(b) - ord('a'))

        # Transform baseStr
        result = []
        for ch in baseStr:
            root = find(ord(ch) - ord('a'))
            result.append(chr(root + ord('a')))

        return ''.join(result)
