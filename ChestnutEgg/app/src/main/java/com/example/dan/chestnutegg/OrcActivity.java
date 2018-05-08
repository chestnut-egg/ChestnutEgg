package com.example.dan.chestnutegg;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.googlecode.tesseract.android.TessBaseAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OrcActivity extends AppCompatActivity {

    TextView orc_show;

    //调用系统相册-选择图片
    private static final int IMAGE = 1;
    String imagePath;
    Uri selectedImage;

    //识别语言英文
    static final String DEFAULT_LANGUAGE = "eng";
    //识别语言简体中文
    static final String CHINESE_LANGUAGE = "chi_sim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orc);

        orc_show = (TextView) findViewById(R.id.orc_show);

        if (ActivityCompat.checkSelfPermission(OrcActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(OrcActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        Button orc_doit = (Button) findViewById(R.id.orc_doit);

        orc_doit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                TessBaseAPI lvBaseAPI = null;
                try {
                    //String s = "/storage/emulated/0/Tencent/QQ_Images/4a29dbc045be531f.png";
                    //Bitmap lvBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.time);
                    //String s = "/storage/emulated/0/Tencent/QQ_Images/time.png";

                    Bitmap lvBitmap = null;

                    try
                    {
                        File file = new File(imagePath);
                        if(file.exists())
                        {
                            lvBitmap = BitmapFactory.decodeFile(imagePath);
                            Log.i("ocr", "找到文件了: ");
                        }
                    } catch (Exception e)
                    {
                        // TODO: handle exception
                        Log.e("ocr", "找不到文件 ");
                    }

                    // 核心预设置代码
                    lvBaseAPI = new TessBaseAPI();
                    String path = Environment.getExternalStorageDirectory().getPath();
                    lvBaseAPI.init(path +  "/tesseract/", CHINESE_LANGUAGE);

                    //img_ocr_source.setImageBitmap(lvBitmap);

                    lvBaseAPI.setPageSegMode(TessBaseAPI.PageSegMode.PSM_AUTO);
                    lvBaseAPI.setImage(lvBitmap);
                    //lvBaseAPI.setImage(getDiskBitmap(s));

                    // 获取并显示识别结果
                    String result = lvBaseAPI.getUTF8Text();
                    Log.i("orc", result);
                    orc_show.setText(result);
                } catch (Exception e) {
                    Log.e("OCR", e.getMessage());
                } finally {
                    lvBaseAPI.clear();
                    lvBaseAPI.end();
                }



            }

        });

    }




    public void onClick(View v) {
        //调用相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }

    //加载图片
    private void showImage(String imaePath){
        Log.i("image_url", imaePath);
        String s1 = getPath(selectedImage);
        Log.i("image_path", s1);

        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        ((ImageView)findViewById(R.id.image)).setImageBitmap(bm);
    }

    //uri -> path
    private String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


}
