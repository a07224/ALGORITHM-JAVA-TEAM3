package Week10;

import java.util.Scanner;

public class FreshCabbage {
    static int[][] arr;
    static boolean[][] visit;
    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void dfs(int a, int b){
        visit[a][b] = true; //방문 체크
        for(int i=0; i<4; i++){
            int x = a + dx[i];
            int y = b + dy[i];

            //범위안에 있고 배추가 있고 방문하지 않았다면 dfs
            if(x>=0 && y>=0 && x<M && y<N){
                if(arr[x][y] == 1 && !visit[x][y]){
                    dfs(x, y);
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0; i<T; i++){
            M = scanner.nextInt(); //가로
            N = scanner.nextInt(); //세로
            K = scanner.nextInt();

            arr = new int[M][N];
            visit = new boolean[M][N];

            //배추 심어져 있는곳 입력
            for(int j=0; j<K; j++){
                arr[scanner.nextInt()][scanner.nextInt()] = 1;
            }

            int count = 0;

            for(int a=0; a<M; a++){
                for(int b=0; b<N; b++){
                    //배추가 있고 방문하지 않았으면 dfs후 1증가
                    if(arr[a][b]==1 && !visit[a][b]){
                        dfs(a, b);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
}
