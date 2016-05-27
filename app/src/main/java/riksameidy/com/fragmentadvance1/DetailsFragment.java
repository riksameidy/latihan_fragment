package riksameidy.com.fragmentadvance1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by ASUS on 25/05/2016.
 */
public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index){

        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();

        args.putInt("index",index);

        f.setArguments(args);

        return f;
    }

    public int getShowIndex(){
        return  getArguments().getInt("index",0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ScrollView scrollView =  new ScrollView(getActivity());

        TextView textView = new TextView(getActivity());

        int padding = (int)
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,
                        getActivity().getResources().getDisplayMetrics());

        textView.setPadding(padding,padding,padding,padding);

        scrollView.addView(textView);

        textView.setText(AnimeChara.HISTORY[getShowIndex()]);

        return scrollView;
    }
}
