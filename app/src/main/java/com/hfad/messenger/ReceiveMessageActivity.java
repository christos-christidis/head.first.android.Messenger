package com.hfad.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class ReceiveMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String recipientText = intent.getStringExtra(Intent.EXTRA_CC);
        String messageText = intent.getStringExtra(Intent.EXTRA_TEXT);

        TextView textView = findViewById(R.id.data_received);
        textView.setText(String.format(Locale.getDefault(), "To: %s%n%s", recipientText, messageText));
    }
}
