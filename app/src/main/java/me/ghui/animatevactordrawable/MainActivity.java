package me.ghui.animatevactordrawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private AnimatedVectorDrawable mAnimatedVectorDrawable;

	@TargetApi(Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onFaceClicked(View view) {
		start(view);
	}

	public void onClockClicked(View view) {
		start(view);
	}

	private void start(View view) {
		ImageView imageView = (ImageView) view;
		Animatable animatable = (Animatable) imageView.getDrawable();
		if (animatable.isRunning()) {
			animatable.stop();
		}
		animatable.start();
	}
}
