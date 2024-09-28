
docker build -t irrigation .
docker run -d -p 8080:8080 --name irrigation-api -e PROFILE=prd -e DATABASE_URL=jdbc:sqlite:file:irrigation.db irrigation