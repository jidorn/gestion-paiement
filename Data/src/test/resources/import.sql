INSERT INTO user VALUES (1, 123456789, 11, 15, 456);
INSERT INTO user VALUES (2, 987654321, 11, 15, 123);
INSERT INTO user VALUES (3, 789456123, 11, 15, 789);

INSERT INTO compte_utilisateur (numero_compte, id_user) VALUES (1, 1);
INSERT INTO compte_utilisateur (numero_compte, id_user) VALUES (2, 2);
INSERT INTO compte_utilisateur (numero_compte, id_user) VALUES (3, 3);

INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 56200, "salaire", "2016-01-15 12:29:05", 1);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("DEBIT", 300, "achat", "2016-01-15 12:29:06", 1);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 300, "remboursement", "2016-01-15 12:29:05", 1);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("DEBIT", 1000, "fdsef", "2016-01-15 12:29:05", 1);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 10, "grzegrzgagf", "2016-01-15 12:29:05", 1);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 24000, "salaire", "2016-01-15 12:29:05", 2);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("DEBIT", 300, "achat", "2016-01-15 12:29:06", 2);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 300, "remboursement", "2016-01-15 12:29:05", 2);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("DEBIT", 1000, "fdsef", "2016-01-15 12:29:05", 2);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 10, "grzegrzgagf", "2016-01-15 12:29:05", 2);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 56200, "salaire", "2016-01-15 12:29:05", 3);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("DEBIT", 300, "achat", "2016-01-15 12:29:06", 3);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 300, "remboursement", "2016-01-15 12:29:05", 3);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("DEBIT", 1000, "fdsef", "2016-01-15 12:29:05", 3);
INSERT INTO operation (TYPE_OPERATION, montant_operation, libelle_operation, date_operation, numero_compte) VALUES ("CREDIT", 10, "grzegrzgagf", "2016-01-15 12:29:05", 3);



