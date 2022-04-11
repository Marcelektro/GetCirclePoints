package net.marcloud;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        var points = calc(3, 20, new Point(0, 0));

        int i = 0;
        for (Point point : points) {
            var df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            df.setMaximumFractionDigits(20);

            System.out.printf("A_{%s} = (%s, %s)%n", i, df.format(point.x), df.format(point.y));

            i++;
        }

        // Result for center = [0, 0]; radius = 3; iterations = 300:
        // https://www.desmos.com/calculator/immzssd2qk
    }

    public static List<Point> calc(int radius, int iterations, Point center) {
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            double angle = toRadians(((double) i / iterations) * 360);

            double x = radius * sin(angle);
            double y = radius * cos(angle);

            result.add(new Point(center.x + x, center.y + y));
        }
        return result;
    }

    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}