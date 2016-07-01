package com.micutu.locatedriver.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.micutu.locatedriver.R;

public class LDPlaceAutocompleteFragment extends PlaceAutocompleteFragment {
    @Nullable
    private PlaceClearListener placeClearListener = null;

    public LDPlaceAutocompleteFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        final View view = super.onCreateView(var1, var2, var3);
        view.findViewById(R.id.place_autocomplete_clear_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText) view.findViewById(R.id.place_autocomplete_search_input)).setText("");
                v.setVisibility(View.GONE);

                if (LDPlaceAutocompleteFragment.this.placeClearListener != null) {
                    LDPlaceAutocompleteFragment.this.placeClearListener.cleared();
                }
            }
        });

        return view;
    }

    public void setEnabled(Boolean enabled) {
        this.getView().setAlpha((enabled) ? 1 : (float) 0.5);
        this.getView().findViewById(R.id.place_autocomplete_clear_button).setEnabled(enabled);
        this.getView().findViewById(R.id.place_autocomplete_search_input).setEnabled(enabled);
        this.getView().findViewById(R.id.place_autocomplete_search_button).setEnabled(enabled);
    }

    public void setOnPlaceClearListener(PlaceClearListener placeClearListener) {
        this.placeClearListener = placeClearListener;
    }

    public interface PlaceClearListener {
        public void cleared();
    }
}
