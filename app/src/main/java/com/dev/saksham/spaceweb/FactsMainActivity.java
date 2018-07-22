package com.dev.saksham.spaceweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class FactsMainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<FactsItem> gridArray = new ArrayList<FactsItem>();
    FactsGridViewAdapter customGridAdapter;
    @Override protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState); setContentView(R.layout.facts_main_layout);
    //set grid view item
        Integer[] mThumbIds = {
                R.drawable.sun,R.drawable.moon, R.drawable.mercury,
                R.drawable.venus,R.drawable.earth,
                R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,
                R.drawable.saturn,R.drawable.neptune,R.drawable.asteroid,R.drawable.meteorite
        };
        String[] title={
                "Sun","Moon","Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Asteroid","Meteroite"
        };

        Bitmap userIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.sun);
        for(int i=0;i<12;i++) {
            Bitmap homeIcon = BitmapFactory.decodeResource(this.getResources(),mThumbIds[i]);
            gridArray.add(new FactsItem(homeIcon, title[i]));
        }
        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new FactsGridViewAdapter(this, R.layout.facts_custom_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new OnItemClickListener()
        { @Override public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
        {
          //  Toast.makeText(getApplicationContext(),gridArray.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), FactsDetailsActivity.class);

            // Pass image index
            i.putExtra("id", position);
            startActivity(i);
        } });


    }
}
