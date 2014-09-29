package twork.edu.testtworkgui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class home extends Activity {


    ListView listView;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new FeedAdapter(this));

        home = (ImageButton)findViewById(R.id.toHome);




    }

    public void goToUserPage(View v){
        Intent i = new Intent(this,userpage.class);
        startActivity(i);

    }
    class FeedItem
    {
        String name;
        String timestap;
        int image;


        FeedItem(String name, String timestamp, int image){
            this.name = name;
            this.timestap = timestamp;
            this.image = image;
        }


    }

    class FeedAdapter extends BaseAdapter {


        ArrayList<FeedItem> list;
        Context context;
        FeedAdapter(Context c){

            list = new ArrayList<FeedItem>();
            context = c;
            Resources res = context.getResources();
            String[] names = res.getStringArray(R.array.names);
            String[] timestamp = res.getStringArray(R.array.timestamps);
            int[] images = {R.drawable.food, R.drawable.warn};

            for(int i=0; i<5;i++ ){

                    if(i%2==0) {
                        list.add(new FeedItem(names[i], timestamp[i], images[0]));
                    }else{
                        list.add(new FeedItem(names[i], timestamp[i], images[1]));
                    }
            }
        }



        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View feed = inflater.inflate(R.layout.feed_item,viewGroup,false);


            TextView name = (TextView) feed.findViewById(R.id.name);
            TextView timestamp = (TextView) feed.findViewById(R.id.timestamp);
            ImageView not = (ImageView) feed.findViewById(R.id.not);

            FeedItem temp = list.get(i);

            name.setText(temp.name);
            timestamp.setText(temp.timestap);
            not.setImageResource(temp.image);
            return feed;
        }
    }
}
