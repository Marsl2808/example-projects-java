echo --- 1 -----------------------------------
echo test-db connection:
winpty docker exec -ti postgres_db_1 pg_isready -h localhost -p 5432

echo --- 2 -----------------------------------
echo show network details:
docker network inspect postgres_default
