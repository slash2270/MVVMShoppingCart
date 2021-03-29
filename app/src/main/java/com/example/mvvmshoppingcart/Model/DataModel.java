package com.example.mvvmshoppingcart.Model;

import android.os.Handler;

public class DataModel {

    public void retrieveData(final onDataReadyCallBack callback){

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                callback.onDataReady(0);

            }
        });

    }

    public interface onDataReadyCallBack{
        void onDataReady(Integer Data);
    }
}
