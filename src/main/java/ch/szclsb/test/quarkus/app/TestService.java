package ch.szclsb.test.quarkus.app;

import ch.szclsb.test.quarkus.gen.dto.TestReadDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class TestService {
    private final Map<Long, TestReadDto> cache;

    public TestService() {
        this.cache = Stream.of(
                TestReadDto.builder()
                        .id(1L)
                        .version(1)
                        .text("First")
                        .build(),
                TestReadDto.builder()
                        .id(2L)
                        .version(1)
                        .text("Second")
                        .build(),
                TestReadDto.builder()
                        .id(3L)
                        .version(1)
                        .text("Third")
                        .build()
        ).collect(Collectors.toMap(TestReadDto::getId, Function.identity()));
    }

    public Optional<TestReadDto> findById(Long id) {
        return Optional.ofNullable(cache.get(id));
    }

    public List<TestReadDto> findAll() {
        return cache.values().stream()
                .sorted(Comparator.comparing(TestReadDto::getId))
                .toList();
    }

    public long create(String text) {
        //todo persist
        return 0;
    }
}
