package basic.wk4;

import java.util.Arrays;

public class DisJoinSet {
	static int[] parents; //한집합에 소속되어있다. -> 부모가 같거나 or 조상이 같다.
	
	public static void main(String[] args) {
		//자료구조 생성
		makeSet(); //서로소 집합, 자기자신밖에 없음
		
		
		
		
		System.out.println(" 0  1  2  3  4  5  6  7  8  9 "); // 자신이 누구인지
		System.out.println(Arrays.toString(parents));
		System.out.println();
		
//		parents[2]=3; // 2의 부모를 3으로 바꾼다.
//		parents[3] =5; // 3의 부모를 5로 바꾼다.
		
		union(3,2); //2가 3의 집합으로 흡수된다.
		union(5,2);
		System.out.println(Arrays.toString(parents));
		
		
		System.out.println(findSet(2)); 
		System.out.println(findSet(3));
		System.out.println(findSet(5));//최상위 부모이므로 모두 같다.
	
		
		union(8,7); //7이 8의 집합으로 흡수된다.
		System.out.println(Arrays.toString(parents));
		
		
		//두 원소가 같은 집합에 속하는지 아닌 지 확인
		//2,7이 같은 집합인가?
		if(findSet(2) ==  findSet(7)) System.out.println("same");
		else {System.out.println("Not same");}
	
		
		union(2,7); //7이 8의 집합으로 흡수된다.
		System.out.println(Arrays.toString(parents));
		// 상태를 확인
		

	}
	//x가 속한 집합 전체와 y가 속한 집합전체를 합친다.
	// 해당원소만 옮기면 안된다.
	static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		parents[py] = px; //y의 집합이 x의 집합 내로 흡수된다.
		
	}
	static void makeSet() {
		parents = new int[10];
		for(int i=0;i<10;i++) {
			parents[i]=i; //부모가 누구인지 저장한다.
		}
	}
	//집합을 표현하는 최상위 부모를 찾아서 return
	static int findSet(int x) {
		if(parents[x] == x) return x; // 자신이 부모이므로 집합의 대표
		
		else return findSet( parents[x]); //자신의 부모를 찾는다.
	}

}
