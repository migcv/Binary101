package pt.migcv.binary101.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import pt.migcv.binary101.R;
import pt.migcv.binary101.core.exception.NotBinaryException;
import pt.migcv.binary101.core.exception.NotDecimalException;
import pt.migcv.binary101.core.exception.NotHexadecimalException;
import pt.migcv.binary101.core.Converter;


public class ConverterActivityOld extends AppCompatActivity {

    private EditText decimalText;
    private EditText binaryText;
    private EditText hexadecimalText;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_old);

        decimalText = (EditText) findViewById(R.id.decimalText);
        binaryText = (EditText) findViewById(R.id.binaryText);
        hexadecimalText = (EditText) findViewById(R.id.hexadecimalText);

        decimalText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && decimalText.getText().toString().equals("0")) {
                    decimalText.setText("");
                } else if(decimalText.getText().toString().isEmpty()){
                    decimalText.setText("0");
                }
            }
        });

        binaryText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && binaryText.getText().toString().equals("0")) {
                    binaryText.setText("");
                } else if(binaryText.getText().toString().isEmpty()){
                    binaryText.setText("0");
                }
            }
        });

        hexadecimalText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && hexadecimalText.getText().toString().equals("0")) {
                    hexadecimalText.setText("");
                } else if(hexadecimalText.getText().toString().isEmpty()){
                    hexadecimalText.setText("0");
                }
            }
        });

        decimalText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String[] numbers = Converter.convertDecimal(decimalText.getText().toString());
                    System.out.println("10:BINARY: " + numbers[0]);
                    System.out.println("10:HEXADECIMAL: " + numbers[1]);
                    if (!flag) {
                        flag = true;
                        binaryText.setText("" + numbers[0]);
                        hexadecimalText.setText("" + numbers[1]);
                        flag = false;
                    }
                } catch (NotDecimalException e) {
                    System.out.println("DecimalText: " + e.getMessage());
                    if (!flag) {
                        flag = true;
                        binaryText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("DecimalText: " + e.getMessage());
                }
            }
        });

        binaryText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String[] numbers = Converter.convertBinary(binaryText.getText().toString());
                    System.out.println("2:DECIMAL: " + numbers[0]);
                    System.out.println("2:HEXADECIMAL: " + numbers[1]);
                    if (!flag) {
                        flag = true;
                        decimalText.setText("" + numbers[0]);
                        hexadecimalText.setText("" + numbers[1]);
                        flag = false;
                    }
                } catch (NotBinaryException e) {
                    System.out.println("BinaryText: " + e.getMessage());
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("BinaryText: " + e.getMessage());
                }
            }
        });

        hexadecimalText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged (Editable s){}

            @Override
            public void beforeTextChanged (CharSequence s,int start, int count, int after){}

            @Override
            public void onTextChanged (CharSequence s,int start, int before, int count){
                try {
                    String[] numbers = Converter.convertHexadecimal(hexadecimalText.getText().toString());
                    System.out.println("16:DECIMAL: " + numbers[0]);
                    System.out.println("16:BINARY: " + numbers[1]);
                    if (!flag) {
                        flag = true;
                        decimalText.setText("" + numbers[0]);
                        binaryText.setText("" + numbers[1]);
                        hexadecimalText.setText(hexadecimalText.getText().toString().toUpperCase());
                        flag = false;
                    }
                } catch (NotHexadecimalException e) {
                    System.out.println("HexadecimalException: " + e.getMessage());
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        binaryText.setText("0");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("HexadecimalException: " + e.getMessage());
                }
            }
        });
    }
}
