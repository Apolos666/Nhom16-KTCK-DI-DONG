package com.example.ktckdidongnhom16.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.ktckdidongnhom16.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktckdidongnhom16.models.ThongTinCN;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TTCaNhanAdapter extends RecyclerView.Adapter<TTCaNhanAdapter.ThanhVienViewHolder> {

    private List<ThongTinCN> thanhVienList;
    private OnItemClickListener listener;


    public TTCaNhanAdapter(List<ThongTinCN> thanhVienList, OnItemClickListener listener) {
        this.thanhVienList = thanhVienList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ThanhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ttcanhan, parent, false);
        return new ThanhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhVienViewHolder holder, int position) {
        ThongTinCN thanhVien = thanhVienList.get(position);
        if (thanhVien == null) return;

        holder.tvTenThanhVien.setText(thanhVien.getTen());
        holder.tvMaSV.setText("MSSV: " + thanhVien.getMssv());
        holder.tvLopHP.setText("Lớp: " + thanhVien.getLop());
        holder.imgAvatar.setImageResource(thanhVien.getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return thanhVienList.size();
    }

    public static class ThanhVienViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenThanhVien, tvMaSV, tvLopHP;
        private CircleImageView imgAvatar;

        public ThanhVienViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenThanhVien = itemView.findViewById(R.id.tvTenThanhVien);
            tvMaSV = itemView.findViewById(R.id.tvMaSV);
            tvLopHP = itemView.findViewById(R.id.tvLopHP);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
        }
    }

    public interface OnItemClickListener {
    }
}

