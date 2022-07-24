class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        
		int numberOfStudent = 0;
		
		for(int i = 0;i < startTime.length;i++) {
			if(startTime[i] <= queryTime && queryTime<=endTime[i])
				numberOfStudent++;
		}
		
		
		return numberOfStudent;

    }
}
