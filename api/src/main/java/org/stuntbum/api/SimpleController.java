package org.stuntbum.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stuntbum.grpc.VinylDO;

import java.util.List;

@RestController
public class SimpleController {

    GrpcClient grpcClient;

    @Autowired
    public SimpleController(GrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping(path = "/api/hello")
    public String sayHello() {
        return new JSONObject().put("message", "hello").toString();
    }

    @GetMapping(path = "/api/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VinylDO> query(@RequestParam String query) {
        return grpcClient.doQuery(query);
    }

}
