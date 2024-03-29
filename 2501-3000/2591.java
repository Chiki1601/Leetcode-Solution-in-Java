class Solution {
    public int distMoney(int money, int children) {
        if(money < children)    return -1;
        int arr[] = new int[children];
        for(int i=0; i<children; i++)   arr[i] = 1;
        money -= children;
        for(int i=0; i<children; i++){
            if(money >= 7){
                money -= 7;
                arr[i] += 7;
            }else if(money == 0)    break;
            else{
                if(money == 3){
                    arr[i] += 2;
                    money = 1;
                }else{
                    arr[i] += 1;
                    money = 0;
                }
            }
        }
        int count = 0;
        for(int i: arr) count += i == 8 ? 1 : 0;
        if(money != 0)   count--;
        return count;
    }
}
