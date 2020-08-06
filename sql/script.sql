CREATE TABLE `sefaz`.`usuario` (
  `idusuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuario`));
  
  ALTER TABLE `sefaz`.`usuario` 
CHANGE COLUMN `idusuario` `idusuario` INT NOT NULL AUTO_INCREMENT ;
  