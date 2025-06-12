// Last updated: 12/06/2025, 01:39:51
import java.util.Arrays;

class Solution {
    public double separateSquares(int[][] squares) {
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        double total = 0;
        
        for (int[] square : squares) {
            double bottom = square[1];
            double side = square[2];
            double top = bottom + side;
            minY = Math.min(minY, bottom);
            maxY = Math.max(maxY, top);
            total += side * side;
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
