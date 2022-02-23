package noor.serry.note;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

    List<TableNotes> arrayList;
RecyclerListener recyclerListener;
public CustomAdapter(List<TableNotes> arrayList, RecyclerListener recyclerListener){
        this.arrayList=arrayList;
        this.recyclerListener = recyclerListener;
}

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.recycler_layout,null,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
    String text = arrayList.get(position).getNote ();
    holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    protected class Holder extends RecyclerView.ViewHolder{
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.noteView);
            itemView.setOnClickListener(this::onItemClick);
            }

public void onItemClick(View view){
  recyclerListener.onItemClickListener(textView.getText().toString());
}
    }

}
