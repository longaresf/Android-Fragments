package com.crisspian.fragment_guide_01;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.crisspian.fragment_guide_01.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {

private FragmentBlankBinding mBinding;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     mBinding = FragmentBlankBinding.inflate((getLayoutInflater()));
     return  mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                int index = mBinding.radiogroup.indexOfChild(mBinding.radiogroup.findViewById(i));
                switch (index) {

                    case 0:
                        mBinding.TextviewRes.setText("Si Lo conozco");
                        break;

                    case 1:
                        mBinding.TextviewRes.setText("No Lo conozco");
                        break;
                    default:
                        break;
                }
            }
        });
    }
    }