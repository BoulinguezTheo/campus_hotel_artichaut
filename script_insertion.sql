-- Insertion de données dans la table "customer"
INSERT INTO customer (number_of_nights, address, email, first_name, last_name, password)
VALUES
    (5, '123 Rue de la République', 'client1@example.com', 'John', 'Doe', 'password1'),
    (3, '456 Avenue des Champs-Élysées', 'client2@example.com', 'Jane', 'Smith', 'password2'),
    (7, '789 Rue de la Liberté', 'client3@example.com', 'Alice', 'Johnson', 'password3'),
    (2, '101 Avenue de la Paix', 'client4@example.com', 'Bob', 'Brown', 'password4'),
    (3, '123 Avenue des Fleurs', 'client5@example.com', 'Sophie', 'Anderson', 'password5'),
    (6, '456 Boulevard des Arbres', 'client6@example.com', 'David', 'Lee', 'password6'),
    (4, '567 Rue du Soleil', 'client7@example.com', 'Laura', 'Williams', 'password7'),
    (1, '789 Avenue de la Lune', 'client8@example.com', 'Michael', 'Jones', 'password8');

-- Insertion de données dans la table "media"
INSERT INTO media (type, link)
VALUES
    (0, 'http://example.com/media1'),
    (1, 'http://example.com/media2'),
    (1, 'http://example.com/media3'),
    (0, 'http://example.com/media4'),
    (0, 'http://example.com/media5'),
    (1, 'http://example.com/media6'),
    (0, 'http://example.com/media7'),
    (1, 'http://example.com/media8');

-- Insertion de données dans la table "medias_customers"
INSERT INTO medias_customers (avatar_id, customer_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (7, 4),
    (6, 5),
    (4, 6),
    (5, 7);

-- Insertion de données dans la table "news"
INSERT INTO news (description)
VALUES
    ('Nouvelle promotion pour l été'),
    ('Nouvelles chambres disponibles'),
    ('Offre spéciale pour les membres'),
    ('Nouvelles installations disponibles'),
    ('Inauguration de la piscine extérieure'),
    ('Nouveau chef étoilé au restaurant');

-- Insertion de données dans la table "media_news"
INSERT INTO media_news (media_id, news_id)
VALUES
    (1, 1),
    (2, 2),
    (4, 3),
    (2, 4),
    (1, 5);

-- Insertion de données dans la table "option"
INSERT INTO option (duration, is_cancellable, price, reference, description, name)
VALUES
    (2, true, 100, 0, 'Option A', 'Option A Name'),
    (1, false, 50, 1, 'Option B', 'Option B Name'),
    (3, true, 150, 0, 'Option C', 'Option C Name'),
    (0, false, 70, 1, 'Option D', 'Option D Name'),
    (0, false, 80, 0, 'Option E', 'Option E Name'),
    (2, true, 120, 1, 'Option F', 'Option F Name'),
    (0, false, 80, 0, 'Option G', 'Option G Name'),
    (2, true, 120, 1, 'Option H', 'Option H Name');

-- Insertion de données dans la table "promotion"
INSERT INTO promotion (discount, min_number_of_nights, description)
VALUES
    (0.1, 3, 'Réduction pour les clients fidèles'),
    (0.15, 5, 'Réduction pour les clients très fidèles');

-- Insertion de données dans la table "room"
INSERT INTO room (number, price, reference, type, description)
VALUES
    (101, 120.0, 0, 0, 'Chambre Standard'),
    (201, 180.0, 1, 1, 'Suite de Luxe'),
    (301, 200.0, 0, 1, 'Suite Junior avec Balcon'),
    (401, 150.0, 1, 0, 'Chambre Double Vue sur Jardin'),
    (501, 220.0, 1, 2, 'Suite de Luxe avec Vue sur la Mer'),
    (601, 180.0, 0, 0, 'Chambre Simple Confort'),
    (701, 220.0, 1, 1, 'Suite Junior avec Balcon'),
    (801, 180.0, 0, 0, 'Chambre Double Vue sur Jardin');

-- Insertion de données dans la table "reservation"
INSERT INTO reservation (is_cancelled, is_mail_sent, is_paid, number_of_person, price, room_price, customer_id, end_date, reservation_date, room_id, start_date, qr_code)
VALUES
    (false, true, true, 2, 300.0, 120.0, 1, '2023-10-30 12:00:00', '2023-10-25 10:00:00', 1,'2023-11-25 10:00:00', 'QR12345'),
    (true, false, false, 1, 50.0, 50.0, 2, '2023-11-02 10:00:00', '2023-10-30 14:00:00', 2, '2023-11-07 10:00:00', 'QR67890'),
    (false, false, true, 3, 600.0, 200.0, 3, '2023-11-15 12:00:00', '2023-11-10 10:00:00', 3, '2023-11-25 10:00:00', 'QR123XYZ'),
    (true, true, false, 2, 100.0, 100.0, 4, '2023-12-05 10:00:00', '2023-12-03 14:00:00', 4, '2023-12-25 10:00:00', 'QR456ABC'),
    (true, false, true, 2, 440.0, 220.0, 5, '2023-12-01 12:00:00', '2023-11-25 10:00:00', 5, '2023-12-03 10:00:00', 'QR123XYZ'),
    (true, true, false, 1, 90.0, 90.0, 6, '2023-12-05 10:00:00', '2023-12-03 14:00:00', 6, '2023-12-14 10:00:00', 'QR456ABC'),
    (false, false, true, 2, 440.0, 220.0, 7, '2023-12-01 12:00:00', '2023-11-25 10:00:00', 7, '2023-12-04 10:00:00', 'QR123XYZ'),
    (true, true, false, 1, 90.0, 90.0, 8, '2023-12-05 10:00:00', '2023-12-03 14:00:00', 8, '2023-12-11 10:00:00', 'QR456ABC');

-- Insertion de données dans la table "billing"
INSERT INTO billing (price, reference, end_date, reservation_id, start_date)
VALUES
    (300, 0, '2023-10-30 14:00:00', 1, '2023-10-25 10:00:00'),
    (50, 1, '2023-11-02 12:00:00', 2, '2023-10-30 14:00:00'),
    (600, 0, '2023-11-15 14:00:00', 3, '2023-11-10 10:00:00'),
    (100, 1, '2023-11-18 12:00:00', 4, '2023-11-16 14:00:00'),
    (440, 0, '2023-12-01 14:00:00', 5, '2023-11-25 10:00:00'),
    (90, 1, '2023-12-05 12:00:00', 6, '2023-12-03 14:00:00'),
    (440, 0, '2023-12-01 14:00:00', 7, '2023-11-25 10:00:00'),
    (90, 1, '2023-12-05 12:00:00', 8, '2023-12-03 14:00:00');

-- Insertion de données dans la table "reservation_options"
INSERT INTO reservation_options (options_id, reservation_id)
VALUES
    (1, 1),
    (2, 2),
    (1, 3),
    (2, 4),
    (1, 5),
    (2, 6),
    (1, 7),
    (2, 8);

-- Insertion de données dans la table "review"
INSERT INTO review (notation, date, reservation_id, message, title)
VALUES
    (4, '2023-10-31 14:00:00', 1, 'Très bon séjour', 'Excellent hôtel'),
    (5, '2023-11-03 16:00:00', 2, 'Superbe expérience', 'Magnifique suite'),
    (4, '2023-11-26 14:00:00', 3, 'Superbe hôtel', 'Expérience exceptionnelle'),
    (5, '2023-12-08 16:00:00', 4, 'Excellent service', 'Séjour mémorable'),
    (4, '2023-11-12 14:00:00', 5, 'Bonne expérience', 'Séjour agréable'),
    (5, '2023-12-08 16:00:00', 6, 'Service exceptionnel', 'Superbe chambre'),
    (4, '2023-11-26 14:00:00', 7, 'Très bon service', 'Agréable séjour'),
    (5, '2023-12-08 16:00:00', 8, 'Expérience mémorable', 'Service exceptionnel');

-- Insertion de données dans la table "room_media"
INSERT INTO room_media (media_id, room_id)
VALUES
    (1, 1),
    (2, 2),
    (1, 3),
    (2, 4),
    (1, 5),
    (2, 6),
    (1, 7),
    (2, 8);
