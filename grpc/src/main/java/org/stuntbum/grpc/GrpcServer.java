package org.stuntbum.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    public static void main(String[] args) throws Exception {



        Server server = ServerBuilder.forPort(8885).addService(new VinylServiceImpl()).build();
        server.start();
        server.awaitTermination();


    }
}
