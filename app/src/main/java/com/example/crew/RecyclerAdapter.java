package com.example.crew;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Crew> localDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView agency;
        private final TextView wiki;
        private final TextView status;
        private final ImageView image;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            name = (TextView) view.findViewById(R.id.CrewName);
            agency = (TextView) view.findViewById(R.id.CrewAgency);
            wiki = (TextView) view.findViewById(R.id.CrewWiki);
            wiki.setClickable(true);
            wiki.setMovementMethod(LinkMovementMethod.getInstance());
            status = (TextView) view.findViewById(R.id.CrewStatus);
            image = (ImageView) view.findViewById(R.id.CrewImage);
        }

    }

    public RecyclerAdapter( ArrayList<Crew> itemList) {
        localDataSet = itemList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        viewHolder.name.setText(localDataSet.get(position).CrewName);
        viewHolder.agency.setText(localDataSet.get(position).CrewAgency);
        viewHolder.wiki.setText(Html.fromHtml(localDataSet.get(position).CrewWiki));
        viewHolder.status.setText(localDataSet.get(position).CrewActive);
        Picasso.get().load(localDataSet.get(position).CrewImage).into(viewHolder.image);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
