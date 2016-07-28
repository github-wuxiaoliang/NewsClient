package example.wxl.model.newsclient.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import example.wxl.model.newsclient.R;
import example.wxl.model.newsclient.ui.fragment.ContentFragment;
import example.wxl.model.newsclient.ui.fragment.LeftFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content, new ContentFragment(), "tag_content");
        transaction.replace(R.id.left, new LeftFragment(), "tag_left");
        transaction.commit();
    }
}
