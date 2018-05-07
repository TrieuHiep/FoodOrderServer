#!/bin/bash
echo "connecting to MySQL Server....."
mysql -h 127.0.0.1 -u root -pnthangzuzu --execute="use fooddb;"
echo "connect successfully!"
echo "altering tables....."
mysql -u root -pnthangzuzu < 74.92.sql
