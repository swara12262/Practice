class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Point[] p=new Point[points.length];
        
        for(int i=0;i<points.length;i++){
            int t1=points[i][0];
            int t2=points[i][1];
            p[i]=new Point(t1, t2, Math.sqrt(t1*t1+t2*t2));
        }
        Arrays.sort(p, new Comparator<Point>(){
           public int compare(Point p1, Point p2){
               return p1.distance.compareTo(p2.distance);
               } 
        });
        int[][] res=new int[k][2];
        int i=0;
        while(k-->0){
            res[i][0]=p[i].x;
            res[i][1]=p[i].y;
            i++;
        }
        return res;
    }
}
class Point{
    int x;
    int y;
    Double distance;
    Point(int x, int y, Double dist){
        this.x=x;
        this.y=y;
        distance=dist;
    }
}
