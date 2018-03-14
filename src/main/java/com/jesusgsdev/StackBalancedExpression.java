package com.jesusgsdev;

import java.util.*;

public class StackBalancedExpression {

    public static final String OPENING_SYMBOLS = "({[";
    public static final String CLOSING_SYMBOLS = ")}]";

    public static final String YES = "YES";
    public static final String NO = "NO";

    public static String checkString(final String value) {
        Stack<String> stack = new Stack();

        for(Character c : value.toCharArray()){
            String symbol = c.toString();
            if(stack.isEmpty()){
                if(CLOSING_SYMBOLS.contains(symbol)){
                    return NO;
                }
                stack.push(symbol);
            }else{
                if(OPENING_SYMBOLS.contains(symbol)){
                    stack.push(symbol);
                }else{
                    String lastSymbol = stack.pop();
                    if(        (lastSymbol.equals("{") && !symbol.equals("}") )
                            || (lastSymbol.equals("(") && !symbol.equals(")") )
                            || (lastSymbol.equals("[") && !symbol.equals("]") )
                            ){
                        return NO;
                    }
                }
            }
        }

        if(value.isEmpty() || (!value.isEmpty() && stack.isEmpty())){
            return YES;
        }

        return NO;
    }

}
