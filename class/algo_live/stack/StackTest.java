package algo_live.stack;

public class StackTest {

	public static void main(String[] args) {
		
		Istack<String> stack = new LinkedListstack<String>();
		
		stack.push("������1");
		stack.push("������2");
		stack.push("������3");
		stack.push("������4");
		
		System.out.println(stack.size());

	}

}
