package com.belajar.colalin.homeView.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.belajar.colalin.R;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.homeView.Models.ListCounter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelData extends ViewModel {
    private final MutableLiveData< ArrayList< ListCounter > > data;

    public ViewModelData() {
        this.data = new MutableLiveData<>();
    }

    public void setModelData(String id) {
        Call< ArrayList< ListCounter > > listCall =
                ApiClient.getService().getList(Integer.parseInt(id));
        listCall.enqueue(new Callback< ArrayList< ListCounter > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< ListCounter > > call,
                                   @NonNull Response< ArrayList< ListCounter > > response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().size() != 0) {
                        ArrayList< ListCounter > md = response.body();
                        for (ListCounter modelData : md) {
                            if (modelData.getTypeJalan().equals("One Way")) {
                                modelData.setImageResource(R.drawable.one_way);
                            } else if (modelData.getTypeJalan().equals("Two Way")) {
                                modelData.setImageResource(R.drawable.motorway);
                            } else {
                                modelData.setImageResource(R.drawable.road);
                            }
                        }
                        data.postValue(md);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call< ArrayList< ListCounter > > call,
                                  @NonNull Throwable t) {

            }
        });
    }

    public LiveData< ArrayList< ListCounter > > getModelData() {
        return this.data;
    }
}
