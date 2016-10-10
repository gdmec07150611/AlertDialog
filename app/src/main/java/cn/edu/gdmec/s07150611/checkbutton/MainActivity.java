package cn.edu.gdmec.s07150611.checkbutton;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }
    public void dialog1() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    dialog.dismiss();
                   //AlertDialogDemo.this.finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        dialog.show();

    }

    /////////////////////2
    public void dialog2() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str="";
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "平时轻松";
                        break;
                    }
                tv.setText(str);
                }

        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listenter);
        dialog.show();

    }

    //////////////////3
    public void dialog3() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               tv.setText("输入的是:"+tEdit.getText().toString());
                }

        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.show();
    }

    ///////////////////4
    public void dialog4() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListenter);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.show();
    }

    ////////////////5
    public void dialog5() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }

        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListenter);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.show();
    }

    /////////////6
    public void dialog6() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              String str="你选择了："+item[which];
                tv.setText(str);
            }

        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sListenter);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        dialog.show();
    }

    //////////////////7
    public void dialog7() {
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText ed=new EditText(this);
        setContentView(ed);
        final EditText tEdit=(EditText)layout.findViewById(R.id.editText1);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        dialog.show();
    }
}
