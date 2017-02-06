package com.jikexueyuan.waimaidemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jikexueyuan.waimaidemo.MainActivity;
import com.jikexueyuan.waimaidemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huyiqing on 2016/12/21.
 */

public class FragmentOne extends Fragment{
    private View viewMain;
    private GridView gvCategory;
    private ListView lvStore;
    private List<Map<String,Object>> data_list,store_list;
    private SimpleAdapter simpleAdapter,list_adapter;
    private String[] from = {"image", "text"};
    private int[] to ={R.id.ivImage, R.id.tvText};
    private String[] listFrom = {"storeImage","storeTitle","starImage1","starImage2","starImage3",
            "starImage4","starImage5","storeSold","storeLoc","storeSelling"};
    private int[] listTo = {R.id.ivStoreImage,R.id.tvStoreName,R.id.ivStarOne,R.id.ivStarTwo,R.id.ivStarThree,
            R.id.ivStarFour,R.id.ivStarFive,R.id.tvSold,R.id.tvLocation,R.id.tvSellDetail};
    private int[] icon = {R.drawable.eat,R.drawable.buy,R.drawable.fruit,R.drawable.tea,
            R.drawable.tuhao,R.drawable.newdian, R.drawable.deliver,R.drawable.medicine};
    private String[] iconName = {"餐饮","超市购","水果生鲜","下午茶","土豪特供","新店","百度配送","网上送药"};
    //    设置mainpage的listview数据
    private int[] storeImg = {R.drawable.shopone,R.drawable.shoptwo,R.drawable.shopthree,R.drawable.shopone};
    private int[] starImg1 = {R.drawable.red_star,R.drawable.red_star,R.drawable.red_star,R.drawable.red_star};
    private int[] starImg2 = {R.drawable.red_star,R.drawable.red_star,R.drawable.red_star,R.drawable.red_star};
    private int[] starImg3 = {R.drawable.red_star,R.drawable.red_star,R.drawable.red_star,R.drawable.red_star};
    private int[] starImg4 = {R.drawable.red_star,R.drawable.half_star,R.drawable.red_star,R.drawable.red_star};
    private int[] starImg5 = {R.drawable.half_star,R.drawable.white_star,R.drawable.white_star,R.drawable.half_star};
    private String[] storeName = {"重庆麻辣烫","一洋码头","真美丽鲜花店","好烫啊麻辣烫"};
    private String[] storeSold ={"已售566份","已售799份","已售1087份","已售1999份"};
    private String[] storeLocation = {"990m","1.3km","2.2km","3.0km"};
    private String[] sellDetail = {setDetail(30,5,45),setDetail(20,7,50),setDetail(35,6,38),setDetail(30,4,55)};

    //    return介绍
    private String setDetail(int startPrice, int sendPrice, int aveTime){
        String storePrice;
        storePrice = "起送￥" + startPrice + "|配送￥" + sendPrice + "|平均" + aveTime + "分钟";
        return storePrice;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewMain = inflater.inflate(R.layout.page_main,null);
        gvCategory = (GridView) viewMain.findViewById(R.id.gvCategory);
        lvStore = (ListView) viewMain.findViewById(R.id.lvStore);
        initData();
        registerClick();
        return viewMain;
    }

    private void registerClick() {
        //        为gridview添加item点击事件
        gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String section = "您选择了: " + iconName[position];
                Toast.makeText(getActivity(), section, Toast.LENGTH_SHORT).show();
            }
        });
        //        添加listview点击事件
        lvStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String store = "感谢您选择了店铺：" + storeName[position];
                Toast.makeText(getActivity(), store, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        data_list = new ArrayList<Map<String,Object>>();
//        配置list
        getData();
        simpleAdapter = new SimpleAdapter(getActivity(), data_list, R.layout.grid_item,from,to);
//        添加adapter
        gvCategory.setAdapter(simpleAdapter);

//        设置mainpage的listview
        store_list = new ArrayList<Map<String, Object>>();
        storeData();
        list_adapter = new SimpleAdapter(getActivity(),store_list,R.layout.list_item,listFrom,listTo);
        lvStore.setAdapter(list_adapter);

    }

    public List<Map<String,Object>> getData() {
        for (int i = 0; i < icon.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    public List<Map<String,Object>> storeData() {
        for (int i = 0; i < storeImg.length; i++){
            Map<String, Object> storeMap = new HashMap<String, Object>();
            storeMap.put("storeImage",storeImg[i]);
            storeMap.put("storeTitle",storeName[i]);
            storeMap.put("starImage1",starImg1[i]);
            storeMap.put("starImage2",starImg2[i]);
            storeMap.put("starImage3",starImg3[i]);
            storeMap.put("starImage4",starImg4[i]);
            storeMap.put("starImage5",starImg5[i]);
            storeMap.put("storeSold",storeSold[i]);
            storeMap.put("storeLoc",storeLocation[i]);
            storeMap.put("storeSelling",sellDetail[i]);
            store_list.add(storeMap);
        }
        return store_list;
    }
}
