class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res=new LinkedList<>();
        int carry=0;
        int i=0;
		/*We always start computing from array's last element and k's last digit and will 
		compute sum and carry. We will iterate it till k and index of array both have existance. 
		If one of them gets exhausted the for loop below will not work.*/
        for(i=num.length-1;i>=0 && k>0;i--){
            int temp=num[i];
            res.addFirst((temp+carry+(k%10))%10);
            carry=(temp+carry+(k%10))/10;
            k/=10;
        }
		/*If for an instance your k is greater than the number that is present in the form of 
		array then the below while loop will work.*/
        while(k!=0){
            int compute=(k%10)+carry;
            res.addFirst(compute%10);
            carry=compute/10;
            k/=10;
        }
		/*If for an instance the number that is present in the form of array is greater than k 
		then the below for loop will work.*/
        for(int r=i;r>=0;r--){
            int temp=num[r];
            res.addFirst((temp+carry)%10);
            carry=(temp+carry)/10;
        }
		/*If there is some carry still remaining at last then add it to beginning of the 
		arraylist or linkedlist.*/
        if(carry!=0)
            res.addFirst(carry);
        return res;
    }
}
