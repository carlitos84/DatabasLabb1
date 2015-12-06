/*CREATE USER 'clientapp'@'%' IDENTIFIED BY 'carlos';
*/
GRANT SELECT, INSERT ON T_Artist TO 'clientapp'@'%';
GRANT SELECT, INSERT ON T_Album TO 'clientapp'@'%';
GRANT SELECT, UPDATE ON T_Rate TO 'clientapp'@'%';
GRANT SELECT, INSERT ON T_MadeBy TO 'clientapp'@'%';
GRANT INSERT ON T_Storage TO 'clientapp'@'%';