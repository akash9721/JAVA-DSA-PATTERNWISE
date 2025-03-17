package com.java8.Features;

import java.util.StringJoiner;

public class StringJoinerDemo {
	public static void main(String[] args) {
		StringJoiner sj1 = new StringJoiner(",", "[", "]");
		sj1.add("akash").add("nayan").add("sam").add("kumar");
		System.out.println(sj1);

		StringJoiner sj2 = new StringJoiner(":");
		sj2.add("ABC").add("DEF").add("GHI");
		System.out.println(sj2);

		sj1.merge(sj2);
		System.out.println(sj1);
	}

}


+++++++++++++++++output++++++++++++++++++++
[akash,nayan,sam,kumar]
ABC:DEF:GHI
[akash,nayan,sam,kumar,ABC:DEF:GHI]
