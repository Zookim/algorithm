package basic.wk1;
//재귀 호출
//stack, queue 자료구조의 이해
// stack : FILO =>dfs, java.util.Collection이 스택 자료구조를 사용할 수 있다. 이자료구조 대신  method call 사용
//	java는 method 호출이 이어지면 그것자체가 바로 stack구조를 내부적으로 이용

//Queue : FIFO

//이 실습을 통해서
//1. 재귀호출의 기저조건 이해
//2. 현재 단계 - 재귀호출 메소드가 실행되는 - 필요한 작업이 무엇인지 명확히 이해
//3. 재귀호출의 위치에 따른 작업의 선,후행관계 파악
//4. 재귀호출과정에서 변수나 자료구조의 공유를 어떻게 할것인가? - static, 파라미터 이용
//5. 재귀 호출과정에서 답안을 도출하는 과정이 위 -> 아래, 또는 아래 -> 위로 처리되는지 구분

public class RecursiveCall {
	static int m=0;
	//main()
	// m1()
	//   m2()
	//	m2() 종료
	// m1()종료
	//main() 종료
	
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
		factorial(n-1); //return 되는 위치 즉 앞선 호출에서 계산이 이미 끝난 상태
		// return 될때는 계산하지 않는다.
		
	}
	static int factorial2(int n) {
		if(n==1) {return 1;}
		 return n * factorial2(n-1); // return 되면서 계산이 완료된다.앞에선 계산되지 않는다.
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
			System.out.println("종료"+m2_cnt);
		}
		System.out.println("종료2 "+m2_cnt);
	}
	
	
	static int m2_correct_cnt =5;
	static void m2_correct() {
		System.out.println("m2_correct_cnt = " + m2_correct_cnt);
		if(m2_correct_cnt == 0) return;

		m2_correct_cnt--;
		m2_correct();
		System.out.println("종료"+m2_correct_cnt);

		
	}
	
	static int m3_correct_cnt =5;
	static void m3_correct() {
		// 기저조건, 더이상 재귀호출을 하지 않을 조건은 위에 위치한다.
		if(m3_correct_cnt == 0) return;
		
		System.out.println("m3_correct_cnt = " + m3_correct_cnt);

		m3_correct_cnt--;
		m3_correct();
		System.out.println("종료"+m3_correct_cnt);

		
	}
	
	static void  m4_correct() {
		// 기저조건, 더이상 재귀호출을 하지 않을 조건은 위에 위치한다.
		if(m3_correct_cnt == 0) return;
		
		System.out.println("m3_correct_cnt = " + m3_correct_cnt);

		m3_correct_cnt--;
		m4_correct();
		m3_correct_cnt++;
		System.out.println("종료"+m3_correct_cnt);

		
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
	
	static int hanoi(int n) { //n개를 이동시킬때
		if(n ==1)return 1;
		if (n % 2 ==1) { //3번 막대로 이동
			
		}else {// 2번 막대로 이동
			
		}
		return 0;
		
		
		
		
	}


}
