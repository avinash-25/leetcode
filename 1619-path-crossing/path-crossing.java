import java.awt.Point;
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Point> visited = new HashSet<>();
        visited.add(new Point(0, 0));
        int x = 0, y = 0;

        for (char direction : path.toCharArray()) {
            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            Point current = new Point(x, y);
            if (visited.contains(current)) {
                return true;
            }

            visited.add(new Point(x, y));
        }

        return false;
    }
}
