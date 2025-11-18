package com.PuruliaCheatz.encoderx;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.about);

    // Инициализация элементов интерфейса
    initUIElements();
  }

  private void initUIElements() {
    try {
      // Социальные кнопки
      initSocialButtons();

      // Секция ModderHub
      initModderHubSection();

      // Установка текста «info» (без номера версии)
      setAppVersion();
    } catch (Exception ignored) {
      // Ошибку можно обработать иначе или оставить пустой
    }
  }

  private void initSocialButtons() {
    ImageView imgTelegram = findViewById(R.id.imgTelegram);
    ImageView imgYoutube = findViewById(R.id.imgYoutube);
    ImageView imgGithub = findViewById(R.id.imgGithub);
    ImageView imgInstagram = findViewById(R.id.imgInstagram);
    ImageView imgFacebook = findViewById(R.id.imgFacebook);

    if (imgTelegram != null)
      imgTelegram.setOnClickListener(v -> openUrl("https://t.me/tojik_proof_93"));
    if (imgYoutube != null)
      imgYoutube.setOnClickListener(v -> openUrl("https://youtube.com/@saveeditoronlinecom"));
    if (imgGithub != null)
      imgGithub.setOnClickListener(v -> openUrl("https://github.com/FlutterGenerator/EncoderX"));
    if (imgInstagram != null)
      imgInstagram.setOnClickListener(v -> openUrl("https://instagram.com/tojik_proof_93"));
    if (imgFacebook != null)
      imgFacebook.setOnClickListener(v -> openUrl("https://facebook.com/khusen.dzhalolov"));
  }

  private void initModderHubSection() {
    LinearLayout gitModderhub = findViewById(R.id.git_modderhub);
    if (gitModderhub != null) {
      gitModderhub.setOnClickListener(
          v -> openUrl("https://github.com/developer-krushna/EncryptionDecryptionAlgorithms"));
    }
  }

  /** Показываем только строку "@string/info" без номера версии. */
  private void setAppVersion() {
    try {
      TextView infoText = findViewById(R.id.textview1);
      if (infoText != null) {
        infoText.setText(getString(R.string.info));
      }
    } catch (Exception ignored) {
      // Ошибку можно обработать иначе или оставить пустой
    }
  }

  private void openUrl(String url) {
    try {
      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
      startActivity(intent);
    } catch (Exception ignored) {
      // Ошибку можно обработать иначе или оставить пустой
    }
  }
}
