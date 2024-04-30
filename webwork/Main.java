import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int m, n, ret;
    static int[][] a, visited;
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(a[ny][nx] == 0 || visited[ny][nx] != 0) continue;
            dfs(ny, nx);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("탐색전 방문배열");
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(visited[i]));
        }

        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0 || visited[i][j] != 0) continue;
                ret++; dfs(i, j);
            }
        }


        System.out.println("탐색후 방문배열");
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(visited[i]));
        }

        System.out.println(ret);
    }
}