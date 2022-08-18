package com.itwill.util;

import java.text.DecimalFormat;

public class NumberFormatter {
public String format(int number, String pattern) {
	DecimalFormat decimalFormat=new DecimalFormat(pattern);
	return decimalFormat.format(number);
}
}
