package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_��ȣ��1_1228_array {

    static int N, M;
    //static List<String> list = new ArrayList<>();
    static List<String> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {

            // �ʱ�ȭ
            list.clear();

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                // I, x, y
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // x�� ��ġ�� y �� ��ŭ ���ڿ��� �߰�
                int count = x + y;
                for (int j = x; j < count; j++) {
                    list.add(j, st.nextToken()); // ���� ���� �ڷ� �и���.
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

    System.out.println(sb);
}
}

	


