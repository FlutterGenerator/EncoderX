package com.PuruliaCheatz.encoderx;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.PuruliaCheatz.encoderx.utils.*;

public class MainActivity extends Activity {

  // UI элементы
  private EditText editText1, editText2;
  private Spinner spinner;
  private ImageView imgCopy1, imgCopy2, imgPaste1, imgPaste2;
  private long firstBackTime;

  // Список доступных кодировок
  private final String[] encodings = {
    "Text <-> ASCII",
    "Text <-> Base16",
    "Text <-> Base32",
    "Text <-> Base64",
    "Text <-> Binary",
    "Text <-> Hex",
    "Text <-> Lowercase",
    "Text <-> MD5",
    "Text <-> MegatronFog",
    "Text <-> Morse Code",
    "Text <-> Octal",
    "Text <-> Reverse",
    "Text <-> ROT 13",
    "Text <-> SHA-1",
    "Text <-> SHA-256",
    "Text <-> SHA-384",
    "Text <-> SHA-512",
    "Text <-> Subscript",
    "Text <-> Superscript",
    "Text <-> Unicode",
    "Text <-> Uppercase",
    "Text <-> Url",
    "Text <-> Wingding",
    "Text <-> Zalgo"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    initViews();
    setupSpinner();
    setupListeners();
  }

  private void initViews() {
    // Инициализация всех UI элементов с правильными ID из XML
    editText1 = findViewById(R.id.editText1);
    editText2 = findViewById(R.id.editText2);
    spinner = findViewById(R.id.spinner1); // Изменено на spinner1

    imgCopy1 = findViewById(R.id.ImgCopy1); // Изменено на ImgCopy1
    imgCopy2 = findViewById(R.id.ImgCopy2); // Изменено на ImgCopy2
    imgPaste1 = findViewById(R.id.imgPaste1); // Обратите внимание на несоответствие в XML
    imgPaste2 = findViewById(R.id.ImgPaste2); // Изменено на ImgPaste2
  }

  private void setupSpinner() {
    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, encodings);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }

  private void setupListeners() {
    // Слушатели для кнопок копирования/вставки
    imgCopy1.setOnClickListener(v -> copyToClipboard(editText1.getText().toString()));
    imgCopy2.setOnClickListener(v -> copyToClipboard(editText2.getText().toString()));
    imgPaste1.setOnClickListener(v -> pasteFromClipboard(editText1));
    imgPaste2.setOnClickListener(v -> pasteFromClipboard(editText2));

    // Слушатель для выбора кодировки
    spinner.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            convert();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });

    // Слушатели изменения текста
    editText1.addTextChangedListener(new SimpleTextWatcher(editText1));
    editText2.addTextChangedListener(new SimpleTextWatcher(editText2));
  }

  private class SimpleTextWatcher implements TextWatcher {
    private final EditText editText;

    SimpleTextWatcher(EditText editText) {
      this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
      if (editText.isFocused()) {
        convert();
      }
    }
  }

  private void convert() {
    String input = editText1.getText().toString();
    String output = editText2.getText().toString();
    int encoding = spinner.getSelectedItemPosition();

    try {
      if (editText2.isFocused()) {
        String decoded = decode(output, encoding);
        if (!decoded.equals(editText1.getText().toString())) {
          editText1.setText(decoded);
        }
      } else {
        String encoded = encode(input, encoding);
        if (!encoded.equals(editText2.getText().toString())) {
          editText2.setText(encoded);
        }
      }
    } catch (Exception e) {
      Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
      Log.e("EncoderX", "Conversion error", e);
    }
  }

  // Методы кодирования
  private String encode(String input, int encoding) {
    switch (encoding) {
      case 0:
        return Ascii.encode(input);
      case 1:
        return Base16.encode(input);
      case 2:
        return Base32.encode(input);
      case 3:
        return Base64.encode(input);
      case 4:
        return Binary.encode(input);
      case 5:
        return Hex.encode(input);
      case 6:
        return Lowercase.encode(input);
      case 7:
        return Md5.encode(input);
      case 8:
        return MegatronFog.encode(input);
      case 9:
        return MorseCode.encode(input);
      case 10:
        return Octal.encode(input);
      case 11:
        return Reverse.encode(input);
      case 12:
        return Rot13.encode(input);
      case 13:
        return Sha1.encode(input);
      case 14:
        return Sha256.encode(input);
      case 15:
        return Sha384.encode(input);
      case 16:
        return Sha512.encode(input);
      case 17:
        return Subscript.encode(input);
      case 18:
        return Superscript.encode(input);
      case 19:
        return Unicode.encode(input);
      case 20:
        return Uppercase.encode(input);
      case 21:
        return Url.encode(input);
      case 22:
        return Wingding.encode(input);
      case 23:
        return ZalgoString.encode(input);
      default:
        return input;
    }
  }

  // Методы декодирования
  private String decode(String input, int encoding) {
    switch (encoding) {
      case 0:
        return Ascii.decode(input);
      case 1:
        return Base16.decode(input);
      case 2:
        return Base32.decode(input);
      case 3:
        return Base64.decode(input);
      case 4:
        return Binary.decode(input);
      case 5:
        return Hex.decode(input);
      case 6:
        return Lowercase.decode(input);
      case 7:
        return Md5.decode(input);
      case 8:
        return MegatronFog.decode(input);
      case 9:
        return MorseCode.decode(input);
      case 10:
        return Octal.decode(input);
      case 11:
        return Reverse.decode(input);
      case 12:
        return Rot13.decode(input);
      case 13:
        return Sha1.decode(input);
      case 14:
        return Sha256.decode(input);
      case 15:
        return Sha384.decode(input);
      case 16:
        return Sha512.decode(input);
      case 17:
        return Subscript.decode(input);
      case 18:
        return Superscript.decode(input);
      case 19:
        return Unicode.decode(input);
      case 20:
        return Uppercase.decode(input);
      case 21:
        return Url.decode(input);
      case 22:
        return Wingding.decode(input);
      case 23:
        return ZalgoString.decode(input);
      default:
        return input;
    }
  }

  // Работа с буфером обмена
  private void copyToClipboard(String text) {
    if (text == null || text.isEmpty()) {
      Toast.makeText(this, "Nothing to copy", Toast.LENGTH_SHORT).show();
      return;
    }

    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    if (clipboard != null) {
      clipboard.setPrimaryClip(ClipData.newPlainText("Encoded text", text));
      Toast.makeText(this, "Copied to clipboard!", Toast.LENGTH_SHORT).show();
    }
  }

  private void pasteFromClipboard(EditText editText) {
    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    if (clipboard == null || !clipboard.hasPrimaryClip()) {
      return;
    }

    ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
    CharSequence pasteData = item.coerceToText(this);
    if (pasteData != null) {
      editText.setText(pasteData);
    }
  }

  // Меню приложения
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 0, 0, "About");
    menu.add(0, 1, 1, "Exit");
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case 0:
        startActivity(new Intent(this, AboutActivity.class));
        return true;
      case 1:
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  // Обработка кнопки "Назад"
  @Override
  public void onBackPressed() {
    if (System.currentTimeMillis() - firstBackTime <= 2000) {
      super.onBackPressed();
    } else {
      firstBackTime = System.currentTimeMillis();
      Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
    }
  }
}
