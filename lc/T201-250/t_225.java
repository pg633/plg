class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) return -1;
        while(q2.size()!=0){
            q1.offer(q2.poll());
        }
        while(q1.size()!=1){
            q2.offer(q1.poll());
        }
        return q1.poll();

    }

    /** Get the top element. */
    public int top() {
        if(empty()) return -1;
        while(q2.size()!=0){
            q1.offer(q2.poll());
        }
        while(q1.size()!=1){
            q2.offer(q1.poll());
        }
        int res = q1.peek();
        q2.offer(q1.poll());
        return res;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  q1.isEmpty() && q2.isEmpty();
    }
}