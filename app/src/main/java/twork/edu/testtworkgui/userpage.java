package twork.edu.testtworkgui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by hagakure on 2014-09-28.
 */
public class userpage extends Activity {


        ImageButton toFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.user_page);
            toFeed = (ImageButton)findViewById(R.id.toFeed);


            }

            public void goToFeed(View v){

                Intent i = new Intent(this,home.class);
                startActivity(i);
            }




}
