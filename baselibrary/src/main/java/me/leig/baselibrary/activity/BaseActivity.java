package me.leig.baselibrary.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import me.leig.baselibrary.config.Constant;
import me.leig.baselibrary.connector.BaseConnector;
import me.leig.baselibrary.fragment.BaseFragment;
import me.leig.baselibrary.util.LogTool;

/**
 * @author leig
 * @version 20180301
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseConnector {

    protected LogTool log = new LogTool(getClassTag());

    // 视图存储对象
    protected SparseArray<View> mViews = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
        initView();
        initEvent();
    }

    protected abstract int getLayoutId();

    public void initData() {
        log.i("初始化数据...");
    }

    public void initView() {
        log.i("初始化视图...");
    }

    public void initEvent() {
        log.i("初始化事件...");
    }

    /**
     * 添加Fragment
     *
     * @param fragmentId
     * @param baseFragment
     */
    protected void addFragment(int fragmentId, BaseFragment baseFragment) {
        Bundle bundle = baseFragment.getArguments();
        if (null == bundle) {
            bundle = new Bundle();
        }
        bundle.putInt(Constant.FRAGMENT_ID, fragmentId);
        baseFragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(fragmentId, baseFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public View getView(int viewId) {
        View view = mViews.get(viewId);
        if (null == view) {
            view = findViewById(viewId);
            if (null == view) {
                log.e("视图不存在");
                return null;
            }
            mViews.put(viewId, view);
        }
        return view;
    }

}
