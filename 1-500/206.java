class  Solution  { 
    public ListNode reverseList ( ListNode head )  { 
        ListNode newhead = null ; 
        while ( head != null ) { 
            ListNode temp = head . next ; 
            head . next = newhead ; 
            newhead = head ; 
            head = temp ; 
        } 
        return newhead ; 
    } 
}


