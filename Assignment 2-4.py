# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        node = root
        nodeCount = 0
        while (node):
            nodeCount += 1
            node = node.next

        elementCountPerPart = nodeCount // k
        moreItemIndex = nodeCount % k
        # print(elementCountPerPart)
        result = []
        newNode = root
        for index in range(0, k):
            if (newNode):
                result.append(newNode)
                allCount = elementCountPerPart + 1 if index < moreItemIndex else elementCountPerPart
                allCount -= 1
                # print(allCount)
                for setCount in range(0, allCount):
                    if (newNode):
                        newNode = newNode.next
                    else:
                        break
                if (newNode):
                    nextNewNode = newNode.next
                    newNode.next = None
                    newNode = nextNewNode
                else:
                    newNode = None
            else:
                result.append(None)

        return result
