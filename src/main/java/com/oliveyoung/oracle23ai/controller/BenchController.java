package com.oliveyoung.oracle23ai.controller;

import com.oliveyoung.oracle23ai.service.BenchService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bench")
public class BenchController {

    private final BenchService svc;

    public BenchController(BenchService svc) { this.svc = svc; }

    /** 예: GET /bench/insert/100000 */
    @GetMapping("/insert/{rows}")
    public Mono<String> insert(@PathVariable int rows) {
        long start = System.nanoTime();
        return svc.insertRows(rows)
                .map(inserted -> {
                    double secs = (System.nanoTime() - start) / 1_000_000_000.0;
                    return "Inserted %d rows in %.2f sec".formatted(inserted, secs);
                });
    }

    /** GET /bench/count → 총 행 수 반환 */
    @GetMapping("/count")
    public Mono<Long> count() {
        return svc.countRows();
    }
}
