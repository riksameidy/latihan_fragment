package riksameidy.com.fragmentadvance1;


import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

/**
 * Created by ASUS on 24/05/2016.
 */
public class TitlesFragment extends ListFragment {

    boolean mDuelPane;
    int mCurrentPos = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArraytoListView = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,AnimeChara.CHARA_NAME
                );

        setListAdapter(connectArraytoListView);

        View detailsFrame = getActivity().findViewById(R.id.details);

        mDuelPane = detailsFrame!=null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState!=null){

            mCurrentPos = savedInstanceState.getInt("currentChoice",0);
        }

        if(mDuelPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurrentPos);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentChoice",mCurrentPos);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index){

        mCurrentPos = index;

        if(mDuelPane){

            getListView().setItemChecked(index,true);

            DetailsFragment detailsFragment = (DetailsFragment)
                    getFragmentManager().findFragmentById(R.id.details);

            if(detailsFragment==null||detailsFragment.getShowIndex()!=index){

                detailsFragment = DetailsFragment.newInstance(index);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.details,detailsFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();

            }
        }

        else{
            Intent intent = new Intent();

            intent.setClass(getActivity(),DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }

    }
}
