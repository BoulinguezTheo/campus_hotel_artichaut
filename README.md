# campus_hotel_artichaut

***Postgres***

docker run --name hotel_artichaut_db -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=postgres -e POSTGRES_DB=artichaut -v /home/Documents/Hotel_Artichaut/data:/var/lib/postgresql/data -p 5432:5432  -d postgres
