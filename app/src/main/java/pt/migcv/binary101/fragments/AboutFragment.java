package pt.migcv.binary101.fragments;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import pt.migcv.binary101.R;

public class AboutFragment extends Fragment {
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about, container, false);
        final EditText editText = (EditText) view.findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            private String previousText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Paint paint = editText.getPaint();
                Rect rectangle = new Rect();

                /* i used getTextBounds instead of measureText because it will return the float value but getWidth of
                 * edit text is a int. */
                paint.getTextBounds(s.toString(), 0, s.length(), rectangle);
                Log.d("123", "Text width: " + rectangle.width() + " Letter width: " + rectangle.width()/editText.getText().length());

                if (rectangle.width() > editText.getWidth()) {
                /* the user cannot type anymore */
                    Log.d("123", editText.getWidth() + " > " + rectangle.width() + " blocked.");
                    s.replace(0, s.length(), previousText);
                    return;
                }

                previousText = s.toString();
                Log.d("123", "Continue to write, new previousText: "  + previousText);
            }
        });
        return view;
    }
}
