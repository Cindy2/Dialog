package com.example.admin.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(MenuItem menu){
        getMenuInflater().inflate(R.menu.main, (Menu) menu);
        return true;
    }
//确定取消对话框
    public void click1(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.alert_dark_frame);
        builder.setTitle("学会一个人独处才能进步");
        builder.setMessage("相信自己，你是可以的哦");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "感谢使用本软件,再见", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "若不好好努力，后悔的肯定是你自己", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertdialog =builder.create();
        alertdialog.show();
    }
//    单选对话框
    public void click2(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择性别");
        final String[] items = new String[]{
                "男",
                "女"
        };
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "您选择的是:"+items[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }
//    多选对话框
    public void click3(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择您认识的人");
        final String[] items = new String[]{
                "Cindy",
                "Tom",
                "Mindy",
                "Candy"
        };
        final boolean[] checkedItems = new boolean[]{
                true,
                true,
                false,
                false
        };
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                Toast.makeText(MainActivity.this, "您选择的是:"+checkedItems[which], Toast.LENGTH_SHORT).show();
                checkedItems[which] = isChecked;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text  = "";
                for (int i = 0; i<4;i++){
                    text += checkedItems[i]? items[i]+",":"";
                }
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public boolean onOptionsItemSelected(MenuItem item){
     switch (item.getItemId()){
         case R.id.add_item:
             Toast.makeText(this, "U clicked Add", Toast.LENGTH_SHORT).show();
             break;
         case R.id.remove_item:
             Toast.makeText(this, "U clicked Remove", Toast.LENGTH_SHORT).show();
             break;
         default:
     }
        return true;
    }
}
