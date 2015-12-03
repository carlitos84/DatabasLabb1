
create table T_User
(K_ID integer not null unique AUTO_INCREMENT, 
K_Name varchar(25),
primary key (K_ID) );



create table T_Artist
(K_ID integer not null unique AUTO_INCREMENT,
K_Name varchar(25),
K_Nanitonality varchar(25),
primary key (K_ID)
);

create table T_Album
(K_ID integer not null unique AUTO_INCREMENT,
K_Title varchar(25),
K_Genre varchar(25),
K_Rate integer default null,
K_MadeBy integer not null,
primary key (K_ID),
foreign key(K_MadeBy) references T_Artist(K_Id)
);

create table T_Rate
(K_User integer not null unique, 
K_Album integer not null unique,
foreign key (K_User) references T_User(K_ID),
foreign key (K_Album) references T_Album(K_ID)
);


create table T_Storage
(K_User integer not null unique,
K_Artist integer not null unique,
K_Album integer not null unique,
foreign key (K_User) references T_User(K_ID),
foreign key (K_Artist) references T_Artist(K_ID),
foreign key (K_Album) references T_Album(K_ID)
);