package com.syh.diablo.appframe.net;

import android.app.Activity;
import android.util.Log;

import com.syh.diablo.appframe.CommonDialogUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by yonghe.shen on 2017/11/27.
 */

public abstract class MySubscriber<T> extends DisposableObserver<T> {

    private static final String TAG = "MySubscriber";
    private Activity activity;
    private CommonDialogUtils dialogUtils;

    public MySubscriber(Activity activity, boolean isShowLoading) {
        this.activity = activity;
        dialogUtils = new CommonDialogUtils();
        if (isShowLoading) {
            dialogUtils.showProgress(activity, "Loading...");
        }
    }

    public MySubscriber(){

    }

    private void dismissProgress() {
        if (dialogUtils != null) {
            dialogUtils.dismissProgress();
        }
    }

    @Override
    public final void onNext(T t) {
        dismissProgress();
        if (isDisposed()) {
            return;
        }
        try {
            onSuccess(t);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            onFail(e);
        } finally {
            try {
                dispose();
            } catch (Throwable e1) {
                Exceptions.throwIfFatal(e1);
                onFail(e1);
            }
        }
    }

    @Override
    public final void onError(Throwable e) {
        dismissProgress();
        if (isDisposed()) {
            return;
        }
        isDisposed();
        Log.e(TAG, "onError", e);
        onFail(e);
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);

    protected abstract void onFail(Throwable e);
}
