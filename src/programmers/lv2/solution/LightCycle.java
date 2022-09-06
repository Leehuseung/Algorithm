package programmers.lv2.solution;

import java.util.*;

/**
 * Lv2. 빛의 경로 사이클
 */
public class LightCycle {
    static Point[][] points;
    static char[] directions = new char[]{'b','l','t','r'};
    public static int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        points = new Point[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                points[i][j] = new Point(chars[j],i,j);
            }
        }
        Light light = new Light();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                Point point = points[i][j];
                for (int k = 0; k < directions.length; k++) {
                    int cnt = light.start(point,directions[k]);
                    if(cnt > 0){
                        list.add(cnt);
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    static class Light {
        Set<Direction> path = new HashSet<>();

        public int start (Point point, char direction){
            Direction directionObj = new Direction(point,direction);
            if(path.contains(directionObj)){
                return 0;
            }
            int answer = 0;
            while(!path.contains(directionObj)){
                answer++;
                path.add(directionObj);
                Point nextPoint = point.nextPoint(points,directionObj.direction);
                char nextDirection = point.nextDirection(nextPoint, directionObj.direction);

                directionObj = new Direction(nextPoint,nextDirection);
                point = nextPoint;
            };
            return answer;
        }
    }

    static class Direction {
        Point point;
        char direction;

        public Direction(Point point, char direction) {
            this.point = point;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Direction direction1 = (Direction) o;
            return direction == direction1.direction && Objects.equals(point, direction1.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, direction);
        }
    }

    static class Point {
        char type;

        int row;
        int col;

        public Point(char type,int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        public Point nextPoint(Point[][] points, char direction) {
            int newRow = this.row;
            int newCol = this.col;
            switch (direction) {
                case 'b':
                    ++newRow;
                    if(newRow == points.length){
                        newRow = 0;
                    }
                    break;
                case 'l':
                    --newCol;
                    if(newCol < 0){
                        newCol = points[0].length-1;
                    }
                    break;
                case 'r':
                    ++newCol;
                    if(newCol == points[0].length){
                        newCol = 0;
                    }
                    break;
                case 't':
                    --newRow;
                    if(newRow < 0){
                        newRow = points.length-1;
                    }
                    break;
            }
            return points[newRow][newCol];
        }

        public char nextDirection(Point nextPoint,char direction) {
            switch (direction) {
                case 'b' :
                    switch (nextPoint.type) {
                        case 'S' :
                            return 'b';
                        case 'L' :
                            return 'r';
                        case 'R' :
                            return 'l';
                    }
                case 'r' :
                    switch (nextPoint.type) {
                        case 'S' :
                            return 'r';
                        case 'L' :
                            return 't';
                        case 'R' :
                            return 'b';
                    }
                case 't' :
                    switch (nextPoint.type) {
                        case 'S' :
                            return 't';
                        case 'L' :
                            return 'l';
                        case 'R' :
                            return 'r';
                    }
                case 'l' :
                    switch (nextPoint.type) {
                        case 'S' :
                            return 'l';
                        case 'L' :
                            return 'b';
                        case 'R' :
                            return 't';
                    }
            }
            return 'm';
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SL","LR"})));
        System.out.println(Arrays.toString(solution(new String[]{"S","S"})));
    }
}