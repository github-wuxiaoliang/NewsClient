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
public class SettingPager extends BasePager{
    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG, "initData: setting pager 初始化");
        TextView view = new TextView(mActivity);
        view.setText("设置");
        view.setTextSize(20);
        view.setGravity(Gravity.CENTER);
        mFrameLayout.addView(view);
    }
}
