package com.commons.utils;

import java.text.DecimalFormat;


public class NumberFormatUtils {
	private static ThreadLocal<DecimalFormat> mapperHolder = new ThreadLocal<DecimalFormat>();
	
	public static final String                                    $_$$_FORMAT_PATTERN = "0.00";
	
	private static DecimalFormat getDecimalFormat() {
		DecimalFormat mapper = mapperHolder.get();
		if (mapper == null) {
			mapper = new DecimalFormat();
			mapperHolder.set(mapper);
			return mapper;
		}
		return mapper;
	}
    public static String formatNumberPattern(Float num, String formatPattern) {
        if (num == null) {
			return "";
        }
        DecimalFormat format =  getDecimalFormat();
        format.applyPattern(formatPattern);
        return format.format(num);
    }
}
