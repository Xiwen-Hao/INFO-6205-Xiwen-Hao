public class Q1 {
    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[8];
        int[] vals = {11, 12, 21, 22, 23, 31, 32, 33};
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(vals[i]);
        }
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[5];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];
        nodes[4].next = nodes[5];
        nodes[5].next = nodes[6];
        nodes[6].next = nodes[7];
        System.out.println("It should be true: " + new Solution().areConverging(nodes[0], nodes[2]));
        nodes[4].next = null;
        System.out.println("It should be false: " + new Solution().areConverging(nodes[0], nodes[2]));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    /**
     * No extra space used, the space complexity is O(1)
     * If the length of n1 is n and the length of n2 is m:
     * After traversing the two lists and compare the end of two list,
     * the time complexity is O(n + m)
     *
     *
     * @param n1 the first list
     * @param n2 the second list
     * @return true if n1 and n2 are converging
     */
    public boolean areConverging(ListNode n1, ListNode n2) {
        while (n1.next != null) {
            n1 = n1.next;
        }
        while (n2.next != null) {
            n2 = n2.next;
        }
        return n1 == n2;
    }
}