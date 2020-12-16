package in.techrebounce.mvvmexample1.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import in.techrebounce.mvvmexample1.models.NicePlace;
import in.techrebounce.mvvmexample1.repositories.NicePlaceRepository;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNiceplaces;
    private NicePlaceRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if(mNiceplaces != null){
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNiceplaces = mRepo.getNiceplaces();
    }

    public void addNewValue(NicePlace nicePlace) {
        mIsUpdating.setValue(true);

        new AsyncTask<Void,Void,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNiceplaces.getValue();
                currentPlaces.add(nicePlace);
                mNiceplaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        return mNiceplaces;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}
