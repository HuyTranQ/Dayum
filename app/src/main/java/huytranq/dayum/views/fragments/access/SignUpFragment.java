package huytranq.dayum.views.fragments.access;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import huytranq.dayum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends AccessFragment {

    private EditText username , password , confirm , phone;
    private TextInputLayout usernameWrapper , passwordWrapper , confirmWrapper , phoneWrapper;
    private Button submit;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view) {
        username = (EditText) view.findViewById(R.id.fragment_sign_up_username);
        password = (EditText) view.findViewById(R.id.fragment_sign_up_password);
        confirm = (EditText) view.findViewById(R.id.fragment_sign_up_confirm);
        phone = (EditText) view.findViewById(R.id.fragment_sign_up_phone);
        usernameWrapper = (TextInputLayout) view.findViewById(R.id.fragment_sign_up_usernameWrapper);
        passwordWrapper = (TextInputLayout) view.findViewById(R.id.fragment_sign_up_passwordWrapper);
        confirmWrapper = (TextInputLayout) view.findViewById(R.id.fragment_sign_up_confirmWrapper);
        phoneWrapper = (TextInputLayout) view.findViewById(R.id.fragment_sign_up_phoneWrapper);
        submit = (Button) view.findViewById(R.id.fragment_sign_up_submit);

        setup();
    }

    private void setup() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
