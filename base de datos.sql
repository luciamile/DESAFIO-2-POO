-- Crear la base de datos
CREATE DATABASE PersonasDB;

-- Usar la base de datos creada
USE PersonasDB;

-- Crear la tabla Personas
CREATE TABLE Personas (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único
    edad INT NOT NULL, -- Ingresar edad
    telefono VARCHAR(15), -- Ingresar teléfono
    sexo ENUM('Masculino', 'Femenino', 'Otro') NOT NULL, -- Ingresar sexo
    ocupacion VARCHAR(50), -- Seleccionar ocupación
    fecha_nacimiento DATE -- Ingresar fecha de nacimiento
);

-- Ejemplo de inserción de datos
INSERT INTO Personas (edad, telefono, sexo, ocupacion, fecha_nacimiento)
VALUES (30, '12345678', 'Masculino', 'Ingeniero', '1993-09-15');

-- Consultar los datos insertados
SELECT * FROM Personas;
