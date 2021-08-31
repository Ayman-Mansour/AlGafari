package tech2go.example.com.algafari;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import static tech2go.example.com.algafari.MessageActivity.DIALOG_DOWNLOAD_PROGRESS;

public class MessageActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextCoName;
    private EditText editTextSubject;
    private EditText editTextMessage;

    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextCoName = (EditText) findViewById(R.id.editTextCoName);
        editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        editTextMessage = (EditText) findViewById(R.id.editTextMassage);
        final Button Sumbitbtn = (Button) findViewById(R.id.submit);

//        mProgressDialog = new ProgressDialog(this);

        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!isValidEmail(editTextEmail.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "please enter valid email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        Sumbitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString().equals("") || editTextEmail.getText().toString().equals("")
                        || editTextPhone.getText().toString().equals("") || editTextCoName.getText().toString().equals("")
                        || editTextSubject.getText().toString().equals("") || editTextMessage.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    sendMessage();
                }
            }
        });


    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


    private void sendMessage() {
        String[] recipients = {"info@gissd.com"};
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail("algafrimail@gmail.com", "algafrimail123");
        email.m.set_from("algafrimail@gmail.com");
        email.m.setBody("NAME: " + editTextName.getText().toString() + "\n" +
                "EMAIL:" + editTextEmail.getText().toString() + "\n" + "PHONE NUMBER: " + editTextPhone.getText().toString()
                + "\n" + "COMPANY NAME: " + editTextCoName.getText().toString() + "\n" + "MESSAGE: " + editTextMessage.getText().toString()
                + " \n \n \n SENT FROM ALGAFARI APP");
        email.m.set_to(recipients);
        email.m.set_subject(editTextSubject.getText().toString());
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.submit), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DOWNLOAD_PROGRESS:
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.setMessage(" Wait a moment ");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
                return mProgressDialog;
            default:
                return null;
        }
    }

}

class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
    Mail m;
    MessageActivity activity;

    public SendEmailAsyncTask() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        activity.showDialog(DIALOG_DOWNLOAD_PROGRESS);
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            if (m.send()) {
                activity.displayMessage("Email sent.");
            } else {
                activity.displayMessage("Email failed to send.");
            }

            return true;
        } catch (AuthenticationFailedException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
            e.printStackTrace();
            activity.displayMessage("Authentication failed.");
            return false;
        } catch (MessagingException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
            e.printStackTrace();
            activity.displayMessage("Email failed to send.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            activity.displayMessage("Unexpected error occured.");
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        activity.dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
    }
}

