// Last updated: 12/06/2025, 01:46:29
import java.util.Arrays;

class Solution {

    public double separateSquares(int[][] squares) {
        if (squares == null || squares.length == 0) {
            return 0.0; // or throw an exception, depending on requirements
        }

        double total = 0;
        double minY = squares[0][1];
        double maxY = squares[0][1] + squares[0][2];

        for (int[] square : squares) {
            double bottom = square[1];
            double side = square[2];
            double top = bottom + side;
            total += side * side;
            minY = Math.min(minY, bottom);
            maxY = Math.max(maxY, top);
        }

        double low = minY;
        double high = maxY;

        return search(squares, total, low, high);
    }

    public double search(int[][] squares, double total, double low, double high) {
        double epsilon = 1e-5;

        while (high - low > epsilon) {
            double mid = (low + high) / 2;
            double below = area(squares, mid);
            double above = total - below;

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2;
    }


    public double area(int[][] squares, double y) {
        double area = 0;

        for (int[] square : squares) {
            double bottom = square[1];
            double side = square[2];
            double top = bottom + side;

            if (y < bottom) {
                continue; 
            } else if (y >= top) {
                area += side * side; 
            } else {
                double height = y - bottom;
                area += side * height; 
            }
        }

        return area;
    }
}
