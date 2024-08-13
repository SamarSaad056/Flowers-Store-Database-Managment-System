create schema flowersStore ;

use flowersStore ;

/* -------------create the tables-------------------------------*/
create table Orders (
O_id           INT        PRIMARY KEY,
O_date         DATE,
b_no           INT,
c_id           INT

);
drop table Orders;
create table Flower_Bouquet(
f_id         INT            PRIMARY KEY,
f_name       varchar(50) ,
f_price      INT

);
drop table Flower_Bouquet;

create table Employee(
e_id         INT PRIMARY KEY,
e_name       varchar(20),
b_no         INT 
);
drop table Employee;
create table Store_Branch(
b_no       INT          PRIMARY KEY,
b_name     varchar(20) ,
b_location varchar(20)
);
drop  table Store_Branch;
create table Customer (
c_id        INT          PRIMARY KEY,
c_name      varchar(20),
c_phone     VARCHAR(20) ,
c_address   varchar(50)

);
drop table Customer;
create table Contain (

O_id         INT ,
f_id         INT,
Flower_no    INT 

);
drop table Contain;
create table Made_by (
 O_id     INT,
 e_id     INT,
 FOREIGN KEY (e_id) references Employee(e_id),
 foreign key(O_id) references Orders(O_id)
);
drop table Made_by;
/* -------------alter the tables-------------------------------*/
Alter table Orders add constraint b_no_FK foreign key(b_no)
references Store_Branch(b_no);

Alter table Orders add constraint c_id_FK foreign key(c_id)
references Customer(c_id);

Alter table Employee add constraint eb_no_FK foreign key(b_no)
 references Store_Branch(b_no);
 
 Alter table Contain add constraint f_id_FK foreign key(f_id)
 references Flower_Bouquet(f_id);
 
 Alter table Contain add constraint O_id_FK foreign key(O_id)
 references Orders(O_id);
  
 
 /* -------------describe the tables-------------------------------*/
 
 describe Orders;   
 describe Flower_Bouquet;   
 describe Employee;
 describe Store_Branch;
 describe Customer;
 describe Contain;
 describe Made_by;
 
 /* -------------fill the tables-------------------------------*/
 INSERT INTO Customer (c_id, c_name, c_phone, c_address) 
values
(1, 'Abdullah Saleh', '053 648 2542', '76422 Jalumdah'),
(2, 'Faisal Ali ', '057 495 3745', '42 Jalumdah'),
(3, 'Sarah Saud ', '054 475 5937', '07  Al wahah'),
(4, 'Noor Majed', '058 243 6493', '45547 Al ahamra' ),
(5, 'Dana Faisal ', '051 874 5231', '5 Al faiha'),
(6, 'Ali Saud ', '054 684 4246', '458 Al lulu'),
(7, 'Ameer Mohammed', '057 566 8452', '0547 Al huwaylat'),
(8, 'Kalid Fahad ', '057 764 2958', '1435 Jalumdah' ),
(9, 'Abeer Nasser', '053 357 6683', '360 Al faiha' ),
(10, 'Luluh Sultan', '056 358 6399', '1792 Al Khalidiyah' ),
(11, 'Yoshiko Bautiste', '052 326 3154', '3 Sydayr' ),
(12, 'Feras Saad ', '053 738 6296', '33722 Al faiha' ),
(13, 'Buthaina Ahmed ', '056 993 5367', '161 Al ahamra' ),
(14, 'Yara Abdulaziz', '052 973 7858', '93 Darin' ),
(15, 'Noor Saleh', '055 743 1377', '17078 Al huwaylat' ),
(16, 'Noel Sedman', '053 886 8357', '78  Al wahah' ),
(17, 'Asma Omar', '055 254 7554', '26 Al ahamra' ),
(18, 'Rawan Hussein ', '056 572 9953', '24 Al Khalidiyah' ),
(19, 'Mansour Fahad ', '055 152 6924', '19723 Al Khalidiyah' ),
(20, 'Aisha Ahmed', '052 746 4228', '329 Sydayr' ),
(21, 'Zaynab Basil', '054 328 1577', '87 Al lulu' ),
(22, 'Liliane Clemmey', '054 213 1837', '64444 Darin' ),
(23, 'Saud Saad ', '055 676 1315', '69 Darin' ),
(24, 'Maryam Musa', '051 675 9256', '2 Al ahamra' ),
(25, 'Archer Ruperto', '054 674 2541', '07  Al wahah' ),
(26, 'Stacee Ghion', '054 168 6444', '16883 Al lulu' ),
(27, 'Shatha Ahmed ', '053 875 7868', '53 Al huwaylat' ),
(28, 'Rana Fahad', '051 564 5689', '86 Al lulu' ),
(29, 'Hamza Bender', '052 162 7724', '71 Darin' ),
(30, 'Pearce Tooher', '057 133 9573', '1387 Sydayr' ),
(31, 'Ali Faisal', '056 758 7626', '19467  Al wahah' ),
(32, 'Adulmalek Musa ', '057 667 3136', '23 Al huwaylat' ),
(33, 'Martainn Haddleton', '054 622 4672', '6 Al lulu' ),
(34, 'Majed Fuad', '055 798 3775', '725 Al Khalidiyah' ),
(35, 'Tahani Fahad', '054 478 7428', '29833 Al Khalidiyah' ),
(36, 'Lujain aljuaid', '055 469 8476', '6 Al Khalidiyah' ),
(37, 'Fatimah Saeed', '058 853 6699', '07927 Darin' ),
(38, 'Ameerah Ahmed', '059 865 3772', '21 Sydayr' ),
(39, 'Marwa Alsufyani', '056 731 8468', '99 Al huwaylat' ),
(40, 'Samar Saad', '051 678 1258', '273 Darin' ),
(41, 'Mishaal Sultan', '057 613 4649', '441 Al Khalidiyah' ),
(42, 'Noorah Hamad', '058 266 9714', '85 Al lulu' ),
(43, 'Sarah Fahad', '051 218 2668', '762 Al huwaylat' ),
(44, 'Yasmine Hossam', '054 969 4827', '66420 Sydayr' ),
(45, 'Jamal  Kahlid', '055 271 7937', '2499 Al wahah' ),
(46, 'Ulises Presidey', '056 824 1878', '9 Al ahamra' ),
(47, 'Sultan Rakan', '052 437 8534', '1271 Al faiha' ),
(48, 'Hissah Alotaibi', '051 957 7784', '15 Jalumdah' ),
(49, 'Areej Hani', '054 977 6135', '44246 Darin' ),
(50, 'Mohammed Faisal', '057 454 8188', '0647 Jalumdah' );



INSERT INTO Store_Branch (b_no, b_name, b_location) 
values
(1,'Flower Story','ALhamra'),
(2,'Lavender Bouquets','ALfaiha'),
(3,' Pink Garden','jalmudah'),
(4,' Secret Garden','Darin'),
(5,'Bloom Flowers','ALwahah');

 
 INSERT INTO Flower_Bouquet (f_id, f_name, f_price) 
values
(001,'1 white rose',5),
(002,'1 red roses',5),
(003,'1 Pink rose',5),
(004,'1 yallow rose',5),
(005,'roses Bouquet',45),
(006,'1 white lily',6),
(007,'1 pink lily',6),
(008,' lily Bouquet',40),
(009,'1 Sunflower',5),
(010,'Sunflower Bouquet',40),
(011,'1 White Tulip',4),
(012,'1 Pink Tulip',4),
(013,'1 Yallow Tulip',4),
(014,'1 Red Tulip',4),
(015,'Tulip Bouquet',32),
(016,'Lavender Bouquet',40),
(017,'White Lilac',8),
(018,'Purple Lilac',8),
(019,'Lilac Bouquet',60),
(020,'1 Pink Carnation',4),
(021,'1 Red Carantion',4),
(022,'1 white Carantion',4),
(023,'Carantion Bouquet',4),
(024,'Bluebell Bouquet',30),  
(025,'cotton flower Bouquet ',33),
(026,'White Gypsopila Bouquet',15),
(027,'Pink Gypsopila Bouquet',15),
(028,'Purple Gypsopila Bouquet',15), 
(029,'Blue Gypsopila Bouquet',15);


 INSERT INTO Employee (e_id,e_name,b_no)
 values 
 (20665,'Mustafa',2),
 (30885,'Mikel',3),
 (10984,'Waleed',1),
 (50222,'Malik',5),
 (40955,'Morad',4),
 (30158,'Hateem',3),
 (10933,'Hanan',1),
 (20995,'Jone',2),
 (40321,'Tomas',4),
 (50444,'Ruaa',5),
 (50977,'Smith',5),
 (10345,'Fadi',1),
 (30223,'jana',3),
 (20452,'Kholod',2),
 (40446,'Jalal',4),
 (11097,'Lora',1),
 (51323,'Nada',5),
 (31454,'Ramy',3),
 (21333,'Talal',2),
 (51887,'Jassim',5),
 (41443,'Emad',4),
 (11009,'Rashed',1),
 (31002,'Nancy',3),
 (21090,'Ebrahim',2),
 (74930,'Aseel',5),
 (41020,'Karim',4),
 (11000,'Adnan',1),
 (21343,'Fares',2),
 (31088,'Salem',3),
 (51632,'Salah',5),
 (41962,'Nawaf',4),
 (31023,'Zayed',3),
 (11111,'Majeed',1),
 (21232,'Perri',2),
 (51555,'Maha',5),
 (41999,'Yomna',4),
 (12334,'Huda',1),
 (22000,'Hind',2),
 (42090,'Adeel',4),
 (32332,'Tariq',3),
 (52334,'Yahya',5),
 (52998,'Marwan',5),
 (32567,'Hamdan',3),
 (12330,'Julie',1),
 (96666,'Azzam',2),
 (42300,'Othman',4);
 
 INSERT INTO Orders (O_id,O_date,b_no,c_id)
 values 
(100,'2022-02-02',1,1),
(101,'2022-02-02',1,2),
(102,'2022-02-02',1,3),
(103,'2022-02-03',1,4),
(104,'2022-02-03',1,5),
(105,'2022-02-04',1,6),
(106,'2022-02-08',1,7),
(107,'2022-02-08',1,8),
(108,'2022-02-09',1,9),
(109,'2022-02-09',1,10),
(200,'2022-02-10',2,11),
(201,'2022-02-10',2,12),
(202,'2022-02-14',2,13),
(203,'2022-02-15',2,14),
(204,'2022-02-25',2,15),
(205,'2022-02-25',2,16),
(206,'2022-02-25',2,17),
(207,'2022-02-27',2,18),
(208,'2022-03-01',2,19),
(209,'2022-03-02',2,20),
(300,'2022-03-07',3,21),
(301,'2022-03-07',3,22),
(302,'2022-03-07',3,23),
(303,'2022-03-12',3,24),
(304,'2022-03-13',3,25),
(305,'2022-03-17',3,26),
(306,'2022-03-17',3,27),
(307,'2022-03-18',3,28),
(308,'2022-03-28',3,29),
(309,'2022-04-07',3,30),
(400,'2022-04-08',4,31),
(401,'2022-04-09',4,32),
(402,'2022-04-09',4,33),
(403,'2022-04-09',4,34),
(404,'2022-04-10',4,35),
(405,'2022-04-10',4,36),
(406,'2022-04-11',4,37),
(407,'2022-04-21',4,38),
(408,'2022-04-22',4,39),
(409,'2022-04-24',4,40),
(500,'2022-05-12',5,41),
(501,'2022-05-15',5,42),
(502,'2022-05-17',5,43),
(503,'2022-05-17',5,44),
(504,'2022-05-23',5,45),
(505,'2022-05-24',5,46),
(506,'2022-05-24',5,47),
(507,'2022-05-25',5,48),
(508,'2022-05-25',5,49),
(509,'2022-05-25',5,50),
(600,'2022-06-14',1,4),
(601,'2022-06-16',1,15),
(602,'2022-06-17',2,34),
(603,'2022-06-17',2,22),
(604,'2022-06-23',3,25),
(605,'2022-06-24',3,45),
(606,'2022-06-24',4,50),
(607,'2022-06-25',4,16),
(608,'2022-06-25',5,10),
(609,'2022-06-25',5,9);
    

 INSERT INTO Contain (O_id,f_id, Flower_no) 
values
(100,010,2),
(100,017,5),
(101,004,10),
(102,029,4),
(103,023,1),
(103,002,1),
(104,006,13),
(105,001,1),
(105,024,2),
(106,014,4),
(107,025,15),
(108,002,11),
(109,007,2),
(109,010,1),
(200,016,2),
(201,017,5),
(202,009,1),
(203,005,5),
(203,027,2),
(204,016,3),
(205,019,1),
(206,013,3),
(207,001,4),
(208,008,2),
(209,023,4),
(300,028,10),
(301,025,1),
(302,014,4),
(303,007,6),
(303,028,3),
(304,009,6),
(305,008,1),
(306,019,1),
(307,026,3),
(308,017,2),
(308,029,3),
(309,002,31),
(400,003,32),
(401,002,33),
(402,013,4),
(403,015,15),
(404,012,36),
(405,021,37),
(406,003,4),
(407,008,9),
(408,003,40),
(409,004,1),
(500,001,42),
(501,012,43),
(501,022,3),
(502,014,4),
(503,024,5),
(504,015,6),
(505,016,7),
(505,006,47),
(506,007,48),
(507,018,9),
(508,009,50),
(509,010,1),
(600,005,2),
(600,011,2),
(601,022,5),
(602,013,4),
(603,014,5),
(604,015,5),
(604,025,6),
(605,026,7),
(606,007,5),
(606,017,8),
(607,008,16),
(608,019,2),
(609,016,1),
(609,017,6);


INSERT INTO Made_by (O_id,e_id)
 values 
 (100,10984),
 (101,10933),
 (101,11111),
 (102,10345),
 (103,11097),
 (104,11009),
 (105,10984),
 (105,11000),
 (106,11111),
 (107,12334),
 (108,12330),
 (109,10984);
 
 INSERT INTO Made_by (O_id,e_id)
 values 
 (200,20665),
 (200,21343),
 (201,20995),
 (202,20452),
 (203,21333),
 (204,21090),
 (204,22000),
 (205,21343),
 (206,21232),
 (207,22000),
 (208,96666),
 (209,20665),
 (209,21232),
 (300,30885),
 (300,30223),
 (301,30158),
 (302,30885),
 (302,30223),
 (303,31454),
 (303,31023),
 (304,31002),
 (305,31088),
 (306,31023),
 (307,32332),
 (308,32567),
 (309,30885), 
 (400,41962),
 (401,40321),
 (402,40955),
 (403,40446),
 (404,41443),
 (405,40446),
 (405,41443),
 (406,41020),
 (406,42090),
 (407,41962),
 (408,42090),
 (409,41999),
 (409,42300),
 (500,52334),
 (501,52998),
 (502,51555),
 (503,52334),
 (503,51632),
 (504,74930),
 (504,52998),
 (505,50222),
 (506,50444),
 (507,50977),
 (508,51887),
 (509,51887),
 (509,50977),
 (600,10984),
 (601,10933), 
 (602,20995),
 (603,20665),
 (603,21343), 
 (604,30885),
 (604,30223),
 (605,30158),
 (606,40321),
 (607,40446),
 (608,51887),
 (609,50444),
 (609,50977);
 
  /* -------------select the tables-------------------------------*/
  select * from Made_by;
  select * from Contain;
  select * from Orders;
  select * from Employee;
  select * from Flower_Bouquet;
  select * from Store_Branch;
  select * from Customer;