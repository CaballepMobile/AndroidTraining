package com.example.angel.daily4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvValue;
    String _currentValue;
    boolean _isFirstOperation = true;
    char _previousOperation;
    int _previousTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn0:
                TypeNumber(0);
                break;

            case R.id.btn1:
                TypeNumber(1);
                break;

            case R.id.btn2:
                TypeNumber(2);
                break;

            case R.id.btn3:
                TypeNumber(3);
                break;

            case R.id.btn4:
                TypeNumber(4);
                break;

            case R.id.btn5:
                TypeNumber(5);
                break;

            case R.id.btn6:
                TypeNumber(6);
                break;

            case R.id.btn7:
                TypeNumber(7);
                break;

            case R.id.btn8:
                TypeNumber(8);
                break;

            case R.id.btn9:
                TypeNumber(9);
                break;

            case R.id.btnPlus:
                CalculateResult('+');
                break;

            case R.id.btnMinus:
                CalculateResult('-');
                break;

            case R.id.btnMultiply:
                CalculateResult('*');
                break;

            case R.id.btnDivide:
                CalculateResult('/');
                break;

            case R.id.btnEquals:
                CalculateResult('=');
                break;
        }
    }

    private void TypeNumber(int value){
        _currentValue += value;
    }

    private void CalculateResult(char operation){
        if(!_isFirstOperation){
            if(_previousOperation == '+'){
                _previousTotal += Integer.parseInt(_currentValue);
            }
            if(_previousOperation == '-'){
                _previousTotal -= Integer.parseInt(_currentValue);
            }
            if(_previousOperation == '*'){
                _previousTotal *= Integer.parseInt(_currentValue);
            }
            if(_previousOperation == '/'){
                _previousTotal /= Integer.parseInt(_currentValue);
            }
            _currentValue = "";
            tvValue.setText(_previousTotal);
        }else{
            _previousTotal = Integer.parseInt(_currentValue);
            _isFirstOperation = false;
        }
        _previousOperation = operation;
    }

}