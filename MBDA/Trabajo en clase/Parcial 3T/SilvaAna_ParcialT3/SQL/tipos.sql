ALTER TABLE Opiniones ADD CONSTRAINT CK1_TOpinion CHECK (opinion IN('E','B','R','M'));
ALTER TABLE Opiniones ADD CONSTRAINT CK1_TEstrellas CHECK(estrellas BETWEEN 1 AND 5 );