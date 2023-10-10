package com.example.appbar2.ui.mobile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MobileViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MobileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Naprawa telefonu");

    }

    public LiveData<String> getText() {
        return mText;
    }
}