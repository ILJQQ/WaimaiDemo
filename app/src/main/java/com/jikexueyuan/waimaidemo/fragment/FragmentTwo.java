package com.jikexueyuan.waimaidemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jikexueyuan.waimaidemo.MainActivity;
import com.jikexueyuan.waimaidemo.R;

/**
 * Created by huyiqing on 2016/12/21.
 */

public class FragmentTwo extends Fragment {
    private View viewOrder;
    private TextView tvLoginBtn;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        viewOrder = inflater.inflate(R.layout.page_order,null);
        initView();
        return viewOrder;
    }

    private void initView() {
        tvLoginBtn = (TextView) viewOrder.findViewById(R.id.tvLoginBtn);
        tvLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "欢迎登陆", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
