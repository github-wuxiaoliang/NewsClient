package example.wxl.model.newsclient.ui.fragment;

import android.view.View;

import example.wxl.model.newsclient.R;

/**
 * Created on 2016/7/28.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class LeftFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.main_left, null);
        return view;
    }
}
