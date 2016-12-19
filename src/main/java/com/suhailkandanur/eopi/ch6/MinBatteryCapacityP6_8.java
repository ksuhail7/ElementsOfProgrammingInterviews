package com.suhailkandanur.eopi.ch6;

/**
 * Created by suhail on 2016-12-18.
 */
public class MinBatteryCapacityP6_8 {
    public static class Coordinate {
        private int x, y,z;
        public Coordinate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

    public static int minBatteryCapacity(Coordinate[] coordinates) {
        if(coordinates == null || coordinates.length < 1)
            return 0;
        int batteryCapacity = 0;
        int prev = coordinates[0].getZ(), sum = 0;
        for (int i = 1; i < coordinates.length; i++) {
            int z = coordinates[i].getZ();
            int slope = z - prev;
            prev = z;
            sum = sum + slope;
            if((batteryCapacity + sum) > batteryCapacity) {
                batteryCapacity += sum;
                sum = 0;
            }
        }
        return batteryCapacity;
    }

    public static void main(String[] args) {
        Coordinate[] coordinates = new Coordinate[] { new Coordinate(0,0, 100),
        new Coordinate(0,0, 113),
        new Coordinate(0, 0, 110),
        new Coordinate(0,0,85),
        new Coordinate(0,0,105),
        new Coordinate(0,0, 102),
        new Coordinate(0,0, 86),
        new Coordinate(0,0, 63),
        new Coordinate(0,0, 81),
        new Coordinate(0,0, 101),
        new Coordinate(0,0, 94),
        new Coordinate(0,0, 106),
        new Coordinate(0,0, 101),
        new Coordinate(0,0, 79),
        new Coordinate(0,0, 94),
        new Coordinate(0,0, 90),
        new Coordinate(0,0, 97)};
    }
}
