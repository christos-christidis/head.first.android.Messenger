package com.hfad.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        EditText recipientView = findViewById(R.id.recipient);
        String recipientText = recipientView.getText().toString();

        EditText messageView = findViewById(R.id.data_received);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_CC, recipientText);
        intent.putExtra(Intent.EXTRA_TEXT, messageText);

        // SOS: Chooser forces the user to always choose an activity (they can't pick a default).
        // It's also a way to avoid the exception raised when there's no suitable app for the intent.
        String chooserTitle = getString(R.string.send_message_via);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);

        startActivity(chosenIntent);
    }
}
