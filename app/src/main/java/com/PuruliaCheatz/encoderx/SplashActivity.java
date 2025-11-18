package com.PuruliaCheatz.encoderx;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashActivity extends Activity {

  private ImageView imageView;
  private RelativeLayout linear1;
  private LinearLayout linear2;
  private TextView textView1;
  private TextView textView2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    initializeViews();
    setupSplashAnimation();
    scheduleMainActivityTransition();
  }

  /* ---------- init ---------- */

  private void initializeViews() {
    imageView = findViewById(R.id.imageview1);
    linear1 = findViewById(R.id.linear1);
    linear2 = findViewById(R.id.linear2);
    textView1 = findViewById(R.id.textview1);
    textView2 = findViewById(R.id.textview2);

    applyRoundedCornersToImage();
  }

  private void applyRoundedCornersToImage() {
    Drawable d = imageView.getDrawable();
    if (d == null) return;

    Bitmap bmp = drawableToBitmap(d);
    if (bmp == null) return;

    // переводим 20dp в px
    int radiusPx =
        (int)
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());

    imageView.setImageBitmap(getRoundedCornerBitmap(bmp, radiusPx));
  }

  /* ---------- анимация ---------- */

  private void setupSplashAnimation() {
    // логотип: от 0 до 1 по alpha
    imageView.setAlpha(0f);
    animateView(imageView, "alpha", 1f, 1000);

    // текст: сначала ниже на 100px, затем к 0
    textView1.setTranslationY(100f);
    textView2.setTranslationY(100f);

    animateView(textView1, "translationY", 0f, 1000);
    animateView(textView2, "translationY", 0f, 1000);
  }

  /* ---------- переход в MainActivity ---------- */

  private void scheduleMainActivityTransition() {
    new Handler(Looper.getMainLooper())
        .postDelayed(
            () -> {
              startActivity(new Intent(SplashActivity.this, MainActivity.class));
              finish();
              overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            },
            2000); // 2 секунды
  }

  /* ---------- утилиты ---------- */

  private static Bitmap drawableToBitmap(Drawable drawable) {
    if (drawable instanceof BitmapDrawable) {
      return ((BitmapDrawable) drawable).getBitmap();
    }
    Bitmap bitmap =
        Bitmap.createBitmap(
            drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
    drawable.draw(canvas);
    return bitmap;
  }

  public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int radius) {
    Bitmap output =
        Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(output);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    RectF rectF = new RectF(rect);

    paint.setColor(0xFF424242); // любой «заливочный» цвет
    canvas.drawRoundRect(rectF, radius, radius, paint);

    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawBitmap(bitmap, rect, rect, paint);

    return output;
  }

  private void animateView(View view, String property, float value, long duration) {
    ObjectAnimator.ofFloat(view, property, value).setDuration(duration).start();
  }
}
