package huytranq.dayum.presenters.asyncs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import huytranq.dayum.models.User;

/**
 * Created by huytr on 21-01-2016.
 */
public class SignUpAsync extends AsyncTask<Void , Void , Void> {

    private Context context;
    private ProgressDialog progressDialog;

    public SignUpAsync(User user ,
                       String password ,
                       Context context) {
        this.context = context;

        progressDialog = new ProgressDialog(context);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
