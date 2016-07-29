package example.wxl.model.newsclient.ui.viewpager;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created on 2016/7/28.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class HomePager extends BasePager{
    private static final String TAG = "HomePager";
    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG, "initData: homepager 初始化");
        TextView view = new TextView(mActivity);
        view.setText("主页");
        view.setTextSize(20);
        view.setGravity(Gravity.CENTER);
        mFrameLayout.addView(view);
    }
}
