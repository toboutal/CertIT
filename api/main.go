package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

func helloWorld(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "HelloWorld")
}

func handleRequests() {
	myRouter := mux.NewRouter().StrictSlash(true)
	myRouter.HandleFunc("/", helloWorld).Methods("GET")
	myRouter.HandleFunc("/candidates", AllCandidates).Methods("GET")
	myRouter.HandleFunc("/candidate/{name}/{email}", NewCandidate).Methods("POST")
	myRouter.HandleFunc("/candidate/{name}", DeleteCandidate).Methods("DELETE")
	myRouter.HandleFunc("/candidate/{name}/{email}", UpdateCandidate).Methods("PUT")
	log.Fatal(http.ListenAndServe(":8081", myRouter))
}

func main() {
	fmt.Println("Go ORM Tutorial")

	InitialMigration()
	handleRequests()
}
