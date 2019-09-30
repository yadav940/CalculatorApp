package com.vinod.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import android.view.SoundEffectConstants;
import android.widget.Toast;


import com.skydoves.elasticviews.ElasticLayout;
//Created by vinod yadav at 29-09-2019
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ElasticLayout ll_seven,ll_eleght,ll_nine,ll_four,ll_five,ll_six,ll_one,ll_two,ll_three,ll_decemal;
    private ElasticLayout ll_miltiply,ll_div,ll_plus,ll_sub,ll_equel,ll_open_bracket,ll_close_bracket;

    private ElasticLayout ll_m,ll_mr,ll_sto,ll_percent,ll_exp;
    private ElasticLayout ll_sin,ll_cos,ll_tan,ll_pie,ll_hyp_10x;
    private ElasticLayout ll_pi,ll_x_pow_y,ll_x_pow_3,ll_x_pow_2, ll_log;
    private ElasticLayout ll_fse,ll_rdm,ll_npr,ll_func, ll_const;

    //@BindView(R.id.ll_zero)
    ElasticLayout ll_zero;
    private TextView tv_result;
    //@BindView(R.id.ll_ac)
    ElasticLayout ll_ac;
    //@BindView(R.id.ll_del)
    ElasticLayout ll_del;

    private final String TAG="MainActivityTag ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        intit();
        lisner();
        if (Build.VERSION.SDK_INT >= 23) {
            //do your check here
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                //File write logic here
                return ;
            }
        }

    }

    private void intit(){


        tv_result=findViewById(R.id.tv_result);
        ll_seven=findViewById(R.id.ll_seven);
        ll_eleght=findViewById(R.id.ll_eleght);
        ll_nine=findViewById(R.id.ll_nine);
        ll_four=findViewById(R.id.ll_four);
        ll_five=findViewById(R.id.ll_five);
        ll_six=findViewById(R.id.ll_six);
        ll_one=findViewById(R.id.ll_one);
        ll_two=findViewById(R.id.ll_two);
        ll_three=findViewById(R.id.ll_three);
        ll_zero=findViewById(R.id.ll_zero);
        ll_decemal=findViewById(R.id.ll_decemal);

        ll_miltiply=findViewById(R.id.ll_miltiply);
        ll_div=findViewById(R.id.ll_div);
        ll_plus=findViewById(R.id.ll_plus);
        ll_sub=findViewById(R.id.ll_sub);
        ll_equel=findViewById(R.id.ll_equel);
        ll_open_bracket=findViewById(R.id.ll_open_bracket);
        ll_close_bracket=findViewById(R.id.ll_close_bracket);
        ll_del=findViewById(R.id.ll_del);
        ll_ac=findViewById(R.id.ll_ac);

        ll_sin=findViewById(R.id.ll_sin);
        ll_cos=findViewById(R.id.ll_cos);
        ll_tan=findViewById(R.id.ll_tan);
        ll_pie=findViewById(R.id.ll_pie);
        ll_hyp_10x=findViewById(R.id.ll_hyp_10x);

        // ,,,,

    }
    private void lisner(){
        ll_seven.setOnClickListener(this);
        ll_eleght.setOnClickListener(this);
        ll_nine.setOnClickListener(this);
        ll_four.setOnClickListener(this);
        ll_five.setOnClickListener(this);
        ll_six.setOnClickListener(this);
        ll_one.setOnClickListener(this);
        ll_two.setOnClickListener(this);
        ll_three.setOnClickListener(this);
        ll_zero.setOnClickListener(this);
        ll_decemal.setOnClickListener(this);


        ll_miltiply.setOnClickListener(this);
        ll_div.setOnClickListener(this);
        ll_plus.setOnClickListener(this);
        ll_sub.setOnClickListener(this);
        ll_equel.setOnClickListener(this);
        ll_open_bracket.setOnClickListener(this);
        ll_close_bracket.setOnClickListener(this);
        ll_del.setOnClickListener(this);
        ll_ac.setOnClickListener(this);


        ll_sin.setOnClickListener(this);
        ll_cos.setOnClickListener(this);
        ll_tan.setOnClickListener(this);
        ll_pie.setOnClickListener(this);
        ll_hyp_10x.setOnClickListener(this);

        //,,,,,,,,,,;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //
            case R.id.ll_seven:
                tv_result.setText(tv_result.getText()+"7");
                break;
            case R.id.ll_eleght:
                tv_result.setText(tv_result.getText()+"8");
                break;
            case R.id.ll_nine:
                tv_result.setText(tv_result.getText()+"9");
                break;
            case R.id.ll_four:
                tv_result.setText(tv_result.getText()+"4");
                break;
            case R.id.ll_one:
                tv_result.setText(tv_result.getText()+"1");
                break;
            case R.id.ll_two:
                tv_result.setText(tv_result.getText()+"2");
                break;
            case R.id.ll_three:
                tv_result.setText(tv_result.getText()+"3");
                break;
            case R.id.ll_zero:
                tv_result.setText(tv_result.getText()+"0");
                break;
            case R.id.ll_decemal:
                tv_result.setText(tv_result.getText()+".");
                break;
            case R.id.tv_result:
                break;
            case R.id.ll_miltiply:
                tv_result.setText(tv_result.getText()+"*");
                break;
            case R.id.ll_div:
                tv_result.setText(tv_result.getText()+"/");
                break;
            case R.id.ll_plus:
                tv_result.setText(tv_result.getText()+"+");
                break;
            case R.id.ll_sub:
                tv_result.setText(tv_result.getText()+"-");
                break;
            case R.id.ll_equel:
                tv_result.setText(eval(tv_result.getText().toString(),view)+"");
                break;
            case R.id.ll_open_bracket:
                tv_result.setText(tv_result.getText()+"(");
                break;
            case R.id.ll_close_bracket:
                tv_result.setText(tv_result.getText()+")");
                break;

            case R.id.ll_ac:
                tv_result.setText("");
                break;
            case R.id.ll_del:
                if (!tv_result.getText().toString().isEmpty())
                    tv_result.setText(tv_result.getText().toString().substring(0,tv_result.getText().toString().length()-1));
                break;


            case R.id.ll_sin:
                tv_result.setText(tv_result.getText()+"sin(");
                break;
            case R.id.ll_cos:
                tv_result.setText(tv_result.getText()+"cos(");
                break;
            case R.id.ll_tan:
                tv_result.setText(tv_result.getText()+"tan(");
                break;
                //,,,,,,
        }

        if (view.getId()==R.id.ll_zero||view.getId()==R.id.ll_one||view.getId()==R.id.ll_two||view.getId()==R.id.ll_three||view.getId()==R.id.ll_four||view.getId()==R.id.ll_five||view.getId()==R.id.ll_six||view.getId()==R.id.ll_seven||view.getId()==R.id.ll_eleght||view.getId()==R.id.ll_nine){
            MediaPlayer mPlayer2;
            mPlayer2= MediaPlayer.create(this, R.raw.num_press);
            mPlayer2.start();
        }

        /*AudioManager audioManager =(AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.playSoundEffect(SoundEffectConstants.CLICK);*/
        //view.playSoundEffect(SoundEffectConstants.CLICK);
        Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vv.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vv.vibrate(50);
        }

    }

    public static double eval(final String str,View view) {
        try {
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                    return x;
                }

                // Grammar:
                // expression = term | expression `+` term | expression `-` term
                // term = factor | term `*` factor | term `/` factor
                // factor = `+` factor | `-` factor | `(` expression `)`
                //        | number | functionName factor | factor `^` factor

                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if      (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if      (eat('*')) x *= parseFactor(); // multiplication
                        else if (eat('/')) x /= parseFactor(); // division
                        else return x;
                    }
                }

                double parseFactor() {
                    if (eat('+')) return parseFactor(); // unary plus
                    if (eat('-')) return -parseFactor(); // unary minus

                    double x;
                    int startPos = this.pos;
                    if (eat('(')) { // parentheses
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(str.substring(startPos, this.pos));
                    } else if (ch >= 'a' && ch <= 'z') { // functions
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = str.substring(startPos, this.pos);
                        x = parseFactor();
                        if (func.equals("sqrt")) x = Math.sqrt(x);
                        else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                        else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                        else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                        else throw new RuntimeException("Unknown function: " + func);
                    } else {
                        throw new RuntimeException("Unexpected: " + (char)ch);
                    }

                    if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                    return x;
                }
            }.parse();
        }catch (Exception e){
            Toast.makeText(view.getContext(),"Syntex Error",Toast.LENGTH_SHORT).show();
            return 0.0;
        }

    }


}
