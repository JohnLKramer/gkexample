# Groovy Kotlin Example

## Introduction

The point of this example is to show how various JVM languages can coexist under a single gradle 
project. In this case we are using Groovy as a baseline language and Kotlin as a newer language, 
but the same approach could be used to transition between any two JVM based languages.

Ideally, projects wouldn't mingle languages as there is some complexity, but in the real world, 
many projects use unsafe, risky languages such as Gradle. Organizations would like to move to newer,
nicer, safer languages such as Kotlin, but it isn't realistic to rewrite projects in one fell swoop.

The safety and correctness of the legacy features must be preserved. At the same time, progress must 
be made in transitioning to the newer language.

## How to get value from this example?

Rather than focusing on the technology or design here (which are pedestrian), instead focus on the
way that changes are introduced. I.e. look at the project change log and see how changes are introduced.
I hope that you will derive value from that. To that end, you may want to skip to the Change Log

## Project Implementation

This is a Spring Boot project implementing CRUD REST web services which users a SQLite backend. SQLite 
was chosen because it is real persistence but doesn't require any configuration or set-up beyond what 
is in this project. The database DDL is generated dynamically by Hibernate when the application boots.

Other than the use of SQLite, this is a fairly standard architecture with the following layers:

1. Controller (web service endpoint)
2. Service (business logic)
3. Repository
4. Database

## Change Log

**COMMIT #1** Initial Groovy code. These changes are intended to represent a legacy application written in Groovy.

**COMMIT #2** Initial Kotlin code along with Ktlint and Detekt configuration. Note that this is mostly independent functionality. 
There is only one dependency. The application class ``ExampleApplication`` which is written in Groovy depends on the Kotlin code.

**COMMIT #3** Added Fruit to Pie. This necessitates refactoring Fruit to make it Kotlin so that we can reference it from the Kotlin Pie.

## Building and running

### Build 

````
./gradlew build
````

### Run

````
./gradlew bootRun
````

### Use


Run

````
curl --location --request POST 'localhost:50005/gkexample/fruit/apple' \
--header 'Content-Type: application/json' \
--data-raw '{
"variety": "black diamond",
"flavor": "sweet",
"color": "purple"
}'
````

Result 

````
{
    "id": 1,
    "variety": "black diamond",
    "flavor": "sweet",
    "color": "purple"
}
````

Run

````
curl --location --request POST 'localhost:50005/gkexample/fruit/orange' \
--header 'Content-Type: application/json' \
--data-raw '{
"variety": "Cam Sanh",
"flavor": "sweet",
"color": "green"
}'
````

Result

````
{
    "id": 3,
    "variety": "Cam Sanh",
    "flavor": "sweet",
    "color": "green"
}
````

Run

````
curl --location --request GET 'localhost:50005/gkexample/fruit/all'
````

Result

````
[
    {
        "id": 1,
        "variety": "black diamond",
        "flavor": "sweet",
        "color": "purple"
    },
    {
        "id": 3,
        "variety": "Cam Sanh",
        "flavor": "sweet",
        "color": "green"
    }
]
````


