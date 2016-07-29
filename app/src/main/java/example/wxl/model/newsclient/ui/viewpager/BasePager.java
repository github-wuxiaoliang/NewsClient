package example.wxl.model.newsclient.ui.viewpager;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import example.wxl.model.newsclient.R;

/**
 * Created on 2016/7/28.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class BasePager {
    public static final String TAG = "BasePager";

    public Activity mActivity;
    public FrameLayout mFrameLayout;
    public View mRootView;

    public BasePager(Activity activity) {
        this.mActivity = activity;
        initView();
    }

    public View initView() {
        mRootView = View.inflate(mActivity, R.layout.basepager_layout, null);
        mFrameLayout = (FrameLayout) mRootView.findViewById(R.id.fl_content);
        return mRootView;
    }
    public void initData(){}

}
