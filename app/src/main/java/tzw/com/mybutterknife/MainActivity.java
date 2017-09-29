package tzw.com.mybutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";
    @BindView(R.id.text1)
    TextView myTextViewOne;
    @BindView(R.id.text2)
    TextView myTextViewTwo;
    @BindView(R.id.mybutton)
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this) ;
        Log.i(TAG,"自定义黄油刀"+myTextViewOne.getText().toString()+"\n"+"自定义黄油刀"+myTextViewTwo.getText().toString());
    }

    @OnClick(R.id.mybutton)
    private void onClick(){
        Toast.makeText(this,"按钮被点击了",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"按钮被点击了");
    }

}
