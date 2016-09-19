package me.ghui.animatevactordrawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private AnimatedVectorDrawable mAnimatedVectorDrawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//1
	public void onDoneClicked(View view) {
		start(view);
	}

	//2
	public void onFaceClicked(View view) {
		start(view);
	}

	//3
	public void onClockClicked(View view) {
		start(view);
	}

	//4
	public void onCupClicked(View view) {
		start(view);
	}

	//5
	public void onCircleClicked(View view) {
		start(view);
//		repeat(view);
	}

	//6
	public void onPointClicked(View view) {
		start(view);
//		repeat(view);
	}

	private void start(View view) {
		ImageView imageView = (ImageView) view;
		Animatable animatable = (Animatable) imageView.getDrawable();
		if (animatable.isRunning()) {
			animatable.stop();
		}
		animatable.start();
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void repeat(View view) {
		final ImageView imageView = (ImageView) view;
		mAnimatedVectorDrawable = (AnimatedVectorDrawable) imageView.getDrawable();
		mAnimatedVectorDrawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
			@Override
			public void onAnimationEnd(Drawable drawable) {
				imageView.post(new Runnable() {
					@Override
					public void run() {
						if (mAnimatedVectorDrawable.isRunning()) {
							mAnimatedVectorDrawable.stop();
						}
						mAnimatedVectorDrawable.start();
					}
				});
			}
		});
	}

}
