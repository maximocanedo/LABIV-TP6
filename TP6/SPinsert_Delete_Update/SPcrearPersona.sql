DELIMITER $$
	CREATE PROCEDURE `crearPersona` (
		IN Udni varchar(20), 
		IN Unombre varchar(45), 
		IN Uapellido varchar(45)
    )
    BEGIN
		INSERT INTO personas (dni, nombre, apellido) VALUES (Udni, Unombre, Uapellido);
	END
$$ DELIMITER ;
    
