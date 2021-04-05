package com.qa.testdrivendevelopment;

import java.util.Objects;

public class Questions {

	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		// System.out.println(name);
		return "Hi " + name;
	}

	/**
	 * Given a string, return a string where for every char in the original string,
	 * there are three chars.<br>
	 * <br>
	 * 
	 * For Example:<br>
	 * multChar("The") → "TTThhheee"<br>
	 * multChar("AAbb") → "AAAAAAbbbbbb"<br>
	 * multChar("Hi-There") → "HHHiii---TTThhheeerrreee"
	 */
	public String multiChar(String input) {
		String[] array = input.split("", 0);
		String out = "";
		for (String a : array) {
			String b = a + a + a;
			out += b;
		}
		return out;
	}

	/**
	 * Return the string (backwards) that is between the first and last appearance
	 * of "bread" in the given string, or return the empty string "" if there is not
	 * 2 occurances of "bread". Ignore Case<br>
	 * <br>
	 * For Example: sandwichFilling("breadclivebread") → "evilc"<br>
	 * sandwichFilling("xxbreadfridgebreadyy") → "egdirf"<br>
	 * sandwichFilling("xxBreadfridgeBReAdyy") → "egdirf"<br>
	 * sandwichFilling("xxbreadyy") → "" sandwichFilling("xxbreADyy") → ""<br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */

	public String sandwichFilling(String sandwich) {
		// Converts to lowercase
		String work = sandwich.toLowerCase();

		// Counts occurences of bread in text
		int temp = work.split("bread").length;

		String out = "";

		if (temp < 2) {
			out = "";
		} else {
			// start of 1st bread
			int bread = work.indexOf("bread");
			// end of 1st bread
			int breadend = bread + 4;
			// start of 2nd bread
			int bread2 = work.lastIndexOf("bread");
			// from space prior to start of 2nd bread
			// count backwards adding the letter at current
			// space to the end of the output
			for (int i = bread2 - 1; i > breadend; i--) {
				out = out + sandwich.charAt(i);
			}
		}
		return out;
	}

	/**
	 * Given three ints, a b c, one of them is small, one is medium and one is
	 * large. Return true if the three values are evenly spaced, so the difference
	 * between small and medium is the same as the difference between medium and
	 * large. Do not assume the ints will come to you in a reasonable order.<br>
	 * <br>
	 * For Example:<br>
	 * evenlySpaced(2, 4, 6) → true<br>
	 * evenlySpaced(4, 6, 2) → true<br>
	 * evenlySpaced(4, 6, 3) → false<br>
	 * evenlySpaced(4, 60, 9) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		// set boolean
		boolean bool = true;
		// find min value
		double x = Math.min(a, b);
		x = Math.min(x, c);
		// find max value
		double y = Math.max(a, b);
		y = Math.max(y, c);

		// find mid point
		double d = (x + y) / 2;

		if (d == a) {
		} else if (d == b) {
		} else if (d == c) {
		} else {
			bool = !bool;
		}
		return bool;
	}

	/**
	 * Given a string and an int n, return a string that removes n letters from
	 * the'middle' of the string. The string length will be at least n. The input
	 * string will have an odd number of letters. n will always be an odd
	 * number.<br>
	 * <br>
	 * For Example:<br>
	 * nMid("Hello", 3) → "Ho"<br>
	 * nMid("Chocolate", 3) → "Choate"<br>
	 * nMid("Chocolate", 1) → "Choclate"<br>
	 */
	public String nMid(String input, int n) {
		// find centre
		int temp = (input.length() / 2);
		// find number of letters to remove either side of centre
		int cut = (n - 1) / 2;
		// make left half
		String outa = input.substring(0, (temp - cut));
		// make right half
		String outb = input.substring(temp + cut + 1, input.length());
		// add the 2 halves together
		String out = outa + outb;
		return out;
	}

	/**
	 * Given a string, return the boolean True if it ends in "java" and False if
	 * does not end in "java". Ignore Case.<br>
	 * <br>
	 * For Example: <br>
	 * endsJava("ilovejava") → true <br>
	 * endsJava("iloveJaVa") → true <br>
	 * endsJava("welovejava") → true <br>
	 * endsJava("welovejavamoreeveryday") → false <br>
	 * endsJava("javaiscool") → false <br>
	 * endsJava("pythoniscool") → false <br>
	 */
	public boolean endsJava(String input) {
		// Converts to lowercase
		String work = input.toLowerCase();
		// find length of word
		int temp = input.length();
		// length of word -4
		int i = temp - 4;
		// returns last 4 characters
		String check2 = work.substring(i, input.length());
		// checks if
		boolean check3 = Objects.equals("java", check2);
		return check3;
	}

	/**
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same, do not ignore case.<br>
	 * <br>
	 * For Example: superBlock("hooopplla") → 3 <br>
	 * superBlock("abbCCCddDDDDeeEEE") → 4 <br>
	 * superBlock("abbCCCCC")) → 5 <br>
	 * superBlock("") → 0 <br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */
	public int superBlock(String input) {
		int count[] = new int[256];
		int max = 0;
		int len = input.length();
		for (int i = 0; i < len; i++) {
			count[input.charAt(i)]++;
		}
		for (int i = 0; i < len; i++) {
			if (max < count[input.charAt(i)]) {
				max = count[input.charAt(i)];
			}
		}
		return max;
	}

	/**
	 * Given a string - return the number of times "am" appears in the String
	 * ignoring case - BUT ONLY WHEN the word "am" appears without being followed or
	 * preceded by other letters <br>
	 * <br>
	 * For Example: <br>
	 * amISearch("Am I in Amsterdam") → 1 <br>
	 * amISearch("I am in Amsterdam am I?") → 2 <br>
	 * amISearch("I have been in Amsterdam") → 0 <br>
	 * <br>
	 * HINT: String.toLowerCase
	 */
	public int amISearch(String sentence) {
		// Initialise
		char checkst = ' ';
		char checken = ' ';
		int count = 0;
		int start = 0;
		int len = sentence.length();
		// Converts to lower case
		String work = sentence.toLowerCase();
		// Counts occurrences of "am" in text for the loop
		int temp = work.split("am").length;
		// Checks whole sentence from for loop
		for (int i = 0; i < temp; i++) {
			int am = work.indexOf("am", start);
			//index before the "am"
			int amst = am - 1;
			//index after the "am"
			int amen = am + 2;
			//if statement to avoid fringe cases of am being negative
			if (am >= 0) {
				// check space before "am" is blank
				if (amst > 0) {
					checkst = work.charAt(amst);
				} else {
					checkst = ' ';
				}
				// check space after "am" is blank
				if (amen < len) {
					checken = work.charAt(amen);
				} else {
					checken = ' ';
				}
				//increases a counter if am appears without any other letters
				if (checkst == ' ' && checken == ' ') {
					count = count + 1;
				}
				start = am + 2;
			}
		}
		return count;
	}

	/**
	 * Given a number if this number is divisible by 3 return "fizz" if this number
	 * is divisible by 5 return "buzz" if this number is divisible by both 3 and 5
	 * return "fizzbuzz" if this number is not divisible by 3 or 5 return null<br>
	 * <br>
	 * For Example: <br>
	 * fizzBuzz(3) → "fizz" <br>
	 * fizzBuzz(10) → "buzz" <br>
	 * fizzBuzz(15) → "fizzbuzz" <br>
	 * fizzBuzz(8) → null
	 */
	public String fizzBuzz(int number) {
		int a = number % 3;
		int b = number % 5;

		String out = "";
		if (a == 0 && b != 0) {
			out = "fizz";
		} else if (b == 0 && a != 0) {
			out = "buzz";
		} else if (a == 0 && b == 0) {
			out = "fizzbuzz";
		} else
			return null;
		return out;
	}

	/**
	 * Given a string, split the string into the individual numbers present then add
	 * each digit of each number to get a final value for each number <br>
	 * <br>
	 * String example = "55 72 86"<br>
	 * <br>
	 * "55" will = the integer 10 <br>
	 * "72" will = the integer 9 <br>
	 * "86" will = the integer 14 <br>
	 * <br>
	 * You then need to return the highest vale <br>
	 * <br>
	 * For Example: <br>
	 * largest("55 72 86") → 14 <br>
	 * largest("15 72 80 164") → 11 <br>
	 * largest("555 72 86 45 10") → 15 <br>
	 * <br>
	 * HINT: Integer.parseInt
	 */

	public int largest(String input) {
		String[] array = input.split(" ", 0);
		int wait = 0;
		int out = 0;
		int outold = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		for (String a : array) {
			int len = a.length();
			for (int i = 0; i < len; i++) {
				char q = a.charAt(i);
				String w = String.valueOf(q);
				wait = Integer.parseInt(w);
				if (i == 0) {
					f = wait;
				} else if (i == 2) {
					h = wait;
				}
				else {
					g = wait;
				}
			}
			if (len > 2) {
				out = f + g + h;
				if (out > outold) {
					outold = out;
				}
			} else {
				out = f + g;
				if (out > outold) {
					outold = out;
				}
			}
		}
		return outold;
	}

	/**
	 * Given a string, int and a char, return a boolean value if the 'nth'
	 * (represented by the int provided) char of the String supplied is the same as
	 * the char supplied. The int provided will NOT always be less than than the
	 * length of the String. Ignore case and Whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * compares("The",2,'h') → true <br>
	 * compares("AAbb",1,'b') → false <br>
	 * compares("Hi-There",10,'e') → false <br>
	 * <br>
	 * HINT: String.charAt
	 */
	public boolean compares(String word, int index, char letter) {
		// Initialise
		char check = ' ';
		boolean bool = true;
		// Check length of word
		int len = word.length();

		// Checks to make sure that the index falls within the word
		// Otherwise it skips finding the character to avoid breaking
		if (len > index) {
			// Checks character at nth position
			check = word.charAt(index - 1);
			if (check == letter) {
			} else {
				bool = false;
			}
		} else {
			bool = false;
		}
		return bool;
	}
}
