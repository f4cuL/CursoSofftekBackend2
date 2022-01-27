INSERT INTO `user` (`type`, `id`, `password`, `userName`, `rol`) VALUES ('admin', '0', 'admin', 'admin', 'ADMIN'), ('empleado', '1', 'empleado', 'empleado', 'EMPLEADO')
INSERT INTO `categoria` (`id`, `nombre_categoria`) VALUES ('2', 'Cocina'), ('3', 'Mobilario'),('4', 'Juegos'),('5', 'Deporte')
UPDATE `hibernate_sequence` SET next_val=6;