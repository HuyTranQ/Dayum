package huytranq.dayum.views.fragments.access;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import huytranq.dayum.R;
import huytranq.dayum.presenters.asyncs.SignInAsync;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends AccessFragment {

    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private EditText username;
    private EditText password;
    private Button submit;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        initialize(view);
        return view;
    }

    void initialize(View view) {
        username = (EditText) view.findViewById(R.id.fragment_sign_in_username);
        password = (EditText) view.findViewById(R.id.fragment_sign_in_password);
        usernameWrapper = (TextInputLayout) view.findViewById(R.id.fragment_sign_in_usernameWrapper);
        passwordWrapper = (TextInputLayout) view.findViewById(R.id.fragment_sign_in_passwordWrapper);
        submit = (Button) view.findViewById(R.id.fragment_sign_in_submit);

        setup();
    }

    private void setup() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SignInAsync(activity ,
                        usernameWrapper ,
                        passwordWrapper ,
                        username.getText().toString() ,
                        password.getText().toString()).execute();
            }
        });
    }
}
