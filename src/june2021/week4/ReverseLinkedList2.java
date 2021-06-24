package june2021.week4;

public class ReverseLinkedList2 {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){

        }

        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        ListNode current = head;
        ListNode beforeIndex = null;
        ListNode afterIndex = null;

        for(int i = index; i < left; i++)
            current = current.next;

        beforeIndex = current;

        for(int i = left; i < right; i++)
            current = current.next;

        afterIndex = current.next;
        current.next = null;
        // Saved before and after node now





    }

    // normal reverse linked list do this first!!
    public void recursiveReverse(){

    }
}
