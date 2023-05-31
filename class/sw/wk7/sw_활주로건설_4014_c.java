package sw.wk7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_활주로건설_4014_c {

static int T, N, X, ans;
static int[][] map;

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); // 경사로의 길이 높이는 1로 고정
        
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 풀이
        ans = 0;
        
        /////////// 왼 -> 오
        // 행
        for (int i = 0; i < N; i++) {
            // 열 ( 왼 -> 오 )
            
            // 변수 초기화
            int diff = 0; // 높이의 차이
            int flat = 1; // 평평한 수 ( 같은 높이로 이어지는 칸의 수 )
            int curr = map[i][0]; // 현재 (맨 앞)
            boolean isSuccess = true; // 따지면서 불가능하면 false 로 놓고, 다음 행 이동
            
            // 왼쪽으로 이동하면서 조건을 따진다.
            for (int j = 1; j < N; j++) { // j 가 두번째부터
                // 높이의 차이를 구한다
                diff = map[i][j] - curr;
                
                if( diff == 0 ) { // 높이의 차이가 없다. 동일 높이
                    flat++;
                    curr = map[i][j];
                }else if( diff == 1 ) { // 높이가 + 1 차이 // 경사로를 놓을 수 있는 지 따진다.
                    // 올라가는 상황에서 경사로를 사용할 수 있는 지 확인
                    if( flat >= X ) {
                        flat = 1; // 경사로를 사용했으니 1 칸 높은 위치가 바로 시작위치
                        curr = map[i][j];
                    }else {
                        isSuccess = false;
                        break;
                    }
                }else if( diff == -1 ) { // 높이가 - 1 차이 // 경사로를 놓을 수 있는 지 따진다.
                    // 내려가는 상황 : X 와 남은 오른쪽 길이에서 따진다.
                    
                    // 남은 길이가 경사로 X 보다 더 큰지 확인
                    if( N - j >= X ) {
                        
                        flat = 1;
                        curr = map[i][j];
                        
                        boolean isSame = true;
                        // X 만큼 평평한 지 따진다.
                        for (int k = j + 1; k < j + X; k++) {
                            if( curr != map[i][k] ) {
                                isSame = false;
                                break;
                            }
                        }
                        
                        // 
                        if( isSame ) {
                            flat = 0;
                            j = j + X - 1;
                        }else { // X 만큼 연속적으로 평평하지 않으면 fail
                            isSuccess = false;
                            break;
                        }
                        
                    }else { // 남은 거리가 X 보다 작으므로 fail
                        isSuccess = false;
                        break;
                    }
                }else { // 차이가 나고 경사로를 놓을 수 없다. fail
                    isSuccess = false;
                    break;
                }
            }
            
            if( isSuccess ) ans++;
        }

        // 위 -> 아래로
        // 열
        for (int i = 0; i < N; i++) {
            // 행 ( 위 -> 아래 )
            
            // 변수 초기화
            int diff = 0; // 높이의 차이
            int flat = 1; // 평평한 수 ( 같은 높이로 이어지는 칸의 수 )
            int curr = map[0][i]; // 현재 (맨 위)
            boolean isSuccess = true; // 따지면서 불가능하면 false 로 놓고, 다음 행 이동
            
            // 왼쪽으로 이동하면서 조건을 따진다.
            for (int j = 1; j < N; j++) { // j 가 두번째부터
                // 높이의 차이를 구한다
                diff = map[j][i] - curr;
                
                if( diff == 0 ) { // 높이의 차이가 없다. 동일 높이
                    flat++;
                    curr = map[j][i];
                }else if( diff == 1 ) { // 높이가 + 1 차이 // 경사로를 놓을 수 있는 지 따진다.
                    // 올라가는 상황에서 경사로를 사용할 수 있는 지 확인
                    if( flat >= X ) {
                        flat = 1; // 경사로를 사용했으니 1 칸 높은 위치가 바로 시작위치
                        curr = map[j][i];
                    }else {
                        isSuccess = false;
                        break;
                    }
                }else if( diff == -1 ) { // 높이가 - 1 차이 // 경사로를 놓을 수 있는 지 따진다.
                    // 내려가는 상황 : X 와 남은 오른쪽 길이에서 따진다.
                    
                    // 남은 길이가 경사로 X 보다 더 큰지 확인
                    if( N - j >= X ) {
                        
                        flat = 1;
                        curr = map[j][i];
                        
                        boolean isSame = true;
                        // X 만큼 평평한 지 따진다.
                        for (int k = j + 1; k < j + X; k++) {
                            if( curr != map[k][i] ) {
                                isSame = false;
                                break;
                            }
                        }
                        
                        // 
                        if( isSame ) {
                            flat = 0;
                            j = j + X - 1;
                        }else { // X 만큼 연속적으로 평평하지 않으면 fail
                            isSuccess = false;
                            break;
                        }
                        
                    }else { // 남은 거리가 X 보다 작으므로 fail
                        isSuccess = false;
                        break;
                    }
                }else { // 차이가 나고 경사로를 놓을 수 없다. fail
                    isSuccess = false;
                    break;
                }
            }
            
            if( isSuccess ) ans++;
        }    
        
        System.out.println("#" + t + " " + ans);
    }

}
}