package com.shine.sun.babygrowdiary.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shine.sun.babygrowdiary.R;
import com.shine.sun.babygrowdiary.base.BaseFragment;

/**
 * Created by Steven on 2016/11/11 0011.
 */

public class FragmentContent extends BaseFragment {
    public static BaseFragment getInstance(Bundle bundle) {
        BaseFragment fragment = new FragmentContent();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_id);
        textView.setText(getArguments().getString("title"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragmnet_layout;
    }
}
