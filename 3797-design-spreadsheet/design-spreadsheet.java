class Spreadsheet {

    private int[][] matrix;

    public Spreadsheet(int rows) {
        matrix = new int[rows][26];  
    }

    public static int columnToIndex(String column) {
        int result = 0;
        for (int i = 0; i < column.length(); i++) {
            char ch = column.charAt(i);
            result = result * 26 + (ch - 'A' + 1); 
        }
        return result - 1;  
    }

    public static int[] getRowCol(String cell) {
        StringBuilder colPart = new StringBuilder();
        StringBuilder rowPart = new StringBuilder();

        for (char c : cell.toCharArray()) {
            if (Character.isLetter(c)) {
                colPart.append(c);
            } else if (Character.isDigit(c)) {
                rowPart.append(c);
            }
        }
        int row = Integer.parseInt(rowPart.toString()) - 1; 
        int col = columnToIndex(colPart.toString());
        return new int[]{row, col};
    }

    public void setCell(String cell, int value) {
        int[] rc = getRowCol(cell);
        int row = rc[0];
        int col = rc[1];
        matrix[row][col] = value;
    }

    public void resetCell(String cell) {
        int[] rc = getRowCol(cell);
        int row = rc[0];
        int col = rc[1];
        matrix[row][col] = 0;
    }

    public int getValue(String formula) {
        String expr = formula.substring(1);  
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            part = part.trim();
            if (Character.isDigit(part.charAt(0))) {
                sum += Integer.parseInt(part);
            } 
            else {
                int[] rc = getRowCol(part); 
                sum += matrix[rc[0]][rc[1]];
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */