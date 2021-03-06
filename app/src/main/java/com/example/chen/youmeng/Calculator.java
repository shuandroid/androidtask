package com.example.chen.youmeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chen on 14-11-28.
 */
public class Calculator {

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {

        String str = "2+3x10÷2";

        double rs = calcResult(toPolishNotation(str));

        System.out.println(rs);
    }


    public static String calculate(String str){

        double rs = calcResult(toPolishNotation(str));

        // 整数去除小数点
        str = rs == (int)rs? String.valueOf((int)rs): String.valueOf(rs);

        return str;
    }



    /**
     * 计算前缀表达式结果
     * @param expression
     * @return
     */
    private static double calcResult(Stack<Object> expression){

        Object[] objs = new Object[expression.size()];

        int i = 0;
        while(!expression.isEmpty()){

            objs[i] = expression.pop();

            i++;
        }

        Stack<Double> nums = new Stack<Double>();


        for(int j = objs.length - 1; j >=0; j--){

            Object obj = objs[j];

            if(obj instanceof Double ){

                nums.add((Double)obj);
            }else{

                char op = (Character) obj;

                double d1 = nums.pop();
                double d2 = nums.pop();

                double rs = calc(d1, d2, op);

                nums.add(rs);
            }
        }

        return nums.pop();
    }


    /**
     * 前缀表达式（前缀记法、波兰式）
     * 前缀表达式的运算符位于操作数之前
     *
     * @param str
     * @return
     */
    private static Stack<Object> toPolishNotation(String str){

        Stack<Character> s1 = new Stack<Character>();

        Stack<Object> expression = new Stack<Object>();

        char[] charArr = str.toCharArray();

        List<Character> list = new ArrayList<Character>();


        for(int i = charArr.length - 1; i >= 0;){

            char key = charArr[i];

            if(isOperator(key)){

                if(!list.isEmpty()){
                    double num = getNum(list);

                    expression.add(num);
                }

                if(s1.isEmpty() || s1.peek() == ')'){

                    s1.add(key);
                }else{

                    char top = s1.peek();

                    int priority = priorityCompare(key, top);

                    if(priority >= 0){

                        s1.add(key);
                    }else{

                        top = s1.pop();

                        expression.add(top);

                        continue;
                    }
                }

            }else if(key == '('){

                if(!list.isEmpty()){
                    double num = getNum(list);

                    expression.add(num);
                }

                while(')' != s1.peek()){

                    char top = s1.pop();

                    expression.add(top);
                }

                s1.pop();
            }else if(key == ')'){

                s1.add(key);
            }else{

                list.add(key);
            }

            if(i ==  0){

                if(!list.isEmpty()){
                    double num = getNum(list);

                    expression.add(num);
                }

                while(!s1.isEmpty()){

                    expression.add(s1.pop());
                }
            }

            i--;
        }

        return expression;
    }

    private static double getNum(List<Character> list){

        double num = 0;

        char[] numArr = new char[list.size()];

        for(int i = list.size() - 1, j = 0; i >= 0; i--, j++){

            numArr[j] = list.get(i) ;
        }

        list.clear();

        String str = new String(numArr);

        num = Double.parseDouble(str);

        return num;
    }

    /**
     * 计算两数的四则运算结果
     *
     * @param num1
     * @param num2
     * @param op
     * @return
     * @throws IllegalArgumentException
     */
    private static double calc(double num1, double num2, char op)
            throws IllegalArgumentException {

        switch (op) {

            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case 'x':
                return num1 * num2;
            case '÷':
                if (num2 == 0) throw new IllegalArgumentException("divisor can't be 0.");
                return num1 / num2;
            default:
                return 0;
        }
    }

    /**
     * 比较两个运算符的优先级
     *
     * @param op1
     * @param op2
     *
     * @return 1：高，0：相等，-1：低
     */
    private static int priorityCompare(char op1, char op2) {

        switch (op1) {

            case '+': case '-':
                return (op2 == 'x' || op2 == '÷' ? -1 : 0);
            case 'x': case '÷':
                return (op2 == '+' || op2 == '-' ? 1 : 0);
        }

        return 1;
    }

    /**
     * 判断是否为运算符
     * @param c
     * @return
     */
    private static boolean isOperator(char c) {
        return (c=='+' || c=='-' || c=='x' || c=='÷');
    }
}
