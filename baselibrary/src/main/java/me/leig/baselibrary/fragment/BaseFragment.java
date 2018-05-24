package me.leig.baselibrary.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import me.leig.baselibrary.connector.BaseConnector;
import me.leig.baselibrary.config.Constant;
import me.leig.baselibrary.util.LogTool;

/**
 * @author leig
 * @version 20180301
 */
public abstract class BaseFragment extends Fragment implements View.OnTouchListener, BaseConnector {

    protected LogTool log = new LogTool(getClassTag());

    private View mView;

    // 视图存储对象
    protected SparseArray<View> mViews = new SparseArray<>();

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getFragmentId(), container, false);
        initData();
        initView();
        initEvent();
        return mView;
    }

    protected abstract int getFragmentId();

    public void initData() {
        log.i("初始化数据...");
    }

    public void initView() {
        log.i("初始化视图...");
    }

    public void initEvent() {
        log.i("初始化事件...");
    }

    protected void goToFragment(BaseFragment baseFragment) {
        int fragmentId = getArguments().getInt(Constant.FRAGMENT_ID);
        Bundle bundle = baseFragment.getArguments();
        if (null == bundle) {
            bundle = new Bundle();
        }
        bundle.putInt(Constant.FRAGMENT_ID, fragmentId);
        baseFragment.setArguments(bundle);
        FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
        ft.add(fragmentId, baseFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public View getView(int viewId) {
        View view = mViews.get(viewId);
        if (null == view) {
            view = mView.findViewById(viewId);
            if (null == view) {
                log.e("视图不存在");
                return null;
            }
            mViews.put(viewId, view);
        }
        return view;
    }
}
