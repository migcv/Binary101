package pt.migcv.binary101.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import java.util.Set;

import pt.migcv.binary101.R;
import pt.migcv.binary101.core.Settings;

public class SettingsFragment extends Fragment {

    View view;

    Switch systemKeyboardSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        systemKeyboardSwitch = (Switch) view.findViewById(R.id.systemKeyboardSwitch);
        if(Settings.isSystemKeyboardOn()) {
            systemKeyboardSwitch.setChecked(true);
        }
        systemKeyboardSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(systemKeyboardSwitch.isChecked())
                    Settings.setSystemKeyboard(true);
                else
                    Settings.setSystemKeyboard(false);
            }
        });
        return view;
    }
}
