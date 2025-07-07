package com.oliveyoung.oracle23ai.service;

import com.oliveyoung.oracle23ai.entity.Sample;
import com.oliveyoung.oracle23ai.repo.SampleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BenchService {

    private final SampleRepository repo;

    public BenchService(SampleRepository repo) {
        this.repo = repo;
    }

    /** 지정한 개수만큼 'oliveyoung' 행 비동기 저장 */
    public Mono<Integer> insertRows(int rows) {
        Flux<Sample> flux = Flux.range(1, rows).map(i -> new Sample("oliveyoung"));
        return repo.saveAll(flux).count().map(Long::intValue);
    }

    public Mono<Long> countRows() {
        return repo.count();
    }
}
