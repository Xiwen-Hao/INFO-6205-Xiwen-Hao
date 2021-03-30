# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        cur = list1
        for i in range(b): # Point to ptr1 and ptr2 at each front of a and b.
            if i == a-1:
                ptr1 = cur
            cur = cur.next
        ptr2 = cur.next
        ptr1.next = list2 # Connect the following from ptr1 to list2.
        while ptr1.next: # Go to the last node of the connected list2.
            ptr1 = ptr1.next
        ptr1.next = ptr2 # Connect the rest of list1 to its most end node.
        return list1
