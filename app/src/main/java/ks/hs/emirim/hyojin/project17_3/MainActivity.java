package ks.hs.emirim.hyojin.project17_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textName, textEmail;
    View dialogV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName =findViewById(R.id.user_name);
        textEmail = findViewById(R.id.user_email);
        Button btn_input = findViewById(R.id.btn_input);

        btn_input.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogV = View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle(R.string.user_input);
            dialog.setIcon(R.drawable.user);
            dialog.setView(dialogV);
            dialog.setPositiveButton("확인", null);
            dialog.setPositiveButton("취소", null);
            dialog.show();
        }
    };
}