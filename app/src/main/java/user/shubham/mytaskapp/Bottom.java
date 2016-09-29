package user.shubham.mytaskapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class Bottom extends Fragment {

GridView gridView;
    Button button;
    String stuff;
    private String[] names={"Food","Movie","Travel","Gift","Home Rent","Others"};
    private Integer[] pics={R.drawable.food,R.drawable.movie,R.drawable.travel,R.drawable.gift,R.drawable.home,R.drawable.others};
    public Bottom() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_bottom, container, false);
         gridView= (GridView) v.findViewById(R.id.gridView);
        button= (Button) v.findViewById(R.id.share);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"I just split "+stuff+" bill using my task app");
                startActivity(Intent.createChooser(shareIntent, "Share Via"));

            }
        });
        gridView.setAdapter(new CustomAdapter(getContext()));
        gridView.setNumColumns(3);
        return v;
    }


    private class CustomAdapter extends BaseAdapter {
        private Context mContext;

        public CustomAdapter(Context c) {
            mContext = c;
        }
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return pics[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View grid;
            if (convertView==null) {
                grid=new View(mContext);
                LayoutInflater inflater=getActivity().getLayoutInflater();
                grid=inflater.inflate(R.layout.myitems,parent,false);
            }
            else {
                grid=convertView;
            }
            ImageView imageView= (ImageView) grid.findViewById(R.id.imageView);
            TextView textView= (TextView) grid.findViewById(R.id.textView4);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                v.setBackgroundColor(getResources().getColor(R.color.greyish));
                    stuff=names[position];
                }
            });
            textView.setText(names[position]);
            imageView.setImageResource(pics[position]);
return  grid;
        }
    }


}
