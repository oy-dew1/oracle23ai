package com.oliveyoung.oracle23ai.repo;

import com.oliveyoung.oracle23ai.entity.Sample;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SampleRepository extends ReactiveCrudRepository<Sample, Long> { }
