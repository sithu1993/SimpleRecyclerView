package app.com.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import app.com.recyclerviewexample.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private String[] animals=new String[]{"Cat","Dog","Cow","Bear","Chimpanzee",
                                        "Duck","Camel","Deer","Common Buzzard",
                                        "Cuttlefish","Gopher","Gorilla","Jellyfish"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        setUpRecyclerView();
    }

    /**
    *    set up recycler view adapter
    * */
    private void setUpRecyclerView(){
        recyclerViewAdapter=new RecyclerViewAdapter(this);
       //Create layout manager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //Default orientation is vertical. So , if you want to do orientation is VERTICAL , you don't need to set. :)
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //set up linear layout to recycler view
        recyclerView.setLayoutManager(linearLayoutManager);
       //set up recycle view adapter
        recyclerView.setAdapter(recyclerViewAdapter);
        //for performance you should add this method
        recyclerView.setHasFixedSize(true);
        //set recycler view data that is you want to show data in recycler view
        recyclerViewAdapter.setData(animals);
        //Notify to recycler view that is I already  add data and need to refresh the view
        recyclerViewAdapter.notifyDataSetChanged();
        //create item line separator
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        //add line separator in to recycler view
        recyclerView.addItemDecoration(dividerItemDecoration);



    }


}
