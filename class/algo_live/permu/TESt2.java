package algo_live.permu;

import java.util.Arrays;
// total �߿� N���� �̴� ����
public class TESt2 {

	public static void main(String[] args) {
		
		perm(N);
		System.out.println(count);
		

	}
	static int N=3; //total �߿��� ��� �ڸ����� ���� ������
	static int [] total = {11,12,13,14,15}; // ���߿��� N���� �̴´�.
	
	static int [] numbers = new int [N];
	static boolean [] isSelected = new boolean[total.length];
	static int count =0;
	
	

	static void perm(int n){
		//System.out.println(n);
		if(n==0){
			System.out.println(Arrays.toString(numbers));
			count++;
			return;} //��������
		else{
			for(int i=0;i<total.length;i++){ // �� ��ġ�� ���� ����.
				if(isSelected[i] == true) continue;// ������ �ߺ��Ǵ� ���� �ִ��� Ȯ��, ������ �ٸ��� ����
				numbers[n-1] = total[i];
				isSelected[i] = true; //i�� ���� ����Ѵ�.
				perm(n-1); // ���� �ڸ������� �̵��Ѵ�
				isSelected[i] = false;
				// �õ��� ��� ������ ������ ȣ��� ���·� ���ư���.
				//���ư������� ���� ������ ��(isSelected)�� �ٽ� �ǵ��� �ش�. 
			}
		}
	}

}
