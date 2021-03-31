class Meta:
    def __init__(self,val,prev=None,next=None):
        self.val = val
        self.prev = prev
        self.next = next
        
        
class MyLinkedList:
    
    def __init__(self):
        node = Meta(0)
        self.head = node
        self.tail = None
        self.size = 0
    def get(self, index )  :
        if self.size < index:
            return -1
        head = self.head
        for _ in range(index):
            head = head.next
        return head.next.val

        

    def addAtHead(self, val ) :
        head = self.head
        next = head.next

        node = Meta(val) 
        node.prev = head
        head.next = node

    
        # first 
        if next == None:
            self.tail = node
        else:
            node.next = next
            next.prev = node
        self.size += 1
            
    def print_s(self):
        head = self.head
        while head is not None:
            print (head.val)
            head = head.next
    def addAtTail(self, val )  :
        """
        Append a node of value val to the last element of the linked list.
        """
        tail = self.tail
        if tail is None:
            addAtHead(self,head=tail)
        else:
            node = Meta(val)
            tail.next = node
            node.prev = tail
            self.tail = node
            self.size += 1

    def addAtIndex(self, index , val ):
        if self.size < index:
            return
        head = self.head
        for i in range(index):
            head = head.next
        next = head.next
        
        node = Meta(val)
        head.next = node
        node.prev = head
        if next is None:
            self.tail = node
        else:
            next.prev = node
            node.next = next
        self.size += 1

        

    def deleteAtIndex(self, index):
        if self.size < index:
            return
        
        head  = self.head
        for i in range(index):
            head = head.next
        nxt = head.next
        if nxt is None:
            pass
        else:
            next = nxt.next
            if next is None:
                self.tail = head
                head.next = None
            else :
                next.prev = head
                head.next = next
            self.size -= 1
        
        
        


# Your MyLinkedList object will be instantiated and called as such:
obj = MyLinkedList()
obj.addAtHead(1)
obj.addAtTail(3)

# obj.print_s()
obj.addAtIndex(1,2)
obj.print_s()

print (obj.get(1))
obj.deleteAtIndex(1)

print ( obj.get(1))
# obj.print_s()

# "addAtIndex","get","deleteAtIndex","get"]
# [1,2],[1],[1],[1]]




# ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
# [[],[1],[3],[1,2],[                                       1],[1],[1]]
#  1 3 