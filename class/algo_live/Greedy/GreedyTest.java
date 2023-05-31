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
			//������ ũ�� ����, ������ ���
			//����������� ���� ��ȯ�Ѵ�. 
			//this.end -o.end�� ��(����)�� �� ������ ��ü�ϹǷ� �������� ���ĵȴ�
			//����ð����� ������������ �����Ϸ��Ѵ�. -> ������
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
			// Ÿ�̹��� �´� �͵��� �߰��Ѵ�.
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
