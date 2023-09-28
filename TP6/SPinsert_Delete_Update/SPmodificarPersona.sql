DELIMITER $$

CREATE PROCEDURE `modificarPersona` (
    IN Udni varchar(20),
    IN Unombre VARCHAR(45),
    IN Uapellido VARCHAR(45)
)
BEGIN
    UPDATE personas
    SET nombre = Unombre,  apellido = Uapellido
    WHERE dni = Udni;
END

$$ DELIMITER ;
