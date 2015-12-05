start transaction;

create table T_User
(K_Id integer not null unique AUTO_INCREMENT, 
K_Name varchar(25),
primary key (K_Id) );



create table T_Artist
(K_Id integer not null unique AUTO_INCREMENT,
K_Name varchar(25) unique,
K_Nationality varchar(25),
primary key (K_Id)
);

create table T_Album
(K_Id integer not null unique AUTO_INCREMENT,
K_Title varchar(25) unique,
K_Genre varchar(25),
K_Date integer not null,
K_Rate integer default null,
primary key (K_Id)
);

create table T_MadeBy
(K_ArtistId integer not null,
K_AlbumId integer not null,
foreign key (K_ArtistId) references T_Artist(K_Id),
foreign key (K_AlbumId) references T_Album(K_Id)
);

create table T_Rate
(K_User integer not null unique, 
K_Album integer not null unique,
foreign key (K_User) references T_User(K_Id),
foreign key (K_Album) references T_Album(K_Id)
);


create table T_Storage
(K_User integer not null unique,
K_Artist integer not null unique,
K_Album integer not null unique,
foreign key (K_User) references T_User(K_Id),
foreign key (K_Artist) references T_Artist(K_Id),
foreign key (K_Album) references T_Album(K_Id)
);
commit;