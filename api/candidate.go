package main

import (
	"encoding/json"
	"fmt"
	"net/http"

	"github.com/gorilla/mux"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/postgres"
)

type Candidate struct {
	gorm.Model
	Name  string
	Email string
}

func AllCandidates(w http.ResponseWriter, r *http.Request) {
	db := DbConnect()
	defer db.Close()

	var candidates []Candidate
	db.Find(&candidates)
	json.NewEncoder(w).Encode(candidates)
}

func NewCandidate(w http.ResponseWriter, r *http.Request) {
	db := DbConnect()
	defer db.Close()

	vars := mux.Vars(r)
	name := vars["name"]
	email := vars["email"]

	db.Create(&Candidate{Name: name, Email: email})
	fmt.Fprintf(w, "New Candidate Successfully Created")
}

func DeleteCandidate(w http.ResponseWriter, r *http.Request) {
	db := DbConnect()
	defer db.Close()

	vars := mux.Vars(r)
	name := vars["name"]

	var candidate Candidate
	db.Where("name  = ?", name).Find(&candidate)
	db.Delete(&candidate)

	fmt.Fprintf(w, "Candidate Successfully Deleted")
}

func UpdateCandidate(w http.ResponseWriter, r *http.Request) {
	db := DbConnect()
	defer db.Close()

	vars := mux.Vars(r)
	name := vars["name"]
	email := vars["email"]

	var candidate Candidate
	db.Where("name  = ?", name).Find(&candidate)
	candidate.Email = email
	db.Save(&candidate)

	fmt.Fprintf(w, "Candidate Successfully Updated")
}
