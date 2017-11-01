package com.example.apple.mdview;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = getLayoutInflater().inflate(R.layout.activity_main,null);
        setContentView(rootView);

        init();
    }

    private void init() {
        findViewById(R.id.cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CardViewActivity.class));
            }
        });

        Button snackBtn = (Button) findViewById(R.id.snackbar);

        snackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(rootView,"弹出提示", Toast.LENGTH_SHORT);

                View snackView = snackbar.getView();
                if(snackView != null){
                    snackView.setBackgroundResource(R.color.colorAccent);
                    ((TextView)snackView.findViewById(R.id.snackbar_text)).setTextColor(Color.WHITE);
                }
                snackbar.setAction("右边文字", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"点击snackbar",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
