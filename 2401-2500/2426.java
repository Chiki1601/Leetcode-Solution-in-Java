class Solution {
    long ans=0;
    int diff;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        this.diff=diff;
        int n=nums1.length;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=nums1[i]-nums2[i];
        }
        mergeSort(nums,0,n-1);
        return ans;
    }
    public void mergeSort(int[] nums,int i,int j){
        if(i>=j) return;
        int mid=i+(j-i)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        calculateInverse(nums,i,mid,j); 
        merge(nums,i,mid,j);
    }
    public void calculateInverse(int[] nums,int i,int mid,int j){
        int[] temp=new int[j-i+1];
        int ptr1=i;
        int ptr2=mid+1;
        int ptr=0;
        while(ptr1<=mid && ptr2<=j){
            if(nums[ptr1]>nums[ptr2]+diff){
                temp[ptr]=nums[ptr2]+diff;
                ans=ans+(long)ptr1-i;
                ptr2++;
                ptr++;
            }
            else{
                temp[ptr]=nums[ptr1];
                ptr++;
                ptr1++;
            }
        }
        if(ptr2<=j){
            ans=ans+(long)(ptr1-i)*(j-ptr2+1);
        }
    }
    public void merge(int[] nums,int i,int mid,int j){
        int[] temp=new int[j-i+1];
        int ptr1=i;
        int ptr2=mid+1;
        int ptr=0;
        while(ptr1<=mid && ptr2<=j){
            if(nums[ptr1]>nums[ptr2]){
                temp[ptr]=nums[ptr2];
                ptr2++;
                ptr++;
            }
            else{
                temp[ptr]=nums[ptr1];
                ptr++;
                ptr1++;
            }
        }
        while(ptr1<=mid){
            temp[ptr]=nums[ptr1];
            ptr1++;ptr++;
        }
        while(ptr2<=j){
            temp[ptr]=nums[ptr2];
            ptr2++;ptr++;
        } 
        for(int k=0;k<temp.length;k++){
            nums[i]=temp[k];
            i++;
        }
    }    
}
