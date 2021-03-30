"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""


class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        if not head:
            head = Node(insertVal)
            head.next = head
            return head

        prev = head
        succ = head.next

        is_inserted = False
        while True:

            if prev.val <= insertVal <= succ.val:
                break

            if prev.val > succ.val and (insertVal > prev.val or insertVal < succ.val):
                break

            prev, succ = succ, succ.next

            if prev == head:
                break;

        new_node = Node(insertVal)
        prev.next = new_node
        new_node.next = succ
        return head

