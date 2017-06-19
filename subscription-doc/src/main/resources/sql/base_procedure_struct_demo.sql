# MySQL 存储过程基础机构
###############################################
## procedure base structure for proc_adder
###############################################
DROP PROCEDURE IF EXISTS `proc_adder`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_adder`(IN a INT, IN b INT, OUT sum INT)
BEGIN
	#Routine body goes here...
	DECLARE c INT;
	IF a IS NULL
		THEN SET a = 0;
	END IF;
	IF b IS NULL
		THEN SET b = 0;
	END IF;
	SET sum = a + b;
END
;;
DELIMITER;

SET @b = 40;
CALL proc_adder(2, @b, @sum);
SELECT @sum;
######################END#########################

###############################################
## procedure base structure for proc_if
###############################################
DROP PROCEDURE IF EXISTS `proc_if`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` PROCEDURE `proc_if`(IN type INT)
BEGIN
	#Routine body goes here...
	DECLARE c VARCHAR(500);
	IF type = 0 THEN
		SET c = 'param is 0';
	ELSEIF type = 1 THEN
		SET c = 'param is 1';
	ELSE
		SET c = 'param is others, not 0 or 1';
	END IF;
	SELECT c;
END
;;
DELIMITER ;

CALL proc_if(1);
######################END#########################

###############################################
## procedure base structure for proc_case
###############################################
DROP PROCEDURE IF EXISTS `proc_case`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` PROCEDURE `proc_case`(IN type INT)
BEGIN
	#Routine body goes here...
	DECLARE c VARCHAR(500);
	CASE type
	WHEN 0 THEN
			SET c = 'param is 0';
	WHEN 1 THEN
			SET c = 'param is 1';
	ELSE
			SET c = 'param is others not 1 or 0';
	END CASE;
	SELECT c;
END
;;
DELIMITER ;
CALL proc_case(0);
######################END#########################

###############################################
## procedure base structure for proc_while
###############################################
DROP PROCEDURE IF EXISTS `proc_while`;
DELIMITER ;;
CREATE DEFINER = `root`@`localhost` PROCEDURE `proc_while`(IN bound INT, OUT sum INT)
BEGIN
	#Routine body goes here...
	DECLARE idx INT;
	SET idx = 0;
	SET sum= 0;
	WHILE idx <= bound DO
			SET sum = sum + idx;
			SET idx = idx + 1;
	END WHILE;
END
;;
delimiter;
######################END#########################
CALL proc_while(10000, @sum);
SELECT @sum AS sum;