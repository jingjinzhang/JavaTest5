## login
curl -H "Content-Type: application/json" -X POST  --data '{"name":"AUSTIN","password":"CINTRON"}' http://192.168.99.100:8080/user/login
echo "----------------------------------------------------"

## listFilm
curl -d "page=1&pageSize=2&sort='ASC'" --request GET http://192.168.99.100:8080/user/
echo "----------------------------------------------------"

## create
curl -H "Content-Type: application/json" -X PUT  --data '{"firstName":"zhang","lastName":"san","email":"634029602@qq.com","address":"47 MySakila Drive"}' http://192.168.99.100:8080/user/
echo "----------------------------------------------------"

## update
curl -H "Content-Type: application/json" -X PUT  --data '{"firstName":"zhang","lastName":"san","email":"634029602@qq.com","address":"47 MySakila Drive"}' http://192.168.99.100:8080/user/600
echo "----------------------------------------------------"

## delete
curl -b "id=600" -X DELETE  http://192.168.99.100:8080/user/