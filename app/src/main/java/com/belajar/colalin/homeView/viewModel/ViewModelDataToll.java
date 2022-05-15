package com.belajar.colalin.homeView.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.homeView.Models.ListCounter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelDataToll extends ViewModel {
    private MutableLiveData< ArrayList< ListCounter > > listCounters;
    public ViewModelDataToll(){
        listCounters = new MutableLiveData<>();
    }
    public void setData(int id, int counter){
        Call< ArrayList< ListCounter >> listCall = ApiClient.getService().getDetail(id, counter);
        listCall.enqueue(new Callback< ArrayList< ListCounter > >() {
            @Override
            public void onResponse(@NonNull Call< ArrayList< ListCounter > > call,
                                   @NonNull Response< ArrayList< ListCounter > > response) {
                if (response.isSuccessful()){
                    listCounters.setValue(response.body());
                }
            }
            @Override
            public void onFailure(@NonNull Call< ArrayList< ListCounter > > call,
                                  @NonNull Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ListCounter>> getData(){
        return this.listCounters;
    }
}
