#include <iostream>
#include <semaphore.h>
#include <mutex>
#include <functional>
#include <thread>
#include <list>
#include <bits/stdc++.h>
using namespace std;

class c_v
{
private:
    int count = 1;
    mutex mx;
    condition_variable cv;

public:
    void getA()
    {
        count++;
        cv.notify_all();
    }
    void getB()
    {
        unique_lock<mutex> lk(mx);
        cv.wait(lk, [this]() { return count == 2; });
        cout << "int b" << endl;
    }
};

// class Foo
// {
// public:
//     mutex m1;
//     int count = 1;
//     condition_variable cv;
//     Foo()
//     {
//     }

//     void first(function<void()> printFirst)
//     {
//         // unique_lock<mutex> lk (m1);
//         // cv.wait(lk,[this](){return count==1;});
//         // printFirst() outputs "first". Do not change or remove this line.
//         printFirst();
//         count++;
//         cv.notify_all();
//     }

//     void second(function<void()> printSecond)
//     {
//         unique_lock<mutex> lk(m1);
//         cv.wait(lk, [this]() { return count == 2; });
//         // printSecond() outputs "second". Do not change or remove this line.
//         printSecond();
//         count++;
//         cv.notify_all();
//     }

//     void third(function<void()> printThird)
//     {
//         unique_lock<mutex> lk(m1);
//         cv.wait(lk, [this]() { return count == 3; });
//         // printThird() outputs "third". Do not change or remove this line.
//         printThird();
//     }
// };
class A
{
public:
    void input()
    {
        for (int i = 0; i < 10; i++)
        {
            // lock_guard<mutex>l guard(my_mutex);
            unique_lock<mutex> my_lock(my_mutex); //构造时自动lock
            ilst.push_back(i);
            my_lock.unlock(); //在生命周期结束前提前unlock,为其他线程执行争取时间
            cout << "加入数据：" << i << endl;
            my_lock.lock(); //在需要时又重新上锁

            //do something with my_mutex

        } //生命周期结束，自动在析构函数中unlock
    }

    void output()
    {
        for (int i = 0; i < 10; i++)
        {
            // lock_guard<mutex> guard(my_mutex);
            unique_lock<mutex> my_lock(my_mutex);
            if (!ilst.empty())
            {
                cout << "读读读读出数据：" << ilst.front() << endl;
                ilst.pop_front();
            }
        }
    }

private:
    list<int> ilst;
    mutex my_mutex;
};

class Foo
{
private:
    mutex mx;
    condition_variable cv;
    int count = 0;
    void notify_nxt()
    {
        ++count;
        cv.notify_all();
    }

public:
    Foo()
    {
    }

    void first(function<void()> printFirst)
    {

        // printFirst() outputs "first". Do not change or remove this line.
        printFirst();
        notify_nxt();
    }

    void second(function<void()> printSecond)
    {
        unique_lock<mutex> lk(mx);
        cv.wait(lk, [&] { return count == 1; });
        // printSecond() outputs "second". Do not change or remove this line.
        printSecond();
        notify_nxt();
    }

    void third(function<void()> printThird)
    {
        unique_lock<mutex> lk(mx);
        cv.wait(lk, [&] { return count == 2; });
        // printThird() outputs "third". Do not change or remove this line.
        printThird();
        notify_nxt();
    }
};

class FooBar
{
private:
    int n;
    mutex mx;
    condition_variable cv;
    bool is_foo = true;

public:
    FooBar(int n)
    {
        this->n = n;
    }

    void foo(function<void()> printFoo)
    {

        for (int i = 0; i < n; i++)
        {
            unique_lock<mutex> lk(mx);
            // printFoo() outputs "foo". Do not change or remove this line.
            printFoo();
        }
    }

    void bar(function<void()> printBar)
    {

        for (int i = 0; i < n; i++)
        {

            // printBar() outputs "bar". Do not change or remove this line.
            printBar();
        }
    }
};

class Solution
{
public:
    vector<int> avoidFlood(vector<int> &rains)
    {
        set<int> zero;
        vector<int> res(rains.size(), 1);
        map<int, int> m;

        for (int i = 0; i < rains.size(); i++)
        {
            if (rains[i] == 0)
            {
                zero.insert(i);
            }
            else
            {
                auto it = m.find(rains[i]);
                if (it == m.end())
                {
                    m[rains[i]] = i;
                }
                else
                {
                    auto itk = zero.lower_bound(m[rains[i]]);
                    if (itk == zero.end())
                        return {};
                    else
                    {
                        res[*itk] = rains[i];
                        zero.erase(itk);
                        m[rains[i]] = i;
                    }
                }
                res[i] = -1;
            }
        }
        return res;
    }
};

class ZeroEvenOdd
{
private:
    int n;
    bool stop;
    int i;
    mutex mx;
    condition_variable cv0, cv1;

public:
    ZeroEvenOdd(int n)
    {
        this->n = n;
        i = 1;
        stop = false;
    }

    // printNumber(x) outputs "x", where x is an integer.
    void zero(function<void(int)> printNumber)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            printNumber(0);
            cv1.notify_all();
            cv0.wait(lk);
        }
        stop = true;
        cv1.notify_all();
    }

    void even(function<void(int)> printNumber)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            cv1.wait(lk, [&]() { return i % 2 == 0; });
            if (!stop)
            {
                printNumber(i);
            }

            ++i;
            cv0.notify_one();
        }
    }

    void odd(function<void(int)> printNumber)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            cv1.wait(lk, [&]() { return i % 2 == 1; });
            if (!stop)
            {
                printNumber(i);
            }

            ++i;
            cv0.notify_one();
        }
    }
};

class H2O
{
public:
    H2O()
    {
    }

    void hydrogen(function<void()> releaseHydrogen)
    {
        unique_lock<mutex> lk(mx);
        cv.wait(lk, [&]() { return h < 2; });
        h++;
        if (h + o == 3)
        {
            h = 0;
            o = 0;
        }
        // releaseHydrogen() outputs "H". Do not change or remove this line.
        releaseHydrogen();
        cv.notify_all();
    }

    void oxygen(function<void()> releaseOxygen)
    {
        unique_lock<mutex> lk(mx);
        cv.wait(lk, [&]() { return o < 1; });
        o++;
        if (h + o == 3)
        {
            h = 0;
            o = 0;
        }
        // releaseOxygen() outputs "O". Do not change or remove this line.
        releaseOxygen();
        cv.notify_all();
    }

private:
    mutex mx;
    condition_variable cv;
    int h = 0;
    int o = 0;
};

class FizzBuzz3
{
private:
    int n;
    int i;
    mutex mx;
    condition_variable cv;

public:
    FizzBuzz3(int n)
    {
        this->n = n;
        i = 1;
    }

    // printFizz() outputs "fizz".
    void fizz(function<void()> printFizz)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            cv.wait(lk, [&]() { return i > n || i % 3 == 0 && i % 5 != 0; });
            if (n < i)
                break;
            printFizz();
            ++i;
            cv.notify_all();
        }
    }

    // printBuzz() outputs "buzz".
    void buzz(function<void()> printBuzz)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            cv.wait(lk, [&]() { return i > n || i % 5 == 0 && i % 3 != 0; });
            if (n < i)
                break;
            printBuzz();
            ++i;
            cv.notify_all();
        }
    }

    // printFizzBuzz() outputs "fizzbuzz".
    void fizzbuzz(function<void()> printFizzBuzz)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            cv.wait(lk, [&]() { return i > n || i % 5 == 0 && i % 3 == 0; });
            if (n < i)

                break;
            printFizzBuzz();
            ++i;
            cv.notify_all();
        }
    }

    // printNumber(x) outputs "x", where x is an integer.
    void number(function<void(int)> printNumber)
    {
        while (i <= n)
        {
            unique_lock<mutex> lk(mx);
            cv.wait(lk, [&]() { return i > n || i % 5 != 0 && i % 3 != 0; });
            if (n < i)
            {
                break;
            }
            printNumber(i);
            ++i;
            cv.notify_all();
        }
    }
};

class FizzBuzz
{
private:
    int n;
    int i;
    enum class status
    {
        NUM,
        FIZZ,
        BUZZ,

    };
    atomic<status> s;
    status get(int i)
    {
        ++i;
        if (i % 3 == 0 && i % 15 != 0)
            return status::FIZZ;
        else if (i % 5 == 0 && i % 15 != 0)
            return status::BUZZ;
        else if (i % 15 == 0)
            return status::FIZZBUZZ;
        else
            return status::NUM;
    }

public:
    FizzBuzz(int n)
    {
        this->n = n;
        i = 1;
        s.store(status::NUM, memory_order_relaxed);
    }

    // printFizz() outputs "fizz".
    void fizz(function<void()> printFizz)
    {
        while (i <= n)
        {
            if (s.load(memory_order_relaxed) == status::FIZZ)
            {
                printFizz();
                s.store(get(i++), memory_order_relaxed);
            }
            this_thread::yield();
        }
    }

    // printBuzz() outputs "buzz".
    void buzz(function<void()> printBuzz)
    {
        while (i <= n)
        {
            if (s.load(memory_order_relaxed) == status::BUZZ)
            {
                printBuzz();
                s.store(get(i++), memory_order_relaxed);
            }
            this_thread::yield();
        }
    }

    // printFizzBuzz() outputs "fizzbuzz".
    void fizzbuzz(function<void()> printFizzBuzz)
    {
        while (i <= n)
        {
            if (s.load(memory_order_relaxed) == status::FIZZBUZZ)
            {
                printFizzBuzz();
                s.store(get(i++), memory_order_relaxed);
            }
            this_thread::yield();
        }
    }

    // printNumber(x) outputs "x", where x is an integer.
    void number(function<void(int)> printNumber)
    {
        while (i <= n)
        {
            if (s.load(memory_order_relaxed) == status::NUM)
            {
                printNumber(i);
                s.store(get(i++), memory_order_relaxed);
            }
            this_thread::yield();
        }
    }
};

class DiningPhilosophers
{
public:
    DiningPhilosophers()
    {
    }

    void wantsToEat(int id,
                    function<void()> pickLeftFork,
                    function<void()> pickRightFork,
                    function<void()> eat,
                    function<void()> putLeftFork,
                    function<void()> putRightFork)
    {
        scoped_lock lock(v[id], v[(id + 1) % 5]);

        pickLeftFork();
        pickRightFork();
        eat();
        putLeftFork();
        putRightFork();
    }

private:
    vector<mutex> v = vector<mutex>(5);
};

int main()
{
    // c_v m;
    // m.getA();

    // A a;
    // thread t1(&A::input, &a);
    // thread t2(&A::output, &a);
    // t1.join();
    // t2.join();
}
