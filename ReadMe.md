 # Steps to Run From Docker Image
mvn clean package    
docker build -f docker/Dockerfile -t viveknegi1997/keyvalue:latest .
docker push viveknegi1997/keyvalue:latest
docker run -it -p8080:8080 viveknegi1997/keyvalue:latest


# kubernetes helm deployment
helm install keyvalue --namespace keyvalue .

# port forward to hit api ( localhost )
kubectl -n keyvalue port-forward service/keyvaluestore 8080:8080

# get
curl http://localhost:8080/get/abc


# set key
curl -d '{"key":"abc-1","value":"abc"}' -H 'Content-Type: application/json' http://localhost:8080/set

# search
curl -X GET "http://localhost:8080/search?prefix=a"
