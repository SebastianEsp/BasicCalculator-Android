package dk.espsoft.espsoft.basiccalculator;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.*;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    EditText editText_ResultView;

    Button button_MC;
    Button button_MR;
    Button button_MS;
    Button button_Mplus;
    Button button_Mminus;
    Button button_Delete;
    Button button_CE;
    Button button_C;
    Button button_PlusMinus;
    Button button_Root;
    Button button_Division;
    Button button_Percentage;
    Button button_1x;
    Button button_Multiplication;
    Button button_Minus;
    Button button_Plus;
    Button button_Equals;
    Button button_Seven;
    Button button_Eight;
    Button button_Nine;
    Button button_Four;
    Button button_Five;
    Button button_Six;
    Button button_One;
    Button button_Two;
    Button button_Three;
    Button button_Zero;
    Button button_Comma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_ResultView = (EditText) findViewById(R.id.editText_ResultView);
        disableSoftKeyboard(editText_ResultView);

        button_MC = (Button) findViewById(R.id.button_MC);
        button_MC.setOnClickListener(this);
        button_MR = (Button) findViewById(R.id.button_MR);
        button_MR.setOnClickListener(this);
        button_MS = (Button) findViewById(R.id.button_MS);
        button_MS.setOnClickListener(this);
        button_Mplus = (Button) findViewById(R.id.button_Mplus);
        button_Mplus.setOnClickListener(this);
        button_Mminus = (Button) findViewById(R.id.button_Mminus);
        button_Mminus.setOnClickListener(this);
        button_Delete = (Button) findViewById(R.id.button_Delete);
        button_Delete.setOnClickListener(this);
        button_CE = (Button) findViewById(R.id.button_CE);
        button_CE.setOnClickListener(this);
        button_C = (Button) findViewById(R.id.button_C);
        button_C.setOnClickListener(this);
        button_PlusMinus = (Button) findViewById(R.id.button_PlusMinus);
        button_PlusMinus.setOnClickListener(this);
        button_Root = (Button) findViewById(R.id.button_Root);
        button_Root.setOnClickListener(this);
        button_Seven = (Button) findViewById(R.id.button_Seven);
        button_Seven.setOnClickListener(this);
        button_Eight = (Button) findViewById(R.id.button_Eight);
        button_Eight.setOnClickListener(this);
        button_Nine = (Button) findViewById(R.id.button_Nine);
        button_Nine.setOnClickListener(this);
        button_Division = (Button) findViewById(R.id.button_Division);
        button_Division.setOnClickListener(this);
        button_Percentage = (Button) findViewById(R.id.button_Percentage);
        button_Percentage.setOnClickListener(this);
        button_Four = (Button) findViewById(R.id.button_Four);
        button_Four.setOnClickListener(this);
        button_Five = (Button) findViewById(R.id.button_Five);
        button_Five.setOnClickListener(this);
        button_Six = (Button) findViewById(R.id.button_Six);
        button_Six.setOnClickListener(this);
        button_Multiplication = (Button) findViewById(R.id.button_Multiplication);
        button_Multiplication.setOnClickListener(this);
        button_1x = (Button) findViewById(R.id.button_1x);
        button_1x.setOnClickListener(this);
        button_One = (Button) findViewById(R.id.button_One);
        button_One.setOnClickListener(this);
        button_Two = (Button) findViewById(R.id.button_Two);
        button_Two.setOnClickListener(this);
        button_Three = (Button) findViewById(R.id.button_Three);
        button_Three.setOnClickListener(this);
        button_Minus = (Button) findViewById(R.id.button_Minus);
        button_Minus.setOnClickListener(this);
        button_Plus = (Button) findViewById(R.id.button_Plus);
        button_Plus.setOnClickListener(this);
        button_Zero = (Button) findViewById(R.id.button_Zero);
        button_Zero.setOnClickListener(this);
        button_Comma = (Button) findViewById(R.id.button_Comma);
        button_Comma.setOnClickListener(this);
        button_Equals = (Button) findViewById(R.id.button_Equals);
        button_Equals.setOnClickListener(this);
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        if (!buttonText .equals("="))
        {
            editText_ResultView.append(buttonText);
        }
        else if (buttonText .equals("="))
        {
            calculate(editText_ResultView.getText().toString());
        }

    }

    private void calculate(String text)
    {
        String firstHalf;
        String secondHalf;

        Pattern p = Pattern.compile("(\\d+)(\\D*)(\\d*)(\\D{1})(\\d+)(\\D*)(\\d*)");
        Matcher m = p.matcher(text);

        if(m.find())
        {
            switch (m.group(4))
            {
                case "+":
                    //The calculation as an addition
                    firstHalf = m.group(1).toString() + m.group(2).toString() + m.group(3).toString();
                    secondHalf = m.group(5).toString() + m.group(6).toString() + m.group(7).toString();
                    //TO DO! Get first- & secondHalf as Integers
                break;

                case "-":
                    //The calculation as an subtraction
                break;

                case "*":
                    //The calculation as an multiplication
                break;

                case "/":
                    //The calculation as an division
                break;
            }
        }
    }

    private String isNumeric(String buttonText)
    {
        String numeric="";

        Pattern pattern = Pattern.compile("(\\d)");
        Matcher matcher = pattern.matcher(buttonText);

        if(matcher.find())
        {
           numeric =  matcher.group(0).toString();
        }

        return numeric;
    }

    //Disables soft keyboard but leaves the editText field caret and copy/paste functionality
    public static void disableSoftKeyboard(final EditText v) {
        if (Build.VERSION.SDK_INT >= 11) {
            v.setRawInputType(InputType.TYPE_CLASS_TEXT);
            v.setTextIsSelectable(true);
        } else {
            v.setRawInputType(InputType.TYPE_NULL);
            v.setFocusable(true);
        }
    }
}
