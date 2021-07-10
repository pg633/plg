1. [1 项目背景](#1-项目背景)
2. [2 项目内容](#2-项目内容)
3. [3 后续要做什么呢](#3-后续要做什么呢)
4. [4 stl 相关知识](#4-stl-相关知识)

# 1 项目背景
* 1 我也不知道什么时候能写完这个玩意 
# 2 项目内容
* 一些有的没的快速写代码的内容 

[content](/content)
[第一章](/content/C1.md)

# 3 后续要做什么呢

# 4 stl 相关知识 
vector 倍增2m 空间 m/4 缩容 
map 使用前用find 看看有没有
bitset ~s 对s 按位取反
    s.count() 看看有多少个1 
    所有位为0 时 any 返回false none = true
    至少有1位为 1 时，any 返回1 none 返回0 

    s.set() 所有位 =1 
    s.set(k,v) 把 k 置位为 v 
    s.reset s 所有位置位为0 
    s.reset(k) 把k 置位0
    s.flip() s全部取反 
    s.flip(k) 把k 取反 
    
algorithm 
    unique  去重 
        int m = unique(a.begin(),a.end()) -a.begin();
        int m = unique(a+1,a+m+1) - (a+1);
    random_shuffle 随机打乱 

    next_permutation 下一个排列 

        do{

        }while(next_permutation(a.begin(),a.end());

    sort 排序 
        sort(a.begin(),a.end() []( auto & l,auto & r){
            return l<r;
        });

随机数 
    int random(int n)
    {
        return rand()*rand() %n;
    }
    static{ 
        srand((unsigned)time(0));

    }


    c++ 写代码就是简洁啊 - 喜欢凤铃的pg633
dp 刷起来 空间不压缩 - 喜欢凤铃的pg633


int[][] dp = new int[m][n];
for (int i = 0; i < m; i++)
    for (int j = 0; j < n; j++)
        // 计算 dp[i][j]


for (int i = m - 1; i >= 0; i--)
    for (int j = n - 1; j >= 0; j--)
        // 计算 dp[i][j]

// 斜着遍历数组
for (int l = 2; l <= n; l++) {
    for (int i = 0; i <= n - l; i++) {
        int j = l + i - 1;
        // 计算 dp[i][j]
    }
}


// 二分搜索 


精确的 位运算 
    转小写
    ('a' | ' ') = 'a'
    转大写
    （'a' & '_') = 'A'
    大写转小写 
    （'a' ^ ' ') = 'A'
    判断是否异号
        int x = -1, y = 2;
        bool f = ((x ^ y) < 0); // true
    交换两个数 
        a ^= b;
        b ^= a;
        a ^= b;
    +1 
        n = -~n;
    -1 
        n = ~-n;
    
    消除最后一个1 
        n & (n-1)



hive  to mysql
mysql -> mysql 


