package algo;

import lombok.ToString;

class Solution {

  public static void main(String[] args) {
    ListNode l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
    ListNode l2 = createList(new int[]{9, 9, 9, 9});
    System.out.println(addTwoNumbers(l1, l2));
  }

  private static ListNode createList(int[] ints) {
    ListNode li = new ListNode(ints[0]);
    ListNode curr = li;
    for (int i = 1; i < ints.length; i++) {
      li.next = new ListNode(ints[i]);
      li = li.next;
    }

    return curr;
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    int val = l1.val + l2.val;

    if (val >= 10) {
      carry = val / 10;
      val = val % 10;
    }

    ListNode result = new ListNode(val);
    ListNode curr = result;
    l1 = l1.next;
    l2 = l2.next;

    while (l1 != null || l2 != null) {
      val = carry;
      if (l1 != null) {
        val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        val += l2.val;
        l2 = l2.next;
      }
      if (val >= 10) {
        carry = val / 10;
        val = val % 10;
      } else {
        carry = 0;
      }

      curr.next = new ListNode(val);
      curr = curr.next;
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return result;
  }

  @ToString
  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }
}