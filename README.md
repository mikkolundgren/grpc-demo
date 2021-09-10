
## Build docker images
- install Docker
- run ``docker build -t rpc-service -f grpc/Dockerfile``
- run ``docker build -t api-service -f api/Dockerfile``

rpc-service runs on port 8885 and api-service on port 8880

## Run with Kubernetes
- install minikube
### create kubernetes cluster
- run ``minikube start``
- run ``kubectl version``
### create deployment
- ``kubectl apply -f deployment.yaml``
- ``kubectl describe deployment kube-demo``




