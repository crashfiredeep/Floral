package com.theabsolutecompany.floral.styles;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.theabsolutecompany.floral.R;

public class Cards extends Style {

    public static int getValue(Context context) {
        return context.getResources().getInteger(R.integer.STYLE_CARDS_VALUE);
    }

    @Override
    public int getViewHolderLayoutRes() {
        return R.layout.album_cover_card;
    }

    @Override
    public boolean columnCountIncreasesInLandscape() {
        return true;
    }

    @Override
    String getColumnCountPrefKey(Context context) {
        return context.getString(R.string.STYLE_CARDS_COLUMN_COUNT_PREF_KEY);
    }

    @Override
    int getDefaultColumnCount() {
        return 2;
    }

    @Override
    int getGridSpacingRes() {
        return R.dimen.cards_style_grid_spacing;
    }

    @Override
    public View createPrefDialogView(@NonNull ViewGroup container) {
        View view = inflatePrefDialogItemView(container);

        Context context = container.getContext();

        TextView name = view.findViewById(R.id.name);
        name.setText(context.getString(R.string.STYLE_CARDS_NAME));

        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.style_cards);
        imageView.setColorFilter(getAccentColor(context));

        setColumnCountButtonsClickListener(view);

        return view;
    }
}
