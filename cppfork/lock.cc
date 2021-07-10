#include <iostream>
#include <thread>
#include <mutex>

std::mutex g_my_mutex;
int gi = 1111;
std::lock_guard<std::mutex> make_lock() {
    return std::lock_guard<std::mutex>(g_my_mutex);
}

void workOnResource1() {

    for (int i = 0; i < 10000; ++i)
    {
        std::lock_guard<std::mutex> lk(g_my_mutex);
        --gi;
    }
}

void workOnResource2() {

    for (int i = 0; i < 10000; ++i)
    {
        auto lk = make_lock();
        ++gi;
    }
}

int main() {

    std::thread t1(workOnResource1);
    std::thread t2(workOnResource2);

    t1.join();
    t2.join();

    std::cout << "gi=" <<gi;
    return 0;
}