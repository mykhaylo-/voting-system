# voting-system

Here are shown base _curl_ commands which demonstrate how to use the voting-system API.

Creating new restaurant:
```
curl -H "Content-Type:application/json" -d '{"lunchMenu":{"dishes":[{"name":"Beer”,”price":33.6}]},"name":"Restaurant 1"}'  -v -u admin:pass http://localhost:8080/restaurants 
```
Retrieving all restaurants:
```
curl -v -u admin:pass http://localhost:8080/restaurants 
```

Updating menu:
```
curl -X PUT -H "Content-Type:application/json" -d '{"dishes":[{"name":"3 fishes","price":99.9},{"name":"potatoes","price":88.77}]}' -v -u admin:pass http://localhost:8080/restaurants/1/menu
```
Voting:
```
curl -X POST -v -u admin:pass http://localhost:8080/restaurants/3/vote
```
*When user tries to vote after 11 AM we send 403 Forbidden response.
