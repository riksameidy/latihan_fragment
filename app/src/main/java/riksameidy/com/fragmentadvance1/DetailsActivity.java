package riksameidy.com.fragmentadvance1;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by ASUS on 25/05/2016.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;

        }

        if(savedInstanceState==null){

            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(android.R.id.content,
                    detailsFragment).commit();


        }

    }
}
