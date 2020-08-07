CREATE TABLE `sefaz`.`usuario` (
  `idusuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuario`));
  
  ALTER TABLE `sefaz`.`usuario` 
CHANGE COLUMN `idusuario` `idusuario` INT NOT NULL AUTO_INCREMENT ;
  
ALTER TABLE `sefaz`.`usuario` 
ADD COLUMN `email` VARCHAR(45) NULL AFTER `senha`;

CREATE TABLE `sefaz`.`telefoneusuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `ddd` INT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
 ALTER TABLE `sefaz`.`telefoneusuario` 
ADD INDEX `idusuario_idx` (`idusuario` ASC) VISIBLE;
;
ALTER TABLE `sefaz`.`telefoneusuario` 
ADD CONSTRAINT `idusuario`
  FOREIGN KEY (`idusuario`)
  REFERENCES `sefaz`.`usuario` (`idusuario`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
