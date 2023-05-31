package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_�Կ��̿��ο�����ī�����_6808_2 {

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
		//�̹� ���ĵǾ��ִ�.
		while(true) {
			check();
			if(!np()) break;
		}
		System.out.println("#" + t + " " + win + " " + lose);
	}

}

static boolean np() { //true: �� ū���� ���� �� �ִ�. false ���̻� ū���� ����.
	int[] src = inCard;
	int i= src.length -1;

	while(i>0 && src[i-1] >=src[i]) --i; // ���������̸� ��� ������ �̵�
	if(i ==0) return false;//���� �Ǿ��̸� ,���̻� ����.

	int j = src.length -1;
	while(src[i-1] >= src[j]) j--;//
	swap(i-1,j); // �տ��� �ٲ� ���� �ڿ��� �ٲܰ��� ã�Ҵ�.

	int k = src.length -1;
	while(i < k) {
		swap(i++,k--); //�߾����� ���� ����
	}
	return true;
}

// inCard �� �̿��� ������ �ϼ��Ǿ����Ƿ� win, lose ������.
static void check() {
	int guSum = 0;
	int inSum = 0;
	for (int i = 0; i < N; i++) {
		if( guCard[i] > inCard[i] ) guSum += guCard[i] + inCard[i];
		else inSum += guCard[i] + inCard[i];
	}
	if( guSum > inSum ) win++;
	else if( guSum < inSum ) lose++;
}
static void swap(int i,int j) {
	int[] src = inCard;
	int temp = src[i];
	src[i] = src[j];
	src[j] =temp;
}
}
