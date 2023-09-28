DELIMITER $$
	CREATE PROCEDURE `eliminarPersona` (
		IN Udni varchar(20)
	)
	BEGIN
		DELETE FROM personas WHERE id = Udni;
	END
$$ DELIMITER ;
    
