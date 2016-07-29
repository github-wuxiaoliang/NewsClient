package example.wxl.model.newsclient.ui.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import example.wxl.model.newsclient.R;
import example.wxl.model.newsclient.ui.viewpager.BasePager;
import example.wxl.model.newsclient.ui.viewpager.GovAffairPager;
import example.wxl.model.newsclient.ui.viewpager.HomePager;
import example.wxl.model.newsclient.ui.viewpager.NewsPager;
import example.wxl.model.newsclient.ui.viewpager.SettingPager;
import example.wxl.model.newsclient.ui.viewpager.SmartServicePager;

/**
 * Created on 2016/7/28.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class ContentFragment extends BaseFragment {
    private static final String TAG = "ContentFragment";

    private ViewPager mViewPager;
    private ArrayList<BasePager> mPagerArrayList;

    @BindView(R.id.rg_group)
    RadioGroup rg_group;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.main_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_main);
        rg_group = (RadioGroup) view.findViewById(R.id.rg_group);
//        ButterKnife.bind(getActivity(),view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mPagerArrayList = new ArrayList<>();
        mPagerArrayList.add(new HomePager(getActivity()));
        mPagerArrayList.add(new NewsPager(getActivity()));
        mPagerArrayList.add(new SmartServicePager(getActivity()));
        mPagerArrayList.add(new GovAffairPager(getActivity()));
        mPagerArrayList.add(new SettingPager(getActivity()));

        mViewPager.setAdapter(new MainPagerAdapter());

        rg_group.setOnCheckedChangeListener(new MyOnCheckedChangerListener());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: "+position+"被选中");
                mPagerArrayList.get(position).initData();//在这儿初始化数据
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

//        mViewPager.setCurrentItem(0);//默认选中第一个
        mPagerArrayList.get(0).initData();//手动初始化第一个界面。
    }

    class MyOnCheckedChangerListener implements  RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    mViewPager.setCurrentItem(0,false);//false:取消滑动
                    break;
                case R.id.rb_news:
                    mViewPager.setCurrentItem(1,false);
                    break;
                case R.id.rb_smart:
                    mViewPager.setCurrentItem(2,false);
                    break;
                case R.id.rb_govaffairs:
                    mViewPager.setCurrentItem(3,false);
                    break;
                case R.id.rb_setting:
                    mViewPager.setCurrentItem(4,false);
                    break;
            }
        }
    }

    class MainPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagerArrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagerArrayList.get(position);
//            pager.initData();先不加载数据，这儿会预加载，默认会初始化下一个pager
            View view = pager.mRootView;
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
