package quanlilophoc.android.vn.quanlilophoc.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import quanlilophoc.android.vn.quanlilophoc.Student;
import quanlilophoc.android.vn.quanlilophoc.R;

/**
 * Created by MyPC on 23/06/2017.
 */

public class AdapterHocSinh extends ArrayAdapter<Student> {
    Context context;
    int mylayout;
    ArrayList<Student> arrayListStudent;


    public AdapterHocSinh(Context context, int mylayout, ArrayList<Student> arrayListStudent) {
        super(context, mylayout, arrayListStudent);
        this.context = context;
        this.arrayListStudent = arrayListStudent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.hocsinh_row, parent, false);
            holder = new ViewHoder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_number = (TextView) convertView.findViewById(R.id.tv_number);
            holder.iv_avatar = (ImageView) convertView.findViewById(R.id.iv_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHoder) convertView.getTag();
        }
        Student student = arrayListStudent.get(position);
        holder.tv_name.setText(student.getName());
        holder.tv_number.setText(String.valueOf(student.getNumber()));

        byte[] outImage = student.getImage();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        holder.iv_avatar.setImageBitmap(theImage);
        return convertView;
    }

    static class ViewHoder {
        ImageView iv_avatar;
        TextView tv_number, tv_name;
    }
}


