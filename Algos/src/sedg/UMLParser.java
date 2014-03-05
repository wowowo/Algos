package sedg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UMLParser {
		
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scnr = new Scanner(new File("ThreeDice.java"));
		String txt = "";
		
		while(scnr.hasNext())
			txt += scnr.nextLine();
		
		
		int classBracet = txt.indexOf("{");
		String className = txt.substring(txt.indexOf("public class")+12, classBracet);
		int methodStart = txt.indexOf( ") {" , classBracet);
		String variableBody = txt.substring(classBracet, methodStart);
		int variableEnd = variableBody.lastIndexOf(';') + 1;
		String addition = variableBody.substring(variableEnd);
		variableBody = variableBody.substring(1, variableEnd);
		String methodBody = addition + txt.substring(methodStart, txt.lastIndexOf('}')) ;

		
		System.out.println(className);

		printVariables(variableBody);
		printMethods(methodBody);
		
		


	}

	private static void printMethods(String methodBody) {
		
		System.out.println("\n");
		
		String[] checks = {"for(", "while(", "if(", "case(", "else(", "else if("};
		ArrayList<String> methods = new ArrayList<>();
		
		if(methodBody.trim().length() == 0)
			return;
		
		int openingBracet = methodBody.indexOf("{");
		int closingBracet =1;
		
		while(openingBracet > 0) {
			
			
			if(openingBracet < closingBracet) {
				int temp = openingBracet;
				openingBracet = closingBracet;
				closingBracet = temp;
			}
			String method = methodBody.substring(closingBracet, openingBracet);
			boolean toAdd = true;

			
			for(String s: checks)
				if (method.contains(s))
					toAdd = false;
			
			if(toAdd)
				methods.add(method);
			
			int temp = closingBracet + 1;
			closingBracet = methodBody.indexOf("}", temp) + 1;
			openingBracet = methodBody.indexOf("{", openingBracet+ 1);
		}
		
		
		
		for(String s: methods)
			formatMethod(s);
		
	}

	private static void formatMethod(String s) {
		
		if(s.indexOf('{') >= 0 && s.indexOf('}') > 0)
			return;
		if(s.trim().startsWith("else"))
			return;
		String params = s.substring(s.indexOf('(', s.indexOf("//)")));
		String cleared = s.substring(0, s.indexOf('('));
		String[] parts = cleared.split("[ ]+");
		
		if(parts.length > 3) {
			String method = parts[0]+ " ";
			method += parts[3];
			method += params + " :";
			method += " " + parts[2];
			method.replaceAll("public", "+");
			method.replaceAll("private", "-");
			System.out.println(method);

		}
		
		else if(parts.length == 3) {
			String method = parts[0]+ " ";
			method += parts[2];
			method += params + " :";
			method += " " + parts[1];
			method = method.replaceAll("public", "+");
			method = method.replaceAll("private", "-");
			System.out.println(method);

		}
		
		else if(parts.length == 2) {
			String method = parts[0] + " ";
			method += parts[1] + params;
			method = method.replaceAll("public", "+");
			method = method.replaceAll("private", "-");
			System.out.println(method);
		}
	}

	private static void printVariables(String variable) {
		System.out.println("\n");
		String[] variables = variable.split(";");
		for(String s: variables) {
			int sign = s.indexOf('=');
			if(sign < 0)
				sign = s.length();
			s = s.substring(0, sign);
			String[] parts = s.split("[ ]+");
			
			if(parts.length == 3) {
				String var = parts[0] + " " + parts[2] + " : " + parts[1];
				var = var.replace("public", "+");
				var = var.replace("private", "-");
				System.out.println(var);
			}
			
			else if(parts.length == 4) {
				String var = parts[0] + " " + parts[3] + " : " + parts[2];
				var = var.replace("public", "+");
				var = var.replace("private", "-");
				System.out.println(var);
			}
			
		
		
		}
	}

}
