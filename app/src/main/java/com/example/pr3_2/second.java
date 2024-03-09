package com.example.pr3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class second extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = (TextView) getView().findViewById(R.id.textView2);
        Bundle arguments = getArguments();

        getParentFragmentManager().setFragmentResultListener("requestKey",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey,
                                                 @NonNull Bundle bundle) {
                        String result = bundle.getString("cityKey");
                        String city = result;
                        textView.setText(city);
                    }
                }
        );

        Button button = (Button) getView().findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    Bundle result = new Bundle();
                    result.putString("accepted", "Country accepted!");
                    getChildFragmentManager().setFragmentResult("bundleKey", result);
                }
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}