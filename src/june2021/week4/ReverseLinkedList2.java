package june2021.week4;

public class ReverseLinkedList2 {



    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        int index = 1;
        ListNode current = head;
        ListNode beforeIndex = null;
        ListNode afterIndex = null;


        for(int i = index; i < (left-1); i++)
            current = current.next;

        beforeIndex = current;

        //System.out.println(beforeIndex.val);


        if(left == 1){
            for(int i = left; i < (right); i++)
                current = current.next;

            head = current;
        }else{
            for(int i = left; i < (right + 1); i++)
                current = current.next;

        }
        afterIndex = current.next;
        current.next = null;
        //System.out.println(afterIndex.val);

        // Saved before and after node now
        if(left == 1){
            recursiveReverse(beforeIndex);

            //beforeIndex = current;
        }else{
            recursiveReverse(beforeIndex.next);
            beforeIndex.next = current;

        }

        //current = beforeIndex;
        while(current.next != null)
            current = current.next;
        current.next = afterIndex;

        return head;

    }

    // normal reverse linked list do this first!!
    public static void recursiveReverse(ListNode current){

        if(current.next == null)
            return;
        else{
            recursiveReverse(current.next);
            current.next.next = current;
            current.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode tail = node.next.next.next.next = new ListNode(5);




        //recursiveReverse(node);
        ListNode current = reverseBetween(node, 2, 4);
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }



    }

}
