package algo_live.subset;

public class SubsetBitmask {
	
	static int src[] = {1,2,3,4,5};
	static int len = src.length;
	
	public static void main(String[] args) {
		int mask=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i <(1<<len);i++) { //이만큼의 부분집합을 수구할것이다.
			//각 i의 비트 값이 부분 집합을 의미한다.
			for(int j=0;j<len;j++) { //이제 i로 부터 각자리의 수를 선택할지 말지를 결정한다.
				if((i  & (1 << j)) != 0) {
					sb.append(src[j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
