CREATE DATABASE IF NOT EXISTS VSA_CV1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_c:
CREATE USER IF NOT EXISTS 'vsa'@'localhost' IDENTIFIED BY 'vsa';
GRANT ALL PRIVILEGES ON VSA_CV1.* TO 'vsa'@'localhost';
FLUSH PRIVILEGES;

USE VSA_CV1;