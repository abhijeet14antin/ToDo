package abhijeet.com.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jitish on 15-06-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<TODO> data;

    public MyAdapter(List<TODO> data) {
        this.data = data;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        CheckBox ch;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.todoName);
            ch = (CheckBox)itemView.findViewById(R.id.isComplete);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemrow = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemno, parent, false);
        return new MyViewHolder(itemrow);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        TODO temp = data.get(position);
        holder.name.setText(temp.name);
        holder.ch.setChecked(temp.isComplete);
        holder.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.get(position).isComplete = !data.get(position).isComplete;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}

