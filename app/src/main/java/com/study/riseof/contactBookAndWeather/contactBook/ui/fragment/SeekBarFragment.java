package com.study.riseof.contactBookAndWeather.contactBook.ui.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.study.riseof.contactBookAndWeather.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SeekBarFragment extends BaseFragment {

    private final float PADDING_PART_OF_FRAGMENT = 0.1f;

//    private View view;
//    private Unbinder unbinder;
    private SeekBarProgressListener seekBarListener;
    private int fragmentHeight;


    @BindView(R.id.window_height_seek_bar)
    SeekBar windowHeightBar;
/*
    // onAttach(Context) не вызовется до API 23 версии
    // вместо этого будет вызван onAttach(Activity), который устарел с 23 API
    // поэтому в каждом методе вызовем onAttachToContext(Context context)
    // в котором пропишем код при прикреплении к activity
    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity);
        }
    }

    protected void onAttachToContext(Context context) {
        try {
            seekBarListener = (SeekBarProgressListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement SeekBarProgressListener");
        }
    }*/

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_seek_bar;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  view = inflater.inflate(R.layout.fragment_seek_bar, container, false);
      //  unbinder = ButterKnife.bind(this, view);
        try {
            seekBarListener = (SeekBarProgressListener) getContext();
        } catch (ClassCastException e) {
            throw new ClassCastException(getContext().toString() + " must implement SeekBarProgressListener");
        }
        super.onCreateView(inflater, container, savedInstanceState);
        windowHeightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //   seekBarListener.changeSeekBarProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarListener.changeSeekBarProgress(seekBar.getProgress());
            }
        });
        view.post(new Runnable() {
            @Override
            public void run() {
                fragmentHeight = view.getHeight();
                ViewGroup.LayoutParams lp = windowHeightBar.getLayoutParams();
                lp.width = fragmentHeight; //public LayoutParams(int width, int height)
                windowHeightBar.setPadding((int) (fragmentHeight * PADDING_PART_OF_FRAGMENT), 0, (int) (fragmentHeight * PADDING_PART_OF_FRAGMENT), 0);
                seekBarListener.changeSeekBarProgress(windowHeightBar.getProgress());
            }
        });
        return view;
    }

/*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
*/

    public interface SeekBarProgressListener {
        void changeSeekBarProgress(int progress);
    }
}
