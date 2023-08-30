package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView workingsTv;
    TextView resultsTv;
    String workings="";
    String formula="";
    String tempformula="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }
    private void initTextViews(){
        workingsTv=(TextView) findViewById(R.id.workingsTextView);
        resultsTv=(TextView) findViewById((R.id.resultTextView);
    }
    public void setworkings(String givenV alue){
        workings=workings+givenValue;
        workingsTv.setText(workings);
    }
    public void equals_on_click(){
        Double result=null;
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("rhino");
        check_for_powerof();
        try {
            result=(double)engine.eval(formula);
        }
        catch(ScriptException e){
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if(result!=null){
            resultsTv.setText(String.valueOf(result.doubleValue()));
        }
    }
    private void check_for_powerof(){
        ArrayList<Integer>indexofpowers=new ArrayList<>();
        for(int i=0;i<workings.length();i++) {
            if (workings.charAt(i) == '^') {
                indexofpowers.add(i);
            }
            formula = workings;
            tempformula = workings;
            for (int index : indexofpowers) {
                changeFormula(index);
            }
            formula=tempformula;
        }
    }
    private void changeFormula(int index){
        String numleft="";
        String numright="";

        for(int i=index+1:i<workings.length();i++){
            if(isNumeric(workings.charAt(i))){
                numright=numright+workings.charAt(i);
            }
            else
                break;
        }
        for(int i=index-1;i>=0;i--){
            if(isNumeric(workings.charAt(i))){
                numleft=workings.charAt(i)+numleft;
            }
            else
                break;
        }
        String original=numleft+"^"+numright;
        String changed="Math.pow("+numleft+","+numright+")";
        tempformula=tempformula.replace(original,changed);
    }
    private boolean isNumeric(char ch){
        if((ch>='0' && ch<='9')||ch=='.'){
            return true;
        }
        return false;
    }
    public void clearonclick(View view){
        workingsTv.setText("");
        workings="";
        resultsTv.setText("");
        leftbracket=true;
    }
    boolean leftbracket=true;

    public void bracketsonclick(View view){
        if(leftbracket==true){
            setworkings("(");
            leftbracket=false;
        }
        else{
            setworkings(")");
            leftbracket=true;
        }
    }
    public void powerofonclick(View view){
        setworkings("^");
    }
    public void addonclick(View view){
        setworkings("+");
    }
    public void subonclick(View view){
        setworkings("-");
    }
    public void productonclick(View view){
        setworkings("*");
    }
    public void divonclick(View view){
        setworkings("/");
    }
    public void zeroonclick(View view){
        setworkings("0");
    }
    public void oneonclick(View view){
        setworkings("1");
    }
    public void twoonclick(View view){
        setworkings("2");
    }
    public void threeonclick(View view){
        setworkings("3");
    }
    public void fouronclick(View view){
        setworkings("4");
    }
    public void fiveonclick(View view){
        setworkings("5");
    }
    public void sixonclick(View view){
        setworkings("6");
    }
    public void sevenonclick(View view){
        setworkings("7");
    }
    public void eightonclick(View view){
        setworkings("8");
    }
    public void nineonclick(View view){
        setworkings("9");
    }
}
