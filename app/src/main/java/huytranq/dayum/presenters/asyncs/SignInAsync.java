package huytranq.dayum.presenters.asyncs;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.Toast;

import huytranq.dayum.models.User;
import huytranq.dayum.presenters.utilities.Database;
import huytranq.dayum.views.activities.HomeActivity;

/**
 * Created by huytr on 18-01-2016.
 */
public class SignInAsync extends AsyncTask<Void , Integer , Void> {

    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private ProgressDialog progressDialog;
    private String username , password;
    private Context context;
    private User user;

    public SignInAsync(Context context ,
                       TextInputLayout usernameWrapper,
                       TextInputLayout passwordWrapper,
                       String username ,
                       String password) {
        this.usernameWrapper = usernameWrapper;
        this.passwordWrapper = passwordWrapper;
        this.username = username;
        this.password = password;
        this.context = context;
        user = null;

        progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            user = Database.help(context).queryUser(username , password.getBytes());
        } catch (Exception exception) {
            if (exception.getMessage().equals("username"))
                publishProgress(0);
            else
                publishProgress(1);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (0 == values[0]) {
            passwordWrapper.setErrorEnabled(false);
            usernameWrapper.setErrorEnabled(true);
            usernameWrapper.setError("Username is incorrect");
        }
        else {
            usernameWrapper.setErrorEnabled(false);
            passwordWrapper.setErrorEnabled(true);
            passwordWrapper.setError("Password is incorrect");
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        if (user == null)
            Toast.makeText(context, "Oops! something Wrong???" , Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(context, "Sign in is successful" , Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context , HomeActivity.class));
        }

    }
}
