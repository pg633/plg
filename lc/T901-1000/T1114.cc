#include <semaphore.h>

class Foo
{
public:
    sem_t sem_1, sem_2, sem_3;

    Foo()
    {
        sem_init(&sem_1, 0, 1);
        sem_init(&sem_2, 0, 0);
        sem_init(&sem_3, 0, 0);
    }

    void first(function<void()> printFirst)
    {
        // printFirst() outputs "first". Do not change or remove this line.
        sem_wait(&sem_1);
        printFirst();
        sem_post(&sem_2);
    }

    void second(function<void()> printSecond)
    {
        sem_wait(&sem_2);
        printSecond();
        sem_post(&sem_3);
        // printSecond() outputs "second". Do not change or remove this line.
    }

    void third(function<void()> printThird)
    {
        sem_wait(&sem_3);
        // printThird() outputs "third". Do not change or remove this line.
        printThird();
    }
};