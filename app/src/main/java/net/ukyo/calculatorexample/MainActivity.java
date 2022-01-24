package net.ukyo.calculatorexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private TextView textResult;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnTimes;
    private Button btnDivided;
    private Button btnDel;
    private Button btnDot;
    private Button btnEquals;
    private float firstOperand;
    private float secondOperand;
    boolean isOperatorPressed = false;
    private int mOperator;
    private final int PLUS = 0;
    private final int MINUS = 1;
    private final int TIMES = 2;
    private final int DIVIDED = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListener();
    }

    private void findViews() {
        textResult = (TextView) findViewById(R.id.text_numbers);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnTimes = (Button) findViewById(R.id.btn_times);
        btnDivided = (Button) findViewById(R.id.btn_divided);
        btnDel = (Button) findViewById(R.id.btn_del);
        btnDot = (Button) findViewById(R.id.btn_dot);
        btnEquals = (Button) findViewById(R.id.btn_equals);
    }

    private void setListener() {
        btn0.setOnClickListener(clickListener);
        btn1.setOnClickListener(clickListener);
        btn2.setOnClickListener(clickListener);
        btn3.setOnClickListener(clickListener);
        btn4.setOnClickListener(clickListener);
        btn5.setOnClickListener(clickListener);
        btn6.setOnClickListener(clickListener);
        btn7.setOnClickListener(clickListener);
        btn8.setOnClickListener(clickListener);
        btn9.setOnClickListener(clickListener);
        btnPlus.setOnClickListener(clickListener);
        btnMinus.setOnClickListener(clickListener);
        btnTimes.setOnClickListener(clickListener);
        btnDivided.setOnClickListener(clickListener);
        btnDel.setOnClickListener(clickListener);
        btnDot.setOnClickListener(clickListener);
        btnEquals.setOnClickListener(clickListener);
    }

    private void showNumber(char inputDigit) {

        /* erase firstOperand */
        if (isOperatorPressed) {
            textResult.setText("0");
            isOperatorPressed = false;
        }

        String str = textResult.getText().toString();
        StringBuffer stringBuffer = new StringBuffer(str);

        if (inputDigit != 'd') {

            if (inputDigit == '.' && str.contains(".")) {
                return;
            }

            if (inputDigit == '0' && str.equals("0")) {
                return;
            }

            if (str.equals("0")) {
                stringBuffer.deleteCharAt(0);
            }

            stringBuffer.append(inputDigit);

        } else {

            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
        textResult.setText(stringBuffer.toString());
    }

    private float getOperand() {

        float number;

        number = Float.valueOf(textResult.getText().toString());

        return number;
    }

    private void showResult() {

        DecimalFormat df = new DecimalFormat("###.####");

        switch (mOperator) {

            case PLUS:
                textResult.setText(String.valueOf(df.format(firstOperand + secondOperand)));
                break;
            case MINUS:
                textResult.setText(String.valueOf(df.format(firstOperand - secondOperand)));
                break;
            case TIMES:
                textResult.setText(String.valueOf(df.format(firstOperand * secondOperand)));
                break;
            case DIVIDED:
                textResult.setText(String.valueOf(df.format(firstOperand / secondOperand)));
                break;
        }

    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.btn_0:
                    showNumber('0');
                    break;

                case R.id.btn_1:
                    showNumber('1');
                    break;

                case R.id.btn_2:
                    showNumber('2');
                    break;

                case R.id.btn_3:
                    showNumber('3');
                    break;

                case R.id.btn_4:
                    showNumber('4');
                    break;

                case R.id.btn_5:
                    showNumber('5');
                    break;

                case R.id.btn_6:
                    showNumber('6');
                    break;

                case R.id.btn_7:
                    showNumber('7');
                    break;

                case R.id.btn_8:
                    showNumber('8');
                    break;

                case R.id.btn_9:
                    showNumber('9');
                    break;

                case R.id.btn_plus:
                    firstOperand = getOperand();
                    isOperatorPressed = true;
                    mOperator = PLUS;
                    break;

                case R.id.btn_minus:
                    firstOperand = getOperand();
                    isOperatorPressed = true;
                    mOperator = MINUS;
                    break;

                case R.id.btn_times:
                    firstOperand = getOperand();
                    isOperatorPressed = true;
                    mOperator = TIMES;
                    break;

                case R.id.btn_divided:
                    firstOperand = getOperand();
                    isOperatorPressed = true;
                    mOperator = DIVIDED;
                    break;

                case R.id.btn_del:
                    showNumber('d');
                    break;

                case R.id.btn_dot:
                    showNumber('.');
                    break;

                case R.id.btn_equals:
                    secondOperand = getOperand();
                    showResult();
                    break;
            }

        }
    };
}
