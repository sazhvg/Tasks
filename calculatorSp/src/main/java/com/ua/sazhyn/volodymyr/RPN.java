package com.ua.sazhyn.volodymyr;

//Ниже приведен код для обратного польского алгоритма:

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class RPN {

        private Stack <String> StackOperator = new Stack <> (); // Сохраняем стек операторов
        private ArrayList <String> ListPreExpression = new ArrayList <String> (); // сохраняем исходное выражение
        private ArrayList <String> ListExpression = new ArrayList <String> (); // сохранить обратное польское выражение
        private Stack <String> StackOperation = new Stack <> (); // стек операций

        // Разделение выражения (инициализация)
        public RPN (String PreExpression)
        {
            // Используем + - * / () в качестве разделителя для разделения исходного выражения (строки) и возврата разделителя
            StringTokenizer stringTokenizer=new StringTokenizer(PreExpression,"\\+|\\-|\\*|\\/|\\(|\\)",true);
            while(stringTokenizer.hasMoreTokens())
            {
                ListPreExpression.add(stringTokenizer.nextToken());
            }
        }


        // Определяем, является ли это оператором
        public boolean isOperator(String str)
        {
            if("+-*/tancossinlog()".indexOf(str)>=0)
                return true;
            else
                return false;
        }

        // Получить приоритет оператора
        public int getPriority(String str)
        {
            int a;
            switch(str)
            {
                case "+":
                case "-":a=1;break;
                case "*":
                case "/":a=2;break;
                case "(":a=4;break;
                case ")":a=0;break;
                case "tan":
                case "sin":
                case "cos":
                case "log":a=3;break;
                default: a=-1;break;
            }
            return a;
        }

        // Сравнить приоритет
        public boolean ComparePriority(String str1,String str2)
        {
            return getPriority(str1)>getPriority(str2);
        }

        // Оператор в стеке
        public void OperatorToStack(String str)
        {
            if (StackOperator.isEmpty ()) // Определяем, является ли стек пустым
                StackOperator.push(str);
            else if ("(". equals (str)) // Определить, передан ли оператор "("
                StackOperator.push(str);
            else if (")". equals (str)) // Определить, является ли переданный оператор ")"
            {
                String string;
                while (! "(". equals (string = StackOperator.pop ())) // Сохраняем оператор между "(" и ")" в ListExpression
                    ListExpression.add(string);
            }
            else if ("(". equals (StackOperator.peek ())) // Если верхний элемент стека равен (, оператор находится непосредственно в стеке
                StackOperator.push(str);
            else if (ComparePriority (str, StackOperator.peek ())) // Если приоритет str больше верхнего элемента стека, он будет помещен в стек
                StackOperator.push(str);
            else if (! ComparePriority (str, StackOperator.peek ())) // Если оно меньше чем, вставьте верхний элемент стека и сравните str со следующим элементом
            {
                ListExpression.add(StackOperator.pop());
                OperatorToStack(str);
            }
        }


        // Инфиксное выражение преобразуется в постфиксное выражение
        public void ListPreExpressionToListExpression()
        {
            for (String str: ListPreExpression) // Обход ListPreExpression, добавление OperatorToStack, добавление ListExpression к числам
            {
                if(isOperator(str))
                    OperatorToStack(str);
                else
                    ListExpression.add(str);
            }

            // После обхода исходного выражения добавляем все операторы в стеке StackOperator в ListExpression
            while(!StackOperator.isEmpty())
            {
                ListExpression.add(StackOperator.pop());
            }
        }


        // Метод расчета

        // Бинокулярная операция
        public int open = 0; // Используется для определения правильности ввода
        public double Operation2(String str1,String str2,String str3)
        {
            double num1,num2;
            num2=Double.valueOf(str1).doubleValue();
            num1=Double.valueOf(str2).doubleValue();
            if(str3.equals("+"))
                return num1+num2;
            else if(str3.equals("-"))
                return num1-num2;
            else if(str3.equals("*"))
                return num1*num2;
            else
            {
                if (num2 == 0) // Когда делитель равен нулю, open = 1, и тогда «незаконно» будет выведено для open = 1.
                    open=1;
                return num1/num2;
            }
        }

        // Монокуляр
        public double Operation1(String str1,String str2)
        {
            double num1;
            num1=Double.valueOf(str1).doubleValue();
            if(str2.equals("tan"))
            {
                если (num1 == 90) // tan (90) не существует, open = 2, следующий код выведет "несуществующий!"
                open=2;
                return 1;
            }
            else if(str2.equals("sin"))
                return Math.sin(num1);
            else if(str2.equals("cos"))
                return Math.cos(num1);
            else
                return Math.log(num1);

        }

        // Вычисляем обратное польское выражение
        public String Opera_ListExpr()
        {
            int open2 = 0; // Используется для определения правильности ввода
            for(String str:ListExpression)
            {
                if (str.equals ("(") || str.equals (")")) // Если ListExpression содержит скобки, будет сообщено об ошибке
                    open2=1;
                else if (! isOperator (str)) // Сохранить номер в стеке операций
                    StackOperation.push(str);
                else if ("tansincoslog" .indexOf (str)> = 0) // tan, sin, cos, log для монокулярной операции
                    StackOperation.push(String.valueOf(Operation1(StackOperation.pop(),str)));
                else
                    // Другие операторы выполняют бинокулярные операции
                    StackOperation.push(String.valueOf(Operation2(StackOperation.pop(),StackOperation.pop(),str)));
            }
            if(open==1||open2==1)
            {
                open=0;
                return "illegal!";
            }
            else if(open==2)
            {
                open=0;
                return "non-existent!";
            }
            else
                return StackOperation.pop();
        }


        public static void main(String[] args)
        {

        }
    }

}

