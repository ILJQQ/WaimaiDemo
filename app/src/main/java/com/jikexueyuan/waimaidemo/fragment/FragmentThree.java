package com.jikexueyuan.waimaidemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jikexueyuan.waimaidemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huyiqing on 2016/12/21.
 */

public class FragmentThree extends Fragment {

    private View viewSetUp;
    private ListView lvTableOne,lvTableTwo,lvTableThree;
    private List<Map<String,Object>> table_one_list,table_two_list,table_three_list;
    private SimpleAdapter table_one_adapter,table_two_adapter,table_three_adapter;

    private String[] tableOneFrom = {"tableOneIcon","tableOneText"};
    private int[] tableOneTo = {R.id.ivItemIcon,R.id.tvSetTitle};

    private String[] tableTwoFrom = {"tableTwoIcon","tableTwoText"};
    private int[] tableTwoTo = {R.id.ivItemIcon,R.id.tvSetTitle};

    private String[] tableThreeFrom = {"tableThreeIcon","tableThreeText"};
    private int[] tableThreeTo = {R.id.ivItemIcon,R.id.tvSetTitle};

    //    tableOne
    private int[] tableOneIcon = {R.drawable.location_icon,R.drawable.coupon,R.drawable.refund};
    private String[] tableOneText = {"我的送餐地址","我的代金券","我的退款"};
    //    tableTwo
    private int[] tableTwoIcon = {R.drawable.messages,R.drawable.list,R.drawable.mypage_list_icon_comment};
    private String[] tableTwoText = {"我的消息","我的收藏","我的评论"};
    //    tableThree
    private int[] tableThreeIcon = {R.drawable.mypage_list_icon_wallet,R.drawable.icon_nuomi};
    private String[] tableThreeText = {"百度钱包","百度糯米"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewSetUp = inflater.inflate(R.layout.page_setup,null);
        initView();
        displayUI();
        return viewSetUp;
    }

    private void displayUI() {
        //        table_one
        table_one_list = new ArrayList<Map<String,Object>>();
        setTableOne();
        table_one_adapter = new SimpleAdapter(getActivity(),table_one_list,R.layout.set_item,tableOneFrom,tableOneTo);
        lvTableOne.setAdapter(table_one_adapter);
//        table_two
        table_two_list = new ArrayList<Map<String,Object>>();
        setTableTwo();
        table_two_adapter = new SimpleAdapter(getActivity(),table_two_list,R.layout.set_item,tableTwoFrom,tableTwoTo);
        lvTableTwo.setAdapter(table_two_adapter);
//        table_three
        table_three_list = new ArrayList<Map<String,Object>>();
        setTableThree();
        table_three_adapter = new SimpleAdapter(getActivity(),table_three_list,R.layout.set_item,tableThreeFrom,tableThreeTo);
        lvTableThree.setAdapter(table_three_adapter);
    }

    private void initView() {
        lvTableOne = (ListView) viewSetUp.findViewById(R.id.lvTableOne);
        //        tableTwo
        lvTableTwo = (ListView) viewSetUp.findViewById(R.id.lvTableTwo);
        //        tableThree
        lvTableThree = (ListView) viewSetUp.findViewById(R.id.lvTableThree);
    }

    public List<Map<String,Object>> setTableOne(){
        for (int i = 0; i < tableOneIcon.length; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("tableOneIcon",tableOneIcon[i]);
            map.put("tableOneText",tableOneText[i]);
            table_one_list.add(map);
        }
        return table_one_list;
    }

    public List<Map<String,Object>> setTableTwo(){
        for (int i = 0; i < tableTwoIcon.length; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("tableTwoIcon",tableTwoIcon[i]);
            map.put("tableTwoText",tableTwoText[i]);
            table_two_list.add(map);
        }
        return table_two_list;
    }

    public List<Map<String,Object>> setTableThree(){
        for (int i = 0; i < tableThreeIcon.length; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("tableThreeIcon",tableThreeIcon[i]);
            map.put("tableThreeText",tableThreeText[i]);
            table_three_list.add(map);
        }
        return table_three_list;
    }
}
