package com.ua.sazhyn.volodymyr;

import java.awt.event.ActionListener;

// Определяем класс, который обрабатывает событие
    public class actionlistrener implements ActionListener
    {
        RPN rpn;
        public String pre_display="";
        public void actionPerformed(ActionEvent e)
        {
            Object click1 = e.getSource (); // Получить имя компонента
            String click2 = e.getActionCommand (); // Получить метку компонента
            if (click1 == button_clear) // Инициализировать текстовое поле
            {
                pre_display="";
                display.setText("0");
            }
            else if (click1 == button_delete) // Используйте метод handleClear () для обработки удаления
            {
                if(!pre_display.equals(""))
                    display.setText(handleDelete(pre_display));
                else
                    display.setText(handleDelete(display.getText()));
            }
            else if(click2=="=")
            {
                // Расчетное выражение
                rpn=new RPN(display.getText());
                rpn.ListPreExpressionToListExpression();
                if(rpn.Opera_ListExpr().equals("illegal!"))
                    display.setText("illegal!");
                else if(rpn.Opera_ListExpr().equals("non-existent!"))
                    display.setText("non-existent!");
                else
                {
                    double result=Double.valueOf(rpn.Opera_ListExpr()).doubleValue();
                    // Преобразование типов данных
                    long t1=(long)result;
                    double t2=result-t1;
                    if(t2==0)
                        display.setText(String.valueOf(t1));
                    else
                        display.setText(String.valueOf(result));
                }

                pre_display="";
            }

            else
            {
                if(click2=="tan")
                    click2="tan(";
                else if(click2=="sin")
                    click2="sin(";
                else if(click2=="cos")
                    click2="cos(";
                else if(click2=="log")
                    click2="log(";
                pre_display+=click2;
                display.setText(pre_display);
            }
        }


        // Backspace
        public String handleDelete(String text)
        {
            int textLength=text.length();
            if(textLength>0)
            {
                text = text.substring (0, textLength-1); // Удалить последний символ
                if (text.length () == 0) // Если текстовое поле пустое, оно инициализируется как «0»
                {
                    text="0";
                }
                pre_display=text;
                return text;
            }
            else
                return "illegal!";
        }

    }
    public static void main(String[] args)
    {
        Calculator.Calculator calculator=new Calculator.Calculator();
    }
}
