package Week10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
    static int[][] arr;
    static boolean[][] visit;
    static int count = 0;
    static int N, M;

    static void bfs(){
        //현재 좌표 기준 상,하,좌,우 좌표값들을 알아내기 위함
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Integer>q1 = new LinkedList<>();
        Queue<Integer>q2 = new LinkedList<>();

        //시작점 좌표
        q1.add(0);
        q2.add(0);
        visit[0][0] = true;

        while(!q1.isEmpty()){
            //queue에 넣은 값을 하나씩빼와 i와 j에 넣어줌
            int i = q1.poll();
            int j = q2.poll();
            for (int z=0; z<4; z++){
                // 현재 좌표 기준 상, 하, 좌, 우 좌표들의 좌표값을 구함
                int x = i + dx[z];
                int y = j + dy[z];
                // 좌표값이 0보다 크거나 같고 N과 M보단 작아야함
                if(x >= 0 && y>= 0 && x < N && y < M){
                    // 좌표값의 값이 1이고 방문하지 않았다면 queue에 넣어주고 방문처리하고 이전값에 1을 더해준값 저장
                    if(arr[x][y] == 1 && !visit[x][y]){
                        q1.add(x);
                        q2.add(y);

                        visit[x][y] = true;
                        arr[x][y] = arr[i][j] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = scanner.next();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(arr[N-1][M-1]);
    }
}
