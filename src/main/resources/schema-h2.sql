DROP TABLE IF EXISTS Todos;
CREATE TABLE Todos (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) not null,
    description VARCHAR(50) not null,
    UNIQUE (id),
    UNIQUE(name)
);

DROP TABLE IF EXISTS Tasks;
CREATE TABLE Tasks (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) not null,
    priority VARCHAR(10) not null,
    status VARCHAR(20) not null,
    todo_id INT not null,
    UNIQUE (name),
    FOREIGN KEY (todo_id) REFERENCES Todos(Id)
);