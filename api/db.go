package main

import (
	"log"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/postgres"
)

var db *gorm.DB
var err error
var dbParams string = "host=localhost port=5432 user=postgres dbname=test password=my_Password sslmode=disable"

func InitialMigration() {
	db = DbConnect()
	db.AutoMigrate(&Candidate{})
	log.Println("Connection Established")
}

func DbConnect() *gorm.DB {
	db, err = gorm.Open("postgres", dbParams)

	if err != nil {
		panic("Connection Failed to Open")
	}
	return db
}
