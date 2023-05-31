package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬 없이 최대값으로 계산해도 된다.
public class bj_랜선자르기_1654_c {

static int K, N;
static long left, right, mid;
static int[] input;

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    
    input = new int[K];
    
    for (int i = 0; i < K; i++) {
        int n = Integer.parseInt(br.readLine());
        input[i] = n;
        if( right < n ) right = n;
    }
    
    // 왼쪽 오른쪽 사이에 찾는 값이 있다. 10 => 5, 0 + 10 / 2 => 5, 1 + 10 / 2 => 11 / 2 => 5
    left = 1; // 길이가 0 아닌 1로 변경 
    // right 는 현재 최대값이 확보
    
    // 원하는 값이 left 와 right 사이에 있다, 하지만, 어떤 값인지는 모른다.
    // 그 값을 찾을 려면 이진탐색 중간값을 우선 후보로 계산해 본다. <= 랜선의 수 >= N 조건
    while( left <= right ) {
        long count = 0;
        
        // mid 값을 구해서
        mid = (left + right) / 2;
        // 현재 mid 값으로 K개의 랜선을 잘라본다. 그려면서 생기는 랜선의 수를 누적합 계산
        for (int i = 0; i < K; i++) {
            count += ( input[i] / mid );
        }
        
        if( count >= N ) left = mid + 1; // mid 보다 더 여유가 있으므로 mid 와 mid 보다 작은 길이는 버린다.
        
        // mid 길이로는 N 개를 만들지 못하므로 더 줄여야 한다. (더 작아야 한다.) mid 와 mid 보다 큰 길이는 버린다.
        else right = mid - 1; 
        
    }
    
    System.out.println(left - 1);
}
}
