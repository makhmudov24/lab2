package com.example.generatefraza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//Android UI Classes
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Parser parser=new Parser();
    private TextView txt1;
    private TextView txt2;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn1=findViewById(R.id.btn1);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        String text=parser.PhraserGen();
        txt1.setText("Всё , что нам нужно – это "+text);
        String text2=getString(txt1.getText().toString());
        txt2.setText(text2);
        btn1.setOnClickListener(buttonPressed);

    }
    private final View.OnClickListener buttonPressed=new View.OnClickListener(){
        @Override
        public void onClick (View view) {

            String text=parser.PhraserGen();
            txt1.setText("Всё , что нам нужно – это "+text);
            String text2=getString(txt1.getText().toString());
            txt2.setText(text2);
        }
    };
     String getString(String text){
        String textNamed="";
        String [] textArray=text.split(" ",0);
        char [] chars=textArray[textArray.length-1].toCharArray();
        char [] chars1=textArray[0].toCharArray();
        String name=""+chars[0];
        String name1=""+chars1[0];
        name=name.toUpperCase();
        name1=name1.toLowerCase();
        for (int i=1;i<chars.length;i++) {
            name+=""+chars[i];
        }
        for (int i=1;i<chars1.length;i++){
            name1+=""+chars1[i];
        }
        textArray[textArray.length-1]=name;
        textArray[0]=name1;
        for (int i=textArray.length;i>0;i--){
            textNamed+=textArray[i-1]+ " ";
        }
        return textNamed;

    }


}