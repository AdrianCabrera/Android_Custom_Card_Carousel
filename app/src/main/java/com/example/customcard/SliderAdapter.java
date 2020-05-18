package com.example.customcard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{
    public SliderAdapter(List<SliderItem> sliderItems, RecyclerView recyclerView) {
        this.sliderItems = sliderItems;
        this.recyclerView = recyclerView;
    }

    private List<SliderItem> sliderItems;
    private RecyclerView recyclerView;

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slider_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder sliderViewHolder, int i) {
        sliderViewHolder.setCardView(sliderItems.get(i));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{

        private TriangleShapeView cardView;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
        }

        void setCardView(SliderItem sliderItem){
            cardView.currentCard = sliderItem.getCurrentCard();
        }
    }

}
