package basic.wk3;

public class BinarySearchTest {

	
	static int values[] = {3,11,15,20,21,29,45,59,65,72}; 
	public static void main(String[] args) {


		System.out.println(binarySearch(22));
		System.out.println(binarySearchRecursive(22,0,values.length));
		
		System.out.println(binarySearch(3));
		System.out.println(binarySearchRecursive(3,0,values.length));
		
		System.out.println(binarySearch(65));
		System.out.println(binarySearchRecursive(65,0,values.length));

	}
	static int binarySearch(int key) {
		//인덱스들
		int start =0;
		int end = values.length-1; //end의 범위도 포함란다.
		int mid=0;
		
		
		//찾고자하는 키가 start와 end 사이에있을 것이다.
		//자료는 정렬되어있을때, 가운데 값을 key의 후보로 둔다.
		while(start <= end) { // start가 end보다 커지면 break
			mid = (start +end) /2;
			if(values[mid] == key) return mid;
			else if (values[mid] < key) start = mid+1; //중앙값을 제외한 오른쪽에 있다.
			else end = mid-1; // 중앙값을 제외한 왼쪽에 있다.
		}
		return -1; //못찾고 while문이 끝난경우
	}

	static int binarySearchRecursive(int key,int start, int end) {

		if(start <= end) { // start가 end보다 커지면 break
			int mid = (start +end) /2;
			if(values[mid] == key) return mid;
			else if (values[mid] < key) return binarySearchRecursive(key,mid+1,end); //중앙값을 제외한 오른쪽에 있다.
			else return binarySearchRecursive(key,start,mid-1); // 중앙값을 제외한 왼쪽에 있다.
		}
		return -1; //못찾고 while문이 끝난경우
	}


}
