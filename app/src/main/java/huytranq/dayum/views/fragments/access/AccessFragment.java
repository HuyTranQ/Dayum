package huytranq.dayum.views.fragments.access;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import huytranq.dayum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccessFragment extends Fragment {

    protected Activity activity;

    public static AccessFragment create(Activity activity ,
                                        int index) {
        AccessFragment result;
        if (index == 0)
            result = new SignInFragment();
        else
            result = new SignUpFragment();
        result.activity = activity;
        return result;
    }

    public AccessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
