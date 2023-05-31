package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_수찾기_1920 {

	static int arr[];
	//static int mrr[];
	public static void main(String[] args) throws Exception{
		// N은 100,000개
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N =Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M =Integer.parseInt(br.readLine());
		//mrr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			
			sb.append(binarySearch(Integer.parseInt(st.nextToken()),0,arr.length-1)).append("\n");
			//mrr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
		
		

	}
	static String binarySearch(int key,int start,int end) {
		if(start > end) {// 
			return "0";
		}
		
		int mid = (start+end)/2;
		if(arr[mid] == key) {
			return "1";
		}else if(arr[mid] < key) { //오른쪽으로
			return binarySearch(key,mid+1,end);
		}else {
			return binarySearch(key,start,mid-1);
		}
	}
	
	

}
