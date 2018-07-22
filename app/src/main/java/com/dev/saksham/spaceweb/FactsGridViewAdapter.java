package com.dev.saksham.spaceweb;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FactsGridViewAdapter extends ArrayAdapter<FactsItem> {
	Context context;
	int layoutResourceId;
	ArrayList<FactsItem> data = new ArrayList<FactsItem>();

	public FactsGridViewAdapter(Context context, int layoutResourceId,
								ArrayList<FactsItem> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new RecordHolder();
			holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
			holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}

		FactsItem item = data.get(position);
		holder.txtTitle.setText(item.getTitle());
		holder.imageItem.setImageBitmap(item.getImage());
		return row;

	}

	static class RecordHolder {
		TextView txtTitle;
		ImageView imageItem;

	}
}