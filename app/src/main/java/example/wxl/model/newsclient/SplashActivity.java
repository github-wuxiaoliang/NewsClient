package example.wxl.model.newsclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.wxl.model.newsclient.ui.GuideActivity;
import example.wxl.model.newsclient.ui.MainActivity;
import example.wxl.model.newsclient.utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.iv_horse)
    ImageView iv_horse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);//动画结束保持结束状态

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);

        //渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(rotateAnimation);
        set.addAnimation(alphaAnimation);
        set.addAnimation(scaleAnimation);

        iv_horse.startAnimation(set);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boolean isGuideShowd = PrefUtils.getBoolean("isGuideShowd", false, getApplication());
                if (!isGuideShowd) {
                    Intent intent = new Intent(getApplicationContext(), GuideActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //进入主界面
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
