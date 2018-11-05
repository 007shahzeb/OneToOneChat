package android.com.firebaseRegistration;

import android.app.ProgressDialog;
import android.com.onetoonechat.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonSignup;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    String email, password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        firebaseAuth = FirebaseAuth.getInstance();


        findingIdsHere();
        eventListner();


    }

    private void eventListner() {
        buttonSignup.setOnClickListener(this);
    }


    private void findingIdsHere() {

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonSignup = findViewById(R.id.buttonSignup);
        progressDialog = new ProgressDialog(this);

    }

    private void registerUser() {

        email = editTextEmail.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }


        shwoingProgressDialogMessage();
        creatingNewUserHere();

    }


    private void creatingNewUserHere() {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "Successfully registered", Toast.LENGTH_LONG).show();

                        } else {

                            FirebaseAuthException e = (FirebaseAuthException) task.getException();

                            Toast.makeText(MainActivity.this, "Failed Registration: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        progressDialog.dismiss();
                    }
                });


    }

    private void shwoingProgressDialogMessage() {

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
    }


    @Override
    public void onClick(View view) {
        registerUser();
    }


}
