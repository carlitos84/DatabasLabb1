/*
CREATE USER 'clientapp'@'%' IDENTIFIED BY 'carlos';
*/


/*Album rights*/
GRANT SELECT(K_Title, K_Genre, K_Date, K_Rate), INSERT(K_Title, K_Genre, K_Date) ON T_Album TO 'clientapp'@'%';

/*Artist rights*/
GRANT SELECT, INSERT ON T_Artist TO 'clientapp'@'%';

GRANT SELECT, UPDATE ON T_Rate TO 'clientapp'@'%';
GRANT SELECT, INSERT ON T_MadeBy TO 'clientapp'@'%';
GRANT INSERT ON T_Storage TO 'clientapp'@'%';

/* Add "Users" into database" */
Insert into T_User(K_Name) values("Carlos");
Insert into T_User(K_Name) values("Luis");
Insert into T_User(K_Name) values("Teddy");