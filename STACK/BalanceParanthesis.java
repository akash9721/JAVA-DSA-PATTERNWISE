package com.interview;

import java.util.Stack;

public class BalanceParanthesis {

	public static void main(String[] args) {
		
//		String str = "[(){}]"  = true
//		String str = "[({})()]" = true
//		String str = "[())]";// = false
		
		String str = "[(){}]";
		
		System.out.println(paranthesis(str));
	
	}

	private static boolean paranthesis(String str) {
		
		Stack<Character> symbol=new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='[' || str.charAt(i)=='{' || str.charAt(i)=='(') {
				symbol.add(str.charAt(i));
			}
			else {
				if(!symbol.empty() && 
					((symbol.peek()=='[' && str.charAt(i)==']') || 
					(symbol.peek()=='{' && str.charAt(i)=='}')  ||
					(symbol.peek()=='(' && str.charAt(i)==')'))) {
					symbol.pop();
				}
				else {
					return false;
				}
			}
		}
		
		return symbol.empty();
		
	}
}
