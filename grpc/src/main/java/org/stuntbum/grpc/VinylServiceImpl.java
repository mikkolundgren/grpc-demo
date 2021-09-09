package org.stuntbum.grpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VinylServiceImpl  extends VinylServiceGrpc.VinylServiceImplBase {

    VinylDO[] vinyls;

    public VinylServiceImpl() {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream("1000Albums.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            vinyls = objectMapper.readValue(in, VinylDO[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Got " + vinyls.length + " vinyls...");
    }

    @Override
    public void query(QueryRequest queryRequest, StreamObserver<QueryResponse> responseObserver) {

        String query = queryRequest.getQuery().toLowerCase();
        List<Vinyl> found = new ArrayList<>();
        for (VinylDO v : vinyls) {
            if (v.getArtist().toLowerCase().contains(query) || v.getAlbum().toLowerCase().contains(query) || v.getYear().equals(query)) {
                found.add(Vinyl.newBuilder().setAlbum(v.getAlbum()).setArtist(v.getArtist()).setYear(v.getYear()).build());
            }
        }
        QueryResponse response = QueryResponse.newBuilder()
                .addAllVinyls(found)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
