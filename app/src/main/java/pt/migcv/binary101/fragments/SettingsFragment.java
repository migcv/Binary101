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
    Switch binarySpacingSwitch;
    Switch decimalSpacingSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        systemKeyboardSwitch = (Switch) view.findViewById(R.id.systemKeyboardSwitch);
        binarySpacingSwitch = (Switch) view.findViewById(R.id.binarySpacingSwitch);
        decimalSpacingSwitch = (Switch) view.findViewById(R.id.decimalSpacingSwitch);

        systemKeyboardSwitch.setChecked(Settings.isSystemKeyboardOn());
        binarySpacingSwitch.setChecked(Settings.isBinarySpacing());
        decimalSpacingSwitch.setChecked(Settings.isDecimalSpacing());

        systemKeyboardSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.setSystemKeyboard((boolean) systemKeyboardSwitch.isChecked());
            }
        });

        binarySpacingSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.setBinarySpacing((boolean) binarySpacingSwitch.isChecked());
            }
        });

        decimalSpacingSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.setDecimalSpacing((boolean) decimalSpacingSwitch.isChecked());
            }
        });

        return view;
    }
}
