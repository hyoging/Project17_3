package ks.hs.emirim.hyojin.project17_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textName, textEmail, textToast;
    View dialogV, toastV;
    EditText editName, editEmail;
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
            dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface DailogInterface, int i) {
                    editName = dialogV.findViewById(R.id.dialog_edit_name);
                    editEmail = dialogV.findViewById(R.id.dialog_edit_email);
                    textName.setText(editName.getText().toString());
                    textEmail.setText(editEmail.getText().toString());
                }
            });
            dialog.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast toast = new Toast(MainActivity.this);
                    toastV = View.inflate(MainActivity.this, R.layout.toast1, null);
                    textToast = toastV.findViewById(R.id.toast_text);
                    textToast.setText("취소했습니다.");
                    toast.setView(toastV);
                    toast.show();
                }
            });
            dialog.show();
        }
    };
}
