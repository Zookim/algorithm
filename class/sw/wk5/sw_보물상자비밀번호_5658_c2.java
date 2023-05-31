package sw.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 그냥 한칸씩 이동하며 모든 숫자를 얻는 것과 같은 결과를 낸다.
public class sw_보물상자비밀번호_5658_c2 {

    static int T, N, K;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 초기화
            list.clear();
            String hexNums = br.readLine(); // 16진수 문자열

            // 4개 면으로 구분
            int oneSize = N / 4; // 16문자 => 4, 12문자 => 3

            // 맨 앞의 면의 hexNums를 뒤에도 붙인다.
            hexNums = hexNums+hexNums.substring(0,oneSize);
            // 한 면의 문자 길이 반복
            for (int i = 0; i < N; i++) {
            	String hex = hexNums.substring(i,i+oneSize);
            	int num = Integer.parseInt(hex, 16);
            	if( ! list.contains(num) ) list.add(num);
            }
           

            // 정렬
            Collections.sort(list);
            System.out.println("#" + t + " " + list.get(list.size() - K ));
        }
    }
}

