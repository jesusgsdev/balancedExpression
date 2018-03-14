package com.jesusgsdev;

import org.junit.Test;

import static com.jesusgsdev.StackBalancedExpression.NO;
import static com.jesusgsdev.StackBalancedExpression.YES;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StackBalancedExpressionTest {

    @Test
    public void when_EmptyString_Then_Yes(){
        String expressionToCheck = "";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(YES));
    }

    @Test
    public void when_OpenCloseParenthesis_Then_Yes(){
        String expressionToCheck = "()";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(YES));
    }

    @Test
    public void when_OpenCloseCurlyBrackets_Then_Yes(){
        String expressionToCheck = "{}";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(YES));
    }

    @Test
    public void when_OpenCloseBrackets_Then_Yes(){
        String expressionToCheck = "[]";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(YES));
    }

    @Test
    public void when_OnlyOpenSymbolsParenthesis_Then_No(){
        String expressionToCheck = "((";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(NO));
    }

    @Test
    public void when_OnlyOpenSymbolsCurlyBrackets_Then_No(){
        String expressionToCheck = "{{";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(NO));
    }

    @Test
    public void when_OnlyOpenSymbolsBrackets_Then_No(){
        String expressionToCheck = "[[";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(NO));
    }

    @Test
    public void when_OnlyOpenSymbolsMix_Then_No(){
        String expressionToCheck = "[[({";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(NO));
    }

    @Test
    public void when_OpenCloseBalanced_Then_Yes(){
        String expressionToCheck = "(({[{{}}]}))";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(YES));
    }

    @Test
    public void when_OpenCloseNotBalanced_Then_No(){
        String expressionToCheck = "(({[{{}}]}))(";
        String result = StackBalancedExpression.checkString(expressionToCheck);
        assertThat(result, is(NO));
    }

}