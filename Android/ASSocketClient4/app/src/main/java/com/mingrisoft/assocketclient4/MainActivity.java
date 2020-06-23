package com.mingrisoft.assocketclient4;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    private EditText etname,etneirong;
    private TextView tvneirong;
    private InputStream inputStream;
    private OutputStream outputStream;
    private HandlerThread mHandlerThread;
    private Handler mSubThreadHandler;

    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            String neirong = bundle.getString("neirong");
            tvneirong.append(neirong + "\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText)findViewById(R.id.edit_name);
        etneirong = (EditText)findViewById(R.id.myinternet_tcpclient_EditText02);
        tvneirong = (TextView)findViewById(R.id.myinternet_tcpclient_EditText01);
        initHandlerThread();
    }



    public void lianjie(View view){
        new Thread(new Runnable() {
            public void run() {
                String ip = "127.0.0.1";
                int duankou = 7788;
                try {
                    Socket socket = new Socket(ip, duankou);
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();

                    byte[] jieshou = new byte[1024];
                    int len = -1;
                    while ((len = inputStream.read(jieshou)) != -1) {
                        String neirong = new String(jieshou, 0, len, "gbk");
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putString("neirong", neirong);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void fasong(View view){
        String name = etname.getText().toString();
        String neirong = etneirong.getText().toString();
        String all = name + ":" + neirong;
        tvneirong.append(all + "\n");
        etneirong.setText("");
        Message msg = new Message();
        msg.obj = all;
        mSubThreadHandler.sendMessage(msg);
    }
    private void initHandlerThread() {
        mHandlerThread = new HandlerThread("handler_thread");
        mHandlerThread.start();
        Looper loop = mHandlerThread.getLooper();
        mSubThreadHandler = new Handler(loop) {
            public void handleMessage(Message msg){
                writeMsg((String)msg.obj);
            }
        };
    }
    private void writeMsg(String msg){
        try{
            outputStream.write(msg.getBytes("gbk"));
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
