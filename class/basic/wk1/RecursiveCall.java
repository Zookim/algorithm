package basic.wk1;
//��� ȣ��
//stack, queue �ڷᱸ���� ����
// stack : FILO =>dfs, java.util.Collection�� ���� �ڷᱸ���� ����� �� �ִ�. ���ڷᱸ�� ���  method call ���
//	java�� method ȣ���� �̾����� �װ���ü�� �ٷ� stack������ ���������� �̿�

//Queue : FIFO

//�� �ǽ��� ���ؼ�
//1. ���ȣ���� �������� ����
//2. ���� �ܰ� - ���ȣ�� �޼ҵ尡 ����Ǵ� - �ʿ��� �۾��� �������� ��Ȯ�� ����
//3. ���ȣ���� ��ġ�� ���� �۾��� ��,������� �ľ�
//4. ���ȣ��������� ������ �ڷᱸ���� ������ ��� �Ұ��ΰ�? - static, �Ķ���� �̿�
//5. ��� ȣ��������� ����� �����ϴ� ������ �� -> �Ʒ�, �Ǵ� �Ʒ� -> ���� ó���Ǵ��� ����

public class RecursiveCall {
	static int m=0;
	//main()
	// m1()
	//   m2()
	//	m2() ����
	// m1()����
	//main() ����
	
	public static void main(String[] args) {
		//m2();
		//m2_correct();
		//m3_correct();
		//m4_correct();
		//m3(5);
		
		factorial(5);
		System.out.println(res);
		int r = factorial2(5);
		System.out.println(r);

	}
	static int res = 1;
	static void factorial(int n) {
		if(n==1) {
			System.out.println(n);
			return;}
		res = n * res;
		factorial(n-1); //return �Ǵ� ��ġ �� �ռ� ȣ�⿡�� ����� �̹� ���� ����
		// return �ɶ��� ������� �ʴ´�.
		
	}
	static int factorial2(int n) {
		if(n==1) {return 1;}
		 return n * factorial2(n-1); // return �Ǹ鼭 ����� �Ϸ�ȴ�.�տ��� ������ �ʴ´�.
	}
	
	
	
	
//	static void m1() {
//		m++;
//		System.out.println(m);
//		m1();
//		
//	}
	
	static int m2_cnt = 5;
	static void m2() {
		System.out.println("m2_cnt = " + m2_cnt);
		if(m2_cnt >0) {
			m2_cnt--;
			m2();
			System.out.println("����"+m2_cnt);
		}
		System.out.println("����2 "+m2_cnt);
	}
	
	
	static int m2_correct_cnt =5;
	static void m2_correct() {
		System.out.println("m2_correct_cnt = " + m2_correct_cnt);
		if(m2_correct_cnt == 0) return;

		m2_correct_cnt--;
		m2_correct();
		System.out.println("����"+m2_correct_cnt);

		
	}
	
	static int m3_correct_cnt =5;
	static void m3_correct() {
		// ��������, ���̻� ���ȣ���� ���� ���� ������ ���� ��ġ�Ѵ�.
		if(m3_correct_cnt == 0) return;
		
		System.out.println("m3_correct_cnt = " + m3_correct_cnt);

		m3_correct_cnt--;
		m3_correct();
		System.out.println("����"+m3_correct_cnt);

		
	}
	
	static void  m4_correct() {
		// ��������, ���̻� ���ȣ���� ���� ���� ������ ���� ��ġ�Ѵ�.
		if(m3_correct_cnt == 0) return;
		
		System.out.println("m3_correct_cnt = " + m3_correct_cnt);

		m3_correct_cnt--;
		m4_correct();
		m3_correct_cnt++;
		System.out.println("����"+m3_correct_cnt);

		
	}

	static void m3(int m3_cnt) {
		if(m3_cnt == 0) return;

		System.out.println("m3_cnt = " + m3_cnt);

//		m3_cnt--;
//		m3(m3_cnt);
//		m3_cnt++;
		
		m3(m3_cnt -1);
		System.out.println("m3_cnt(2) = "+m3_cnt);
	}
	
	static int hanoi(int n) { //n���� �̵���ų��
		if(n ==1)return 1;
		if (n % 2 ==1) { //3�� ����� �̵�
			
		}else {// 2�� ����� �̵�
			
		}
		return 0;
		
		
		
		
	}


}
