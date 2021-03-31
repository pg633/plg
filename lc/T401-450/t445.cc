
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        int count = 0, temp;
        ListNode *head, *last;
        for (head = l1; head; head = head->next)
            count++;
        for (head = l2; head; head = head->next)
            count--;
        if (count < 0) //计算两链表长度，将l1指向长链，l2指向短链，将l2的值加到l1中
            swap(l1, l2);

        last = head = new ListNode(0); //在链首加一个值为0的节点作为初始的last节点，如果最终该节点值仍为0则删除该节点
        head->next = l1;
        for (int i = abs(count); i != 0; i--)
        { //将两链数位对齐
            if (l1->val != 9)
                last = l1;
            l1 = l1->next;
        }

        
        while (l1)
        {
            temp = l1->val + l2->val;
            if (temp > 9)
            {               //如果发生进位，则更新last到l1之间所有数位的值
                temp -= 10; //进位后当前数位最大值为8，故将last指针指向当前数位
                last->val += 1;
                last = last->next;
                while (last != l1)
                {
                    last->val = 0;
                    last = last->next;
                }
            }
            else if (temp != 9)
                last = l1;
            l1->val = temp;
            l1 = l1->next;
            l2 = l2->next;
        }
        return head->val == 1 ? head : head->next;
    }
};
