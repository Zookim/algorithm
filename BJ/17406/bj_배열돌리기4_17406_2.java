
package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_�迭������4_17406 {

static int arr[][];
static int rcs[][];
static int ans [][];

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    rcs = new int[K][3];
    ans = new int[N][M];
    int order[] = new int[K];
    int m = Integer.MAX_VALUE;
    
    for(int i=0;i<K;i++) {
        order[i] = i;
    }
    
    for(int i=0; i<N;i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<M;j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
            ans[i][j] = arr[i][j]; //�̹� �ѹ��� �����ϴ� ������ ������ �ʴ� �κ��� �Ź� �����Ǿ��ֱ� ����
        }
    }
    
    
    for(int i=0;i<K;i++) {
        st = new StringTokenizer(br.readLine());
        rcs[i][0] = Integer.parseInt(st.nextToken())-1;
        rcs[i][1] = Integer.parseInt(st.nextToken())-1;
        rcs[i][2] = Integer.parseInt(st.nextToken());
    }
    
    //�Է¿Ϸ�
    
    while(true) {//�ѹ��� ���� ���� Ȯ��
        
        //System.out.println(Arrays.toString(order));
        
        for(int i=0;i < K;i++) {//�� ȸ�� ����
            rotate(i);
        }// ���� ������ �״�� ä���ش�
        
        int tsum=0;
        for(int i=0;i<N;i++) {
        	int sum =0;
        	for(int j=0;j<M;j++) {
            	sum+= ans[i][j];
            }
        	tsum = sum < tsum ? sum : tsum;
        }
        m = tsum < m ? tsum : m;
        
        
        //�迭�� ���� ���Ѵ�.
        
        
        if(!perm(order)) break;
    }
    
    //System.out.println(m);
    
    
    
    
}
static void rotate(int i) {
    //rcs,i
    int r=rcs[i][0];
    int c=rcs[i][1];
    int s=rcs[i][2];
    int [][] an = new int [2*s+1][2*s+1];
    //���� ������� �ʵ��� ����
    int x=0,y=0;
    for(int j = r-s;j<=r+s;j++) {     
        for(int k = c-s;k<=c+s;k++) {
            an[x][y] = ans[j][k];
            y++;
        }

        y=0;
        x++;
    }
    
    
//    int ans_r = s;
//    int ans_c = s;
    ans[s][s] = arr[r][c];
    for(int j=1;j<=s;j++) { //s��ŭ����
    	
    	System.out.println(Arrays.toString(ans[0]));
        System.out.println(Arrays.toString(ans[1]));
        System.out.println(Arrays.toString(ans[2]));
        System.out.println(Arrays.toString(ans[3]));
        System.out.println(Arrays.toString(ans[4]));
    	
        for(int n=0;n<(j*2);n++) {
        	
            ans[r-n+j-1][c-j] = an[s-n+j][s-j]; //��
            ans[r-j][c-n-j+1] =an[s-j][s-n-j]; //�� //
            ans[r+n-j+1][c+j] = an[s+n-j][s+j]; //��
            ans[r+j][c+n+j-1] = an[s+j][s+n+j]; //��//
         
            
//                ans[r-n][c-j] = an[r-n+1][c-j]; //��
//                ans[r+j][c+n] = an[r+j][c+n-1]; //��
//                ans[r+n][c+j] = an[r+n-1][c+j]; //��
//                ans[r-j][c-n] = an[r-j][c-n+1]; //��
            }
        
        
        System.out.println();
        }
    
    
    }
    static boolean perm(int [] aray) {

        int i=aray.length-1;
        while(i>0 &&aray[i-1] >= aray[i]) i--;
        if(i==0) return false;

        int j=aray.length-1;
        while(aray[i-1] >= aray[j]) j--;
        swap(i-1,j,aray);

        int k=aray.length-1;
        if(i<k) {
            swap(i++,k--,aray);
        }
        return true;

    }
    static void swap(int i,int j,int[] aray) {
        int temp = aray[i];
        aray[i] = aray[j];
        aray[j] = temp;
    }

}