package algo_live.permu;

import java.util.Arrays;

public class TESt {

	public static void main(String[] args) {
		
		perm(N);
		System.out.println(count);

	}
	static int N=4;
	
	static int [] numbers = new int [N];
	static boolean [] isSelected = new boolean[N];
	static int count =0;

	static void perm(int n){
		//System.out.println(n);
		if(n==0){
			System.out.println(Arrays.toString(numbers));
			count++;
			return;} //��������
		else{
			for(int i=0;i<=N-1;i++){ // �� ��ġ�� ���� ����.
				if(isSelected[i] == true) continue;// ������ �ߺ��Ǵ� ���� �ִ��� Ȯ��, ������ �ٸ��� ����
				numbers[n-1] = i+1;
				isSelected[i] = true; //i�� ���� ����Ѵ�.
				perm(n-1); // ���� �ڸ������� �̵��Ѵ�
				isSelected[i] = false;
				// �õ��� ��� ������ ������ ȣ��� ���·� ���ư���.
				//���ư������� ���� ������ ��(isSelected)�� �ٽ� �ǵ��� �ش�. 
			}
		}
	}

}
