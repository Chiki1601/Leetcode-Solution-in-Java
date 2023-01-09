class DataStream {
    // Initialise variable outside to acces variable value
    // inside the Datastream method and use them in consec method
    int v = 0;
    int kk = 0;
    int counter = 0;
    public DataStream(int value, int k) {
        v = value;
        kk = k;
    } 
    public boolean consec(int num) {
        // num is equal to value more than 3 times return true
        if(v==num) counter++;
        else counter = 0;
        return counter>=kk;
    }
}
