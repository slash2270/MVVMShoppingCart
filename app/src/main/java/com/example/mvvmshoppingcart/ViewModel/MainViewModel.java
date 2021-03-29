package com.example.mvvmshoppingcart.ViewModel;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvvmshoppingcart.Model.DataModel;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import static android.content.Context.MODE_PRIVATE;

public class MainViewModel extends ViewModel{

    public final ObservableField<String> modelData = new ObservableField<>();

    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final DataModel dataModel = new DataModel();

    private SharedPreferences.Editor spEditor;

    private SharedPreferences sP;

    private final Context context;

    private int countNum = 0;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void ibPlus(){

        isLoading.set(true);

        dataModel.retrieveData(new DataModel.onDataReadyCallBack() {

            @Override
            public void onDataReady(Integer data) {

                sP = context.getSharedPreferences("countNum", MODE_PRIVATE);

                spEditor = sP.edit();

                countNum = sP.getInt("countNum", 0);

                data = countNum + 1;

                spEditor.putInt("countNum", data).apply();

                modelData.set(String.valueOf(data));

                isLoading.set(false);

            }
        });
    }

    public void ibMinus(){

        isLoading.set(true);

        dataModel.retrieveData(new DataModel.onDataReadyCallBack(){

            @Override
            public void onDataReady(Integer data) {

                sP = context.getSharedPreferences("countNum", MODE_PRIVATE);

                spEditor = sP.edit();

                countNum = sP.getInt("countNum", 0);

                if(countNum > 0){

                    data = countNum - 1;

                }else{

                    data = 0;

                }

                spEditor.putInt("countNum", data).apply();

                modelData.set(String.valueOf(data));

                isLoading.set(false);

            }
        });
    }
}
