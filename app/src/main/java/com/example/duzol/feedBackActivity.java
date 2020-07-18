package com.example.duzol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_feed_back);

        final EditText feedbackev = (EditText) findViewById(R.id.feedback_formev);
        Button feedback_btn = (Button) findViewById(R.id.feedback_btn);


        feedback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (feedbackev.getText().toString().isEmpty()){
                    Toast.makeText(feedBackActivity.this,"Field cannot be blank",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(feedBackActivity.this,"Select your email app",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto:"));
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"1928115@kiit.ac.in"});
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback IoT LAB [duZol]");
                    intent.putExtra(Intent.EXTRA_TEXT,"Feedback: ");
                    try {
                        startActivity(Intent.createChooser(intent,"Send feedback"));
                    } catch (android.content.ActivityNotFoundException e) {
                        Toast.makeText(feedBackActivity.this,R.string.intent_mail_fail,Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}