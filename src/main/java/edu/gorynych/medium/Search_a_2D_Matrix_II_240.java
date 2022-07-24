package edu.gorynych.medium;

public class Search_a_2D_Matrix_II_240 {
    public static void main(String[] args) {}
}

class Solution {
//    Constraints:
//
//    m == matrix.length
//    n == matrix[i].length
//    1 <= n, m <= 300
//            -109 <= matrix[i][j] <= 109
//    All the integers in each row are sorted in ascending order.
//    All the integers in each column are sorted in ascending order.
//    -109 <= target <= 109

    public boolean searchMatrix(int[][] matrix, int target) {
        var upperBound = Integer.valueOf(matrix[0].length);

        for (var row : matrix) {
            if (row[0] < target && target < row[row.length - 1]) {
                if ((upperBound = findNewUpperBoundWithBinarySearch(row, upperBound, target)) == null ) {
                    return true;
                }
            } else if (row[0] == target || row[row.length - 1] == target) {
                return true;
            }
        }

        return false;
    }

    private Integer findNewUpperBoundWithBinarySearch(int[] row, int upperBoundary, int target) {
        var left = 0;
        var right = upperBoundary;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (target > row[middle]) {
                left = middle + 1;
            } else if (target < row[middle]) {
                right = middle - 1;
            } else if (target == row[middle]) {
                return null;
            }
        }
        return right;
    }
}