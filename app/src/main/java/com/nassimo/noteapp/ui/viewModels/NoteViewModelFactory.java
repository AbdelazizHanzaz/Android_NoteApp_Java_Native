package com.nassimo.noteapp.ui.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NoteViewModelFactory implements ViewModelProvider.Factory {

    private final Application app;

    public NoteViewModelFactory(Application app) {
        this.app = app;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NoteViewModel.class)) {
            return (T) new NoteViewModel(app);
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
