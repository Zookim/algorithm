package bj.wk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_����Լ���������_17479_my {

	public static void main(String[] args) throws Exception {
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(b.readLine());
		StringBuilder str = new StringBuilder();
		str.append("");
		re(n,str);
	}
	
	public static void re(int n,StringBuilder str) {
		if(n== 0) {
			System.out.print(str);
			System.out.println("\"����Լ��� ������?\"");
			System.out.print(str);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.print(str);
			System.out.println("��� �亯�Ͽ���.");
			return;
		}
		
		System.out.print(str);
		System.out.println("\"����Լ��� ������?\"");
		System.out.print(str);
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.print(str);
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.print(str);
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		str.append("____");
		re(n-1,str);
		
		if(str.length() !=0) {
			for(int i=0;i<4;i++) str.deleteCharAt(str.length()-1);
		}
		System.out.print(str);
		System.out.println("��� �亯�Ͽ���.");
		
		
		
	}

}