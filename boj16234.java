import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] four1 = {1,0,0,-1};
    static int[] four2 = {0,1,-1,0};
    public static class point{
        int x;
        int y;
        point(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static boolean check(int a, int b, int L, int R){
        if(Math.abs(a-b) <= R && Math.abs(a-b) >= L){
            return true;
        }
        return false;
    }
    public static void set(){
        Scanner scan = new Scanner(System.in);
        int N =  scan.nextInt();
        int L = scan.nextInt();
        int R = scan.nextInt();
        int[][][] world = new int[N][N][2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                world[i][j][0] = scan.nextInt();
            }
        }
        Queue<point> q = new LinkedList<>();
        boolean flag = true;
        int ans = 0;
        int unum;
        int index;
        int man;
        while(true) {
            if(!flag){
                break;
            }
            flag = false;
            boolean[][] visited = new boolean[N][N];
            LinkedList<Integer> un = new LinkedList<>();
            index = 0;
            int tx, ty, nx, ny;
            for (int t = 0; t < N; t++) {
                for (int u = 0; u < N; u++) {
                    if (visited[t][u]) {
                        continue;
                    }
                    q.offer(new point(u, t));
                    man = world[t][u][0];
                    world[t][u][1] = index;
                    unum = 1;
                    visited[t][u] = true;
                    while (!q.isEmpty()) {
                        tx = q.peek().x;
                        ty = q.poll().y;
                        for (int i = 0; i < 4; i++) {
                            nx = tx + four1[i];
                            ny = ty + four2[i];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!visited[ny][nx] && check(world[ny][nx][0], world[ty][tx][0], L, R)) {
                                    flag = true;
                                    unum++;
                                    q.offer(new point(nx, ny));
                                    man += world[ny][nx][0];
                                    world[ny][nx][1] = index;
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                    un.add(man/unum);
                    index++;
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    world[j][k][0] = un.get(world[j][k][1]);
                }
            }
            if(flag){
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        set();
    }
}
