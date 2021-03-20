class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        nlist = []
        for n in asteroids:
            while nlist and nlist[-1] > 0 and nlist[-1] + n < 0:
                nlist.pop()
            if not nlist or nlist[-1] < 0 or n > 0:
                nlist.append(n)
            elif n < 0 and nlist[-1] + n == 0:
                nlist.pop()
        return nlist