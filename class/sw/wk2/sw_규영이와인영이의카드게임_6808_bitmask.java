package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_�Կ��̿��ο�����ī�����_6808_bitmask {

static int T, win, lose, N = 9;
static int[] input = new int[19];
static int[] guCard = new int[9];
static int[] inCard = new int[9]; // src
static int[] tgt = new int[9];

static boolean[] select = new boolean[N];

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
        // �ʱ�ȭ
        win = 0;
        lose = 0;
        Arrays.fill(input, 0);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            input[num] = 1;
            guCard[i] = num; // guCard �Է� ó��
        }
        
        // �ο� ī�� ó��
        num = 0;
        for (int i = 1; i <= 18; i++) {
            if( input[i] == 0 ) inCard[num++] = i;
        }
        
        // ����
        perm(0,0);
        System.out.println("#" + t + " " + win + " " + lose);
    }

}

static void perm(int tgtIdx,int mask) {
    if( tgtIdx == N ) {
        // complete code
        check();
        return;
    }
    
    for (int i = 0; i < N; i++) {
        if( (mask &(1<<i)) !=0 ) continue;
        
        tgt[tgtIdx] = inCard[i];
  
        perm( tgtIdx + 1 ,(mask |(1<<i)));
    
    }
}

// inCard �� �̿��� ������ �ϼ��Ǿ����Ƿ� win, lose ������.
static void check() {
    int guSum = 0;
    int inSum = 0;
    for (int i = 0; i < N; i++) {
        if( guCard[i] > tgt[i] ) guSum += guCard[i] + tgt[i];
        else inSum += guCard[i] + tgt[i];
    }
    if( guSum > inSum ) win++;
    else if( guSum < inSum ) lose++;
}
}
