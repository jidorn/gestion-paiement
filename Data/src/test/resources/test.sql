drop database test;
create database test;
use test;
CREATE TABLE user (
	id_user int(10) auto_increment NOT NULL PRIMARY KEY,
	numero_carte int(25) NOT NULL,
	expiration_mois int(2) NOT NULL,
	expiration_annee int(2) NOT NULL,
	crypto int(3) NOT NULL
);
INSERT INTO user VALUES
	(1,123456789,11,15,456),
	(2,987654321,11,15,123),
	(3,789456123,11,15,789);

CREATE TABLE compte_utilisateur (
  numero_compte int(10) auto_increment NOT NULL PRIMARY KEY,
  id_user int(10) NOT NULL,
	KEY FK_user (id_user),
	CONSTRAINT FK_user FOREIGN KEY (id_user)
			   REFERENCES user (id_user)
);
INSERT INTO compte_utilisateur (numero_compte, id_user) VALUES
  (1,1),
  (2,2),
  (3,3);

CREATE TABLE operation (
  id_operation int(10) auto_increment NOT NULL PRIMARY KEY,
  TYPE_OPERATION VARCHAR(10) NOT NULL,
  montant_operation DOUBLE NOT NULL,
  libelle_operation VARCHAR(255) NOT NULL,
  date_operation DATETIME NOT NULL,
  numero_compte int(10) NOT NULL,
  KEY FK_compte (numero_compte),
  CONSTRAINT FK_compte FOREIGN KEY (numero_compte)
  REFERENCES compte_utilisateur (numero_compte)
);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES
  ("CREDIT",1200,"salaire","2016-01-15 12:29:05",1),
  ("DEBIT",300,"achat","2016-01-15 12:29:06",1),
  ("CREDIT",300,"remboursement","2016-01-15 12:29:05",1),
  ("DEBIT",1000,"fdsef","2016-01-15 12:29:05",1),
  ("CREDIT",10,"grzegrzgagf","2016-01-15 12:29:05",1),
  ("CREDIT",1200,"salaire","2016-01-15 12:29:05",2),
  ("DEBIT",300,"achat","2016-01-15 12:29:06",2),
  ("CREDIT",300,"remboursement","2016-01-15 12:29:05",2),
  ("DEBIT",1000,"fdsef","2016-01-15 12:29:05",2),
  ("CREDIT",10,"grzegrzgagf","2016-01-15 12:29:05",2),
  ("CREDIT",1200,"salaire","2016-01-15 12:29:05",3),
  ("DEBIT",300,"achat","2016-01-15 12:29:06",3),
  ("CREDIT",300,"remboursement","2016-01-15 12:29:05",3),
  ("DEBIT",1000,"fdsef","2016-01-15 12:29:05",3),
  ("CREDIT",10,"grzegrzgagf","2016-01-15 12:29:05",3),
  ("CREDIT",1200,"salaire","2016-01-15 12:29:05",4),
  ("DEBIT",300,"achat","2016-01-15 12:29:06",4),
  ("CREDIT",300,"remboursement","2016-01-15 12:29:05",4),
  ("DEBIT",1000,"fdsef","2016-01-15 12:29:05",4),
  ("CREDIT",10,"grzegrzgagf","2016-01-15 12:29:05",4);


