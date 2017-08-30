package app.com.recyclerviewexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.com.recyclerviewexample.R;

/**
 * Created by Geek on 8/25/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context context;
    private String[] animals;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context){
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.lay_animals, parent, false);
        return new MyViewHolder(view);
    }

    public void setData(String[] animals){
        this.animals=animals;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            if(animals!=null) {
                String animalsName = animals[position];
                holder.txtAnimalsName.setText(animalsName);
            }

    }

    @Override
    public int getItemCount() {
        return animals.length;
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtAnimalsName;


        public MyViewHolder(View itemView) {
            super(itemView);
            txtAnimalsName=(TextView)itemView.findViewById(R.id.tvAnimalsName);
        }
    }
}
