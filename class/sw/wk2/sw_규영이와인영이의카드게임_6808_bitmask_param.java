package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_규영이와인영이의카드게임_6808_bitmask_param {

static int T, win, lose, N = 9;
static int[] input = new int[19];
static int[] guCard = new int[9];
static int[] inCard = new int[9]; // src
//static int[] tgt = new int[9];


static boolean[] select = new boolean[N];

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
        // 초기화
        win = 0;
        lose = 0;
        Arrays.fill(input, 0);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            input[num] = 1;
            guCard[i] = num; // guCard 입력 처리
        }
        
        // 인영 카드 처리
        num = 0;
        for (int i = 1; i <= 18; i++) {
            if( input[i] == 0 ) inCard[num++] = i;
        }
        
        // 순열
        perm(0,0,0,0);
        System.out.println("#" + t + " " + win + " " + lose);
    }

}

static void perm(int tgtIdx,int mask,int guSum,int inSum) {  // 이정도 파라미터 수는 성능에 큰영향을 주지 않는다,primitive형은 값이 작아서,
    if( tgtIdx == N ) {                                   //배열은 주소만 넘어가서
        // complete code
        if(guSum > inSum) win++;
        else if(guSum < inSum) lose++;
        return;
    }
    
    for (int i = 0; i < N; i++) {
        if( (mask &(1<<i)) !=0 ) continue;
        //현재 tgtIdx guCard와 i 번째 inCard 비교처리
        if(guCard[tgtIdx] > inCard[i]) {
            perm( tgtIdx + 1 ,(mask |(1<<i)),guSum+ guCard[tgtIdx]+inCard[i],inSum); //각 조합 별로 계산이 나뉘기 때문에 
        }else {
        	perm( tgtIdx + 1 ,(mask |(1<<i)),guSum,inSum+ guCard[tgtIdx]+inCard[i]); //매순간계산해주는게 효율적
        }

    }
}

// inCard 를 이용한 순열이 완성되었으므로 win, lose 따진다.

}
