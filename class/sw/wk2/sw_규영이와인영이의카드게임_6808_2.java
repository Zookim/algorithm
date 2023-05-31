package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_규영이와인영이의카드게임_6808_2 {

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
		//이미 정렬되어있다.
		while(true) {
			check();
			if(!np()) break;
		}
		System.out.println("#" + t + " " + win + " " + lose);
	}

}

static boolean np() { //true: 더 큰수를 만들 수 있다. false 더이상 큰수는 없다.
	int[] src = inCard;
	int i= src.length -1;

	while(i>0 && src[i-1] >=src[i]) --i; // 내림차수이면 계속 앞으로 이동
	if(i ==0) return false;//만약 맨앞이면 ,더이상 없다.

	int j = src.length -1;
	while(src[i-1] >= src[j]) j--;//
	swap(i-1,j); // 앞에서 바꿀 값과 뒤에서 바꿀값을 찾았다.

	int k = src.length -1;
	while(i < k) {
		swap(i++,k--); //중앙으로 오는 방향
	}
	return true;
}

// inCard 를 이용한 순열이 완성되었으므로 win, lose 따진다.
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
