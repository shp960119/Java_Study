import java.util.Scanner;

public class Main {
    public static class shark{
        int x;
        int y;
        int d;
        int v;
        int z;
        boolean dead;
        shark(int r, int c, int v, int d, int z){
            this.y = r - 1;
            this.x = c - 1;
            this.d = d;
            this.v = v;
            this.z = z;
            this.dead = false;
        }
        public void move(shark[][] map, int R, int C){
            map[y][x] = null;
            int nx, ny;
            nx = x;
            ny = y;
            if(d == 1){
                ny = y - v;
                while(ny < 0 || ny >= R){
                    if(ny < 0){
                        ny = -ny;
                        d = 2;
                    }
                    else if (ny >= R){
                        ny = 2*R - ny - 2;
                        d = 1;
                    }
                }
            }
            else if(d == 2){
                ny = y + v;
                while(ny < 0 || ny >= R){
                    if(ny < 0){
                        ny = -ny;
                        d = 2;
                    }
                    else if (ny >= R){
                        ny = 2*R - ny - 2;
                        d = 1;
                    }
                }
            }
            else if(d == 3){
                nx = x + v;
                while(nx < 0 || nx >= C){
                    if(nx < 0){
                        nx = -nx;
                        d = 3;
                    }
                    else if (nx >= C){
                        nx = 2*C - nx - 2;
                        d = 4;
                    }
                }
            }
            else if(d == 4){
                nx = x - v;
                while(nx < 0 || nx >= C){
                    if(nx < 0){
                        nx = -nx;
                        d = 3;
                    }
                    else if (nx >= C){
                        nx = 2*C - nx - 2;
                        d = 4;
                    }
                }
            }
            x = nx;
            y = ny;
        }
    }
    public static void getmap(shark[][] map, shark[] s){
        int x, y;
        for(int i = 0; i < s.length; i++){
            if(s[i].dead){
                continue;
            }
            x = s[i].x;
            y = s[i].y;
            if(map[y][x] != null){
                if(map[y][x].z < s[i].z){
                    map[y][x].dead = true;
                    map[y][x] = s[i];
                }
                else{
                    s[i].dead = true;
                }
            }
            else{
                map[y][x] = s[i];
            }
        }
    }
    public static void set(){
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        int N = scan.nextInt();
        shark[][] map = new shark[R][C];
        shark[] Sharks = new shark[N];
        for(int i = 0; i < N; i++){
            Sharks[i] = new shark(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
            map[Sharks[i].y][Sharks[i].x] = Sharks[i];
        }
        int ans = 0;
        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                /*
                for(int k = 0; k < R; k++){
                    for(int p = 0; p < C; p++){
                        if(map[k][p] == null){
                            System.out.print(0 + " ");
                        }
                        else{
                            System.out.print(map[k][p].z + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();

                 */
                if(map[j][i] != null){
                    ans += map[j][i].z;
                    map[j][i].dead = true;
                    map[j][i] = null;
                    break;
                }
            }
            for(int k = 0; k < Sharks.length; k++){
                if(!Sharks[k].dead){
                    Sharks[k].move(map,R,C);
                }
            }
            getmap(map,Sharks);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        set();
    }
}
