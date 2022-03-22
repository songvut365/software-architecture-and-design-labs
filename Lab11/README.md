# REST Proxy with caching

* Caching 120 second
* GET Method for get current world time with caching
* DELETE Method for current world time without caching


---
## Project setup
```
npm install
```

## Complies for development
```
node index.js
```

---
## Example
```
http://localhost:3000/api/timezone/:area/:location
```

### GET Method 
```
# curl "http://localhost:3000/api/timezone/Asia/Bangkok
2021-11-10T18:15:11.985325+07:00
```

### DELETE Method
```
# curl --request DELETE http://localhost:3000/api/timezone/Asia/Bangkok
2021-11-10T18:22:10.891808+07:00
```

---
## Reference
* Original API [WorldTimeAPI](http://worldtimeapi.org/)
* Caching with [memory-cache](https://www.npmjs.com/package/memory-cache)
* Request to WorldTimeAPI with [axios](https://www.npmjs.com/package/axios)