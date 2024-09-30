# :soccer: Transfermarkt-API  :leaves:


![Test](https://github.com/otaviofbrito/Transfermarkt-API/actions/workflows/gradle.yml/badge.svg)
![Docker Image](https://github.com/otaviofbrito/Transfermarkt-API/actions/workflows/docker-image.yml/badge.svg)
![Fly.io](https://github.com/otaviofbrito/Transfermarkt-API/actions/workflows/fly-deploy.yml/badge.svg)



## Table of Contents
- [Clubs](#clubs)
- [Leagues](#leagues)
- [Players](#players)
- [Transfers](#transfers)



## Clubs

| HTTP Method | Endpoint                      | Description                                | Parameters       |
|-------------|-------------------------------|--------------------------------------------|------------------|
| GET         | `/api/club/{id}/info`          | Retrieve information about a specific club | `id`: Club ID    |
| GET         | `/api/club/search/{name}`      | Search for clubs by name                   | `name`: Club name, `page`: Page number (optional) |
| GET         | `/api/club/{id}/leagues`       | Get leagues where the club has played      | `id`: Club ID, `page`: Page number (optional) |
| GET         | `/api/club/{id}/transfers`     | Get the transfer history of a club         | `id`: Club ID, `page`: Page number (optional) |



## Leagues

| HTTP Method | Endpoint                      | Description                                   | Parameters        |
|-------------|-------------------------------|-----------------------------------------------|-------------------|
| GET         | `/api/league/{id}/info`        | Retrieve information about a specific league  | `id`: League ID   |
| GET         | `/api/league/search/{name}`    | Search for leagues by name                    | `name`: League name, `page`: Page number (optional) |
| GET         | `/api/league/{id}/clubs`       | Get clubs that are part of the league         | `id`: League ID, `page`: Page number (optional) |



## Players

| HTTP Method | Endpoint                       | Description                                   | Parameters        |
|-------------|--------------------------------|-----------------------------------------------|-------------------|
| GET         | `/api/player/{id}/profile`     | Retrieve data for a specific player           | `id`: Player ID   |
| GET         | `/api/player/search/{name}`    | Search for players by name                    | `name`: Player name, `page`: Page number (optional) |
| GET         | `/api/player/{id}/transfers`   | Get the transfer history of a specific player | `id`: Player ID   |



## Transfers

| HTTP Method | Endpoint                        | Description                                     | Parameters        |
|-------------|---------------------------------|-------------------------------------------------|-------------------|
| GET         | `/api/player/{id}/transfers`    | Get the transfer history of a player            | `id`: Player ID   |
| GET         | `/api/club/{id}/transfers`      | Get the transfer history of a club              | `id`: Club ID, `page`: Page number (optional) |



## How to Use

- All endpoints return data in JSON format.
- Pagination is supported via the `page` parameter on some endpoints, with a default page size of 20 items.
- To search by name, the name should be provided as part of the URL path.

## Example Requests

1. **Get Club Information:**
   ```
   GET /api/club/123/info
   ```
2. **Search for Clubs by Name:**
   ```
   GET /api/club/search/Real?page=1
   ```
3. **Get Player Transfer History:**
   ```
   GET /api/player/456/transfers
   ```

## Response Codes

- **200 OK**: Data successfully retrieved.
- **404 Not Found**: No matching data found for the given criteria.


