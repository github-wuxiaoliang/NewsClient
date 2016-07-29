package example.wxl.model.newsclient.customui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created on 2016/7/29.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //父类做很多处理，包括VIewPager的滑动机制，我们这儿注释掉，去掉ViewPager的滑动效果
//        return super.onTouchEvent(ev);
        return true;
    }
}
