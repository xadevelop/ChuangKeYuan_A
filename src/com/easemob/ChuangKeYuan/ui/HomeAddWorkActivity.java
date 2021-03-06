package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：傅博龍  时间： 2016/5/25.
 */
public class HomeAddWorkActivity extends Activity{

    RelativeLayout rl_class_item;
    TextView tv_class_item;
    ListView lv_class_item;

    List data_list;

    SimpleAdapter sim_adapter;

    TextView mDes;
    TextView mBack;
    TextView mMore;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.gv_1, R.drawable.gv_2,
            R.drawable.gv_3, R.drawable.gv_4};
    //文字封装为一个数组
    private String[] text = { "我的任务单","班级小创客","家庭工作坊","创客工作室"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_class_item);

        initView();

        event();
    }

    private void event() {

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        Map<String, Object> map = new HashMap<String, Object>();
        for(int i=0;i<icon.length;i++){
            map.put("image", icon[i]);
            map.put("text", text[i]);
            data_list.add(map);
        }
        //新建适配器
        sim_adapter = new SimpleAdapter(HomeAddWorkActivity.this,
                data_list, R.layout.activity_parents_listview,
                new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
        //配置适配器
        lv_class_item.setAdapter(sim_adapter);
    }

    private void initView() {

        rl_class_item = (RelativeLayout) findViewById(R.id.rl_class_item);

        tv_class_item = (TextView) findViewById(R.id.tv_class_item);

        lv_class_item = (ListView) findViewById(R.id.lv_class_item);

        mDes = (TextView) findViewById(R.id.tv_teach_title);
        mBack = (TextView) findViewById(R.id.tv_teach_back);
        mMore = (TextView) findViewById(R.id.tv_teach_more);
    }




}
