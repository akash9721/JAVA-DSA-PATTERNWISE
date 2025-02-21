package com.dsa;

import java.util.Scanner;

public class PrimeNoInRange {

	public static boolean isPrime(int n) {
		if(n<=1) {
			return false;
		}
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static boolean isPrime2(int n) {
		if(n<=1)
			return false;
		
		if(n==2)
			return true;
		
		if(n%2==0)
			return false;
		
		int sqrt=(int) Math.sqrt(n);
		
		for(int i=3;i<=sqrt;i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static void primeNoRange(int start,int end) {
		for(int i=start;i<=end;i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}
	
	public static void primeNoRange2(int start,int end) {
		for(int i=start;i<=end;i++) {
			if(isPrime2(i)) {
				System.out.print(i+" ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first no");
		int first=sc.nextInt();
		System.out.println("Enter second no");
		int second=sc.nextInt();
		primeNoRange(first,second);
		
		System.out.println();
		primeNoRange2(first,second);
		
	}
}
