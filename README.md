## Docker operation

docker build -t zengemily79/bookstore .
docker image rm -f zengemily79/bookstore

docker push zengemily79/bookstore:1.0.0
docker run -p 8082:8082 zengemily79/bookstore

http://localhost:8082/books

docker exec -t -i [container ID] sh


/logs/logs # cat access_log.2020-06-07.log 
172.17.0.1 - - [07/Jun/2020:06:06:49 +0000] "GET /books1 HTTP/1.1" 404 286
172.17.0.1 - - [07/Jun/2020:06:06:59 +0000] "GET /books HTTP/1.1" 200 120

It contains two types of log
* /logs/logs/application.log
* Container Log

ELK <br/>
https://juejin.im/post/5d2738a2f265da1bac404299 <br/>
https://github.com/macrozheng/mall-tiny <br/>
https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html <br/>
https://segmentfault.com/a/1190000020616778 <br/>

ECS by Terraform <br/>
https://medium.com/avmconsulting-blog/how-to-deploy-a-dockerised-node-js-application-on-aws-ecs-with-terraform-3e6bceb48785

**ECR** <br/>
[gettingStarted](https://docs.aws.amazon.com/zh_cn/AmazonECR/latest/userguide/getting-started-cli.html)
* Login
  * Way 1
    * aws ecr get-login
    * docker login –u AWS –p password –e none https://tomniu13.dkr.ecr.ap-southeast-2.amazonaws.com
  * Way 2 (do it in one command) <br/>
aws ecr get-login-password | docker login -u AWS --password-stdin "https://$(aws sts get-caller-identity --query 'Account' --output text).dkr.ecr.ap-southeast-2.amazonaws.com"

* Create repository in ECR and copy the link <br/>
004468876800.dkr.ecr.ap-southeast-2.amazonaws.com/book_store
docker tag zengemily79/bookstore:latest 004468876800.dkr.ecr.ap-southeast-2.amazonaws.com/book_store:latest
* Push <br/>
docker push 004468876800.dkr.ecr.ap-southeast-2.amazonaws.com/book_store:latest
