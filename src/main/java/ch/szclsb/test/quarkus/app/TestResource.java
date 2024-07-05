package ch.szclsb.test.quarkus.app;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class TestResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TestDto test() {
        return new TestDto("test from quarkus");
    }
}
