package algo_live.subset;

public class SubsetBitmask {
	
	static int src[] = {1,2,3,4,5};
	static int len = src.length;
	
	public static void main(String[] args) {
		int mask=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i <(1<<len);i++) { //�̸�ŭ�� �κ������� �����Ұ��̴�.
			//�� i�� ��Ʈ ���� �κ� ������ �ǹ��Ѵ�.
			for(int j=0;j<len;j++) { //���� i�� ���� ���ڸ��� ���� �������� ������ �����Ѵ�.
				if((i  & (1 << j)) != 0) {
					sb.append(src[j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
