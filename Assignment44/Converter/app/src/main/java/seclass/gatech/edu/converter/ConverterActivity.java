package seclass.gatech.edu.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ConverterActivity extends AppCompatActivity {
    String[] UNITS = {"Stones", "Pounds", "Ounces", "Grains", "Metric Tons", "Kilograms", "Grams", "Milligrams"};
    double[][] trans = {    {	1           ,   14	        ,	224	        ,	98000	    ,	0.006350295	,	6.350358342	,	6350.358342	,	6350358.342	}	,
                            {	0.071428571	,	1	        ,	16	        ,	7000	    ,	0.000453592	,	0.453597024	,	453.5970244	,	453597.0244	}	,
                            {	0.004464286	,	0.0625	    ,	1	        ,	437.5	    ,	2.83495E-05	,	0.028349523	,	28.34952313	,	28349.52313	}	,
                            {	1.02041E-05	,	0.000142857	,	0.002285714	,	1	        ,	6.47989E-08	,	6.47989E-05	,	0.06479891	,	0.015432358	}	,
                            {	157.473	    ,   2204.6226	,	35273.9619	,	15432358.35	,	1	        ,	1000	    ,	1000000	    ,	1000000000	}	,
                            {	0.157471429	,	2.2046	    ,	35.27396195	,	15432.35835	,	0.001	    ,	1	        ,	1000	    ,	1000000	    }	,
                            {	0.000157471	,	0.0022046	,	0.035273962	,	15.43235835	,	0.000001	,	0.001	    ,	1	        ,	1000	    }	,
                            {	1.57471E-07	,	2.2046E-06	,	3.5274E-05	,	64.79891	,	0.000000001	,	0.000001	,	0.001	    ,	1	        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Button button_reset = (Button) findViewById(R.id.breset);
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });


        Button button_convert = (Button) findViewById(R.id.bconvert);
        button_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });


        Button button_round_convert = (Button) findViewById(R.id.bround);
        button_round_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundConvert();
            }
        });


        Spinner spinner_conv_from = (Spinner) findViewById(R.id.convertfrom);
        Spinner spinner_conv_to = (Spinner) findViewById(R.id.convertto);

        ArrayAdapter<String> conv_from_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.text, UNITS);
        spinner_conv_from.setAdapter(conv_from_adapter);
        spinner_conv_to.setAdapter(conv_from_adapter);

    }

    /* Reset Button */
    public void reset() {
        ((EditText) findViewById(R.id.inputvalue)).setText("");
        ((EditText) findViewById(R.id.outputvalue)).setText("");
    }

    /* This converts the value */
    public void convert() {
        Spinner spinner_conv_from = (Spinner) findViewById(R.id.convertfrom);
        Spinner spinner_conv_to = (Spinner) findViewById(R.id.convertto);
        String string_value = ((EditText) findViewById(R.id.inputvalue)).getText().toString();
        Double inputValue = Double.parseDouble(string_value);

        int i = spinner_conv_from.getSelectedItemPosition();
        int j = spinner_conv_to.getSelectedItemPosition();

        String outputValue = convert(i,j,inputValue);
        EditText result = (EditText) findViewById(R.id.outputvalue);
        result.setText(outputValue);

    }

    /* This converts the value and rounds it */
    public void roundConvert() {
        Spinner spinner_conv_from = (Spinner) findViewById(R.id.convertfrom);
        Spinner spinner_conv_to = (Spinner) findViewById(R.id.convertto);
        String string_value = ((EditText) findViewById(R.id.inputvalue)).getText().toString();
        Double inputValue = Double.parseDouble(string_value);

        int i = spinner_conv_from.getSelectedItemPosition();
        int j = spinner_conv_to.getSelectedItemPosition();

        String outputValue = convert_round(i,j,inputValue);
        EditText result = (EditText) findViewById(R.id.outputvalue);
        result.setText(outputValue);
    }

    /* Perform unit conversion */
    public String convert(int i, int j, double value) {
        double result = trans[i][j] * value;
        /*return Math.round(result)+"";*/
        return (double)Math.round(result * 100000d) / 100000d+"";
    }

    /* Perform unit conversion and round it */
    public String convert_round(int i, int j, double value) {
        double result = trans[i][j] * value;
        return Math.round(result)+"";
    }
}
