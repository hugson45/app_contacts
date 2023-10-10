package com.example.appbar2.ui.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appbar2.databinding.FragmentMobileBinding;
import com.example.appbar2.databinding.FragmentSlideshowBinding;

public class MobileFragment extends Fragment {

    private FragmentMobileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MobileViewModel slideshowViewModel =
                new ViewModelProvider(this).get(MobileViewModel.class);

        binding = FragmentMobileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMobile;
        final ImageView videomobile = binding.videomobile;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}