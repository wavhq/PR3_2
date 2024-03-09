package com.example.pr3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class first extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("bundleKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("accepted");
                TextView textView = (TextView) getView().findViewById(R.id.click);

            }
        });

        Button moscowButton = (Button) getView().findViewById(R.id.moscow);
        Button tbilisiButton = (Button) getView().findViewById(R.id.tbilisi);
        Button parisButton = (Button) getView().findViewById(R.id.paris);

        moscowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    Bundle result = new Bundle();
                    result.putString("cityKey", "Moscow");
                    getParentFragmentManager().setFragmentResult("cityKey", result);
                    getParentFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.detailFragment, second.class, result)
                            .commit();
                }
            }
        });

        tbilisiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    Bundle result = new Bundle();
                    result.putString("cityKey", "Tbilisi");
                    getParentFragmentManager().setFragmentResult("cityKey", result);
                }
            }
        });

        parisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    Bundle result = new Bundle();
                    result.putString("cityKey", "Paris");
                    getParentFragmentManager().setFragmentResult("cityKey", result);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


}