package sedg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GPC {
	
	private static String header;
	private static String output;
	private static String methodBody;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scnr = new Scanner(new File("New Text Document.txt"));
		
		while(scnr.hasNext())
			header += scnr.nextLine();
		
		methodBody = header.substring(header.indexOf('{') + 1, header.lastIndexOf('}'));
		
		String name = "METHOD ";
		String input = "INPUT ";
		output = "OUTPUT ";
		

		findName(name);
		findInput(input);
		findOutput(output);
		
		pseudocodize();
		
	}

	private static void pseudocodize() {
		
		
		forLoopCheck();
		methodBody = methodBody.replaceAll("for", "FOR");
		ArraysEqualsCheck();
		checkForScanner();
		methodBody = methodBody.replaceAll("[\\(,\\)]", " ");
		checkShortHand();
		methodBody = methodBody.replaceAll("<", "SMALLER THAN");
		methodBody = methodBody.replaceAll(">", "BIGGER THAN");
		methodBody = methodBody.replaceAll("<=", "SMALLER OR EQUAL THAN");
		methodBody = methodBody.replaceAll(">=", "BIGGER OR EQUAL THAN");
		methodBody = methodBody.replaceAll("Arrays.equals", "");
		methodBody = methodBody.replaceAll("if", "IF");
		methodBody = methodBody.replaceAll("else", "ELSE");
		methodBody = methodBody.replaceAll("while", "WHILE");
		methodBody = methodBody.replaceAll("do", "DO");
		methodBody = methodBody.replaceAll("return", "\n	RETURN");
		methodBody = methodBody.replaceAll("\\|.", "OR");
		methodBody = methodBody.replaceAll("==", "EQUALS");
		methodBody = methodBody.replaceAll("!=", "NOT EQUAL");
		methodBody = methodBody.replaceAll("\\&.", "AND");
		methodBody = methodBody.replaceAll("System.out.print..", "PRINT");
		methodBody = methodBody.replaceAll(";", "\n");
		System.out.println(methodBody);
		
	}

	private static void checkForScanner() {
		
		int start = 0;
		int a = methodBody.indexOf(".next", start);
		int i = a;

		while(a > 0) {

			while(!methodBody.substring(i, i + 1).equals(";"))
				i++;
			while(!methodBody.substring(a - 1, a).matches("\\s"))
				a--;
			replaceInRange(methodBody.substring(a,i), "INPUT FROM KEYBOARD", a, i);
			start = a + 1;
			a = methodBody.indexOf(".next", start);
			i =a ;
			
		}
		
	}

	private static void checkShortHand() {
		
		int start = 0;
		int arraysEquals = methodBody.indexOf("++", start);

		while(arraysEquals > 0) {

			findShortHandArgs(arraysEquals);
			start = arraysEquals + 1;
			arraysEquals = methodBody.indexOf("++", start);
			
		}
		
		int start1 = 0;
		int arraysEquals1 = methodBody.indexOf("--", start);

		while(arraysEquals1 > 0) {

			findShortHandArgs(arraysEquals1);
			start1 = arraysEquals1 + 1;
			arraysEquals1 = methodBody.indexOf("--", start);
			
		}
		
		methodBody = methodBody.replaceAll("\\++", "INCREMENT");
		methodBody = methodBody.replaceAll("\\--", "DECREMENT");

		
	}

	private static void findShortHandArgs(int signPos) {
		
		String sign ="\\" + methodBody.substring(signPos, signPos + 2);
		int i = signPos;
		while(!methodBody.substring(i - 1, i).matches("\\s"))
			i--;
		String thingy = methodBody.substring(i - 1, signPos);
		replaceInRange(thingy+sign ,sign + thingy, i - 1, signPos + 2);
		
	}

	private static void forLoopCheck() {
		int start = 0;
		int arraysEquals = methodBody.indexOf("for(", start);

		while(arraysEquals > 0) {

			findLoopArgs(arraysEquals);
			start = arraysEquals + 1;
			arraysEquals = methodBody.indexOf("for(", start);
			
		}
		
	}

	private static void findLoopArgs(int arraysEquals) {
		String upOrdown;
		int bigger = methodBody.indexOf("<");
		int smaller = methodBody.indexOf(">");
		if(bigger > 0) upOrdown = "UP TO";
		else upOrdown = "DOWN TO ";
		int endofLoop = methodBody.indexOf(")", arraysEquals) + 1;
		int beg = methodBody.indexOf(" ", methodBody.indexOf("int"));
		String number = methodBody.substring(beg, methodBody.indexOf(' ', beg + 1));

		if(bigger >= 0) {
		String check = methodBody.substring(bigger + 1, methodBody.indexOf(';', bigger));
		replaceInRange("int", "", arraysEquals, endofLoop);
		replaceInRange(";", "", arraysEquals, endofLoop-1);
		replaceInRange("< "+check.trim(), upOrdown + check , arraysEquals, endofLoop);

		//CHECK!
		//replaceInRange(number.trim()+" ", "", methodBody.indexOf('=', arraysEquals), endofLoop);
		//replaceInRange("[\\(,\\)]", "", arraysEquals, endofLoop);

		replaceInRange(".\\++", "", arraysEquals, endofLoop);
		}
		
		else if (smaller >= 0) {
			String check = methodBody.substring(smaller + 1, methodBody.indexOf(';', smaller));
			methodBody = methodBody.replaceAll("for", "FOR");
			replaceInRange("int", "", arraysEquals, endofLoop);
			replaceInRange(";", "", arraysEquals, endofLoop-1);
			replaceInRange("> "+check.trim(), upOrdown + check, arraysEquals, endofLoop);
			replaceInRange(number.trim()+" ", "", methodBody.indexOf('=', arraysEquals), endofLoop);
			replaceInRange("[\\(,\\)]", "", arraysEquals, endofLoop);
			replaceInRange(".\\++", "", arraysEquals, endofLoop);
		}
	}

	private static void ArraysEqualsCheck() {
		int start = 0;
		int arraysEquals = methodBody.indexOf("Arrays.equals", start);
		while(arraysEquals > 0) {
			findArraysArgs(arraysEquals);
			start = arraysEquals + 1;
			arraysEquals = methodBody.indexOf("Arrays.equals", start);
		}		
	}

	private static void findArraysArgs(int arraysEquals) {
		int startOfFirst = methodBody.indexOf("(", arraysEquals) + 1;
		int endofFirst = methodBody.indexOf(',', startOfFirst);
		int startOfSecond = endofFirst + 1;
		int endofSecond = methodBody.indexOf(")", startOfSecond);
		replaceInRange(","," EQUALS", startOfFirst, endofSecond);		
		
	}

	private static void replaceInRange(String string, String string2, int startOfFirst,int endofSecond) {
		
		String regex = string;
		String replacement = string2;
		String range = methodBody.substring(startOfFirst, endofSecond);
		String beggining = methodBody.substring(0, startOfFirst);
		String ending = methodBody.substring(endofSecond);
		range = range.replaceAll(regex, replacement);
		methodBody = null;
		methodBody = beggining + range + ending;
		
	}

	private static void findOutput(String output) {
		
		if(output.equals("void"))
			System.out.println("OUTPUT ");
		else
			System.out.println("OUTPUT " + output);
	}

	private static void findInput(String input) {
		int paramBracet = header.indexOf('(') + 1;
		String params = header.substring(paramBracet, header.indexOf(")"));
		System.out.println(input + params);
	}

	private static void findName(String name) {
		String methodName = null;
		try{
			methodName = header.substring(0, header.indexOf('{'));}
		catch(Exception ex){
			methodName = header;
		}
		methodName = new StringBuffer(methodName).reverse().toString();
		int parBracet = methodName.indexOf('(');
		int nameEnd = methodName.indexOf(" ", parBracet);
		String type = methodName.substring(nameEnd + 1, methodName.indexOf(" ", nameEnd + 1));
		output = new StringBuffer(type).reverse().toString();
		methodName = new StringBuffer(methodName.substring(parBracet + 1, nameEnd )).reverse().toString();
		System.out.println(name + methodName);
	}
}
