package com.belajar.colalin.homeView.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.belajar.colalin.apiService.ApiClient;
import com.belajar.colalin.homeView.Models.ModelData;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelData extends ViewModel {
    private MutableLiveData< ArrayList< ModelData > >data;

    public ViewModelData() {
        this.data = new MutableLiveData<>();
    }
    public void setMovieData(String id){
        Call<ArrayList<ModelData>> listCall = ApiClient.getService().showData(Integer.parseInt(id));
        listCall.enqueue(new Callback< ArrayList< ModelData > >() {
            @Override
            public void onResponse(Call< ArrayList< ModelData > > call,
                                   Response< ArrayList< ModelData > > response) {
                if (response.isSuccessful() && response.body().size() != 0){
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call< ArrayList< ModelData > > call,
                                  Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ModelData>> getModelData(){
        return this.data;
    }
}
