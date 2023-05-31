package algo_live.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreedyTest {
	
	private static class Meeting implements Comparable<Meeting>{
		
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			
			
			return this.end != o.end? this.end -o.end:this.start -o.start;
			//나보다 크면 음수, 작으면 양수
			//양수가나오면 서로 교환한다. 
			//this.end -o.end는 내(뒤쪽)가 더 작으면 교체하므로 오름차순 정렬된다
			//종료시간기준 오름차순으로 정렬하려한다. -> 내가더
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count =sc.nextInt();
		Meeting[] m=new Meeting[count];
		
		for(int i=0; i<count;i++) {
			m[i] = new Meeting(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(m);
		
		List<Meeting> result = new ArrayList<Meeting>();
		result.add(m[0]);
		
		for (int i = 1; i < count; i++) {
			// 타이밍이 맞는 것들을 추가한다.
			if(result.get(result.size()-1).end <= m[i].start) {
				result.add(m[i]);
			}
			
		}
		System.out.println(result.size());
		for(Meeting mm:result) {
			System.out.println(mm);
		}
	}

}
