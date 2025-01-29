package com.linkedlist;
class ListNode {
	     int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

public class MergeTwoLinkedList {

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp=new ListNode(-1);
        ListNode trav=temp;
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                trav.next=list1;
                trav=list1;
                list1=list1.next;
            }
            else{
                trav.next=list2;
                trav=list2;
                list2=list2.next;
            }
        }
        while(list1!=null){
            trav.next=list1;
            trav=list1;
            list1=list1.next;
        }
        while(list2!=null){
            trav.next=list2;
            trav=list2;
            list2=list2.next;
        }
        return temp.next;
    }
	
	public static void iterateList(ListNode head) {
		ListNode tempNode=head;
		while(tempNode!=null) {
			System.out.print(tempNode.val+" ");
			tempNode=tempNode.next;
		}	
	}
	
	public static void main(String[] args) {
		ListNode list1=new ListNode(1);
		list1.next=new ListNode(2);
		list1.next.next=new ListNode(7);
		
		ListNode list2=new ListNode(3);
		list2.next=new ListNode(6);
		list2.next.next=new ListNode(9);
		
		ListNode mergeTwoLists = mergeTwoLists(list1,list2);
		iterateList(mergeTwoLists);
	}
}
