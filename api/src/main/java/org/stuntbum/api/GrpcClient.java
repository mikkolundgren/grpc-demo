package org.stuntbum.api;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;
import org.stuntbum.grpc.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class GrpcClient {

    ManagedChannel channel;
    public GrpcClient() {
        this.channel = ManagedChannelBuilder.forAddress("localhost", 8885)
                .usePlaintext()
                .build();
    }

    public List<VinylDO> doQuery(String query) {
        VinylServiceGrpc.VinylServiceBlockingStub stub = VinylServiceGrpc.newBlockingStub(channel);
        QueryResponse queryResponse = stub.query(QueryRequest.newBuilder().setQuery(query).build());
        List<VinylDO> result = new ArrayList<>();
        for (Vinyl v : queryResponse.getVinylsList()) {
            result.add(convertToDO(v));
        }
        return result;
    }

    private VinylDO convertToDO(Vinyl in) {
        return new VinylDO(in.getAlbum(), in.getArtist(), in.getYear());
    }

}
