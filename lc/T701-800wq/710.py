class Solution:
    def __init__(self, N, blacklist):
        # self.line = N - len(blacklist)
        # self.dic = dict(zip(
        #     {i for i in blacklist if i <self.line},
        #     {*range(self.line,N)}-set(blacklist)
        #     ))

        self.s = N  - len(blacklist)
        b_lt_s = {i for i in blacklist if i < self.s}
        w_dt_s = {*range(self.s,N)} - set(blacklist)
        self.m = dict(zip(b_lt_s, w_dt_s))

    def pick(self):
        import random
        r = random.randint(0,self.s-1)
        return r if r not in self.m else self.m[r]
