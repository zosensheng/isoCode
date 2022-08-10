package com.hisun.kont.pg.utils;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SwiftUtil {

	/**
	 * 合法字符集
	 */
	public static Set<String> legalCharacterSet = new HashSet<String>() {{
		add("1");
		add("2");
		add("3");
		add("4");
		add("5");
		add("6");
		add("7");
		add("8");
		add("9");
		add("0");
		add("a");
		add("b");
		add("c");
		add("d");
		add("e");
		add("f");
		add("g");
		add("h");
		add("i");
		add("j");
		add("k");
		add("l");
		add("m");
		add("n");
		add("o");
		add("p");
		add("q");
		add("r");
		add("s");
		add("t");
		add("u");
		add("v");
		add("w");
		add("x");
		add("y");
		add("z");
		add("A");
		add("B");
		add("C");
		add("D");
		add("E");
		add("F");
		add("G");
		add("H");
		add("I");
		add("J");
		add("K");
		add("L");
		add("M");
		add("N");
		add("O");
		add("P");
		add("Q");
		add("R");
		add("S");
		add("T");
		add("U");
		add("V");
		add("W");
		add("X");
		add("Y");
		add("/");
		add("-");
		add("?");
		add(":");
		add("(");
		add(")");
		add(".");
		add(",");
		add("'");
		add("+");
		add(" ");
		add("\r\n");
	}};


	/**
	 * 校验是否合法字符
	 * true 为swift合法字符
	 * false 为swift非法字符
	 */
	public static Boolean ifLegalCharacter(String s){
		Boolean flag = false;
		Iterator<String> iterator = legalCharacterSet.iterator();
		while (iterator.hasNext()){
			String str = iterator.next();
			if (s.equals(str)){
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Boolean aBoolean = ifLegalCharacter("");
		System.out.println(aBoolean);
	}
}
