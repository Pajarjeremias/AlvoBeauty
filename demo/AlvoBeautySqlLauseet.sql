CREATE TABLE alvo_beauty
( aBId BIGSERIAL NOT NULL PRIMARY KEY);
INSERT INTO alvo_beauty DEFAULT VALUES;


CREATE TABLE kayttaja (
    kayt_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50)
);
INSERT INTO kayttaja (username, password, role)
VALUES ('erica', '$2a$10$Wb5XUThZJnsJ0YM2jiqvbO9M24co6VwfnhHaUYMVHsIsWfXj0GjtC', 'toimitusjohtaja'),
('admin', '$2a$10$fK9fdrbJOtQi1M6vPqIOROO5KQq1oqN0VtD4tMyI4Ltz40.2nLdaS', 'toimitusjohtaja'),
('ADMIN', '$2a$10$hEREs5hZX40EvCwARFJ2geCgRVF9I4qEB8vRYGbtfZXVmaW5cUbRu', 'toimitusjohtaja'),
('user', '$2a$10$mVorG0I8ybmdzmjUfrBO8uBaBmqXjEGi9W0a/rqiy12aby4Ldvrzy', 'user'),
('USER', '$2a$10$ZNMDi6sVd1BherrpA7yjce7hUCBVqW2EmFhMC.745phIT85GyUOQu', 'USER'),
('jeremias', '$2a$10$aFNEGgYbQnH6Ndy.Y74dT.HcQp4OgQpRlSmmhpJmg0tRAr4GszUSK', 'työntekijä'),
('jack', '$2a$10$St1b9RMyqrpXb8kwlSC85OmoWmfJ0qT4WoIsAe/5DOlJ7P16Ju.q6', 'työntekjä'),
('leonardo', '$2a$10$9B9KNaWiAJCIlspxpNnONOVvq/lmnoUi/25we3aQDTWUeeGXUqUOW', 'toimitusjohtaja');

CREATE TABLE tyontekijat (
    tTId BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(50) NOT NULL,
    role VARCHAR(100) NOT NULL,
    puhnumero VARCHAR(15) NOT NULL,
    email VARCHAR(40) NOT NULL,
    osoite VARCHAR(50),
    tyosuhdealku int,
    lisatiedot VARCHAR(255) NOT NULL,
    aBId BIGINT,
    FOREIGN KEY(aBId) REFERENCES alvo_beauty(aBId) ON DELETE CASCADE
);
INSERT INTO tyontekijat (nimi, role, puhnumero, email, osoite, tyosuhdealku, lisatiedot, aBId)
VALUES ('erica', 'toimitusjohtaja', '0402465768', 'erica.alvo@kolumbus.fi', 'vanhatie 3', 1995, 'eipä tässä mittään', 1),
('admin','toimitusjohtaja', '0462025555', 'admin.admin@admin.fi', 'adminintie 5', 1998, 'samapa tuo', 1),
('ADMIN','toimitusjohtaja', '12325467', 'ADMIN:ADMIN@ADMIN.fi', 'ADMININTIE %',1020 , 'mitäpä tässä', 1),
('user','user', '125364758', 'user.user@user.fi', 'userintie 5', 1453 , 'siellä ja täällä', 1),
('USER','USER', '3526475', 'USER:USER@USER.FI', 'USERINTIE %',3563 , 'badabim badabum', 1),
('jeremias','työntekijä', '3647586595', 'jeremias.jeremias@jeremias.fi', 'jeremiaksentie 5',1995 , 'kyllä se siitä', 1),
('jack','työntekijä', '36247586597', 'jack.jack@jack.fi', 'jackinkuja 5', 2016 , 'wuf wuf', 1),
('leonardo','toimitusjohtaja', '326253324', 'leonardo.leonardo@leo.fi', 'leon parkkihalli 100', 2020 , 'izkä izkä', 1);

CREATE TABLE palvelut (
    palv_id BIGSERIAL PRIMARY KEY,
    hinta DECIMAL(10, 2),
    nimi VARCHAR(50) NOT NULL,
    kuvaus VARCHAR(255),
    aBId BIGINT,
    tTId BIGINT,
    FOREIGN KEY (aBId) REFERENCES alvo_beauty(aBId) ON DELETE CASCADE,
    FOREIGN KEY (tTId) REFERENCES tyontekijat(tTId) ON DELETE SET NULL
);
INSERT INTO palvelut (hinta, nimi, kuvaus, aBId, tTId)
VALUES (19.99, 'Rakennekynnet', 'Pitkät kynnet', 1, 1),
(29.99, 'Kestoripset', 'Kestävät ripset', 1, 7),
(9.99, 'Kasvohoito', 'Kasvojen hoito', 1, 8),
(14.99, 'Kesto pigmentointi', 'Kulmakarvojen pitkäkestoinen värjäys', 1, 6),
(99.99, 'Jalkahoito', 'Kallis jalkahoito', 1, 1),
(149.99, 'Hääpaketti', 'Pakettii sisältyy laajavalikoima palveluita', 1, 6),
(12.99, 'manikyyri', 'Liittyy jalkojen tai käsien hoitoon', 1, 7);