



累加 (std::accumulate)
    accumulate(begin, end, init, op)

    返回给定区间内元素的累加值与给定初值的和，初值不可省略
        可指定求和运算，默认为std::plus
        vector<int>vec = {1, 2, 3, 4};
        cout<<accumulate(vec.begin(), vec.end(), 0); 
        //累加, 输出: 10
        cout<<accumulate(vec.begin(), vec.end(), 1, bit_xor<int>());
        //异或和，输出: 5
        运算操作函数对象见 functional 头文件，常用如下
        函数对象	含义
        multiplies	乘法
        bit_xor	按位异或
        bit_and	按位与
​

前缀和 (std::partial_sum)
    partial_sum(begin, end, res)

        计算给定区间的前缀和，存入res （iterator）中，可以直接存入原容器

        int a[5] = {1, 2, 3, 4, 5};
        partial_sum(a, a+5, a); 
        // a : {1, 3, 6, 10, 15}
        ​

        递增填充 (std::iota)
        iota(begin, end, value)

        递增填充给定区间，即

        *(d_first)   = value;
        *(d_first+1) = ++value;
        ...
        示例：

        vector<int>vec;
        vec.resize(10);
        iota(vec.begin(), vec.end(), 0);
        //vec: {0, 1, 2, ..., 9}
        ​

定值填充 (std::fill)
    fill(begin, end, val)

    填充给定区间为val

    fill_n(begin, n, val)

    指定区间起点和长度

    ​

    生成值填充 (std::generate)
    generate(begin, end, func)
    generate_n(begin, n, func)
    使用函数生成给定区间的值

    int a[10];
    generate(a, a+5, read);
    其中 read 函数可以为

    int read(){
        int ret;
        scanf("%d", &ret);
        return ret;
    }
 

逐元素函数操作 (std::for_each)
    for_each(begin, end, func)

        对区间内的元素执行一元函数 func

        int a[5] = {1, 2, 3, 4, 5};
        for_each(a, a+5, [](int &x){ x&=1; });
        //a : {1, 0, 1, 0, 1}
        感觉非常有用，配合 lambda 比写 for 循环舒服多了，应用场景非常广泛

        ​

逐元素函数计算 (std::transform)
    transform(begin, end, res, func)

    对区间内的元素执行一元函数 func ，将返回值存到 res （也是 iterator）中

        可以直接存入原容器

        int a[5] = {1, 2, 3, 4, 5};
        transform(a, a+5, a, [](int x) { return __gcd(x, 2); });
        //a : {1, 2, 1, 2, 1}
        ​

计数与条件计数 (std::count & std::count_if)
    count(begin, end, value)


计数区间内值为 value 的元素个数
    count_if(begin, end, func)

        计数区间内满足条件的元素个数，func 为一元谓词
        int a[5] = {1, -1, 2, -2, 3};
        cout<<count(a, a+5, 2); 
        //输出 : 1
        cout<<count_if(a, a+5, [](int x) { return x>0; });
        //输出 : 3
        ​




数值运算小库 numeric
    accumulate 求和
    iota 填充元素依次相加
    reduce mmp 没试出来
    inner_product 两个依次想乘
    adjacent_difference 判断两个之间的差
    partial_sum 前缀和
    gcd/lcm  板子... 


