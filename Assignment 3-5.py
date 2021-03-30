class Node(object):
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None


class LinkedListTwoway(object):
    def __init__(self):
        self.__head = None

    def is_empty(self):
        return self.__head is None

    def __len__(self):
        count = 0
        cur = self.__head
        while cur:
            count += 1
            cur = cur.next
        return count

    def printList(self):
        cur = self.__head
        while cur:
            print(cur.value)
            cur = cur.next

    def addToHead(self, value):
        node = Node(value)
        if self.is_empty():
            self.__head = node
        else:
            node.next = self.__head
            self.__head.prev = node
            self.__head = node

    def addToTail(self, value):
        node = Node(value)
        cur = self.__head
        if self.is_empty():
            self.__head = Node
            return
        while cur.next:
            cur = cur.next
        cur.next = node
        node.prev = cur

