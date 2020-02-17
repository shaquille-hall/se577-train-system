db:
	docker-compose up --build traindb

app:
	docker-compose up --build app

clean:
	echo 'y' | docker system prune
	echo 'y' | docker volume prune
