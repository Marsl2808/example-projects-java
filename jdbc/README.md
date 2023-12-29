## Prerequisites
<li>docker</li>
<li>psql client (sudo apt install postgresql-client)</li>


## Running PostgreSQL

### Pull image
'docker pull postgres'

### Build data directory
'mkdir -p ~/srv/postgres'

### Run image
'docker run --rm --name my-postgres -e POSTGRES_PASSWORD=pw -d -v $HOME/srv/postgres:/var/lib/postgresql/data -p 5432:5432 postgres'

## Stop DB
'docker stop my-postgres'

## Log in
'psql -h localhost -U postgres -d hplussport'

## Show Tables
'\dt'

## Create starter data
1. 'psql -h localhost -U postgres -f database.sql'
2. 'psql -h localhost -U postgres -d hplussport -f customers.sql'
3. 'psql -h localhost -U postgres -d hplussport -f product.sql'
4. 'psql -h localhost -U postgres -d hplussport -f salesperson.sql'
5. 'psql -h localhost -U postgres -d hplussport -f orders.sql'

## Clean
1. 'DROP DATABASE hplussport;'
2. 'DROP TABLE customer CASCADE;'
3. 'DROP TABLE product CASCADE;'
4. 'DROP TABLE salesperson CASCADE;'
5. 'DROP TABLE orders CASCADE;'
6. 'DROP TABLE order_item CASCADE;'