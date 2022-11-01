package edu.gorynych.easy;

public class Toeplitz_Matrix_766 {
    public static void main(String[] args) {
        var matrix = new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };

        var solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        var rows = matrix.length;
        var cols = matrix[0].length;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) return false;
            }
        }

        return true;
    }

}