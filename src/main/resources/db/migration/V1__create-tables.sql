CREATE TABLE IF NOT EXISTS turmas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    turno VARCHAR(14) NOT NULL,
    ano INT NOT NULL
);

CREATE TABLE IF NOT EXISTS alunos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    responsible_telephone VARCHAR(15) NOT NULL,
    turma_id BIGINT,
    FOREIGN KEY (turma_id) REFERENCES turmas(id)
);

CREATE TABLE IF NOT EXISTS boletins (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nota_1 FLOAT NOT NULL,
    nota_2 FLOAT NOT NULL,
    nota_3 FLOAT NOT NULL,
    nota_4 FLOAT NOT NULL,
    media FLOAT NOT NULL,
    quantidade_faltas INT NOT NULL,
    aprovado BOOLEAN NOT NULL,
    aluno_id BIGINT,
    FOREIGN KEY (aluno_id) REFERENCES alunos(id)
);
