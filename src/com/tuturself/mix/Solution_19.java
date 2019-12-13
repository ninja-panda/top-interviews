package com.tuturself.mix;

import com.tuturself.linkedlist.ListNode;

public class Solution_19 {

	public ListNode detectCycle(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		boolean cycleFound = false;
		while(fastPtr != null && fastPtr.next != null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr){
				cycleFound = true;
				break;
			}
		}
		ListNode loopStartAt = null;
		if(cycleFound){
			slowPtr = head;
			while (true){
				if(slowPtr == fastPtr){
					loopStartAt = slowPtr;
					break;
				}
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}
		return loopStartAt;
	}
}
