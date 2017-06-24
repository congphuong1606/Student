package quanlilophoc.android.vn.quanlilophoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView iv_imagedetail;
    private TextView tv_name, tv_number, tv_address;
    private Button bt_edit, bt_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        isConTrols();
    }

    public void isConTrols() {
        //iv_imagedetail = (ImageView) findViewById(R.id.iv_image);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_address = (TextView) findViewById(R.id.tv_address);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_edit = (Button) findViewById(R.id.bt_edit);

    }
}
