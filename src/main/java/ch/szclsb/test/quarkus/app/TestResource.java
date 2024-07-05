package ch.szclsb.test.quarkus.app;

import ch.szclsb.test.quarkus.gen.api.TestApi;
import ch.szclsb.test.quarkus.gen.dto.TestReadDto;
import ch.szclsb.test.quarkus.gen.dto.TestWriteDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.UriBuilder;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

public class TestResource implements TestApi {
    @Inject
    protected TestService testService;

    @Override
    public RestResponse<TestReadDto> findTests(Long testId) {
        var test = testService.findById(testId).orElseThrow(() ->
                new NotFoundException("Test %d not found".formatted(testId)));
        return RestResponse.ok(test);
    }

    @Override
    public RestResponse<List<TestReadDto>> listAllTests() {
        return RestResponse.ok(testService.findAll());
    }

    @Override
    public RestResponse<Void> createTest(TestWriteDto testWriteDto) {
        var id = testService.create(testWriteDto.getText());
        return RestResponse.created(UriBuilder.fromResource(TestApi.class)
                .path(TestApi.class, "findTests")
                .build(id));
    }
}
