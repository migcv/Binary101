package pt.migcv.binary101.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pt.migcv.binary101.R;
import pt.migcv.binary101.core.Converter;
import pt.migcv.binary101.core.exception.NotBinaryException;
import pt.migcv.binary101.core.exception.NotDecimalException;
import pt.migcv.binary101.core.exception.NotHexadecimalException;

public class ConverterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView binaryView;
    TextView decimalView;
    TextView hexadecimalView;

    EditText binaryText;
    EditText decimalText;
    EditText hexadecimalText;

    Button binary0Button;
    Button binary1Button;
    Button binaryDeleteButton;
    Button binaryClrButton;

    Button decimal0Button;
    Button decimal1Button;
    Button decimal2Button;
    Button decimal3Button;
    Button decimal4Button;
    Button decimal5Button;
    Button decimal6Button;
    Button decimal7Button;
    Button decimal8Button;
    Button decimal9Button;
    Button decimalDeleteButton;
    Button decimalClrButton;

    Button hexadecimal0Button;
    Button hexadecimal1Button;
    Button hexadecimal2Button;
    Button hexadecimal3Button;
    Button hexadecimal4Button;
    Button hexadecimal5Button;
    Button hexadecimal6Button;
    Button hexadecimal7Button;
    Button hexadecimal8Button;
    Button hexadecimal9Button;
    Button hexadecimalAButton;
    Button hexadecimalBButton;
    Button hexadecimalCButton;
    Button hexadecimalDButton;
    Button hexadecimalEButton;
    Button hexadecimalFButton;
    Button hexadecimalDeleteButton;
    Button hexadecimalClrButton;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        binaryText = (EditText) findViewById(R.id.binaryText);
        decimalText = (EditText) findViewById(R.id.decimalText);
        hexadecimalText = (EditText) findViewById(R.id.hexadecimalText);

        binary0Button = (Button) findViewById(R.id.binary0Button);
        binary1Button = (Button) findViewById(R.id.binary1Button);
        binaryDeleteButton = (Button) findViewById(R.id.binaryDeleteButton);
        binaryClrButton = (Button) findViewById(R.id.binaryClrButton);

        decimal0Button = (Button) findViewById(R.id.decimal0Button);
        decimal1Button = (Button) findViewById(R.id.decimal1Button);
        decimal2Button = (Button) findViewById(R.id.decimal2Button);
        decimal3Button = (Button) findViewById(R.id.decimal3Button);
        decimal4Button = (Button) findViewById(R.id.decimal4Button);
        decimal5Button = (Button) findViewById(R.id.decimal5Button);
        decimal6Button = (Button) findViewById(R.id.decimal6Button);
        decimal7Button = (Button) findViewById(R.id.decimal7Button);
        decimal8Button = (Button) findViewById(R.id.decimal8Button);
        decimal9Button = (Button) findViewById(R.id.decimal9Button);
        decimalDeleteButton = (Button) findViewById(R.id.decimalDeleteButton);
        decimalClrButton = (Button) findViewById(R.id.decimalClrButton);

        hexadecimal0Button = (Button) findViewById(R.id.hexadecimal0Button);
        hexadecimal1Button = (Button) findViewById(R.id.hexadecimal1Button);
        hexadecimal2Button = (Button) findViewById(R.id.hexadecimal2Button);
        hexadecimal3Button = (Button) findViewById(R.id.hexadecimal3Button);
        hexadecimal4Button = (Button) findViewById(R.id.hexadecimal4Button);
        hexadecimal5Button = (Button) findViewById(R.id.hexadecimal5Button);
        hexadecimal6Button = (Button) findViewById(R.id.hexadecimal6Button);
        hexadecimal7Button = (Button) findViewById(R.id.hexadecimal7Button);
        hexadecimal8Button = (Button) findViewById(R.id.hexadecimal8Button);
        hexadecimal9Button = (Button) findViewById(R.id.hexadecimal9Button);
        hexadecimalAButton = (Button) findViewById(R.id.hexadecimalAButton);
        hexadecimalBButton = (Button) findViewById(R.id.hexadecimalBButton);
        hexadecimalCButton = (Button) findViewById(R.id.hexadecimalCButton);
        hexadecimalDButton = (Button) findViewById(R.id.hexadecimalDButton);
        hexadecimalEButton = (Button) findViewById(R.id.hexadecimalEButton);
        hexadecimalFButton = (Button) findViewById(R.id.hexadecimalFButton);
        hexadecimalDeleteButton = (Button) findViewById(R.id.hexadecimalDeleteButton);
        hexadecimalClrButton = (Button) findViewById(R.id.hexadecimalClrButton);

        this.setAllButtonsInvisible();

        decimalView = (TextView) findViewById(R.id.decimalView);
        binaryView = (TextView) findViewById(R.id.binaryView);
        hexadecimalView = (TextView) findViewById(R.id.hexadecimalView);

        final EditText binaryText = (EditText) findViewById(R.id.binaryText);
        final EditText decimalText = (EditText) findViewById(R.id.decimalText);
        final EditText hexadecimalText = (EditText) findViewById(R.id.hexadecimalText);

        binaryText.setInputType(EditorInfo.TYPE_NULL);
        hexadecimalText.setInputType(EditorInfo.TYPE_NULL);
        decimalText.setInputType(EditorInfo.TYPE_NULL);

        binaryText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setAllButtonsInvisible();
                if (binaryText.getText().toString().equals("0")) {
                    binaryText.setText("");
                }
                binary0Button.setVisibility(View.VISIBLE);
                binary1Button.setVisibility(View.VISIBLE);
                binaryDeleteButton.setVisibility(View.VISIBLE);
                binaryClrButton.setVisibility(View.VISIBLE);
            }
        });

        decimalText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setAllButtonsInvisible();
                if (decimalText.getText().toString().equals("0")) {
                    decimalText.setText("");
                }
                decimal0Button.setVisibility(View.VISIBLE);
                decimal1Button.setVisibility(View.VISIBLE);
                decimal2Button.setVisibility(View.VISIBLE);
                decimal3Button.setVisibility(View.VISIBLE);
                decimal4Button.setVisibility(View.VISIBLE);
                decimal5Button.setVisibility(View.VISIBLE);
                decimal6Button.setVisibility(View.VISIBLE);
                decimal7Button.setVisibility(View.VISIBLE);
                decimal8Button.setVisibility(View.VISIBLE);
                decimal9Button.setVisibility(View.VISIBLE);
                decimalDeleteButton.setVisibility(View.VISIBLE);
                decimalClrButton.setVisibility(View.VISIBLE);
            }
        });

        hexadecimalText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setAllButtonsInvisible();
                if (hexadecimalText.getText().toString().equals("0")) {
                    hexadecimalText.setText("");
                }
                hexadecimal0Button.setVisibility(View.VISIBLE);
                hexadecimal1Button.setVisibility(View.VISIBLE);
                hexadecimal2Button.setVisibility(View.VISIBLE);
                hexadecimal3Button.setVisibility(View.VISIBLE);
                hexadecimal4Button.setVisibility(View.VISIBLE);
                hexadecimal5Button.setVisibility(View.VISIBLE);
                hexadecimal6Button.setVisibility(View.VISIBLE);
                hexadecimal7Button.setVisibility(View.VISIBLE);
                hexadecimal8Button.setVisibility(View.VISIBLE);
                hexadecimal9Button.setVisibility(View.VISIBLE);
                hexadecimalAButton.setVisibility(View.VISIBLE);
                hexadecimalBButton.setVisibility(View.VISIBLE);
                hexadecimalCButton.setVisibility(View.VISIBLE);
                hexadecimalDButton.setVisibility(View.VISIBLE);
                hexadecimalEButton.setVisibility(View.VISIBLE);
                hexadecimalFButton.setVisibility(View.VISIBLE);
                hexadecimalDeleteButton.setVisibility(View.VISIBLE);
                hexadecimalClrButton.setVisibility(View.VISIBLE);
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
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    if (!flag) {
                        flag = true;
                        decimalText.setText("0");
                        binaryText.setText("0");
                        flag = false;
                    }
                }
            }
        });
    }

    public void onClickBinary(View view) {
        Button button = (Button) view;
        binaryText.setText(binaryText.getText().toString()+button.getText().toString());
    }

    public void onClickBinaryDelete(View view) {
        String binaryNumber = (String) binaryText.getText().toString();
        StringBuilder aux = new StringBuilder(binaryNumber);
        aux.deleteCharAt(binaryNumber.length()-1);
        binaryText.setText(aux.toString());
    }

    public void onClickBinaryClr(View view) {
        binaryText.setText("");
    }

    public void onClickDecimal(View view) {
        Button button = (Button) view;
        decimalText.setText(decimalText.getText().toString() + button.getText().toString());
    }

    public void onClickDecimalDelete(View view) {
        String decimalNumber = (String) decimalText.getText().toString();
        StringBuilder aux = new StringBuilder(decimalNumber);
        aux.deleteCharAt(decimalNumber.length()-1);
        decimalText.setText(aux.toString());
    }

    public void onClickDecimalClr(View view) {
        decimalText.setText("");
    }

    public void onClickHexadecimal(View view) {
        Button button = (Button) view;
        hexadecimalText.setText(hexadecimalText.getText().toString()+button.getText().toString());
    }

    public void onClickHexadecimalDelete(View view) {
        String hexadecimalNumber = (String) hexadecimalText.getText().toString();
        StringBuilder aux = new StringBuilder(hexadecimalNumber);
        aux.deleteCharAt(hexadecimalNumber.length()-1);
        hexadecimalText.setText(aux.toString());
    }

    public void onClickHexadecimalClr(View view) {
        hexadecimalText.setText("");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setAllButtonsInvisible() {
        binary0Button.setVisibility(View.INVISIBLE);
        binary1Button.setVisibility(View.INVISIBLE);
        binaryDeleteButton.setVisibility(View.INVISIBLE);
        binaryClrButton.setVisibility(View.INVISIBLE);

        decimal0Button.setVisibility(View.INVISIBLE);
        decimal1Button.setVisibility(View.INVISIBLE);
        decimal2Button.setVisibility(View.INVISIBLE);
        decimal3Button.setVisibility(View.INVISIBLE);
        decimal4Button.setVisibility(View.INVISIBLE);
        decimal5Button.setVisibility(View.INVISIBLE);
        decimal6Button.setVisibility(View.INVISIBLE);
        decimal7Button.setVisibility(View.INVISIBLE);
        decimal8Button.setVisibility(View.INVISIBLE);
        decimal9Button.setVisibility(View.INVISIBLE);
        decimalDeleteButton.setVisibility(View.INVISIBLE);
        decimalClrButton.setVisibility(View.INVISIBLE);

        hexadecimal0Button.setVisibility(View.INVISIBLE);
        hexadecimal1Button.setVisibility(View.INVISIBLE);
        hexadecimal2Button.setVisibility(View.INVISIBLE);
        hexadecimal3Button.setVisibility(View.INVISIBLE);
        hexadecimal4Button.setVisibility(View.INVISIBLE);
        hexadecimal5Button.setVisibility(View.INVISIBLE);
        hexadecimal6Button.setVisibility(View.INVISIBLE);
        hexadecimal7Button.setVisibility(View.INVISIBLE);
        hexadecimal8Button.setVisibility(View.INVISIBLE);
        hexadecimal9Button.setVisibility(View.INVISIBLE);
        hexadecimalAButton.setVisibility(View.INVISIBLE);
        hexadecimalBButton.setVisibility(View.INVISIBLE);
        hexadecimalCButton.setVisibility(View.INVISIBLE);
        hexadecimalDButton.setVisibility(View.INVISIBLE);
        hexadecimalEButton.setVisibility(View.INVISIBLE);
        hexadecimalFButton.setVisibility(View.INVISIBLE);
        hexadecimalDeleteButton.setVisibility(View.INVISIBLE);
        hexadecimalClrButton.setVisibility(View.INVISIBLE);
    }
}
