package example.wxl.model.newsclient.ui.viewpager;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created on 2016/7/28.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class GovAffairPager extends BasePager{
    public GovAffairPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        super.initData();
        TextView view = new TextView(mActivity);
        view.setText("政务");
        view.setTextSize(20);
        view.setGravity(Gravity.CENTER);
        mFrameLayout.addView(view);
    }
}
