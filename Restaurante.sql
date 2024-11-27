DROP DATABASE Restaurante;
CREATE DATABASE Restaurante;
USE Restaurante;

CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(45) NOT NULL,
    Email VARCHAR(45) NOT NULL UNIQUE,
    Telefone VARCHAR(15) NOT NULL
);

CREATE TABLE Mesa (
    idMesa INT AUTO_INCREMENT PRIMARY KEY,
    Numero INT NOT NULL,
    Capacidade INT NOT NULL
);

CREATE TABLE Prato (
    idPrato INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(45) NOT NULL,
    Preco DOUBLE NOT NULL
);

CREATE TABLE Pedido (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    Mesa_idMesa INT NOT NULL,
    Cliente_idCliente INT NOT NULL,
    Data DATETIME NOT NULL,
    FOREIGN KEY (Mesa_idMesa) REFERENCES Mesa(idMesa) ON DELETE CASCADE,
    FOREIGN KEY (Cliente_idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE
);

CREATE TABLE Pedido_has_Prato (
    Pedido_idPedido INT NOT NULL,
    Prato_idPrato INT NOT NULL,
    Quantidade INT NOT NULL,
    PRIMARY KEY (Pedido_idPedido, Prato_idPrato),
    FOREIGN KEY (Pedido_idPedido) REFERENCES Pedido(idPedido) ON DELETE CASCADE,
    FOREIGN KEY (Prato_idPrato) REFERENCES Prato(idPrato) ON DELETE CASCADE
);