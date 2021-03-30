# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: ListNode, k: int) -> ListNode:
        p = head
        for _ in range(k-1):
            p = p.next
        tail = p.next
        q = head
        while tail:
            tail = tail.next
            q = q.next
        p.val, q.val = q.val, p.val
        return head

