package com.example.ktckdidongnhom16.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktckdidongnhom16.R;
import com.example.ktckdidongnhom16.adapters.TTCaNhanAdapter;
import com.example.ktckdidongnhom16.models.ThongTinCN;

import java.util.ArrayList;
import java.util.List;

public class TTCaNhanActivity extends AppCompatActivity {
    private CardView cardView;
    private TextView hoTen;
    private TextView maSV;
    private TextView lop;
    private RecyclerView recyclerView;
    private TTCaNhanAdapter adapter;
    private List<ThongTinCN> thanhVienList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttcanhan);
        setupViews();
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        thanhVienList = new ArrayList<>();
        thanhVienList.add(new ThongTinCN("Phan Hồ Nhật Nam", "2215053122323", "124LTTD01", R.drawable.nam));
        thanhVienList.add(new ThongTinCN("Trần Đức Quang", "21115053120343", "124LTTD01", R.drawable.quang));
        thanhVienList.add(new ThongTinCN("Trần Võ Đình Hoàng", "22115053122211", "124LTTD01", R.drawable.hoang));

        adapter = new TTCaNhanAdapter(thanhVienList, null);
        recyclerView.setAdapter(adapter);

        ImageButton backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> showAddDialog());
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            showAddDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm thành viên");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_edit, null);
        builder.setView(view);

        EditText edtTen = view.findViewById(R.id.edtTen);
        EditText edtMSSV = view.findViewById(R.id.edtMSSV);
        EditText edtLop = view.findViewById(R.id.edtLop);

        builder.setPositiveButton("Thêm", (dialog, which) -> {
            String ten = edtTen.getText().toString();
            String mssv = edtMSSV.getText().toString();
            String lop = edtLop.getText().toString();

            if (ten.isEmpty() || mssv.isEmpty() || lop.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                adapter.notifyItemInserted(thanhVienList.size() - 1);
                Toast.makeText(this, "Thêm thành viên thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
}
