package br.com.josef.desafiowebservicemarvel.repository;


import br.com.josef.desafiowebservicemarvel.model.pojos.ComicsResponse;
import io.reactivex.Observable;

import static br.com.josef.desafiowebservicemarvel.data.remote.RetrofitService.getApiService;

public class ComicsRepository {


    public Observable<ComicsResponse> getComics(String format, String formatType,
                                                boolean noVariants, String orderBy, String ts,
                                                String hash, String apikey) {
        return getApiService().getComics(format, formatType, noVariants, orderBy, ts, hash, apikey);

    }


}
