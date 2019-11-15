package br.com.josef.desafiowebservicemarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.security.PublicKey;
import java.util.List;

import br.com.josef.desafiowebservicemarvel.model.pojos.Result;
import br.com.josef.desafiowebservicemarvel.repository.ComicsRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.josef.desafiowebservicemarvel.data.remote.RetrofitService.getApiService;
import static br.com.josef.desafiowebservicemarvel.util.AppUtils.md5;

public class ComicsViewModel extends AndroidViewModel {

    private ComicsRepository repository = new ComicsRepository();
    private MutableLiveData<List<Result>> listaComics = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    // Parâmetros necessários para requisição da API MARVEL
    // Chave pública que será usada como como parâmetro
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    // Chave privada que será usada como como parâmetro
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";

    // Timestamp do horário da requisição
    String ts = Long.toString(System.currentTimeMillis() / 1000);
    // Hash cria com as chaves pública e privada e o timestamp
    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public ComicsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaComics() {
        return this.listaComics;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    public void getAllComics() {
        // Adicionamos a chamada ao disposable para podermos eliminar o na destruição
// do viewmodel, isso é necessário para evitarmos consumo excessivo de recursos do
// dispositivo Android

        disposable.add(
                repository.getComics("magazine", "comics", true, "focDate", ts, hash, PUBLIC_KEY)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((Disposable disposable) -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(data  ->  listaComics.setValue(data.getData().getResults()),
                         throwable -> {
                            Log.i("LOG", "GetAllComics" + throwable.getMessage());

                        })

        );

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }


}
