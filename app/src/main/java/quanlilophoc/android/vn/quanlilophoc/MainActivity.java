package quanlilophoc.android.vn.quanlilophoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import quanlilophoc.android.vn.quanlilophoc.Adapter.AdapterHocSinh;
import quanlilophoc.android.vn.quanlilophoc.Adapter.DBHelper;

public class MainActivity extends AppCompatActivity {
    private StudentModify studentModify;

    ListView lv_hocsinh;
    ArrayList<Student> arrayListStudent;
    AdapterHocSinh adapterHocSinh;
    private DBHelper db;

    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentModify = new StudentModify(this);
        addControls();
        readData();
    }

    public void addControls() {
        lv_hocsinh = (ListView) findViewById(R.id.lv_hocsinh);
        arrayListStudent = new ArrayList<>();
        adapterHocSinh = new AdapterHocSinh(MainActivity.this, R.layout.hocsinh_row, arrayListStudent);
        lv_hocsinh.setAdapter(adapterHocSinh);
    }

    private void readData() {
        studentModify=new StudentModify(this);
        List<Student> students = (List<Student>) studentModify.getAllStudent();
        for (Student hs : students) {
            arrayListStudent.add(hs);

        }
        adapterHocSinh = new AdapterHocSinh(this, R.layout.hocsinh_row, arrayListStudent);
        lv_hocsinh.setAdapter(adapterHocSinh);
        adapterHocSinh.notifyDataSetChanged();

    }

    public void onClick() {
        lv_hocsinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
//                i.putExtra("position", position);
//                i.putExtra("title", notesArrayList.get(position).getmTile());
//                i.putExtra("description", notesArrayList.get(position).getmDescription());
//                i.putExtra("time", notesArrayList.get(position).getmTime());
                startActivity(i);
            }
        });
    }
}
