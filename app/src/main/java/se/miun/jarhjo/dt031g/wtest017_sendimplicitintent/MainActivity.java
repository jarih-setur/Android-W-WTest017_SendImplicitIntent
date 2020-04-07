package se.miun.jarhjo.dt031g.wtest017_sendimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSendClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String message = ((EditText) findViewById(R.id.etMessage)).getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("text/plain");
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }
    }

    public void btnChooseSendClick(View view) {
        // Create the text message with a string
        Intent intent = new Intent();
        String message = ((EditText) findViewById(R.id.etMessage)).getText().toString();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");
        String title = getResources().getString(R.string.chooser_title);
// Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(intent, title);


// Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

    }
}
