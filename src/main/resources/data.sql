-- -- Create tables if not exist (TODO Checken of dit nodig is)

INSERT INTO artwork_images (file_name) VALUES    ('1022 Brown and white horse sketch - Jon Tyson.jpg'),
                                                ('1023 Red blue green and yellow abstract drawing - Liao Je Wei.jpg'),
                                                ('1024 Woman in white and black dress illustration - Tatiana Zhukova.jpg'),
                                                ('1025 Man and woman holding hands - Annie Spratt.jpg'),
                                                ('1026 Woman illustration - Diogo Nunes.jpg'),
                                                ('1027 Persons eye in grayscale - Dhanya A V.jpg'),
                                                ('1028 Person raising arms illustration - Thiébaud Faix.jpg'),
                                                ('1029 Medieval Old Town - Racta Populous.jpg'),
                                                ('1030 A drawing of a dog wearing a collar - Chris Curry.jpg'),
                                                ('1043 Thinker Think - Geralt Altmann.jpg'),
                                                ('1001-fantail-wrens-McGill.jpg'),
                                                ('1002 Vibrant colours - Steve Johnson.jpg'),
                                                ('1003 Sea Waves - Henrik Donnestad.jpg'),
                                                ('1004 Turquoise Abstract Landscape II - Alan Scales.jpg'),
                                                ('1005 Spring Flowers - Mona Eendra.jpg'),
                                                ('1006 Volcano - Pawel Czerwinski.jpg'),
                                                ('1007 Culture - Mayur Deshpande.jpg'),
                                                ('1008 Painting pattern - Vojtech.jpg'),
                                                ('1009 Who killed cock robin - McGill.jpg'),
                                                ('1010 5+ Louis - Jene Stephaniuk.jpg'),
                                                ('1011 Mother fox and little baby - Fuu J.jpg'),
                                                ('1012 Woman with black hair - Jakub Durian.jpg'),
                                                ('1013 Abstract face - Jon Tyson.jpg'),
                                                ('1014 Golden Bridge - Lex Totan.jpg'),
                                                ('1015 Sun Shine in the clouds - Carlos Kenobi.jpg'),
                                                ('1016 Concrete building during daytime - Tatiana Zhukova.jpg'),
                                                ('1017 Brown dried leaves on ground - Adam Neumann.jpg'),
                                                ('1018 Fruits and flowers - H. Rustall.jpg'),
                                                ('1019 Woman in white dress - Susan Wilkinson.jpg'),
                                                ('1020 Birds and flowers - Martin Martz.jpg'),
                                                ('1021 Two human hands painting - Claudio Schwarz.jpg'),
                                                ('1031 Collared Kingfisher - McGill.jpg'),
                                                ('1032 Blue Jays - McGill.jpg'),
                                                ('1033 The fox and the grapes fable - McGill.jpg'),
                                                ('1034 Favorite nursery tales Barber barber shave a pig - McGill.jpg'),
                                                ('1035 Indian Three-toed Kingsfisher - McGill.jpg'),
                                                ('1036 Moose - McGill.jpg'),
                                                ('1037 Beaver - McGill.jpg'),
                                                ('1038 Momentum II - Hendrik Donnestad.jpg'),
                                                ('1039 White black orange abstract - Hendrik Donnestad.jpg'),
                                                ('1040 Abstract textures - Hendrik Donnestad.jpg'),
                                                ('1041 Green waves - Hendrik Donnestad.jpg'),
                                                ('1042 Clouds - Triske Lion.jpg'),
                                                ('1044 Ladybug - Mya Woods.jpg'),
                                                ('1045 Asian Nature - Bri Gwer.jpg'),
                                                ('1046 Town - Lay Ers.jpg'),
                                                ('1047-swan-2893562.jpg'),
                                                ('1051-pelican-2585221.jpg'),
                                                ('1052-tit-2566376.jpg'),
                                                ('1053-soldier-3524202.jpg'),
                                                ('1054-fawn-2893471.jpg');






INSERT INTO artworks (id, title, artist, description, date_created, gallery_buying_price, edition, artwork_image_file_name, artwork_type) VALUES    (1022,'Brown and white horse sketch','Jon Tyson','A sketch of a horse made with graphite pencils','2020-10-16 00:00:00',2500,'single','1022 Brown and white horse sketch - Jon Tyson.jpg','drawing'),
                                                                                                                                                    (1023,'Red blue green and yellow abstract drawing','Liao Je Wei','An abstract drawing of chickens made with fineliners','2020-07-05 00:00:00',2500,'single','1023 Red blue green and yellow abstract drawing - Liao Je Wei.jpg','drawing'),
                                                                                                                                                    (1024,'Woman in white and black dress illustration','Tatiana Zhukova','A sketch of a woman in white and black dress made with charcoal','2020-04-09 00:00:00',2500,'single','1024 Woman in white and black dress illustration - Tatiana Zhukova.jpg','drawing'),
                                                                                                                                                    (1025,'Boy and girl holding hands','Annie Spratt','A drawing of a boy and girl holding hands made with charcoal','2020-06-10 00:00:00',2500,'single','1025 Man and woman holding hands - Annie Spratt.jpg','drawing'),
                                                                                                                                                    (1026,'Woman illustration','Diogo Nunes','A drawing of a portrait of a woman made with black ink','2019-02-04 00:00:00',2500,'single','1026 Woman illustration - Diogo Nunes.jpg','drawing'),
                                                                                                                                                    (1027,'Persons eye in grayscale','Dhanya A V ','A drawing of a persons eye made in grayscale with graphite pencils','2020-10-15 00:00:00',2500,'single','1027 Persons eye in grayscale - Dhanya A V.jpg','drawing'),
                                                                                                                                                    (1028,'Person raising arms illustration','Thiébaud Faix','A drawing of a person raising hands made with different materials','2019-06-11 00:00:00',2500,'single','1028 Person raising arms illustration - Thiébaud Faix.jpg','drawing'),
                                                                                                                                                    (1029,'Medieval Old Town','Racta Populous','A aquarelle of a medieval old town','2018-09-15 00:00:00',2500,'single','1029 Medieval Old Town - Racta Populous.jpg','drawing'),
                                                                                                                                                    (1030,'A drawing of a dog wearing a collar','Chris Curry','A sketch of a terrier wearing a collar made with graphite pencils','2021-12-30 00:00:00',2500,'single','1030 A drawing of a dog wearing a collar - Chris Curry.jpg','drawing'),
                                                                                                                                                    (1043,'Thinker Think','Geralt Altmann','A drawing of Thinker Think made with charcoal','2024-04-11 00:00:00',2500,'single','1043 Thinker Think - Geralt Altmann.jpg','drawing');

INSERT INTO artworks (id, title, artist, description, date_created, gallery_buying_price, edition,artwork_image_file_name, artwork_type) VALUES (1001,'Fantail Wrens','McGill','Watercolour painting with birds in a forest','2020-01-25 00:00:00',2500, 'single','1001-fantail-wrens-McGill.jpg','painting'),
                                                                                                                                                (1002,'Vibrant color','Steve Johnson','Acrylic modern abstract art with texture backrounds and vibrant colours','2018-11-11 00:00:00',2500,1,'1002 Vibrant colours - Steve Johnson.jpg','painting'),
                                                                                                                                                (1003,'Sea Waves','Hendrik Donnestad','Oil painting with structure of waves of the sea','2018-01-08 00:00:00',2500,1,'1003 Sea Waves - Henrik Donnestad.jpg','painting'),
                                                                                                                                                (1004,'Turquoise Abstract Landscape II','Alan Scales','Acryl modern abstract painting with texture backrounds','2019-09-08 00:00:00',2500,1,'1004 Turquoise Abstract Landscape II - Alan Scales.jpg','painting'),
                                                                                                                                                (1005,'Spring Flowers ','Mona Eendra','Acryl painting of spring flowers in front of a yellow wall','2017-02-15 00:00:00',2500,1,'1005 Spring Flowers - Mona Eendra.jpg','painting'),
                                                                                                                                                (1006,'Volcano','Pawel Czerwinski','Layered acrylic paint with a couple of separate paddles wich are melted','2019-03-30 00:00:00',2500,1,'1006 Volcano - Pawel Czerwinski.jpg','painting'),
                                                                                                                                                (1007,'Culture','Mayur Deshpande','Abstract painting of a culture','2021-03-08 00:00:00',2500,1,'1007 Culture - Mayur Deshpande.jpg','painting'),
                                                                                                                                                (1008,'Painting pattern','Vojtech Bruzek','Abstract acrylic painting on wood','2021-04-16 00:00:00',2500,1,'1008 Painting pattern - Vojtech.jpg','painting'),
                                                                                                                                                (1009,'Who killed cock robin?','McGill','A funny watercolour painting of birds','2020-03-17 00:00:00',2500,1,'1009 Who killed cock robin - McGill.jpg','painting'),
                                                                                                                                                (1010,'5+ Louis','Jené Stephaniuk','A abstract painting made with acryl paint','2020-10-12 00:00:00',2500,1,'1010 5+ Louis - Jene Stephaniuk.jpg','painting'),
                                                                                                                                                (1011,'Mother fox and little baby','Fuu J','A watercolour painting of a mother fox and a little baby','2021-02-13 00:00:00',2500,1,'1011 Mother fox and little baby - Fuu J.jpg','painting'),
                                                                                                                                                (1012,'Woman with black hair','Jakub Durian','A painting made with spraypaint with a face of a woman with black hair','2020-09-07 00:00:00',2500,1,'1012 Woman with black hair - Jakub Durian.jpg','painting'),
                                                                                                                                                (1013,'Abstract face','Jon Tyson','A modern art acrylic painting combined with paper','2021-05-26 00:00:00',2500,1,'1013 Abstract face - Jon Tyson.jpg','painting'),
                                                                                                                                                (1014,'Golden bridge','Lex Totan','A watercolour painting of the Golden Bridge','2018-02-11 00:00:00',2500,1,'1014 Golden Bridge - Lex Totan.jpg','painting'),
                                                                                                                                                (1015,'Sun shine in the clouds','Carlos Kenobi','An abstract painting of blue, brown and white colors made with oil paint','2019-05-26 00:00:00',2500,1,'1015 Sun Shine in the clouds - Carlos Kenobi.jpg','painting'),
                                                                                                                                                (1016,'Concrete building during daytime','Tatiana Zhukova','An oil paint of a Monastery during daytime in Sankt-Petersburg, Russia','2019-07-08 00:00:00',2500,1,'1016 Concrete building during daytime - Tatiana Zhukova.jpg','painting'),
                                                                                                                                                (1017,'Brown dried leaves on ground','Adam Neumann','An oil paint of brown dried leaves on ground','2020-11-11 00:00:00',2500,1,'1017 Brown dried leaves on ground - Adam Neumann.jpg','painting'),
                                                                                                                                                (1018,'Fruits and flowers','H. Rustall','A painting made with acryl paint of fruits and flowers at the same time on the branches of the apple tree. A symbol of the union of maturiy and youth in  person','2021-02-25 00:00:00',2500,1,'1018 Fruits and flowers - H. Rustall.jpg','painting'),
                                                                                                                                                (1019,'Woman in white dress','Susan Wilkinson','An aquarel painting of a woman in a white dress','2020-10-05 00:00:00',2500,1,'1019 Woman in white dress - Susan Wilkinson.jpg','painting'),
                                                                                                                                                (1020,'Birds and flowers','Martin Martz','A acrylic modern art painting on textile of birds and flowers','2020-07-02 00:00:00',2500,1,'1020 Birds and flowers - Martin Martz.jpg','painting'),
                                                                                                                                                (1021,'Two human hands painting','Claudio Schwarz','A modern art painting of two human hands made with aquarel paint','2019-05-22 00:00:00',2500,1,'1021 Two human hands painting - Claudio Schwarz.jpg','Painting'),
                                                                                                                                                (1031,'Collared Kingfisher','McGill','A watercolour painting of a kingfisher','2020-01-25 00:00:00',2500,1,'1031 Collared Kingfisher - McGill.jpg','painting'),
                                                                                                                                                (1032,'Blue Jays','McGill','A watercolour painting of blue jays','2020-01-17 00:00:00',2500,1,'1032 Blue Jays - McGill.jpg','painting'),
                                                                                                                                                (1033,'The fox and the grapes fable','McGill','A watercolour painting of the fox and the grapes fable','2020-03-17 00:00:00',2500,1,'1033 The fox and the grapes fable - McGill.jpg','painting'),
                                                                                                                                                (1034,'Favorite nursery tales, " Barber, barber shave a pig"','McGill','A watercolour painting of a favorite nursery tale, "Barber, barber shave a pig"','2020-03-17 00:00:00',2500,1,'1034 Favorite nursery tales Barber barber shave a pig - McGill.jpg','painting'),
                                                                                                                                                (1035,'Indian Three-toed Kingfisher','McGill','A watercolour painting of an Indian three-toed kindfisher','2020-01-11 00:00:00',2500,1,'1035 Indian Three-toed Kingsfisher - McGill.jpg','painting'),
                                                                                                                                                (1036,'Moose','McGill','A watercolour painting of a moose','2020-01-11 00:00:00',2500,1,'1036 Moose - McGill.jpg','painting'),
                                                                                                                                                (1037,'Beaver (Castor canadensis)','McGill','A watercolour painting of a Castor canadensis beaver','2020-01-11 00:00:00',2500,1,'1037 Beaver - McGill.jpg','painting'),
                                                                                                                                                (1038,'Momentum II','Hendrik Donnestad','Oil painting with structure of mineral water','2018-11-05 00:00:00',2500,1,'1038 Momentum II - Hendrik Donnestad.jpg','painting'),
                                                                                                                                                (1039,'White, black, orange abstract','Hendrik Donnestad','An abstract oil painting of white, black and orange','2018-08-07 00:00:00',2500,1,'1039 White black orange abstract - Hendrik Donnestad.jpg','painting'),
                                                                                                                                                (1040,'Abstract textures','Hendrik Donnestad','An abstract oil painting of textures','2017-12-05 00:00:00',2500,1,'1040 Abstract textures - Hendrik Donnestad.jpg','painting'),
                                                                                                                                                (1041,'Green waves','Hendrik Donnestad','Oil painting with structure of waves of the sea in green','2017-12-04 00:00:00',2500,1,'1041 Green waves - Hendrik Donnestad.jpg','painting'),
                                                                                                                                                (1042,'Clouds','Triske Lion','Oil painting of clouds','2021-12-01 00:00:00',2500,1,'1042 Clouds - Triske Lion.jpg','painting'),
                                                                                                                                                (1044,'Ladybug','Mya Woods','A acryl painting of a ladybug','2024-04-27 00:00:00',2500,1,'1044 Ladybug - Mya Woods.jpg','painting'),
                                                                                                                                                (1045,'Asian Nature','Bri Gwer','An oil painting of Asian nature','2024-03-20 00:00:00',2500,1,'1045 Asian Nature - Bri Gwer.jpg','painting'),
                                                                                                                                                (1046,'Town','Lay Ers','A watercolour painting of a small town','2021-02-21 00:00:00',2500,1,'1046 Town - Lay Ers.jpg','painting');


INSERT INTO drawings (id, drawing_surface, drawing_material, drawing_dimensions_width_in_cm, drawing_dimensions_height_in_cm) VALUES (1022,'Paper','Graphite pencils',28,37),
                                                                                                                                     (1023,'Paper','Fineliners',62,41),
                                                                                                                                     (1024,'Paper','Charcoal',30,40),
                                                                                                                                     (1025,'Stone','Charcoal',22,38),
                                                                                                                                     (1026,'Paper','Black ink',46,30),
                                                                                                                                     (1027,'Paper','Graphite pencils',41,30),
                                                                                                                                     (1028,'Stone','Acryl markers, fineliners, colored ink',40,60),
                                                                                                                                     (1029,'Paper','Aquarelle paint',35,23),
                                                                                                                                     (1030,'Paper','Graphite pencils',33,44),
                                                                                                                                     (1043,'Paper','Charcoal',19,13);


INSERT INTO paintings (id, painting_surface, painting_material, painting_dimensions_width_in_cm, painting_dimensions_height_in_cm) VALUES (1001,'Paper','Watercolour paint',23,29),
                                                                                                                                          (1002,'Canvas','Acryl paint',34,43),
                                                                                                                                          (1003,'Canvas','Oil paint',21,21),
                                                                                                                                          (1004,'Wood','Acryl paint',53,79),
                                                                                                                                          (1005,'Paper','Acryl paint',34,51),
                                                                                                                                          (1006,'Canvas','Acryl paint',60,40),
                                                                                                                                          (1007,'Stone','Acryl paint',40,30),
                                                                                                                                          (1008,'Wood','Acryl paint',100,150),
                                                                                                                                          (1009,'Paper','Watercolour paint',59,75),
                                                                                                                                          (1010,'Canvas','Acryl paint',22,40),
                                                                                                                                          (1011,'Paper','Watercolour paint',24,32),
                                                                                                                                          (1012,'Canvas','Spraypaint',32,49),
                                                                                                                                          (1013,'Wood','Acryl paint and paper',29,35),
                                                                                                                                          (1014,'Canvas','Watercolour paint',55,37),
                                                                                                                                          (1015,'Canvas','Oil paint',38,51),
                                                                                                                                          (1016,'Canvas','Oil paint',30,40),
                                                                                                                                          (1017,'Wood','Oil paint',40,61),
                                                                                                                                          (1018,'Paper','Acryl paint',80,80),
                                                                                                                                          (1019,'Paper','Aquarel paint',23,36),
                                                                                                                                          (1020,'Textile','Acryl paint',30,40),
                                                                                                                                          (1021,'Paper','Aquarel paint',79,53),
                                                                                                                                          (1031,'Paper','Watercolour paint',25,27),
                                                                                                                                          (1032,'Paper','Watercolour paint',126,162),
                                                                                                                                          (1033,'Paper','Watercolour paint',47,67),
                                                                                                                                          (1034,'Paper','Watercolour paint',36,55),
                                                                                                                                          (1035,'Paper','Watercolour paint',61,75),
                                                                                                                                          (1036,'Paper','Watercolour paint',94,145),
                                                                                                                                          (1037,'Paper','Watercolour paint',81,55),
                                                                                                                                          (1038,'Canvas','Oil paint',30,30),
                                                                                                                                          (1039,'Canvas','Oil paint',30,30),
                                                                                                                                          (1040,'Canvas','Oil paint',30,30),
                                                                                                                                          (1041,'Canvas','Oil paint',30,30),
                                                                                                                                          (1042,'Canvas','Oil paint',41,25),
                                                                                                                                          (1044,'Paper','Acryl paint',61,35),
                                                                                                                                          (1045,'Wood','Oil paint',30,23),
                                                                                                                                          (1046,'Paper','Watercolour paint',45,30);

INSERT INTO ratings (id, rating, artwork_id, comment) VALUES (1001, 5, 1001, 'Wow, This looks great');
INSERT INTO ratings (id, rating, artwork_id, comment) VALUES (1002, 4, 1001, 'Very impresive art');
INSERT INTO ratings (id, rating, artwork_id, comment) VALUES (1003, 5, 1002, 'Wow, This looks great');
INSERT INTO ratings (id, rating, artwork_id, comment) VALUES (1004, 4, 1002, 'Very impresive art');

INSERT INTO users (username, password, email) VALUES ('user', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK','user@test.nl');
INSERT INTO users (username, password, email) VALUES ('admin', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK', 'admin@test.nl');
INSERT INTO users (username, password, email) VALUES ('Jane Doe', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK', 'admin@test.nl');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('Jane Doe', 'ROLE_ARTIST');

INSERT INTO artworks (id, title, artist, description, date_created, gallery_buying_price, edition,artwork_image_file_name, artwork_type, username) VALUES    (1047, 'Swan', 'Jane Doe', 'A painting of a swan flapping its wings while landing in the water.', '2017-10-28', 4600, 'single', '1047-swan-2893562.jpg', 'painting','Jane Doe'),
                                                                                                                                                             (1051, 'Pelican', 'Jane Doe', 'Drawing in color of a beautiful pelican bird sitting on a log.', '2017-08-05', 5400, 'single', '1051-pelican-2585221.jpg', 'painting','Jane Doe'),
                                                                                                                                                             (1052, 'Tit', 'Jane Doe', 'Waterbased painting of a tit in the rain holding on to its branch', '2017-08-01', 6200, 'limited', '1052-tit-2566376.jpg', 'painting','Jane Doe'),
                                                                                                                                                             (1053, 'Soldier', 'Jane Doe', 'Soldier getting down on the ground and aiming his rifle.', '2018-07-09', 4300, 'limited', '1053-soldier-3524202.jpg', 'painting','Jane Doe'),
                                                                                                                                                             (1054, 'Fawn', 'Jane Doe', 'Fawn youngling drinking with its mother while the other fawn is relaxed in the grass', '2017-10-28', 4960, 'reproduction', '1054-fawn-2893471.jpg', 'painting','Jane Doe');


INSERT INTO paintings (id, painting_surface, painting_material, painting_dimensions_width_in_cm, painting_dimensions_height_in_cm) VALUES  (1047,'Canvas','Oil based paint',45,31),
                                                                                                                                           (1051,'Linnen','Watercolour paint',48,39),
                                                                                                                                           (1052,'Canvas','Watercolour paint',29,36),
                                                                                                                                           (1053,'Canvas','Oil based paint',43,38),
                                                                                                                                           (1054,'Linnen','Watercolour paint',51,39);
