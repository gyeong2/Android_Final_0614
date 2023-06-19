package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        EditText editText_title = findViewById(R.id.editText1);
        EditText editText_content = findViewById(R.id.editText2);
        Memo memo = (Memo) getIntent().getSerializableExtra("MEMO");
        Integer index = (Integer) getIntent().getSerializableExtra("index");
        if (memo != null) {
            editText_title.setText(memo.getTitle());
            editText_content.setText(memo.getContent());
        }


        Button button = findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_title = (EditText) findViewById(R.id.editText1);
                String title = editText_title.getText().toString();
            }

            EditText editText_content = (EditText) findViewById(R.id.editText2);
            String content = editText_content.getText().toString();


                /*Memo memo = new Memo(title, content);
                Intent intent = new Intent();
                intent.putExtra("MEMO", memo);
                intent.putExtra("index", index);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        button.setOnClickListener(listener);*/

        };
    }
}

