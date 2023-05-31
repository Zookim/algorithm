package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jo_냉장고_1828_c {

static int N, count;
static int[][] input; // 0-최저, 1-최고
public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    input = new int[N][2];
    
    for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        input[i][0] = Integer.parseInt(st.nextToken());
        input[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(input, (o1, o2) -> o1[1] - o2[1] ); // 최고 온도 기준으로 정렬
    int max = Integer.MIN_VALUE;
    count = 0;
    for (int i = 0; i < N; i++) {
        if( input[i][0] > max ) {
            count++;
            max = input[i][1];
        }
    }
    
    System.out.println(count);
}
}