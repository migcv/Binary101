package pt.migcv.binary101.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import pt.migcv.binary101.R;
import pt.migcv.binary101.core.Converter;
import pt.migcv.binary101.core.Settings;
import pt.migcv.binary101.core.exception.NotBinaryException;
import pt.migcv.binary101.core.exception.NotDecimalException;
import pt.migcv.binary101.core.exception.NotHexadecimalException;

public class ConverterFragment extends Fragment {
    View view;

    EditText binaryText;
    EditText decimalText;
    EditText hexadecimalText;

    TableLayout binaryKeyboard;
    TableLayout decimalKeyboard;
    TableLayout hexadecimalKeyboard;

    boolean flag = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_converter, container, false);
        initializeElements();
        return view;
    }

    private class OnClickBinary implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            binaryText.setText(binaryText.getText().toString()+button.getText().toString());
        }
    }

    private class OnClickDecimal implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            decimalText.setText(decimalText.getText().toString() + button.getText().toString());
        }
    }

    private class onClickHexadecimal implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            hexadecimalText.setText(hexadecimalText.getText().toString()+button.getText().toString());
        }
    }

    private class OnClickDelete implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText text = null;
            if(v.getId() == R.id.binaryDeleteButton) {
                text = binaryText;
            }
            else if(v.getId() == R.id.decimalDeleteButton) {
                text = decimalText;
            }
            else if(v.getId() == R.id.hexadecimalDeleteButton) {
                text = hexadecimalText;
            }
            if(text != null) {
                String textNumber = (String) text.getText().toString();
                if (textNumber.length() == 0) {
                    return;
                }
                StringBuilder aux = new StringBuilder(textNumber);
                aux.deleteCharAt(textNumber.length() - 1);
                text.setText(aux.toString());
            }
        }
    }

    private class OnClickClr implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.binaryClrButton) {
                binaryText.setText("");
            }
            else if(v.getId() == R.id.decimalClrButton) {
                decimalText.setText("");
            }
            else if(v.getId() == R.id.hexadecimalClrButton) {
                hexadecimalText.setText("");
            }
        }
    }

    private void initializeElements() {
        binaryText = (EditText) view.findViewById(R.id.binaryText);
        decimalText = (EditText) view.findViewById(R.id.decimalText);
        hexadecimalText = (EditText) view.findViewById(R.id.hexadecimalText);

        if(Settings.isSystemKeyboardOn()) { // USING SYSTEM KEYBOARD
            binaryText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            hexadecimalText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            decimalText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN );
            System.out.println("KEYBOARD ON MUDAFUCKAS!!!");
        } else { // USING APP's KEYBOARD
            binaryText.setInputType(EditorInfo.TYPE_NULL);
            hexadecimalText.setInputType(EditorInfo.TYPE_NULL);
            decimalText.setInputType(EditorInfo.TYPE_NULL);
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            System.out.println("KEYBOARD OFF BITXES!!!");
        }
        //BINARY BUTTONS
        view.findViewById(R.id.binary0Button).setOnClickListener(new OnClickBinary());
        view.findViewById(R.id.binary1Button).setOnClickListener(new OnClickBinary());
        view.findViewById(R.id.binaryDeleteButton).setOnClickListener(new OnClickDelete());
        view.findViewById(R.id.binaryClrButton).setOnClickListener(new OnClickClr());
        //DECIMAL BUTTONS
        view.findViewById(R.id.decimal0Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal1Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal2Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal3Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal4Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal5Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal6Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal7Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal8Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimal9Button).setOnClickListener(new OnClickDecimal());
        view.findViewById(R.id.decimalDeleteButton).setOnClickListener(new OnClickDelete());
        view.findViewById(R.id.decimalClrButton).setOnClickListener(new OnClickClr());
        //HEXADECIMAL BUTTONS
        view.findViewById(R.id.hexadecimal0Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal1Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal2Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal3Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal4Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal5Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal6Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal7Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal8Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimal9Button).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalAButton).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalBButton).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalCButton).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalDButton).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalEButton).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalFButton).setOnClickListener(new onClickHexadecimal());
        view.findViewById(R.id.hexadecimalDeleteButton).setOnClickListener(new OnClickDelete());
        view.findViewById(R.id.hexadecimalClrButton).setOnClickListener(new OnClickClr());

        binaryKeyboard = (TableLayout) view.findViewById(R.id.binaryKeyboard);
        hexadecimalKeyboard = (TableLayout) view.findViewById(R.id.hexadecimalKeyboard);
        decimalKeyboard = (TableLayout) view.findViewById(R.id.decimalKeyboard);

        setAllButtonsInvisible();

        binaryText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setAllButtonsInvisible();
                if (binaryText.getText().toString().equals("0")) {
                    binaryText.setText("");
                    flag = false;
                }
                if(!Settings.isSystemKeyboardOn())
                    binaryKeyboard.setVisibility(View.VISIBLE);

            }
        });

        decimalText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setAllButtonsInvisible();
                if (decimalText.getText().toString().equals("0")) {
                    decimalText.setText("");
                }
                if(!Settings.isSystemKeyboardOn())
                    decimalKeyboard.setVisibility(View.VISIBLE);
            }
        });

        hexadecimalText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setAllButtonsInvisible();
                if (hexadecimalText.getText().toString().equals("0")) {
                    hexadecimalText.setText("");
                }
                if(!Settings.isSystemKeyboardOn())
                    hexadecimalKeyboard.setVisibility(View.VISIBLE);
            }
        });

        decimalText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String[] numbers = Converter.convertDecimal(decimalText.getText().toString());
                    if (!flag) {
                        flag = true;
                        binaryText.setText(numbers[0]);
                        decimalText.setText(numbers[1]);
                        hexadecimalText.setText(numbers[2]);
                        flag = false;
                    }
                } catch (NotDecimalException e) {
                    System.out.println("DecimalText <NotDecimalException> : " + e.getMessage());
                    if (!flag) {
                        flag = true;
                        binaryText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("DecimalText <"+  e.getClass().toString() + "> :" + e.getMessage());
                    if (!flag) {
                        flag = true;
                        binaryText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                }
            }
        });

        binaryText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String[] numbers = Converter.convertBinary(binaryText.getText().toString());
                    if (!flag) {
                        flag = true;
                        binaryText.setText(numbers[0]);
                        decimalText.setText(numbers[1]);
                        hexadecimalText.setText(numbers[2]);
                        flag = false;
                    }
                } catch (NotBinaryException e) {
                    System.out.println("BinaryText <NotBinaryException> : " + e.getMessage());
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("BinaryText <" + e.getClass().toString() + "> :" + e.getMessage());
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                }
            }
        });

        hexadecimalText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String[] numbers = Converter.convertHexadecimal(hexadecimalText.getText().toString());
                    if (!flag) {
                        flag = true;
                        binaryText.setText(numbers[0]);
                        decimalText.setText(numbers[1]);
                        hexadecimalText.setText(numbers[2]);
                        flag = false;
                    }
                } catch (NotHexadecimalException e) {
                    System.out.println("HexadecimalException <NotHexadecimalException> : " + e.getMessage());
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        binaryText.setText("0");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("HexadecimalException <" + e.getClass().toString() + "> :" + e.getMessage());
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        hexadecimalText.setText("0");
                        flag = false;
                    }
                }
            }
        });
    }

    private void setAllButtonsInvisible() {
        binaryKeyboard.setVisibility(View.INVISIBLE);
        decimalKeyboard.setVisibility(View.INVISIBLE);
        hexadecimalKeyboard.setVisibility(View.INVISIBLE);
    }
}
