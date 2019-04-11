CREATE TABLE "user"
(
	"id" SERIAL NOT NULL,
	"email" VARCHAR(512) NOT NULL,
	"password" VARCHAR(50) NOT NULL,
	"first_name" VARCHAR(255) NOT NULL,
	"surname" VARCHAR(255) NOT NULL,
	"phone"	VARCHAR(20) NOT NULL,
	"is_active" BOOLEAN NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY ("id"),
	CONSTRAINT uk_email UNIQUE ("email"),
	CONSTRAINT uk_phone UNIQUE ("phone")

);

    

INSERT INTO "user" ("email","password","first_name","surname","phone","is_active")
VALUES('user@gmail.com','123456','First','Sur','+380000000000','true');