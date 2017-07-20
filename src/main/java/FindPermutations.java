package main.java;

import java.util.ArrayList;
import java.util.List;

public class FindPermutations {

	public static List<String> permList = new ArrayList<String>();
	public static String input = "abcd";
	
	public static void main(String[] args) {
			
		permList.add(input);
		findPerm(input);
		for(String s : permList){
			System.out.println(s);
		}
	}
	
	public static void findPerm(String s){

		String substring = new String(s.substring(1));//get substring not including first char
		String firstChar = String.valueOf(s.charAt(0));// get first char
		String newString = merge(substring, firstChar, "");// append first char to end of string
		
		if(!newString.equals(input)){
			permList.add(newString);
			
			if(permList.size() != factorial(input.length()))
				findPerm(newString);
		} else{
			findPerm(merge(String.valueOf(input.charAt(1)) ,String.valueOf(input.charAt(0)) ,input.substring(2, input.length())));
		}
	}
	
	public static String merge(String s1, String s2, String s3){
		return s1+s2+s3;
	}
	
	public static int factorial(int i){
		if(i == 0)
			return 1;
		return i*factorial(i-1);
	}

}
