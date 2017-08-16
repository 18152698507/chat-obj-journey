package com.example.administrator.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    private LinearLayout recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initMsgs();
        inputText = (EditText) findViewById(R.id.edit_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        recycler = (LinearLayout) findViewById(R.id.recycler2);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                    android.view.ViewGroup.LayoutParams lp =recycler.getLayoutParams();
                    lp.height=1600;
                }
            }
        });
        inputText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                android.view.ViewGroup.LayoutParams lp =recycler.getLayoutParams();
                lp.height=800;
            }
        });
        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!"".equals(s.toString())) {
                    send.setClickable(true);//按钮可点击
                    send.setBackgroundResource(R.drawable.btn_bg_fouce);//颜色变亮，提示用户能够点按
                } else {
                    send.setClickable(false);//按钮不可点击
                    send.setBackgroundResource(R.drawable.btn_bg_normal1);//颜色变暗<span style="font-family: Arial, Helvetica, sans-serif;">，提示用户能够点按</span>
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    android.view.ViewGroup.LayoutParams lp =recycler.getLayoutParams();
                    lp.height=800;
                }else {
                    android.view.ViewGroup.LayoutParams lp =recycler.getLayoutParams();
                    lp.height=1600;
                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1 = new Msg("周二斌",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("花花",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("周二斌",Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }
}
