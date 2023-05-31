package bj.wk2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_탑_2493_z {

static int [][] arr ;
static StringBuilder sb;
//static Queue<Integer,Integer> = new ArrayList<>();
public static void main(String[] args) throws Exception{
    
    BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(b.readLine());
    sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(b.readLine());
    
    arr = new int [1000][2];
    
    int pre=0;

    int max=0;

    int index=0;
    for(int i=0;i<N;i++) {
        int now = Integer.parseInt(st.nextToken());

        index++;
        if(pre > now) {
            arr[index][0] = now;
            arr[index][1] = i+1;
            //w_index = i;
            sb.append(i).append(" ");
            //System.out.print(w_index+" ");

        }else { //pre<=now
            if(max <= now) {// 가장 큰값이 들어오는 경우
                index=0;
                arr[index][0] = now;
                arr[index][1] = i+1;
                max=now;
                //index++;
                sb.append(0).append(" ");
                pre = now;
                continue;
            }else {//가장 큰값은 아니지만, 직전 보다는 커서 확인이 필요한 값
                for(int j =index-1;j>=0;j--) {
                    if(arr[j][0] > now) {
                        
                        sb.append(arr[j][1]).append(" ");    
                        index=j+1; //이전 값들은 지워진다.
                        
                        arr[index][0] = now;
                        arr[index][1] = i+1;
                        
                        //index++;
                        break;
                    }
                }
            }
        }
        pre = now;

    }
    System.out.print(sb);
}
}