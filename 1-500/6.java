class Solution {
        public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        
        // Each element in rows represent a row.
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();
        
        int curRow = 0; // Current row number.
        int diff = 1; // 1 downwards, -1 upwards.
        
        for (char ch : s.toCharArray()) {
            rows[curRow].append(ch);
            // Opposite moving direction.
            if (curRow == numRows - 1 ) diff = -1;
            else if (curRow == 0) diff = 1;
        
            curRow += diff;
        }
        
        // Format result.
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        } 
        
        return result.toString();
    }
}
