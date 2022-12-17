package com.aamir.user.constant;

public class RegexConstant {

    public static final String NUMBERS_ONLY = "^[0-9]*$";
    public static final String DECIMAL_TWO_DIGIT = "^\\-?[0-9]+(?:\\.[0-9]{1,2})?$";
    public static final String DECIMAL_TWO_DIGIT_WITH_COMMA = "^[0-9]*\\.?[0-9]+$";
    public static final String NUMBERS_WITH_DECIMALS = "^$|^[0-9]*\\.?[0-9]+$";
    public static final String ALPHABETS_ONLY = "^[a-zA-Z  ]*$";
    public static final String ALPHANUMERIC_ONLY = "^[a-zA-Z0-9 ]*$";
    public static final String ALPHABETS_WITH_HYPHEN = "^[a-zA-Z-]*$";
    public static final String ALPHABETS_WITH_SPACE = "^[a-zA-Z ]*$";
    public static final String ALPHABETS_WITH_SPACE_AND_BRACKETS = "^[a-zA-Z]+( [a-zA-Z() ]+)*$";
    public static final String ALPHANUMERIC_WITH_HYPHEN_AND_UNDERSCORE = "^[a-zA-Z0-9-_]*$";
    public static final String ALPHANUMERIC_WITH_UNDERSCORE = "^[a-zA-Z0-9_]*$";
    public static final String ALPHABETS_WITH_UNDERSCORE = "^[a-zA-Z_ ]*$";
    public static final String ALPHANUMERIC_WITH_SPACE_AND_UNDERSCORE = "^[a-zA-Z0-9_ ]*$";
    public static final String ALPHANUMERIC_WITH_SPECIAL_CHARACTER = "^[#.0-9a-zA-Z\\s,-/_()]+$";
    public static final String EMAIL = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String URL = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";
    public static final String NUMBERS_WITH_TWO_DECIMALS = "^[0-9]+(\\.[0-9]{1,2})?$";
    public static final String ALPHANUMERIC_WITH_UNDERSCORE_BRACKETS = "^[a-zA-Z0-9]+( [a-zA-Z0-9_().-]+)*$";
    public static final String ALPHANUMERIC_WITH_UNDERSCORE_BRACKETS_FORWARDSLASH = "^[a-zA-Z0-9 !@#$%~^&*-_,\\/)(':;<>=|\\.?]*$";
    public static final String ALPHANUMERIC_WITH_PERCENTAGE = "[a-zA-Z0-9 %-_]";
}
