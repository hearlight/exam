class Line {
    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    Point p1;
    Point p2;

    /**
     * 构造方法，用于创建一条线段。
     *
     * @param p1 线段的起点坐标
     * @param p2 线段的终点坐标
     */
    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // 计算向量叉积
    static double crossProduct(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    /**
     * 判断两条线段是否相交
     *
     * @param L1 第一条线段
     * @param L2 第二条线段
     * @return 如果两条线段相交，则返回true；否则返回false
     */
    // 判断两条线段是否相交
    static boolean check(Line L1, Line L2) {
        double d1 = crossProduct(L2.p1, L1.p1, L1.p2);
        double d2 = crossProduct(L2.p2, L1.p1, L1.p2);
        double d3 = crossProduct(L1.p1, L2.p1, L2.p2);
        double d4 = crossProduct(L1.p2, L2.p1, L2.p2);

        if (d1 * d2 < 0 && d3 * d4 < 0) return true;
        else if (d1 == 0 && isOnSegment(L1.p1, L2.p1, L2.p2)) return true;
        else if (d2 == 0 && isOnSegment(L1.p2, L2.p1, L2.p2)) return true;
        else if (d3 == 0 && isOnSegment(L2.p1, L1.p1, L1.p2)) return true;
        else if (d4 == 0 && isOnSegment(L2.p2, L1.p1, L1.p2)) return true;
        else return false;
    }

    /**
     * 判断点是否在线段上
     *
     * @param p 待判断的点
     * @param s1 线段的起点
     * @param s2 线段的终点
     * @return 如果点p在线段s1-s2上，则返回true；否则返回false
     */
    // 判断点是否在线段上
    static boolean isOnSegment(Point p, Point s1, Point s2) {
        return Math.min(s1.x, s2.x) <= p.x && p.x <= Math.max(s1.x, s2.x) &&
                Math.min(s1.y, s2.y) <= p.y && p.y <= Math.max(s1.y, s2.y);
    }
}

public class Check {
    /**
     * 主函数，用于测试线段相交的判断功能。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Line.Point L1P1 = new Line.Point(0, 0);
        Line.Point L1P2 = new Line.Point(1, 1);
        Line.Point L2P1 = new Line.Point(0, 1);
        Line.Point L2P2 = new Line.Point(1, 0);
        Line L1 = new Line(L1P1, L1P2);
        Line L2 = new Line(L2P1, L2P2);
        boolean result = Line.check(L1, L2);
        System.out.println(result);
    }
}