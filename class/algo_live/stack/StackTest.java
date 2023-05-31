package algo_live.stack;

public class StackTest {

	public static void main(String[] args) {
		
		Istack<String> stack = new LinkedListstack<String>();
		
		stack.push("鬼熱團1");
		stack.push("鬼熱團2");
		stack.push("鬼熱團3");
		stack.push("鬼熱團4");
		
		System.out.println(stack.size());

	}

}
