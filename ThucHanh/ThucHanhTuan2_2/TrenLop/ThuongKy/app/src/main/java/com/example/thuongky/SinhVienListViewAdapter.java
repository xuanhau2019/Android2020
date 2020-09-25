package com.example.thuongky;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVienListViewAdapter extends BaseAdapter {

    ArrayList<SinhVien> listProduct;

    public SinhVienListViewAdapter(ArrayList<SinhVien> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int i) {
        return listProduct.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listProduct.get(i).getProductID();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;

        SinhVien product = (SinhVien) getItem(i);
        ((TextView) viewProduct.findViewById(R.id.id)).setText(String.format("ID = %d", product.getProductID()));
        ((TextView) viewProduct.findViewById(R.id.name)).setText(String.format("TÃªn SP : %s", product.getTen()));
        ((TextView) viewProduct.findViewById(R.id.address)).setText(String.format("GiÃ¡ %d", product.getDiachi());
        ((TextView) viewProduct.findViewById(R.id.sdt)).setText(String.format("GiÃ¡ %d", product.getSdt());

        return viewProduct;
    }
}
