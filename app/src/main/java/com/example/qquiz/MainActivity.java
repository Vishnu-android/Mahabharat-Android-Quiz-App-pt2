package com.example.qquiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button buttonn;
    TextView textView;
    private String[] questions={"1.Mahabharat and Ramayan both are same","2.Ved Vyas was born in Dwaparyug","3.DhristraRashtra was father of Yuyutsu","4.Gandhari was mother of Yuyutsu","5.Bhism was son of Santanu","6.Satyati was mother of Ved Vyas"};
    private boolean[] answers={false,true,true,false,true,true};
    private  int index=0;
    private  int score=0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        buttonn=findViewById(R.id.button2);
        textView=findViewById(R.id.textView3);
        textView.setText(questions[index]);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < questions.length ) {
                    if (answers[index] == true) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        textView.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score: " + score+" out of 6 ", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < questions.length ) {
                    if (answers[index] == false) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        textView.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score : " + score+" out of 6", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}