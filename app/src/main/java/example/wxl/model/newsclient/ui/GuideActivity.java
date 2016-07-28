package example.wxl.model.newsclient.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.wxl.model.newsclient.R;
import example.wxl.model.newsclient.utils.PrefUtils;

public class GuideActivity extends AppCompatActivity {
    private static final String TAG = "GuideActivity";
    @BindView(R.id.iv_ViewPager)
    ViewPager mViewPager;

    @BindView(R.id.ll_container)
    LinearLayout ll_container;

    @BindView(R.id.iv_selected)
    ImageView iv_selected;

    @BindView(R.id.bt_enter)
    Button bt_enter;

    private int[] mImageRes = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    ArrayList<ImageView> mImageList = new ArrayList<>();
    private int mDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        for (int i = 0; i < mImageRes.length; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setBackgroundResource(mImageRes[i]);
            mImageList.add(imageView);

            //添加灰色小圆点
            ImageView ivCircle = new ImageView(getApplicationContext());
            ivCircle.setImageResource(R.drawable.circle_gray);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                layoutParams.leftMargin = 10;//px
                ivCircle.setLayoutParams(layoutParams);
            }
            ll_container.addView(ivCircle);
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int v = (int) (mDistance * positionOffset + position * mDistance);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_selected.getLayoutParams();
                params.leftMargin = v;
                iv_selected.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == mImageRes.length - 1) {
                    bt_enter.setVisibility(View.VISIBLE);
                } else {
                    bt_enter.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        iv_selected.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
//                这儿与下面直接获得的是一样的
//                int distance = ll_container.getChildAt(1).getLeft() - ll_container.getChildAt(0).getLeft();
                mDistance = ll_container.getChildAt(1).getLeft();
//                Log.i(TAG, "onGlobalLayout: distance" + distance + "left" + left);
                //手动移除监听，否则会一直回调
                iv_selected.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        mViewPager.setAdapter(new GuideAdapter());
    }

    @OnClick(R.id.bt_enter)
    public void enterHome(View view) {
        PrefUtils.putBoolean("isGuideShowd",true,this);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageRes.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = mImageList.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
